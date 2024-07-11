package com.maintainapps.util;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.maintainapps.schema.xml.Contributor;
import com.maintainapps.schema.xml.Measure;
import com.maintainapps.schema.xml.ONIXMessage;
import com.maintainapps.schema.xml.PersonName;
import com.maintainapps.schema.xml.Product;
import com.maintainapps.schema.xml.Publisher;
import com.maintainapps.schema.xml.PublisherName;
import com.maintainapps.schema.xml.PublishingDate;
import com.maintainapps.schema.xml.Subject;
import com.maintainapps.schema.xml.SubjectHeadingText;
import com.maintainapps.schema.xml.SupportingResource;
import com.maintainapps.schema.xml.Text;
import com.maintainapps.schema.xml.TextContent;
import com.maintainapps.schema.xml.TitleWithoutPrefix;
import com.maintainapps.util.StoreHippoVO.Attribute;
import com.maintainapps.util.StoreHippoVO.SEO;

public class BookUtil {
	
	
	public static ONIXMessage getOnixMessage(InputStream stream)
	{
		System.out.println("starting getOnixMessage");
		ONIXMessage message = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ONIXMessage.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			message = (ONIXMessage) unmarshaller.unmarshal(stream);
		}
		catch(JAXBException e)
		{
			e.printStackTrace();
		}
		System.out.println("ending getOnixMessage");
		return message;
	}
	
	
	public static StoreHippoVO convertToEcommereBulkRecord(Product product)
	{
		System.out.println("starting convertToEcommereBulkRecord for ");
		StoreHippoVO map = new StoreHippoVO();
		String isbn = product.getProductIdentifier().get(2).getIDValue().getValue();
		System.out.println(">>>>>>>>"+isbn+"<<<<<<<<<");
		
		map.setPublish(0);
		map.setSeller("read@midlandbookshop.com");
		  List<SupportingResource> resources = product.getCollateralDetail().getSupportingResource();
	    
	    for (SupportingResource supportingResource : resources) {
	    	
	    	map.setImage1(supportingResource.getResourceVersion().get(0).getResourceLink().get(0).getValue());
		}
        
		TitleWithoutPrefix title = (TitleWithoutPrefix) product.getDescriptiveDetail().getTitleDetail().get(0).getTitleElement().get(0).getContent().get(2);
		
		map.setName(title.getValue());

		String description = constructDescription(product.getCollateralDetail().getTextContent());
		
		map.setDescription(description);
		
		
		if(product.getProductSupply().size() > 0)
		map.setPrice(""+product.getProductSupply().get(0).getSupplyDetail().get(0).getPrice().get(0).getPriceAmount().getValue());
		

		
		
		map.setSku(isbn);
		map.setIsbn(isbn);
		
		
		List<Contributor> contributor =  product.getDescriptiveDetail().getContributor();
		
		StringJoiner authors = new StringJoiner(",");
		
		for (Contributor contributor2 : contributor) {
			
			PersonName authorname = getPersonName(contributor2.getContent());
			if(authorname != null)
			authors.add(authorname.getValue());
		}
		
		
		
		map.setBrand(authors.toString());
		
	
		
		String keywords = "";
		StringJoiner categories = new StringJoiner(",");
		
		List<Subject> subjects = product.getDescriptiveDetail().getSubject();
		
		for (Subject subject : subjects) {
			
			if(subject.getContent().size() == 5)
			{
				SubjectHeadingText text = (SubjectHeadingText) subject.getContent().get(4);
				String category = convertCategoryString(text.getValue());
				categories.add(category);
			}
			else if (subject.getContent().size() == 4){
				
				SubjectHeadingText text = (SubjectHeadingText) subject.getContent().get(3);
				String category = convertCategoryString(text.getValue());
				categories.add(category);
				
			}
			else if (subject.getContent().size() == 2){
				
				SubjectHeadingText text = (SubjectHeadingText) subject.getContent().get(1);
				keywords = text.getValue();
				
				
			}
			
		}
		
		map.setCategories(categories.toString());
		
		
		
		JSONObject dimension = new JSONObject();
		List<Measure> measure = product.getDescriptiveDetail().getMeasure();
		for (Measure measure2 : measure) {
			if(measure2.getMeasureType().getValue().equals("01"))
			{
				dimension.put("length", measure2.getMeasurement().getValue());
			}
			else if(measure2.getMeasureType().getValue().equals("02"))
			{
				dimension.put("width", measure2.getMeasurement().getValue());
			}
			else if(measure2.getMeasureType().getValue().equals("08"))
			{
				dimension.put("weight", measure2.getMeasurement().getValue());
				
				map.setWeight(measure2.getMeasurement().getValue()+"");
			}
			
		}
	
		
		
		Attribute attributes =  map.new Attribute();
		attributes.setISBN(isbn);
		map.setFeature1("ISBN:"+isbn);
		attributes.setAuthors(authors.toString());
		map.setFeature2("Authors:"+authors.toString());
		Publisher publisher = (Publisher) product.getPublishingDetail().getContent().get(1);
		PublisherName name = (PublisherName) publisher.getContent().get(2);
		PublishingDate date = getPublishingDate(product.getPublishingDetail().getContent());
		SimpleDateFormat formatTO = new SimpleDateFormat("dd MMM yyyy");
		SimpleDateFormat formatFROM = new SimpleDateFormat("yyyyMMdd");
		Date dateReal;
		try {
			dateReal = formatFROM.parse(date.getDate().getValue());
			attributes.setPublished_Date(formatTO.format(dateReal));
			map.setFeature3("Published Date:"+attributes.getPublished_Date());
		} catch (ParseException e) {
			System.err.println(e.getLocalizedMessage());
		}
		
		attributes.setPublisher(name.getValue());
		map.setFeature4("Publisher:"+attributes.getPublisher());
		
		//NumberOfPages is missing.
		
		
		//attributes.put(new JSONObject().put("Pages", name.getValue()));
		if(product.getDescriptiveDetail().getProductFormDescription().size() > 0)
		{
			attributes.setFormat(product.getDescriptiveDetail().getProductFormDescription().get(0).getValue());
			map.setFeature5("Format:"+attributes.getFormat());
		}
		
		
		
		
		map.setAttribute(attributes);
		SEO seo = map.new SEO();
		seo.setTitle(title.getValue());
		seo.setDescription(description);
		seo.setKeywords(keywords);
		
		map.setSeo(seo);
		
		
        
		
	    
	     return map;
	}
	
	public static PublishingDate getPublishingDate(List<Object> objects)
	{
		for (Object object : objects) {
			
			if(object instanceof PublishingDate)
			{
				return (PublishingDate) object;
			}
			
		}
		
		return null;
	}
	
	
	
	
	public static JSONObject convertToEcommerceMessage(Product product)
	{
		System.out.println("starting convertToEcommerceMessage");
		JSONObject map = new JSONObject();
		String isbn = product.getProductIdentifier().get(2).getIDValue().getValue();
		System.out.println("ISBN :" + isbn);
		map.put("publish", "0");
		map.put("seller","60a4dae1ef0172d72afa3f4e");
		JSONArray images = new JSONArray();
	    JSONObject imageActual = new JSONObject();
	    List<SupportingResource> resources = product.getCollateralDetail().getSupportingResource();
	    
	    for (SupportingResource supportingResource : resources) {
	    	
	    	JSONObject image = new JSONObject();
	    	image.put("data", supportingResource.getResourceVersion().get(0).getResourceLink().get(0).getValue());
	    	image.put("uploadType", "url");
	    	imageActual.put("image",image);
	    	map.put("image1", image);
	    	
		}
        
        images.put(imageActual);
        
		map.put("images", images);
		
	    
		TitleWithoutPrefix title = (TitleWithoutPrefix) product.getDescriptiveDetail().getTitleDetail().get(0).getTitleElement().get(0).getContent().get(2);
		
		map.put("name", title.getValue());

		String description = constructDescription(product.getCollateralDetail().getTextContent());
		
		map.put("description", description);
		
		map.put("price", product.getProductSupply().get(0).getSupplyDetail().get(0).getPrice().get(0).getPriceAmount().getValue());
		
		
		
		map.put("uniquesku",isbn);
		map.put("sku",isbn);
		map.put("isbn",isbn);
		map.put("hsn",product.getProductIdentifier().get(0).getIDValue().getValue());
		map.put("sac",product.getProductIdentifier().get(1).getIDValue().getValue());
		
	
		
		List<Contributor> contributor =  product.getDescriptiveDetail().getContributor();
		
		StringJoiner authors = new StringJoiner(",");
		
		for (Contributor contributor2 : contributor) {
			
			PersonName authorname = getPersonName(contributor2.getContent());
			authors.add(authorname.getValue());
		}
		
		
		
		map.put("brand",authors.toString());
		
		
		
		String keywords = "";
		
		JSONArray categories = new JSONArray();
		List<Subject> subjects = product.getDescriptiveDetail().getSubject();
		
		for (Subject subject : subjects) {
			
			if(subject.getContent().size() == 5)
			{
				SubjectHeadingText text = (SubjectHeadingText) subject.getContent().get(4);
				String category = convertCategoryString(text.getValue());
				categories.put(category);
			}
			else if (subject.getContent().size() == 4){
				
				SubjectHeadingText text = (SubjectHeadingText) subject.getContent().get(3);
				String category = convertCategoryString(text.getValue());
				categories.put(category);
				
			}
			else if (subject.getContent().size() == 2){
				
				SubjectHeadingText text = (SubjectHeadingText) subject.getContent().get(1);
				keywords = text.getValue();
				
				
			}
			
		}
		
		map.put("categories", categories);
		
		
		JSONObject dimension = new JSONObject();
		List<Measure> measure = product.getDescriptiveDetail().getMeasure();
		for (Measure measure2 : measure) {
			if(measure2.getMeasureType().getValue().equals("01"))
			{
				dimension.put("length", measure2.getMeasurement().getValue());
			}
			else if(measure2.getMeasureType().getValue().equals("02"))
			{
				dimension.put("width", measure2.getMeasurement().getValue());
			}
			else if(measure2.getMeasureType().getValue().equals("08"))
			{
				dimension.put("weight", measure2.getMeasurement().getValue());
				map.put("weight", measure2.getMeasurement().getValue());
			}
			
		}
		map.put("dimension", dimension);
		
		map.put("inventory_management", 1);
		
		map.put("inventory_quantity", product.getProductSupply().get(0).getSupplyDetail().get(0).getProductAvailability().getValue());
		
		
		JSONArray attributes = new JSONArray();
		attributes.put(createAttribute("ISBN",isbn));
		attributes.put(createAttribute("Author", authors.toString()));
		Publisher publisher = (Publisher) product.getPublishingDetail().getContent().get(1);
		PublisherName name = (PublisherName) publisher.getContent().get(2);
		PublishingDate date = (PublishingDate) product.getPublishingDetail().getContent().get(4);
		SimpleDateFormat formatTO = new SimpleDateFormat("dd MMM yyyy");
		SimpleDateFormat formatFROM = new SimpleDateFormat("yyyyMMdd");
		Date dateReal;
		try {
			dateReal = formatFROM.parse(date.getDate().getValue());
			attributes.put(createAttribute("Published Date", formatTO.format(dateReal)));
		} catch (ParseException e) {
			System.err.println(e.getLocalizedMessage());
		}
		
		attributes.put(createAttribute("Publisher", name.getValue()));
		
		//NumberOfPages is missing.
		
		
		//attributes.put(new JSONObject().put("Pages", name.getValue()));
		attributes.put(createAttribute("Format", product.getDescriptiveDetail().getProductFormDescription().get(0).getValue()));
		
		map.put("attributes", attributes);
		
		map.put("features", convertAttributesToFeatures(attributes));
		
		JSONObject seo = new JSONObject();
		seo.put("title", title.getValue());
		seo.put("description", description);
		seo.put("keywords", keywords);
		
		map.put("SEO", seo);
		
		
        
		
	     System.out.println("ending convertToEcommerceMessage");
	     return map;
	}
	
	private static PersonName getPersonName(List<Object> content) {
		for (Object object : content) {
			
			if(object instanceof PersonName)
			{
				return (PersonName) object;
			}
			
		}
		
		return null;
	}


	private static JSONArray convertAttributesToFeatures(JSONArray attributes) {
		JSONArray features = new JSONArray();
		for (Object object : attributes) {
			JSONObject attribute = (JSONObject) object;
			features.put(attribute.getString("name")+":" + attribute.getString("value"));
		}
		return features;
	}
	
	

	private static JSONObject createAttribute(String key, String value) {
		JSONObject object = new JSONObject();
		object.put("name", key);
		object.put("value", value);
		//object.put("group", "default");
		return object;
	}


	private static String constructDescription(List<TextContent> descriptions) {
		
		
		StringJoiner paragraph = new StringJoiner("</br>");
		for (TextContent textContent : descriptions) {
			if(textContent.getTextType().getValue().equals("03"))
			{
				paragraph.add("<b>Book Description:</b>");
				List<Text> content = textContent.getText();
				
				for (Text text : content) {
					paragraph.add((String)text.getContent().get(0));
				}
				
			}
		}
		
		for (TextContent textContent : descriptions) {
			
			if(textContent.getTextType().getValue().equals("12"))
			{
				paragraph.add("<b>Author Description:</b>");
				List<Text> content = textContent.getText();
				
				for (Text text : content) {
					paragraph.add((String)text.getContent().get(0));
				}
				
			}
		}
		
		return paragraph.toString();
		
	}


	private static String convertCategoryString(String text) {
		text = text.replaceAll("&amp;", "and");
		text = text.replaceAll(" / ", ":");
		text = text.replaceAll("/", ":");
		return text;
	}


	public static String sendCreationMessage(JSONObject map)
	{
		  System.out.println("starting sendCreationMessage");
		  HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.add("access-key", "65fafbd96820e0f1d51e5b62da6e6bff");
			
	        HttpEntity<String> completeMessage = 
	   		      new HttpEntity<String>(map.toString(), headers);
		  RestTemplate restTemplate = new RestTemplate();
          String response = restTemplate.postForObject("https://mybookclub.storehippo.com/api/1.1/entity/ms.products", completeMessage,String.class);
          System.out.println("response from store hippo" + response);
          System.out.println("ending sendCreationMessage");
          return response;
	}

}
