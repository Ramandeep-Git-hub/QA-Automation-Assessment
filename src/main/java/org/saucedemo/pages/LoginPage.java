package org.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    private By userNameInputField = By.xpath("//input[@id=\"user-name\"]");
    private By passwordInputField = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//input[@id=\"login-button\"]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String username) {
        WebElement userNameInput = driver.findElement(userNameInputField);
        userNameInput.clear();
        userNameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputField);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
