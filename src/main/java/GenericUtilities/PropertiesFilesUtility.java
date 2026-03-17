package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesFilesUtility {

	
	public String readDataFromPropertyFile(String key) throws Throwable {
		
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
		
		
		
		
	}
	
	
	
}
