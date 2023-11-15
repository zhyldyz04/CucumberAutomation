package steps.api_steps;

import entities.RequestBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.APIRunner;

public class CreateBankAccount_api_steps {

    @Given("user hits create bank account API with {string} {string} {string} {string} {string}")
    public void user_hits_create_bank_account_api_with(String path, String bankType, String bankTitle, String description, int balance) {

       String  path1 = "/api/myaccount/bankaccount";
        RequestBody requestBody = new RequestBody();
        requestBody.setType_of_pay(bankType);
        requestBody.setBank_account_name(bankTitle);
        requestBody.setDescription(description);
        requestBody.setBalance(balance);

        APIRunner.runPOST(path1, requestBody);
    }
    @Then("user verifies that bank account is successfully created")
    public void user_verifies_that_bank_account_is_successfully_created() {

    }


    @Given("user hits create bank account API without token with {string} {string} {string} {string} {string}")
    public void user_hits_create_bank_account_api_without_token_with(String string, String string2, String string3, String string4, String string5) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user verifies the status code {string}")
    public void user_verifies_the_status_code(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
