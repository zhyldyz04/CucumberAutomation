package steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CashwiseInvoicePagePdf;
import pages.CashwiseLoginPage;
import utilities.Driver;

public class Aigerim_steps {



        CashwiseLoginPage cashwiseLoginPage = new CashwiseLoginPage();
        CashwiseInvoicePagePdf invoicePagePdf = new CashwiseInvoicePagePdf();

        @Given("User is on the Cashwise web page")
        public void user_is_on_the_cashwise_web_page() {
            Driver.getDriver().get("https://cashwise.us");

        }

        @Given("User logs in with valid credentials in CashWise")
        public void user_logs_in_with_valid_credentials_in_cash_wise() {
            cashwiseLoginPage.signInLink.click();
            cashwiseLoginPage.emailInputBox.sendKeys("Rocket@gmail.com");
            cashwiseLoginPage.passwordInputBox.sendKeys("111222");
            cashwiseLoginPage.signInButton.click();

        }

        @Then("User User clicks on the Sales menuBar")
        public void user_user_clicks_on_the_sales_menu_bar() {
            invoicePagePdf.SalesButton.click();
        }

        @Then("User clicks on the Invoice bar")
        public void user_clicks_on_the_invoice_bar() {
            invoicePagePdf.InvoiceButton.click();
        }

        @When("User clicks on the three dots menu bar and application should offer Show PDF version option")
        public void user_clicks_on_the_three_dots_menu_bar_and_application_should_offer_show_pdf_version_option() {
            invoicePagePdf.ThreeDotsBurgerMenu.click();
        }

        @And("User choose Show PDF version and clicks on it")
        public void user_choose_show_pdf_version_and_clicks_on_it() {
            invoicePagePdf.ShowPDFVersion.click();
        }

        @Then("User should be able to see PDF file and {string} option")
        public void user_should_be_able_to_see_pdf_file_and_option(String option) {
            String actualOption = invoicePagePdf.downloadPDF.getText();
            Assert.assertEquals(option,actualOption);

        }
    }

