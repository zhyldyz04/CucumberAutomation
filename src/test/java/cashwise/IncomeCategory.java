package cashwise;

import entities.RequestBody;
import org.junit.Test;
import utilities.APIRunner;

public class IncomeCategory {


    @Test
    public void updateDescription(){
        String getPath = "/api/myaccount/categories/income";
        APIRunner.runGetList(getPath);



        for(int i = 0; i < APIRunner.getResponseList().length; i++){

           int id =APIRunner.getResponseList()[i].getCategory_id();
           String path = "/api/myaccount/categories/" + id;

            RequestBody requestBody = new RequestBody();
            requestBody.setCategory_title(APIRunner.getResponseList()[i].getCategory_title());
            requestBody.setCategory_description("For income purpose");
            requestBody.setFlag(true);

            APIRunner.runPUT(path,requestBody);

        }

    }

}
