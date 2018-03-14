package skyware_test.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationSkyware {

	private static Properties properties;
	
	static {
		try {
			properties = new Properties();
			FileInputStream inputStream = new FileInputStream("./skyware.configuration");
			properties.load(inputStream); 
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	public static String getProporty(String key) {
		return properties.getProperty(key);
	}
}
