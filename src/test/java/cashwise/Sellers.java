package cashwise;

import com.github.javafaker.Faker;
import entities.RequestBody;
import org.junit.Test;
import utilities.APIRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sellers {


    @Test
    public void createSeller(){
        String path = "/api/myaccount/sellers";
        RequestBody requestBody = new RequestBody();

        requestBody.setCompany_name("Amazon.com");
        requestBody.setSeller_name("Epson Brother");
        requestBody.setEmail("epson@gmail.com");
        requestBody.setPhone_number("8765431290");
        requestBody.setAddress("Online store");

        APIRunner.runPOST(path, requestBody);


    }

    @Test
    public void create10Sellers(){
        String path = "/api/myaccount/sellers";
        RequestBody requestBody = new RequestBody();
        Faker faker = new Faker();

        for(int i = 0; i < 10; i++){
            requestBody.setCompany_name(faker.company().name());
            requestBody.setSeller_name(faker.name().fullName());
            requestBody.setEmail(faker.internet().emailAddress());
            requestBody.setPhone_number(faker.phoneNumber().phoneNumber());
            requestBody.setAddress(faker.address().fullAddress());

            APIRunner.runPOST(path, requestBody);

        }
    }

    @Test
    public void create5BankAccount(){
        String path = "/api/myaccount/bankaccount";
        RequestBody requestBody = new RequestBody();
        Random random = new Random();
        List<String> payType = new ArrayList<>();
        payType.add("CASH");
        payType.add("BANK");
        payType.add("Electronic Money Transfer");


        Faker faker = new Faker();

        for(int i = 0; i < 5; i++){
            int index = random.nextInt(payType.size());
            int balance = random.nextInt(600, 9000);
            requestBody.setBalance(balance);
            requestBody.setType_of_pay(payType.get(index));
            requestBody.setBank_account_name(faker.company().name());
            requestBody.setDescription("Created  payment method number: " + i);
            APIRunner.runPOST(path, requestBody);
        }


    }

    @Test
    public void createBankAccount(){
        String path = "/api/myaccount/bankaccount";
        RequestBody requestBody = new RequestBody();
        requestBody.setBank_account_name("Bank Of America Credit");
        requestBody.setType_of_pay("BANK");
        requestBody.setDescription("BoA credit account");
        requestBody.setBalance(4500);

        APIRunner.runPOST(path,requestBody);
        System.out.println(APIRunner.getCustomResponse().getBank_account_name());
    }

}
