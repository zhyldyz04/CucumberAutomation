package cashwise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import entities.CustomResponse;
import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class SellersTest {


    @Test
    public void SingleSellerInfo() throws JsonProcessingException {

        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QHRlc3Rlci5jb20iLCJleHAiOjE2ODE4NTY3NjEsImlhdCI6MTY4MTI1MTk2MX0.5X2nUVEWS4VFo2ZjqgSw3CeC7kmwSS8rMtQ1ALfPaMtqr2C_zuj7YdJLL5RUrvoUBe8Hj6o9p-NA2lcXT8jOUQ";


        Response response = RestAssured.given().auth().oauth2(token).get("https://backend.cashwise.us/api/myaccount/sellers/112");
       Assert.assertEquals("Connecting to API is failed", 200, response.statusCode());


        ObjectMapper mapper = new ObjectMapper();
        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);
        Assert.assertNotNull("Company name is null", customResponse.getCompany_name());
        Assert.assertNotNull(customResponse.getSeller_name());
        Assert.assertFalse(customResponse.getCompany_name().trim().isEmpty());
        Assert.assertFalse(customResponse.getSeller_name().trim().isEmpty());

    }

    @Test
    public void createSellerTest() {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QHRlc3Rlci5jb20iLCJleHAiOjE2ODE4NTY3NjEsImlhdCI6MTY4MTI1MTk2MX0.5X2nUVEWS4VFo2ZjqgSw3CeC7kmwSS8rMtQ1ALfPaMtqr2C_zuj7YdJLL5RUrvoUBe8Hj6o9p-NA2lcXT8jOUQ";

        Faker faker = new Faker();
        String companyName = faker.company().name();
        String sellerName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String phoneNum = faker.phoneNumber().cellPhone();
        String address = faker.address().city();

        RequestBody requestBody = new RequestBody();
        requestBody.setCompany_name(companyName);
        requestBody.setSeller_name(sellerName);
        requestBody.setEmail(email);
        requestBody.setPhone_number(phoneNum);
        requestBody.setAddress(address);

        Response response = RestAssured.given().auth().oauth2(token).
                contentType(ContentType.JSON).body(requestBody).post("https://backend.cashwise.us/api/myaccount/sellers");
        Assert.assertEquals(200, response.statusCode());
        System.out.println(response.asPrettyString());

        int id = response.jsonPath().get("seller_id");

        String url = "https://backend.cashwise.us/api/myaccount/sellers" + id;
        Response response1 = RestAssured.given().auth().oauth2(token).get(url);
        Assert.assertEquals(200, response1.statusCode());
        System.out.println(response1.asPrettyString());

    }












    }






