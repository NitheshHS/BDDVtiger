package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	
	public String getPropertyValue(String key) throws Throwable {
		FileInputStream file=new FileInputStream(FilePath.PROPERTY_FILE);
		Properties prop=new Properties();
		prop.load(file);
		return prop.getProperty(key);
	}

}
