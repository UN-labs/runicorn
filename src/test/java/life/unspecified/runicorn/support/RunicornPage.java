package life.unspecified.runicorn.support;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
// import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
// import static org.openqa.selenium.support.ui.ExpectedConditions.not;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertNotNull;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        assertFalse("Start button class must be disabled", startButton.getAttribute("class").contains("disable_button"));
    }

    public void assertStartButtonDisabled() {
        WebElement startButton = getStartButton();
        assertNotNull("Start button must be present", startButton);
        assertTrue("Start button class must be disabled", startButton.getAttribute("class").contains("disable_button"));
    }

    public void assertRestartButtonEnabled() {
        WebElement restartButton = getRestartButton();
        assertNotNull("Start button must be present", restartButton);
        assertFalse("Restart button class must be enabled", restartButton.getAttribute("class").contains("disable_button"));
    }

    public void assertRestartButtonDisabled() {
        WebElement restartButton = getRestartButton();
        assertNotNull("Restart button must be present", restartButton);
        assertTrue("Start button class must be disabled", restartButton.getAttribute("class").contains("disable_button"));
    }

    public WebElement getTitle() {
        return getDriver().findElement(By.cssSelector("body > h1.title"));
    }

    public WebElement getButtons() {
        return getDriver().findElement(By.id("buttons"));
    }

    public boolean isStartButtonEnabled() {
       return !getStartButton().getAttribute("class").contains("disable_button");
    }

    public boolean isRestartButtonEnabled() {
        return !getRestartButton().getAttribute("class").contains("disable_button");
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

    public boolean isJumping() {
        return (Boolean)getDriver().executeScript("function isJumping() {return the_unicorn.jumped;}; return isJumping();");
    }

    public void clickStartButton() {
        waitAndClick(getStartButton());
    }

    public void clickRestartButton() {
        waitAndClick(getRestartButton());
    }

    private void waitAndClick(WebElement button) {
        long startTime = System.currentTimeMillis();
        WebDriverWait wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(button, "class", "disable_button")));
        System.out.println("Elapsed time is " + (System.currentTimeMillis() - startTime));
        button.click();
    }

    public boolean isGameStarted() {
        return !isStartButtonEnabled() && !isRestartButtonEnabled();
    }

    public void waitForPageStarted() {

    }

    public void jump() {
        WebElement body = getDriver().findElement(By.cssSelector("body"));
        body.sendKeys(" ");
    }

    protected RemoteWebDriver getDriver() {
        return driver;
    }

    private void dumpMethods(String classname) {
        try {
        Method[] methods = Class.forName(classname).getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    } catch (Exception ex) {
        System.out.println("Failed to dump methods: " + ex.getMessage());
    }
    }


}