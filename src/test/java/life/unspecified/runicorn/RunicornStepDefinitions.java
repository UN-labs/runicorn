package life.unspecified.runicorn;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import life.unspecified.runicorn.support.RunicornPage;

public class RunicornStepDefinitions {

	private RemoteWebDriver driver = StepSetupHooks.getDriver();
	private RunicornPage runicornPage = new RunicornPage(driver);

   @Then("^I am on the runicorn page$")
	public void i_am_on_the_runicorn_page() throws Throwable {
		((RunicornPage)runicornPage).assertIsValidState();
	}

	@Given("^I load runicorn$")
	public void i_load_runicorn() throws Throwable {
		runicornPage = runicornPage.reset();
	}

	@Given("^I am on the Runicorn homepage$")
	public void i_am_on_the_Runicorn_homepage() throws Throwable {
		i_load_runicorn();
	}

	@Given("^the start game button is active$")
	public void the_start_game_button_is_active() throws Throwable {
		runicornPage.assertStartButtonEnabled();
	}

	@Given("^the restart button is inactive$")
	public void the_restart_button_is_inactive() throws Throwable {
		runicornPage.assertRestartButtonDisabled();
	}

	@When("^I click start game$")
	public void i_click_start_game() throws Throwable {
		runicornPage.clickStartButton();
	}

	@Then("^the game starts$")
	public void the_game_starts() throws Throwable {
		runicornPage.assertStartButtonDisabled();
		runicornPage.assertRestartButtonDisabled();
	}

	@Given("^I end the game$")
	public void i_end_the_game() throws Throwable {
		long startTime = System.currentTimeMillis();
		long MAX_TIME = 5000;
		while(runicornPage.isGameStarted() && (System.currentTimeMillis( ) < (startTime + MAX_TIME))) {
			try {
				Thread.sleep(100);
			} catch (java.lang.InterruptedException intEx) {
        	}
		}
		System.out.println("Time to end game was " + (System.currentTimeMillis() - startTime) + " millis");
	}

	@Given("^the start game button is inactive$")
	public void the_start_game_button_is_inactive() throws Throwable {
		runicornPage.assertStartButtonDisabled();
	}

	@Given("^the restart button is active$")
	public void the_restart_game_is_active() throws Throwable {
		runicornPage.assertRestartButtonEnabled();
	}

	@When("^I click restart game$")
	public void i_click_restart_game() throws Throwable {
		runicornPage.clickRestartButton();
	}

	@Given("^I have started the game$")
	public void i_have_started_the_game() throws Throwable {
		runicornPage = runicornPage.reset();	
		runicornPage.clickStartButton();
		runicornPage.waitForPageStarted();
	}

	@When("^I press the space bar$")
	public void i_press_the_space_bar() throws Throwable {
     	runicornPage.jump();
	}

	@Then("^My unicorn jumps$")
	public void my_unicorn_jumps() throws Throwable {
		assertTrue("Should be jumping", runicornPage.isJumping());
	}

}