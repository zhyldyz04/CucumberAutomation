package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomResponse {



    private String jwt_token;
    private String message;
    private String company_name;
    private  String seller_name;
    private boolean income;
    private String bank_account_name;
    private int balance;
    private String id;
    private String phone_number;
    private String email;
    private String type_of_pay;

    private String jsonString;
    private int statusCode;
    private String category_title;
    private int  category_id;
    private String category_description;
    private boolean flag;
    private String description;
    private String client_name;

     private List<Universal> tags;

    private List <Universal> responses;














}
