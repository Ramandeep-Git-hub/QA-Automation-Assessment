package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.saucedemo.pages.LoginPage;
import org.testng.Assert;
import static hooks.hooks.driver;


public class LoginStepDef extends BaseStepDef{

    private LoginPage loginPage;

    @Given("I am on the sauce demo login page")
    public void i_am_on_the_sauce_demo_login_page() {
        driver.get(properties.getProperty("url"));
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"));
        loginPage = new LoginPage(driver);
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.enterUserName(properties.getProperty("user"));
        loginPage.enterPassword(properties.getProperty("password"));
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMessage) {
        WebElement userNameInput = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertEquals(errorMessage, userNameInput.getText());
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

}
