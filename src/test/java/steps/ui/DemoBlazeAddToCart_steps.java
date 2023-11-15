package steps.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.DemoBlazeHomePage;
import utilities.Driver;
import utilities.Flow;
import utilities.TempStorage;

public class DemoBlazeAddToCart_steps {

    DemoBlazeHomePage blazeHomePage = new DemoBlazeHomePage();


    @Given("user clicks on the product {string}")
    public void user_clicks_on_the_product(String productTitle) {

        boolean found = false;
        for (WebElement product : blazeHomePage.products) {
            if (product.getText().equalsIgnoreCase(productTitle)) {
                found = true;
                product.click();
                break;

            }
        }
        if (!found) {
            Assert.fail("Product: " + productTitle + "is not found");


        }
        Flow.wait(500);


    }



    @When("user clicks add to cart button")
    public void user_clicks_add_to_cart_button() {
        String title = blazeHomePage.productTitle.getText();
        String price = blazeHomePage.productPrice.getText();
        TempStorage.addData("title", title);
        TempStorage.addData("price", price);

        blazeHomePage.addToCartBtn.click();
        Flow.wait(1000);

    }
    @Then("user sees {string} message on alert and clicks ok")
    public void user_sees_message_on_alert_and_clicks_ok(String message) {
        String alertMessage = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(message, alertMessage);
        Driver.getDriver().switchTo().alert().accept();

    }
    @Then("user clicks on Cart button")
    public void user_clicks_on_cart_button() {

        blazeHomePage.cartButton.click();


    }
    @Then("user verifies the details of the added product")
    public void user_verifies_the_details_of_the_added_product() {

        Assert.assertEquals(TempStorage.getData("title"), blazeHomePage.firstProductTitle.getText());
        Assert.assertTrue(TempStorage.getData("price").contains(blazeHomePage.getFirstProductPrice.getText()));

    }



}
