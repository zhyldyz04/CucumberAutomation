package cashwise;

import com.github.javafaker.Faker;
import entities.RequestBody;
import org.junit.Test;
import utilities.APIRunner;

public class Tags {

    @Test
    public void createTags(){
        String postPath = "/api/myaccount/tags";

        Faker faker = new Faker();

        RequestBody requestBody  = new RequestBody();


        for(int i = 0; i < 7; i++){
            requestBody.setName_tag(faker.pokemon().name());
            requestBody.setDescription(faker.funnyName().name());

            APIRunner.runPOST(postPath, requestBody);



        }



    }
}
