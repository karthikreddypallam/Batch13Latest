package com.ap.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReaderExample {
	

	public static void main(String[] args) {
		
		Properties prop = null;
		
		String path = System.getProperty("user.dir")+"/src/test/resources/env.properties";
		FileReader fr = null;
		try {
			 fr = new FileReader(path);
			 prop = new Properties();
			 prop.load(fr); 
			 
			 System.out.println(prop.getProperty("browser"));
			 
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
