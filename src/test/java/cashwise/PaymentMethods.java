package cashwise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import entities.CustomResponse;
import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.*;

public class PaymentMethods {

    @Test
    public void createPaymentMethod(){

        RequestBody requestBody = new RequestBody();
        requestBody.setType_of_pay("BANK");
        requestBody.setBank_account_name("US Bank");
        requestBody.setBalance(1500);
        requestBody.setDescription("US Bank Credit account");

        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKaWthMDRAZ21haWwuY29tIiwiZXhwIjoxNjgyMDI0MjI1LCJpYXQiOjE2ODE0MTk0MjV9.gVP6dburXQ7VQDpr95ISwClD1rRo9mUK_xlZKKeeUhn6Hv_A31UE12T2XAEa4bScYFikEuOfTPaY25dR02GQmA";

        Response response = RestAssured.given().auth().oauth2(token).
                contentType(ContentType.JSON).body(requestBody).
                post("https://backend.cashwise.us/api/myaccount/bankaccount");

        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());



    }

    @Test
    public void create13Methods(){
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKaWthMDRAZ21haWwuY29tIiwiZXhwIjoxNjgyMDI0MjI1LCJpYXQiOjE2ODE0MTk0MjV9.gVP6dburXQ7VQDpr95ISwClD1rRo9mUK_xlZKKeeUhn6Hv_A31UE12T2XAEa4bScYFikEuOfTPaY25dR02GQmA";

        Faker faker = new Faker();
        Random random = new Random();

        List<String> payTypes = new ArrayList<>();
        payTypes.add("BANK");
        payTypes.add("CASH");
        payTypes.add("ELECTRONIC_MONEY_TRANSFER");


        for(int i = 0; i < 13; i++){

            RequestBody requestBody = new RequestBody();
            int index = random.nextInt(payTypes.size());
            requestBody.setType_of_pay(payTypes.get(index));
            requestBody.setBank_account_name(faker.company().name());
            int balance = random.nextInt(200, 5000);
            requestBody.setBalance(balance);
            requestBody.setDescription("created 13 banks API");

            Response response = RestAssured.given().auth().oauth2(token).
                    contentType(ContentType.JSON).body(requestBody).
                    post("https://backend.cashwise.us/api/myaccount/bankaccount");

            System.out.println("Status creation " + (i+1) + ": " +response.statusCode());

        }

    }

    @Test
    public void deleteAccount() throws JsonProcessingException {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKaWthMDRAZ21haWwuY29tIiwiZXhwIjoxNjgyMDI0MjI1LCJpYXQiOjE2ODE0MTk0MjV9.gVP6dburXQ7VQDpr95ISwClD1rRo9mUK_xlZKKeeUhn6Hv_A31UE12T2XAEa4bScYFikEuOfTPaY25dR02GQmA";

        Response response = RestAssured.given().auth().oauth2(token).get("https://backend.cashwise.us/api/myaccount/bankaccount");
        System.out.println(response.statusCode());
        //System.out.println(response.asPrettyString());

        ObjectMapper mapper = new ObjectMapper();

        CustomResponse [] myResponse = mapper.readValue(response.asString(), CustomResponse[].class);
        List<String> idList = new ArrayList<>();

        for(int i = 0; i < myResponse.length; i++){
           // System.out.println(myResponse[i].getBank_account_name());

            if(myResponse[i].getBalance() < 1000 ){
              idList.add(myResponse[i].getId());

                }


            }
        System.out.println(idList);


        for(String id: idList){
            String url = "https://backend.cashwise.us/api/myaccount/bankaccount/" + id;
            Response response1 = RestAssured.given().auth().oauth2(token).delete(url);
            System.out.println("Deletion status: " + response1.statusCode());


        }

        }




    }

