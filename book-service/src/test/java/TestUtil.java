import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;

import com.maintainapps.schema.xml.ONIXMessage;
import com.maintainapps.schema.xml.Product;
import com.maintainapps.util.BookUtil;
import com.maintainapps.util.StoreHippoVO;
import com.maintainapps.util.StoreHippoVO.SEO;
import com.opencsv.CSVWriter;

public class TestUtil {

	public static void main(String[] args) throws FileNotFoundException {

		File initialFile = new File("C:/temp/TEST_PRH_India_MidlandBookShop_20210921_2145.xml");
		InputStream targetStream = new FileInputStream(initialFile);

		ONIXMessage message = BookUtil.getOnixMessage(targetStream);

		System.out.println(message.getProduct().size());

		try {

			FileWriter stringWriter = new FileWriter(new File("c:/temp/test.csv"));
			CSVWriter writer = new CSVWriter(stringWriter);

			StoreHippoVO upload = new StoreHippoVO();
			com.maintainapps.util.StoreHippoVO.Attribute attr = upload.new Attribute();
			SEO seo = upload.new SEO();
			upload.setAttribute(attr);
			upload.setSeo(seo);
			writer.writeNext(StoreHippoVO.createHeader(upload));

			List<Product> products = message.getProduct();

			for (Product product : products) {
				writer.writeNext(StoreHippoVO.createRecord(BookUtil.convertToEcommereBulkRecord(product)));
			}

			stringWriter.flush();
			stringWriter.close();
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// JSONObject hippoMessage =
		// BookUtil.convertToEcommerceMessage(message.getProduct().get(0));

		// BookUtil.sendCreationMessage(hippoMessage);

	}
}
