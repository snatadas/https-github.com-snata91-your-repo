package com.vetaar.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private AppiumDriver<MobileElement> driver;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    // Constructor
    public LoginPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to perform login
    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    // Method to check if the user is logged in
    public boolean isLoggedIn() {
        // Check if a specific element exists that indicates the user is logged in
        // For example, you might check for the presence of a logout button
        return driver.findElementsById("logoutButton").size() > 0;
    }
}


