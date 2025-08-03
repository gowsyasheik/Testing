package com.janitri.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.janitri.pages.LoginPage;

public class LoginTests extends BaseTest {

	@Test
	public void testLoginButtonDisabledWhenFieldsAreEmpty() {
		LoginPage login = new LoginPage(driver);
		login.enterEmail("");
		login.enterPassword("");
		Assert.assertFalse(login.isLoginButtonEnabled(), "Login button should be disabled");
	}

	@Test
	public void testPasswordMaskedButton() {
		LoginPage login = new LoginPage(driver);
		login.enterPassword("Test1234");
		Assert.assertTrue(login.isPasswordMasked(), "Password should be masked");
		login.togglePasswordVisibility();
		Assert.assertFalse(login.isPasswordMasked(), "Password should be visible after toggle");
	}

	@Test
	public void testInvalidLoginShowErrorMsg() {
		LoginPage login = new LoginPage(driver);
		login.enterEmail("wrong@test.com");
		login.enterPassword("wrongpass");
		login.clickLogin();
		Assert.assertTrue(login.getErrorMessage().contains("Invalid"), "Error message should appear for wrong creds");
	}

	@Test
	public void testPageElementsAreVisible() {
		LoginPage login = new LoginPage(driver);
		Assert.assertTrue(login.areElementsVisible(), "All login page elements should be visible");
	}
}
