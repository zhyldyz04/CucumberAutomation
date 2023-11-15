package cashwise;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.APIRunner;

import java.util.HashMap;
import java.util.Map;

public class GetClients {

    @Test
    public void getClientParam(){

        String url = "https://backend.cashwise.us/api/myaccount/clients";
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKaWthMDRAZ21haWwuY29tIiwiZXhwIjoxNjgyNDM4MTQzLCJpYXQiOjE2ODE4MzMzNDN9.csuMLs_Rv5Kb1feSzBDPV8Y4D4BxbfXk-HVEXvfaNEfgE6Qzxt1-jWa-M-NVoClNDbwiYJ49CxjlkyKFIIn4sg";


        Map<String, Object> parameters = new HashMap<>();
        parameters.put("isArchived", false);
        parameters.put("page", 1);
        parameters.put("size", 5);

        Response response = RestAssured.given().auth().oauth2(token).params(parameters).get(url);
        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());


    }
}
