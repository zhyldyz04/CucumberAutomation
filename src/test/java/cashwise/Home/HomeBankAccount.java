package cashwise.Home;

import com.github.javafaker.Faker;
import entities.RequestBody;
import org.junit.Assert;
import org.junit.Test;
import utilities.APIRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeBankAccount {

    @Test
    public void createBankAcc(){
        String path = "/api/myaccount/bankaccount";

        List<String> payType = new ArrayList<>();
        payType.add("CASH");
        payType.add("BANK");
        payType.add("ELECTRONIC_MONEY_TRANSFER");

        Faker faker = new Faker();

        Random random = new Random();
        int index = random.nextInt(payType.size());
        RequestBody requestBody = new RequestBody();
        requestBody.setType_of_pay(payType.get(index));
        requestBody.setBank_account_name(faker.company().name());
        int balance = random.nextInt(100, 13000);
        requestBody.setBalance(balance);

        APIRunner.runPOST(path, requestBody);


    }


    @Test//не правильно
    public void updateBankAcc(){

        String getPath = "/api/myaccount/bankaccount";

        APIRunner.runGetList(getPath);

        for(int i = 0; i < APIRunner.getResponseList().length; i++){
            String path = "/api/myaccount/bankaccount/" + i;
            RequestBody requestBody = new RequestBody();
            requestBody.setBalance(0);
            System.out.println(APIRunner.getResponseList()[i].getBalance());
            APIRunner.runPUT(path, requestBody);

        }

    }

    @Test//не правильно
    public void addDescription(){
        String getPath = "/api/myaccount/bankaccount";
        APIRunner.runGetList(getPath);

        Faker faker = new Faker();

        for(int i = 0; i < APIRunner.getResponseList().length; i++){


            Assert.assertNotNull(APIRunner.getResponseList()[i].getDescription());

                RequestBody requestBody = new RequestBody();
                requestBody.setDescription(faker.food().vegetable());
                //APIRunner.runPUT(path,requestBody);


            }

        }


        @Test
    public void addToElectronicMoney(){
        
        }


    }


