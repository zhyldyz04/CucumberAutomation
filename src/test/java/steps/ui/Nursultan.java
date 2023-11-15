package steps.ui;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Nursultan {

    @Test

    public void archiveClients(){


        boolean isArchived = true;
        int page = 1;
        int size = 10;
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0b3JvYmFldi5udXJzdWx0YW5AZ21haWwuY29tIiwiZXhwIjoxNjgxOTIyNDIxLCJpYXQiOjE2ODEzMTc2MjF9.jPTRLQleyaAredX8rDOe-Q4Jfw8U-b08qQItz9OJ9I_HpDzvP5t2zfdb82TtXf9bnMt9hlg_bDq_oQaCIBHR8Q";
        Response response = RestAssured.given().contentType(ContentType.JSON).auth().oauth2(token).param("isArchived",isArchived).param("page", page).param("size",size).get("https://backend.cashwise.us/api/myaccount/clients");
        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());

        List<Integer> clientsIdsForArchive = Arrays.asList(351,352);
        String clientsIdString = clientsIdsForArchive.toString();
        boolean archive = true;
        String language = "whatever";
        Response response1 = RestAssured.given().contentType(ContentType.JSON).auth().oauth2(token).queryParam("clientsIdsForArchive",clientsIdsForArchive).queryParam("archive",archive).queryParam("language",language).post("https://backend.cashwise.us/api/myaccount/clients/archive/unarchive");
        System.out.println(response1.statusCode());
        System.out.println(response1.asString());


        boolean isArchived2 = true;
        int page2 = 1;
        int size2 = 10;
        Response response3 = RestAssured.given().contentType(ContentType.JSON).auth().oauth2(token).queryParam("isArchived",isArchived2).queryParam("page",page).queryParam("size",size2).get("https://backend.cashwise.us/api/myaccount/clients");
        System.out.println(response3.statusCode());
        System.out.println(response3.asPrettyString());








    }
}


