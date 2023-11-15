package steps.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import pages.DemoBlazeHomePage;
import utilities.Config;
import utilities.Driver;
import utilities.Flow;


import java.util.Random;

public class DemoBlazeSignUp_steps {

    DemoBlazeHomePage blazeHomePage = new DemoBlazeHomePage();

    @Given("user is on a demoblaze application")
    public void user_is_on_a_demoblaze_application() {
      //  MyLogger.info("User is on demo blaze website");
      Driver.getDriver().get(Config.getValue("demoblazeURL"));
    }

    @Given("user clicks on sing up button")
    public void user_clicks_on_sing_up_button() {
        //MyLogger.warn("Clicking the sign up link");
        blazeHomePage.signUpBtn.click();
        Flow.wait(500);

    }


    @When("user enters  credentials {string} and {string} and clicks sign up")
    public void user_enters_credentials_and_and_clicks_sign_up(String username, String password) {

        if(username.equals("placeholder")){
            username = username +new Random().nextInt(1000);
        }
        //MyLogger.warn("Entering Credentials: username: " + username + " pass: " + password);
        blazeHomePage.formUsernameInputBox.sendKeys(username);
        blazeHomePage.formPasswordInputBox.sendKeys(password);
        blazeHomePage.formSignUpBtn.click();
        Flow.wait(2000);

    }


    @Then("user should see alert message {string}")
    public void user_should_see_alert_message(String message) {
       // MyLogger.info("Verifying the alert messages");
        Alert signUpAlert = Driver.getDriver().switchTo().alert();
        String actualMessage = signUpAlert.getText();
        Assert.assertEquals(message, actualMessage);

    }

}
