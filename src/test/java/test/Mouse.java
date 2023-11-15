package test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class Mouse {

    @Test
    public void singUser(){
        Response response = RestAssured.get("https://reqres.in/api/users/2");
        System.out.println(response.statusCode());
       // System.out.println(response.asString());

        String email = response.jsonPath().get("data.email");
        int id = response.jsonPath().get("data.id");
        String avatar = response.jsonPath().get("data.avatar");
        String text = response.jsonPath().get("support.text");

        System.out.println(email);
        System.out.println(id);
        System.out.println(avatar);
        System.out.println(text);

        Assert.assertFalse("Email is empty", email.trim().isEmpty());
        Assert.assertTrue(email.trim().endsWith("reqres.in"));

        Assert.assertTrue(id > 0);
        Assert.assertTrue(avatar.trim().endsWith(".jpeg") || avatar.trim().endsWith(".png") || avatar.trim().endsWith(".jpg"));

        String expectedText = "To keep ReqRes free, contributions towards server costs are appreciated!";
        Assert.assertEquals(expectedText,text);


    }

    @Test
    public void listOfUsers(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        //System.out.println(response.asString());

        String url = response.jsonPath().get("support.url");
        System.out.println(url);



        int size = response.jsonPath().get("per_page");
        for(int i = 0; i <size; i++){
            String path = "data[" + i + "].first_name";
            String name = response.jsonPath().get(path);
            Assert.assertFalse("Name is empty. Index: " + i,name.trim().isEmpty() );
        }

    }
}
