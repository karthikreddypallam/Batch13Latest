package com.ap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BasePage {
	
	
	
	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[text()='Retrieve Password']")
	public WebElement btn_RetrievePwd;
	
	
	
}
