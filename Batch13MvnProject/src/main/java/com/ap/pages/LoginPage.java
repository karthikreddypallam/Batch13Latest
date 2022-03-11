package com.ap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="input#email")
	public WebElement txtFld_email;
	
	@FindBy(css="input#passwd")
	public WebElement txtFld_pwd;
	
	@FindBy(css="button#SubmitLogin")
	public WebElement btn_Submit;
	
	@FindBy(xpath="//a[@title='Recover your forgotten password']")
	public WebElement lnk_ForgotPwd;
	
	public void login(String user,String pwd) {
		enterText(txtFld_email, user);
		enterText(txtFld_pwd, pwd);
		click(btn_Submit);
	}
	
	public void navToForgotPwdPage() {
		click(lnk_ForgotPwd);
	}
	
}
