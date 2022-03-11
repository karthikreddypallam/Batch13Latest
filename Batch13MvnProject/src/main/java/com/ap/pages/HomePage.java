package com.ap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="a.login")
	public WebElement lnk_signIn;
	
	public void navToLoginPage() {
		click(lnk_signIn);
		WebElement ele = driver.findElement(By.cssSelector("a.login"));
		ele.click();
	}
	
	
}
