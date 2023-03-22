package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import pages.CashwiseTransactionsPage;
import utilities.Config;
import utilities.Driver;
import utilities.Flow;

public class CashwiseTransactions_steps {

    CashwiseTransactionsPage cashwiseTransactionsPage = new CashwiseTransactionsPage();

    @Given("I on cashwise home page")
    public void i_on_cashwise_home_page() {
        Driver.getDriver().get(Config.getValue("cashwiseURL"));
        cashwiseTransactionsPage.signInLink.click();
        cashwiseTransactionsPage.emailInputBox.sendKeys(Config.getValue("cashwiseLoginEmail"));
        cashwiseTransactionsPage.passwordInputBox.sendKeys("123123");

        cashwiseTransactionsPage.signInButton.click();
        Flow.wait(1000);

    }


    @When("I click on {string} button and click {string} button")
    public void i_click_on_button_and_click_button(String reports, String transactions) {
        cashwiseTransactionsPage.reportsButton.click();
        cashwiseTransactionsPage.transactionsButton.click();

    }


    @When("i should click on {string} button and create an expense")
    public void i_should_click_on_button_and_create_an_expense(String addExpenses) {

        cashwiseTransactionsPage.addExpensesButton.click();
        cashwiseTransactionsPage.expensesTitle.sendKeys("laptop");
        cashwiseTransactionsPage.expensesCategory.click();

        cashwiseTransactionsPage.listOfCategories.get(4).click();

        cashwiseTransactionsPage.paymentMethod.click();
        cashwiseTransactionsPage.listOfPaymentMethod.get(0).click();
        cashwiseTransactionsPage.paymentInvoice.click();
        cashwiseTransactionsPage.listOfInvoices.get(0).click();
        cashwiseTransactionsPage.amountOfMoney.sendKeys("12.5");
        cashwiseTransactionsPage.payButton.click();
    }






    @Then("I should be able to search specific transaction")
    public void i_should_be_able_to_search_specific_transaction() {

        cashwiseTransactionsPage.paymentTypeButton.click();

        cashwiseTransactionsPage.listOfPaymentType.get(2).click();
        cashwiseTransactionsPage.allStatusesButton.click();
        Flow.wait(500);

        cashwiseTransactionsPage.listOfStatuses.get(2).click();
        Flow.wait(1000);




    }

}
