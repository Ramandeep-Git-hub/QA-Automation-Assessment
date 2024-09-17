package org.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By checkoutButton = By.xpath(" //Button[@id='checkout']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

}
