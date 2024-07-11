package com.maintainapps.midlandbookshop;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.json.JSONObject;
import org.springframework.web.client.HttpClientErrorException;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.RawMessage;
import com.amazonaws.services.simpleemail.model.SendRawEmailRequest;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.maintainapps.schema.xml.ONIXMessage;
import com.maintainapps.schema.xml.Product;
import com.maintainapps.util.BookUtil;
import com.maintainapps.util.StoreHippoVO;
import com.maintainapps.util.StoreHippoVO.SEO;
import com.opencsv.CSVWriter;

public class BookHandler implements RequestHandler<S3Event, String> {

	public String handleRequest(S3Event input, Context context) {
		
		
		String mailids = System.getenv("ReportMailIds");

		String fromemailid = System.getenv("FromMailId");
		
		long Noofbooks = Integer.parseInt(System.getenv("Noofbooks"));
		
		int maxsize = Integer.parseInt(System.getenv("MaxSize"));
		
		String processingFolder = System.getenv("ProcessingBucketFolder");
		
		System.out.println("Environmental Variables " + mailids + "-" + fromemailid + "-" + Noofbooks + "-" + maxsize + "-" + processingFolder);
		
		String snsMessage = "";
	
	   
	    
		
		String bucketname = input.getRecords().get(0).getS3().getBucket().getName();
		String keyname = input.getRecords().get(0).getS3().getObject().getKey();
		try {

			System.out.println("The file is processed from " + bucketname);
			System.out.println("and the file name is " + keyname);

			AmazonS3 client = AmazonS3ClientBuilder.defaultClient();

			S3Object xFile = client.getObject(new GetObjectRequest(bucketname, keyname));
			long filesize = xFile.getObjectMetadata().getContentLength();
			if (filesize > maxsize) {
				
				sendSNS("File Processing Failure! -" + keyname, "File size cannot be greater than 10 MB received "  + filesize);
				return "";
			}

			InputStream inputStream = xFile.getObjectContent();

			String filedata = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines()
					.collect(Collectors.joining("\n"));

			ONIXMessage message = BookUtil.getOnixMessage(new ByteArrayInputStream(filedata.getBytes()));

			if (message.getProduct().size() <= Noofbooks) {

				List<Product> products = message.getProduct();
				for (Product product : products) {
					JSONObject hippoMessage = BookUtil.convertToEcommerceMessage(product);

					try {
						String response = BookUtil.sendCreationMessage(hippoMessage);
						snsMessage = "Processed Successfully " + hippoMessage.getString("isbn") + "-"
								+ hippoMessage.getString("name") + "-" + hippoMessage.getString("brand");
						response = response + "\n" + keyname;
						response = response + "\n" + filedata;

						sendSNS(snsMessage, response);
						

					} catch (HttpClientErrorException e) {
						snsMessage = "Failure! - Can't Process " + hippoMessage.getString("isbn") + "-"
								+ hippoMessage.getString("name") + "-" + hippoMessage.getString("brand");
						String response = e.getMessage() + "\n" + keyname;
						response = response + "\n" + filedata;
						sendSNS(snsMessage, response);
						return "";
					}
				}
			} else {
				
				List<Product> products = message.getProduct();
				
				StringWriter writerString = new StringWriter();
				CSVWriter writer = new CSVWriter(writerString);
				
				//Headers
				
				StoreHippoVO upload = new StoreHippoVO();
				com.maintainapps.util.StoreHippoVO.Attribute attr = upload.new Attribute();
				SEO seo = upload.new SEO();
				upload.setAttribute(attr);
				upload.setSeo(seo);
				writer.writeNext(StoreHippoVO.createHeader(upload));
				
				
				
				for (Product product : products) {
					writer.writeNext(StoreHippoVO.createRecord(BookUtil.convertToEcommereBulkRecord(product)));
				}
				Date date = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				String folder = calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.YEAR);
				
				client.putObject(processingFolder+folder,changeExtension(keyname),writerString.toString());
				writer.close();
				String tag = calendar.get(Calendar.DAY_OF_MONTH) + "-"  + folder;
				sendEmail(fromemailid,mailids,message.getProduct().size() + " Books received for processing, please upload the book on storehippo after verification","PENGUIN BOOKS RECEIVED - "+tag,writerString.toString(),changeExtension(keyname) );
				// book csv
				snsMessage = "Bulk Upload Processing! - " + keyname;
				sendSNS(snsMessage, "File was processed and archived");
				
			}
		} catch (Exception e) {
			snsMessage = "File Processing Failure! - " + keyname;
			sendSNS(snsMessage, e.getMessage());
		
			e.printStackTrace();
		}

		return snsMessage;
	}

	private String changeExtension(String keyname) {
		  if (keyname.contains(".")) {
			  keyname = keyname.substring(0, keyname.lastIndexOf('.'));
		    }
		  keyname += ".csv";
		return keyname;
	}
	
	private void sendSNS(String subject, String message)
	{
		AmazonSNS snsclient = AmazonSNSClientBuilder.defaultClient();
		String topicName = System.getenv("SNSTopicName");
		snsclient.publish(topicName, message, subject);
		System.out.println(subject + "-" + message);
	}
	
	private void sendEmail(final String fromemailid,final String toEmail,String messageStr,String subject,String filecontent,String filename) {
		 try {
		 
	      Session session = Session.getDefaultInstance(new Properties());


		  MimeMessage message = new MimeMessage(session);
		  
		  message.setSubject(subject);
		  message.setRecipients(javax.mail.Message.RecipientType.TO, toEmail);
		  
		  MimeMultipart mimeMultipart = new MimeMultipart();
		    BodyPart p = new MimeBodyPart();
		    p.setContent(messageStr, "text/html");
		    mimeMultipart.addBodyPart(p);
		    
		    
		    try {
		    	BodyPart attachment = new MimeBodyPart();
	            attachment.setText(filecontent);
	            attachment.setFileName(filename);
	            mimeMultipart.addBodyPart(attachment);
	          
	        } catch (MessagingException e) {
	           e.printStackTrace();
	        }

		    
		    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		    message.setContent(mimeMultipart);
		    message.writeTo(outputStream);
		    RawMessage rawMessage = new RawMessage(ByteBuffer.wrap(outputStream.toByteArray()));
		     

		 
			  	SendRawEmailRequest rawEmailRequest = new SendRawEmailRequest(rawMessage);
			  	ArrayList<String> destination = new ArrayList<String>();
			    rawEmailRequest.setDestinations(destination);
			    rawEmailRequest.setSource(fromemailid);
			    AmazonSimpleEmailService client = AmazonSimpleEmailServiceClient.builder().withRegion("us-east-2").build();
			    client.sendRawEmail(rawEmailRequest);
			    System.out.println("Sending email ..... to " + toEmail);
			  
		    
		   
		  } catch (Exception anyException) {
		   anyException.printStackTrace();
		  }

		}
	

}
