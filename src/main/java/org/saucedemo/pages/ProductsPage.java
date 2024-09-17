package org.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {

    private WebDriver driver;

    private By inventoryItemsListDivs = By.xpath("//div[@class='inventory_item_label']/a/div");
    private By cartIconTag = By.xpath("//a[@class='shopping_cart_link']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getInventoryItemsList() {
        return driver.findElements(inventoryItemsListDivs);
    }

    public void clickCartIcon() {
        driver.findElement(cartIconTag).click();
    }

}
