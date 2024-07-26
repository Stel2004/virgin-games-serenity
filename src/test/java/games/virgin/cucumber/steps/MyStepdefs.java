package games.virgin.cucumber.steps;

import games.virgin.virgingamesinfo.VirginGamesSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

/**
 * Created by smita
 */
public class MyStepdefs {

    static ValidatableResponse response;

    @Steps
    VirginGamesSteps steps;

    @When("User sends a GET request to jackpots bingo endpoint")
    public void userSendsAGETRequestToJackpotsBingoEndpoint() {
        response = steps.getAllJackpotsBingo();
    }

    @Then("Verify the status code of request")
    public void verifyTheStatusCodeOfRequest() {
        response.statusCode(200);
    }

    @Then("User must get back a valid status code {int} as per the currency: {string}")
    public void userMustGetBackAValidStatusCodeAsPerTheCurrency(int statusCode, String currency) {
        //response = steps.getAllJackpotsBingoByCurrency(currency).statusCode(statusCode);
        HashMap<String,Object> currencyList = steps.getAllJackpotsBingoByCurrency(currency);
        Assert.assertThat(currencyList, hasValue(currency));
    }
}
