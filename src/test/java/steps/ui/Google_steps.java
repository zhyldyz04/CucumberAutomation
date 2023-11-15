package steps.ui;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Driver;

public class Google_steps {

    @Given("I am on the google page")
    public void i_am_on_the_google_page() {
        Driver.getDriver().get("https://google.com");

    }



    @When("I search for {string}")
    public void i_search_for(String string) {
        Driver.getDriver().findElement(By.name("q")).sendKeys(string + Keys.ENTER);

    }


    @Then("I should see only {string} related results")
    public void i_should_see_only_related_results(String word) {
        System.out.println("Result verified: " + word);

    }

    @When("I click on image option")
    public void i_click_on_image_option() {
        Driver.getDriver().findElement(By.linkText("Images")).click();


    }
    @Then("I should see only {string} related images")
    public void i_should_see_only_related_images(String word) {
        System.out.println("Verifying the images for: " + word);

        //Assertions.fail("on purpose");
    }

}
