package life.unspecified.runicorn.support;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.Assert.assertTrue;

public class RunicornPage {

	public static String RUNICORN_URL = "http://runicorn_runicorn:8080";

    private RemoteWebDriver driver;

    public RunicornPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public RunicornPage reset() {
        getDriver().navigate().to(RUNICORN_URL);
        return this;
    }   

    public WebElement getElementById(String id) { 
         return getDriver().findElementById(id);
    }

    public boolean isValidState() {
        return false;
    }

    public void assertIsValidState() {
        assertTrue("Fail assertion", false);
    }


    protected RemoteWebDriver getDriver() {
        return driver;
    }

}