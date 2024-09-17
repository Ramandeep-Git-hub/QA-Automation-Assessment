package stepdefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.saucedemo.pages.CartPage;
import org.testng.Assert;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static hooks.hooks.driver;

public class CartStepDef extends BaseStepDef {

    private CartPage cartPage;
    private Logger log;

    public CartStepDef() {
        log = LogManager.getLogger(this.getClass().getName());
    }

    @And("click checkout button")
    public void click_checkout_button() {
        cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"));
    }

    @And("verify {string} and {string} items price in the cart")
    public void verify_and_items_price_in_the_cart(String product, String secondProduct) {
        WebElement cartItem1 = driver.findElement(By.xpath("//div[@class='cart_item_label']/a/div[text()='" + product + "']/../following-sibling::div[@class='item_pricebar']/div"));
        log.info("Cart price of product1: " + cartItem1.getText());
        String product1price = properties.getProperty("Product1");
        log.info("Config price of product1: " + product1price);
        Assert.assertEquals(product1price, cartItem1.getText());


        WebElement cartItem2 = driver.findElement(By.xpath("//div[@class='cart_item_label']/a/div[text()='" + secondProduct + "']/../following-sibling::div[@class='item_pricebar']/div"));
        log.info("Cart price of product2: " + cartItem2.getText());
        String product2price = properties.getProperty("Product2");
        log.info("Config price of product2: " + product2price);
        Assert.assertEquals(product2price, cartItem2.getText());
    }
}
