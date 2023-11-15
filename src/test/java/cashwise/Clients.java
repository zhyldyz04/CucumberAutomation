package cashwise;

import org.junit.Test;
import utilities.APIRunner;

public class Clients {

    @Test
    public void getClient(){
        String path = "/api/myaccount/clients/1272";
        APIRunner.runGET(path);

        System.out.println(APIRunner.getCustomResponse().getCompany_name());
        System.out.println(APIRunner.getCustomResponse().getClient_name());
        System.out.println(APIRunner.getCustomResponse().getEmail());

       // System.out.println(APIRunner.getCustomResponse().getTags().get(0).getNameTag());
        for(int i = 0; i < APIRunner.getCustomResponse().getTags().size(); i++){
            System.out.println(APIRunner.getCustomResponse().getTags().get(i).getNameTag());

            System.out.println(APIRunner.getCustomResponse().getTags().get(i).getCompany().getCompanyName());


        }
    }



}
