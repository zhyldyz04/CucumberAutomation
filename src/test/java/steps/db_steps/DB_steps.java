package steps.db_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ja.且つ;
import oracle.jdbc.driver.OracleDriver;
import org.junit.Assert;
import utilities.DBUtilities;
import utilities.TempStorage;


import java.sql.*;
import java.util.List;
import java.util.Map;

public class DB_steps {

    Connection connection;
    Statement statement;
    ResultSet resultSet;



    @Given("I have access to the database")
    public void i_have_access_to_the_database() {
        connection = DBUtilities.getConnection();

    }
    @When("I create a new employee with {int}, {string}, {string}, {string}, {string}, {string}, {int}, {int}, {int}, {int}")
    public void i_create_a_new_employee_with(int employee_id, String first_name, String last_name,
                                             String email, String phone, String hire_date,
                                             int job_id, int salary, int manager_id, int department_id) throws SQLException {
       String query = "INSERT INTO employees VALUES (" + employee_id
               + ", " + first_name
               + ", " + last_name
               + ", " + email
               + ", " + phone
               + ", " + hire_date
               + ", " + job_id
               + ", " + salary
               + ", " + manager_id
               + ", " + department_id + ") ";

        System.out.println(query);
        resultSet = DBUtilities.getResultSet(query);

        TempStorage.addData("employee_id", "" + employee_id);



    }
    @Then("the record should be successfully inserted")
    public void the_record_should_be_successfully_inserted() throws SQLException {

        String query = "select * from employees where " + TempStorage.getKey() + " = " + TempStorage.getData(TempStorage.getKey());


        List<Map<String,Object>> results = DBUtilities.getQueryResultAsList(query);

    }
    @Then("when I query for the record with employee_id {int}, I should receive the correct details")
    public void when_i_query_for_the_record_with_employee_id_i_should_receive_the_correct_details(Integer int1) {



    }























    @Given("user connects to the database")
    public void user_connects_to_the_database() throws ClassNotFoundException, SQLException {

        //tries to find object of the given class
       Class.forName("oracle.jdbc.driver.OracleDriver");

       //start the object
        DriverManager.registerDriver(new OracleDriver());

        //create connection with Oracle Database
        connection = DriverManager.getConnection("jdbc:oracle:thin:@3.123.40.26:1521:CODEWISE",
                "system", "Codewise_123");

        //create4 statement to build SQL query

         statement = connection.createStatement();



    }
    @When("user runs {string} query")
    public void user_runs_query(String query) throws SQLException {
       resultSet = statement.executeQuery(query);
        DBUtilities.printResults(query);

    }



    @Then("verify if data is returned")
    public void verify_if_data_is_returned() {

        try{
       while (resultSet.next()) {
           if(resultSet.getString("first_name").equals("Steven")){
               System.out.println(resultSet.getString("FIRST_NAME"));
          }


       }

       }catch(SQLException e){
            System.out.println("ERROR, SQL  result set was not returned");
            e.printStackTrace();
        }


    }









    SQLException exception;
    @Given("user tries to connect to the database with incorrect password")
    public void user_tries_to_connect_to_the_database_with_incorrect_password() throws ClassNotFoundException, SQLException {
        //tries to find object of the given class
        Class.forName("oracle.jdbc.driver.OracleDriver");

        //start the object
        DriverManager.registerDriver(new OracleDriver());

        try {

            //create connection with Oracle Database
            connection = DriverManager.getConnection("jdbc:oracle:thin:@3.123.40.26:1521:CODEWISE",
                    "system", "wrong");


        }catch(SQLException e){
           e.printStackTrace();
            }
   }





    @Then("verify user is not able to connect")
    public void verify_user_is_not_able_to_connect() {
        Assert.assertNotNull("The connection didn't throw exception", connection);
    }

}
