package cashwise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.CustomResponse;
import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class Login {

    @Test
    public void authorization() throws JsonProcessingException {
        RequestBody requestBody = new RequestBody();
        requestBody.setEmail("test@tester.com");
        requestBody.setPassword("123456");




        Response response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post("https://backend.cashwise.us/api/myaccount/auth/login");

        System.out.println(response.statusCode());
        System.out.println();
        //System.out.println(response.asString());
        ObjectMapper mapper = new ObjectMapper();
        CustomResponse customResponse = mapper.readValue(response.asString(),CustomResponse.class);

        System.out.println(customResponse.getJwt_token());
        System.out.println(customResponse.getMessage());






    }

    @Test
    public void getIncomeCategories(){
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QHRlc3Rlci5jb20iLCJleHAiOjE2ODE2OTEzNTQsImlhdCI6MTY4MTA4NjU1NH0.I0I1BaJtDbhYC8vHwm2f1YJnLsb9p2tdO5xWYioSq3tQ7MFFUY-evUyggo4URr-Cv-AJMuk6IKRV4SvgaXY9Pg";

       Response response =  RestAssured.given().contentType(ContentType.JSON).auth().oauth2(token).get("https://backend.cashwise.us/api/myaccount/categories/income");
        System.out.println(response.statusCode());
        System.out.println(response.asString());

       String title = response.jsonPath().get("[0].category_title");
        System.out.println(title);

        for(int i = 0; i < 61; i++){
            String path = "[" + i + "].flag";
            boolean flag = response.jsonPath().get(path);
            Assert.assertTrue(flag);

            String path2 = "[" +i + "].category_title";
            String title2 = response.jsonPath().get(path2);
            if(title2.trim().isEmpty()){
                System.out.println("Found at: " + i);
            }
        }





    }

    @Test
    public void reqResCreate(){
        String body =  "{\n" +
                "    \"name\": \"Codewise\",\n" +
                "    \"job\": \"cashier \"\n" +
                "}";

       Response response = RestAssured.given().contentType(ContentType.JSON).body(body).post("https://reqres.in/api/users");
        System.out.println(response.statusCode());
        System.out.println(response.asString());

    }
}
