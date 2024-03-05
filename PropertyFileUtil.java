package CommonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil {

	public String getDataFromPropertyFile(String keyname) throws IOException {
		FileInputStream fis = new FileInputStream("src\\test\\resources\\LoginCredential.properties");	
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(keyname);
		return value;
	
	
	
	
	
	}
}
