package org.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutOverviewPage {

    private WebDriver driver;

    private By itemTotalPriceDiv = By.xpath("//div[@class='summary_subtotal_label']");
    private By finishButton = By.xpath("//button[@id='finish']");
    private By leftMenuIconButton = By.xpath("//button[@id='react-burger-menu-btn']");
    private By logOutTextTag = By.xpath("//a[@id='logout_sidebar_link']");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getItemTotalPrice() {
        WebElement ele = driver.findElement(itemTotalPriceDiv);
        int index = ele.getText().indexOf("$");
        return ele.getText().substring(index);
    }

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }

    public void clickLeftMenuIconButton() {
         driver.findElement(leftMenuIconButton).click();
    }

    public void clickLogOutTextTag() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        driver.findElement(logOutTextTag).click();
    }
}
