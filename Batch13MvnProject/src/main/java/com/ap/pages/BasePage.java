package com.ap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver = null;
	
	public BasePage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterText(WebElement ele, String text) {
		ele.sendKeys(text);
	}
	
	public void click(WebElement ele) {
		ele.click();
	}

}
