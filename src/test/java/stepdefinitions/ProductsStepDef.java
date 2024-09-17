package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;

import static hooks.hooks.driver;

public class ProductsStepDef extends BaseStepDef {

    private ProductsPage productsPage;
    private Logger log;

    public ProductsStepDef() {
        log = LogManager.getLogger(this.getClass().getName());
        productsPage = new ProductsPage(driver);
    }

    @Given("the {string} is not present on the page")
    public void the_is_not_present_on_the_page(String product) {
        List<WebElement> inventoryItemsList = productsPage.getInventoryItemsList();
        Assert.assertFalse(inventoryItemsList.stream().anyMatch(e -> e.getText().trim().equals(product)));

    }

    @Given("the {string} is present on the page")
    public void the_present_on_the_page(String product) {
        List<WebElement> inventoryItemsList = productsPage.getInventoryItemsList();
        Assert.assertTrue(inventoryItemsList.stream().anyMatch(e -> e.getText().trim().equals(product)));
    }

    @When("the {string} is found print its price to console")
    public void the_is_found_print_its_price_to_console(String product) {
        WebElement item1Price = driver.findElement(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='" + product + "']/ancestor::div/following-sibling::div[@class='pricebar']/div"));
        log.info("Price of " + product + ": " + item1Price.getText());
        System.out.println("Price of " + product + ": " + item1Price.getText());
        properties.setProperty("Product1", item1Price.getText());
    }

    @And("add {string} and {string} items to the cart")
    public void add_and_items_to_the_cart(String product, String secondProduct) {
        WebElement product1AddToCartBtn = driver.findElement(By.xpath("//div[@class='inventory_item_label']/a/div[text()='" + product + "']/ancestor::div/following-sibling::div[@class='pricebar']/button"));
        WebElement product2AddToCartBtn = driver.findElement(By.xpath("//div[@class='inventory_item_label']/a/div[text()='" + secondProduct + "']/ancestor::div/following-sibling::div[@class='pricebar']/button"));

        WebElement item2Price = driver.findElement(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='" + secondProduct + "']/ancestor::div/following-sibling::div[@class='pricebar']/div"));
        log.info("Price of " + secondProduct + ": " + item2Price.getText());
        properties.setProperty("Product2", item2Price.getText());

        product1AddToCartBtn.click();
        product2AddToCartBtn.click();
        productsPage.clickCartIcon();
    }

    @When("cart icon is clicked")
    public void cart_icon_is_clicked() {
        productsPage.clickCartIcon();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));
    }

}
