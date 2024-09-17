package stepdefinitions;

import io.cucumber.java.en.And;
import org.saucedemo.pages.CheckoutPage;
import org.testng.Assert;

import static hooks.hooks.driver;

public class CheckoutStepDef {

    private CheckoutPage checkoutPage;

    @And("fill {string} {string} {string} form details and continue")
    public void fill_form_details_and_continue(String firstName, String lastName, String zip){
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillFormDetails(firstName, lastName, zip);
        checkoutPage.clickContinueInput();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two.html"));
    }
}
