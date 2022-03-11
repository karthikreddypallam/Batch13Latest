package com.ap.tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ap.utils.ConfigReader;
import com.ap.utils.IConstants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest {
	
	public static ExtentHtmlReporter htmlReporter = null;
	public static ExtentReports reports = null;
	public static ExtentTest test;
	
	WebDriver driver = null;
	WebDriverWait wait= null;
	String browser = null;
	String url = null;
	ConfigReader cfgRdr = null;
	
	@BeforeSuite
	public void init() {
		htmlReporter = new ExtentHtmlReporter("AutomationPractice.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		cfgRdr = new ConfigReader();
		cfgRdr.readConfig();
	}
	
	@BeforeTest
	public void launchBrowser() {
		browser = cfgRdr.getBrowser();
		url = cfgRdr.getURL();
		
		if(cfgRdr.getPlatform().equalsIgnoreCase("mac")) {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", IConstants.mac_chromedriverPath);
			    driver = new ChromeDriver(); 	
			}else {
				System.setProperty("webdriver.gecko.driver", IConstants.mac_geckodriverPath);
			    driver = new FirefoxDriver();
			}
		}else {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", IConstants.win_chromedriverPath);
			    driver = new ChromeDriver(); 	
			}else {
				System.setProperty("webdriver.gecko.driver", IConstants.win_geckodriverPath);
			    driver = new FirefoxDriver();
			}
		}

		driver.get(url); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void validation(String expText, String actText, String validtion) {
		if(expText.equals(actText))
			System.out.println(validtion+" validtion is successful. Exp Text==> "+expText+" Act Text ==> "+actText);
		else
			System.out.println(validtion+" validtion is failed. Exp Text==> "+expText+" Act Text ==> "+actText);
	}
	
	public boolean isElementPresent(WebElement ele) {
		boolean elePresent = false;

		try {
			if(ele.isDisplayed()&& ele.isEnabled())
				elePresent = true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return elePresent;
	}
	
	public void closeBrowser() {
		driver.close(); 
	}
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			System.out.println(result.getMethod().getMethodName()+" passed");
		}else if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println(result.getMethod().getMethodName()+" failed");
			getScreenshot(result.getMethod().getMethodName());
		}else {
			System.out.println(result.getMethod().getMethodName()+" skipped");
		}
	}
	
	public String getScreenshot(String screenshotName) {
		//below line is just to append the date format with the screenshot name to avoid duplicate names 
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = IConstants.screenshots+screenshotName+date+".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Returns the captured file path
		return destination;
	}
	
	public void takeScreenshot() {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(IConstants.screenshots+"failed.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterTest(alwaysRun=true)
	public void quit() {
		driver.quit(); 
	}
	
	public String getTitle() {
		return driver.getTitle(); 
	}
	
	

}
