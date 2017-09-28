package life.unspecified.runicorn;

import static org.junit.Assert.assertFalse;

import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import life.unspecified.runicorn.support.RunicornPage;

public class RunicornStepDefinitions {

    private RemoteWebDriver driver = StepSetupHooks.getDriver();
    private RunicornPage runicornPage = new RunicornPage(driver);

    //@Given("^I am on the home page$") 
    @Then("^I am on the runicorn page$")
    public void i_am_on_the_runicorn_page() throws Throwable {
        ((RunicornPage)runicornPage).assertIsValidState();
    }

    @Given("^I load runicorn$")
    public void i_load_crazy_kittens() throws Throwable {
        runicornPage = runicornPage.reset();
    }

}