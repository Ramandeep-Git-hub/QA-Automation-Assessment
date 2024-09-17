package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.saucedemo.pages.CheckoutOverviewPage;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;

import static hooks.hooks.driver;

public class CheckoutOverviewStepDef extends BaseStepDef {

    private CheckoutOverviewPage checkoutOverviewPage;
    private Logger log;

    public CheckoutOverviewStepDef() {
        log = LogManager.getLogger(this.getClass().getName());
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    @Then("verify the {string} {string} prices and {string} price")
    public void verify_the_prices_and_price(String product, String secondProduct, String totalPrice) {
        WebElement cartItem1 = driver.findElement(By.xpath("//div[@class='cart_item_label']/a/div[text()='" + product + "']/../following-sibling::div[@class='item_pricebar']/div"));
        log.info("Summary overview price1: " + cartItem1.getText());
        Assert.assertEquals(properties.getProperty("Product1"), cartItem1.getText());

        WebElement cartItem2 = driver.findElement(By.xpath("//div[@class='cart_item_label']/a/div[text()='" + secondProduct + "']/../following-sibling::div[@class='item_pricebar']/div"));
        log.info("Summary overview price2: " + cartItem2.getText());
        Assert.assertEquals(properties.getProperty("Product2"), cartItem2.getText());

        log.info("Total price: " + checkoutOverviewPage.getItemTotalPrice());
        Assert.assertEquals(checkoutOverviewPage.getItemTotalPrice(), totalPrice);
    }

    @And("click Finish button to verify order is complete")
    public void click_finish_button_to_verify_order_is_complete() {
        checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete.html"));
    }

    @Then("logout of app")
    public void logout_of_app() {
        checkoutOverviewPage.clickLeftMenuIconButton();
        checkoutOverviewPage.clickLogOutTextTag();
    }

}
