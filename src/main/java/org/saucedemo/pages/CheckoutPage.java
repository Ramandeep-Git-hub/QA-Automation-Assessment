package org.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    private By firstNameInput = By.xpath("//input[@id='first-name']");
    private By lastNameInput = By.xpath("//input[@id='last-name']");
    private By zipInput = By.xpath("//input[@id='postal-code']");
    private By continueInput = By.xpath("//input[@id='continue']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFormDetails(String firstName, String lastName, String zip) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(zipInput).sendKeys(zip);
    }

    public void clickContinueInput() {
        driver.findElement(continueInput).click();
    }

}
