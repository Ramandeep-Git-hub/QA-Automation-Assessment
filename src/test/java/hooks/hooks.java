package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import stepdefinitions.BaseStepDef;
import java.util.Objects;

public class hooks {

    //private static final Logger log = LoggerFactory.getLogger(hooks.class);
    public static WebDriver driver;

    @Before
    public void setup() throws Exception {

        BaseStepDef baseStepDef = new BaseStepDef();
        baseStepDef.setupPropConfig();
        String browser = baseStepDef.getBrowser();

        if (Objects.equals(browser, "Chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        if (Objects.equals(browser, "Firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
             driver.quit();
        }
    }
}


