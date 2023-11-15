package cashwise;

import groovyjarjarantlr4.v4.analysis.AnalysisPipeline;
import org.junit.Test;
import utilities.APIRunner;

public class BankAccount {

    @Test
    public void deleteBankAccounts() {

        String bankAccountPath = "/api/myaccount/bankaccount";
        APIRunner.runGetList(bankAccountPath);
        for (int i = 0; i < APIRunner.getResponseList().length; i++) {
            int balance = APIRunner.getResponseList()[i].getBalance();
            if (balance > 1000 && balance < 2000) {
                String id = APIRunner.getResponseList()[i].getId();
                String path = "/api/myaccount/bankaccount/" + id;

                APIRunner.runDELETE(path);
            }

        }
        System.out.println("After Deletion");
        APIRunner.runGetList(bankAccountPath);
        for (int i = 0; i < APIRunner.getResponseList().length; i++) {
            System.out.println("Bank name: " + APIRunner.getResponseList()[i].getBank_account_name());
            System.out.println("Balance: " + APIRunner.getResponseList()[i].getBalance());



    }}}

