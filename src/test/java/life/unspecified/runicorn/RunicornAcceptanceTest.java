package life.unspecified.runicorn;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import life.unspecified.runicorn.support.RunicornPage;

public class RunicornAcceptanceTest {

	private static final String SELENIUM_DRIVER_URL = "http://selenium-chrome:4444/wd/hub";
	// private static final String SELENIUM_DRIVER_URL = "http://localhost:4444/wd/hub";
	private static RemoteWebDriver driver = null;
	private RunicornPage runicornPage;

	public static RemoteWebDriver getDriver() {
		if (driver == null) {
			throw new RuntimeException("Driver is not defined");
		}
		return driver;
	}

	@Before
	public void setupDriver() throws MalformedURLException {
		if (driver == null) {
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			URL driverLocation = new URL(SELENIUM_DRIVER_URL);
			System.out.println("Setup Driver:\n");
			System.out.println("\t" + capability.toString());
			System.out.println("\tDriver Location " + driverLocation.toString());

			try {
				driver = new RemoteWebDriver(driverLocation, capability);
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
				driver.manage().window().setSize(new Dimension(1920, 1080));
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}
		runicornPage = new RunicornPage(RunicornAcceptanceTest.getDriver());
	}

	@After
	public void teardown() {
		if (driver != null) {
			try {
				driver.quit();
			} finally {
				driver = null;
			}
		}
	}

	@Test
	public void startNewGame() {
		runicornPage = runicornPage.reset();
		runicornPage.assertStartButtonEnabled();
		runicornPage.assertRestartButtonDisabled();
		runicornPage.clickStartButton();
		runicornPage.assertStartButtonDisabled();
		runicornPage.assertRestartButtonDisabled();
	}

	@Test
	public void resetGame() {
		runicornPage = runicornPage.reset();
		runicornPage.clickStartButton();
		endGame();
		runicornPage.clickRestartButton();
		runicornPage.assertStartButtonDisabled();
		runicornPage.assertRestartButtonDisabled();
	}
	
	@Test
	public void jumpTest() {
		runicornPage = runicornPage.reset();
		runicornPage.clickStartButton();
		runicornPage.jump();
		assertTrue("Should be jumping", runicornPage.isJumping());
	}

	private void endGame() {
		long startTime = System.currentTimeMillis();
		long MAX_TIME = 5000;
		while (runicornPage.isGameStarted() && (System.currentTimeMillis() < (startTime + MAX_TIME))) {
			try {
				Thread.sleep(100);
			} catch (java.lang.InterruptedException intEx) {
			}
		}
		System.out.println("Time to end game was " + (System.currentTimeMillis() - startTime) + " millis");
	}

	

}