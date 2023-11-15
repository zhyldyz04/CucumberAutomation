package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;


public class CashwiseAPI {

    @Test
    public void getCategories(){

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        //System.out.println(response.asString());

        String data = response.jsonPath().get("data[0].email");
        System.out.println(data);
    }


}
