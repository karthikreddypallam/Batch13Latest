package com.ap.utils;

public interface IConstants {
	
	String userDir = System.getProperty("user.dir");
	
	String envPath = userDir+"/src/test/resources/env.properties";
	String screenshots = userDir+"/src/test/resources/screenshots/";
	
	String mac_chromedriverPath = userDir+"/src/main/resources/Drivers/chromedriver";
	String mac_geckodriverPath = userDir+"/src/main/resources/Drivers/geckodriver";
	String win_geckodriverPath = userDir+"/src/main/resources/Drivers/winDrivers/geckodriver.exe";
	String win_chromedriverPath = userDir+"/src/main/resources/Drivers/winDrivers/chromedriver.exe";
	
	
	
}
