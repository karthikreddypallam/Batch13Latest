package com.ap.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.pages.ForgotPasswordPage;
import com.ap.pages.HomePage;
import com.ap.pages.LoginPage;
import com.ap.pages.MyAccountPage;

public class LoginTest extends BaseTest {
	
	HomePage homePage= null;
	LoginPage loginPage= null;
	MyAccountPage myAccPage = null;
	ForgotPasswordPage fp = null;

	@BeforeMethod
	public void initPages() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		myAccPage = new MyAccountPage(driver);
		fp = new ForgotPasswordPage(driver);
		
		homePage.navToLoginPage();
	}
	
	@Test(priority=0)
	public void verifyValidLogin() {
		loginPage.login("dem7@gmail.com","xyzabc");
		assertEquals(myAccPage.lbl_MyAccountPageTitle, getTitle());
		assertTrue(isElementPresent(myAccPage.lnk_signOut));
		myAccPage.signout();
	}

	@Test(priority=1)
	public void verifyInvalidLogin() {
		loginPage.login("dem77@gmail.com","xyzabc");
		assertFalse(isElementPresent(myAccPage.lnk_signOut));
	}

	@Test(priority=2)
	public void verifyEmptyLogin() {
		loginPage.login("","");
		assertFalse(isElementPresent(myAccPage.lnk_signOut));
	}
	
	@Test(priority=3)
	public void verifyForgotPasswordPageNavigation() {
		loginPage.navToForgotPwdPage();
		assertTrue(isElementPresent(fp.btn_RetrievePwd));
	}

}
