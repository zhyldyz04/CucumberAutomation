package cashwise;

import io.cucumber.java.bs.A;
import org.apiguardian.api.API;
import org.junit.Assert;
import org.junit.Test;
import utilities.APIRunner;



public class Expenses {

    @Test
    public void seller(){
        String path = "/api/myaccount/sellers/1074";
        APIRunner.runGET(path);
        //get company_name, seller_name, phone number from response

        String companyName = APIRunner.getCustomResponse().getCompany_name();
        System.out.println(companyName);

        String sellerName = APIRunner.getCustomResponse().getSeller_name();
        System.out.println(sellerName);

        String phoneNumber = APIRunner.getCustomResponse().getPhone_number();
        System.out.println(phoneNumber);

        Assert.assertNotNull(companyName);
        Assert.assertNotNull(sellerName);
        Assert.assertNotNull(phoneNumber);
        Assert.assertNotNull(APIRunner.getCustomResponse().getEmail());

        Assert.assertFalse(APIRunner.getCustomResponse().getSeller_name().trim().isEmpty());
        Assert.assertFalse(APIRunner.getCustomResponse().getCompany_name().trim().isEmpty());
        Assert.assertFalse(APIRunner.getCustomResponse().getPhone_number().trim().isEmpty());
        Assert.assertFalse(APIRunner.getCustomResponse().getEmail().trim().isEmpty());

        Assert.assertTrue(APIRunner.getCustomResponse().getEmail().
                contains("@") && APIRunner.getCustomResponse().getEmail().contains("."));

        phoneNumber = phoneNumber.replace("+","");
        phoneNumber = phoneNumber.replace("-","");
        phoneNumber = phoneNumber.replace(" ","");

        Assert.assertTrue(phoneNumber.length() == 10 || phoneNumber.length() == 11);



    }


    @Test
    public void singleBankAccount(){
        String path = "/api/myaccount/bankaccount/1094";

        APIRunner.runGET(path);

        // System.out.println(APIRunner.getCustomResponse().getJsonString());

        Assert.assertEquals(200, APIRunner.getCustomResponse().getStatusCode());


    }

    @Test
    public void verifiedSellers(){
        String path = "/api/myaccount/sellers/all";
        APIRunner.runGetList(path);
        System.out.println(APIRunner.getResponseList().length);
        for(int i = 0; i < APIRunner.getResponseList().length; i++ ){
           // System.out.println(APIRunner.getResponseList()[i].getSeller_name());
            Assert.assertNotNull(APIRunner.getResponseList()[i].getSeller_name());
            Assert.assertNotNull(APIRunner.getResponseList()[i].getCompany_name());
        }

}
}
