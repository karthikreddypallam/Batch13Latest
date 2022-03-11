package com.ap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public String lbl_MyAccountPageTitle = "My account - My Store";

	@FindBy(css="a.logout")
	public WebElement lnk_signOut;
	
	public void signout() {
		click(lnk_signOut);
	}

}
