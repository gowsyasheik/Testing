package com.janitri.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(tagName = "button")
    WebElement loginButton;

    @FindBy(css = "[type='button'] svg") // update if different
    WebElement eyeIcon;

    @FindBy(xpath = "//*[contains(text(), 'Invalid email or password')]")
    WebElement errorMsg;

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String pwd) {
        passwordField.clear();
        passwordField.sendKeys(pwd);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isLoginButtonEnabled() {
        return loginButton.isEnabled();
    }

    public boolean isPasswordMasked() {
        return passwordField.getAttribute("type").equals("password");
    }

    public void togglePasswordVisibility() {
        eyeIcon.click();
    }

    public String getErrorMessage() {
        return errorMsg.getText();
    }

    public boolean areElementsVisible() {
        return emailField.isDisplayed() && passwordField.isDisplayed() &&
               loginButton.isDisplayed() && eyeIcon.isDisplayed();
    }
}


