package steps.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CashwiseInvoicesPage;
import utilities.Config;
import utilities.Driver;

public class Zhyldyz_steps {

    CashwiseInvoicesPage invoicesPage = new CashwiseInvoicesPage();

    @Given("user goes to cashwise applicaton and successfully logs in")
    public void user_goes_to_cashwise_applicaton_and_successfully_logs_in() {
       Driver.getDriver().get(Config.getValue("cashwiseURL"));
       invoicesPage.signInLink.click();
       invoicesPage.emailInputBox.sendKeys("test@tester.com");
       invoicesPage.passwordInputBox.sendKeys("123456");
       invoicesPage.signInButton.click();
    }
    @Then("user goes to Sales button")
    public void user_goes_to_sales_button() {
       invoicesPage.salesButton.click();
    }
    @Then("clicks on Invoice tab")
    public void clicks_on_invoice_tab() {
        invoicesPage.invoicesTab.click();
    }
    @When("user clicks on status button and sort for Not paid invoices")
    public void user_clicks_on_status_button_and_sort_for_not_paid_invoices() {
        invoicesPage.statusButton.click();
        invoicesPage.statusList.get(1).click();



    }


    @Then("user should see all unpaid invoices")
    public void user_should_see_all_unpaid_invoices() {
        String expectedWidget = "Total unpaid amount:";
        String actual = invoicesPage.widget.getText();
        Assert.assertEquals( expectedWidget, actual);
    }





}

