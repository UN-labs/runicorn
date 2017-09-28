package life.unspecified.runicorn.support;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RunicornPage {

	public static String RUNICORN_URL = "http://runicorn:8080";

    private RemoteWebDriver driver;

    public RunicornPage(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public RunicornPage reset() {
        getDriver().navigate().to(RUNICORN_URL);
        try {
            Thread.sleep(2000);
        } catch (java.lang.InterruptedException intEx) {
        }
        return this;
    }   

    public WebElement getElementById(String id) { 
        return getDriver().findElementById(id);
    }

    public boolean isValidState() {
        return getTitle().getText().equals("RUNICORN");
    }

    public void assertIsValidState() {
        assertEquals("Page title should be present", getTitle().getText(), "RUNICORN");
    }

    public void assertStartButtonEnabled() {
        WebElement startButton = getStartButton();
        assertNotNull("Start button must be present", startButton);
        assertEquals("Start button class must be enabled", "start_game", startButton.getAttribute("class"));
    }

    public void assertStartButtonDisabled() {
        WebElement startButton = getStartButton();
        assertNotNull("Start button must be present", startButton);
        assertEquals("Start button class must be disabled", "start_game disable_button", startButton.getAttribute("class"));
    }

    public void assertRestartButtonEnabled() {
        WebElement restartButton = getRestartButton();
        assertNotNull("Start button must be present", restartButton);
        assertEquals("Start button class must be enabled", "init_game", restartButton.getAttribute("class"));
    }

    public void assertRestartButtonDisabled() {
        WebElement restartButton = getRestartButton();
        assertNotNull("Restart button must be present", restartButton);
        assertEquals("Restart button class must be disabled", "init_game disable_button", restartButton.getAttribute("class"));
    }

    public WebElement getTitle() {
        return getDriver().findElement(By.cssSelector("body > h1.title"));
    }

    public WebElement getButtons() {
        return getDriver().findElement(By.id("buttons"));
    }

    public WebElement getStartButton() {
       return getDriver().findElement(By.cssSelector("#buttons > button.start_game"));
    }

    public WebElement getRestartButton() {
        return getDriver().findElement(By.cssSelector("#buttons > button.init_game"));
    }

    public WebElement getCanvas() {
        return getDriver().findElement(By.id("canvas_wrapper"));
    }

    protected RemoteWebDriver getDriver() {
        return driver;
    }

}