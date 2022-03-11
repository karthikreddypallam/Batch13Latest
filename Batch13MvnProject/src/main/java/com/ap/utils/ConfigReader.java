package com.ap.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop = null;
	FileReader fr = null;
	
	public void readConfig() {
		try {
			 fr = new FileReader(IConstants.envPath);
			 prop = new Properties();
			 prop.load(fr); 
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getBrowser() {
		return prop.getProperty("browser");
	}
	
	public String getPlatform() {
		return prop.getProperty("platform");
	}
	
	public String getURL() {
		return prop.getProperty("url");
	}
	
	public String getUser() {
		return prop.getProperty("user");
	}
	
	public String getPassword() {
		return prop.getProperty("password");
	}


}
