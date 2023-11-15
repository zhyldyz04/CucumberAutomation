package steps.db_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import oracle.jdbc.driver.OracleDriver;
import org.junit.Assert;
import utilities.DBUtilities;
import utilities.TempStorage;


import java.sql.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import java.util.Map;

public class DB_steps {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    Map<String, Object> dataSent = new HashMap<>();



    @Given("I have access to the database")
    public void i_have_access_to_the_database() {
        connection = DBUtilities.getConnection();

    }
    @When("I create a new employee with {int}, {string}, {string}, {string}, {string}, {string}, {int}, {int}, {int}, {int}")
    public void i_create_a_new_employee_with(int employee_id, String first_name, String last_name,
                                             String email, String phone_number, String hire_date,
                                             int job_id, int salary, int manager_id, int department_id) throws SQLException {
        dataSent.put("EMPLOYEE_ID", employee_id);
        dataSent.put("FIRST_NAME", first_name);
        dataSent.put("LAST_NAME", last_name);
        dataSent.put("EMAIL", email);
        dataSent.put("PHONE_NUMBER", phone_number);
        dataSent.put("HIRE_DATE", hire_date);
        dataSent.put("JOB_ID", job_id);
        dataSent.put("SALARY", salary);
        dataSent.put("MANAGER_ID", manager_id);
        dataSent.put("DEPARTMENT_ID", department_id);

        String query = "INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, employee_id );
        preparedStatement.setString(2, first_name);
        preparedStatement.setString(3, last_name);
        preparedStatement.setString(4, email);
        preparedStatement.setString(5, phone_number);
        preparedStatement.setString(6, hire_date);
        preparedStatement.setInt(7, job_id);
        preparedStatement.setInt(8, salary);
        preparedStatement.setInt(9, manager_id);
        preparedStatement.setInt(10, department_id);

        int affectedRows = preparedStatement.executeUpdate();

        resultSet = DBUtilities.getResultSet(query);

        TempStorage.addData("employee_id", "" + employee_id);

    }




    @Then("the record should be successfully inserted")
    public void the_record_should_be_successfully_inserted() throws SQLException {

        String query = "select * from employees where " + TempStorage.getKey() + " = " + TempStorage.getData(TempStorage.getKey());

        Map<String, Object> results = DBUtilities.getQueryResultAsList(query).get(0);

        Assert.assertEquals("The number of columns sent and received did not match", dataSent.size(), results.size());

        for (String key : results.keySet()) {
            System.out.println("EXPECTED DATA: " + key + " : " + dataSent.get(key));
            System.out.println("ACTUAL DATA: " + key + " : " + results.get(key));

            if(key.equals("HIRE_DATE")){
                SimpleDateFormat actualFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                SimpleDateFormat expectedFormat = new SimpleDateFormat("dd-MMM-yy");
                Date date = null;
                try{
                    date = actualFormat.parse(results.get(key) + "");
                }catch(ParseException e){
                    e.printStackTrace();

                }
                String expectedString = expectedFormat.format(date);
                Assert.assertEquals("Data did not match: ", dataSent.get(key), expectedString.toUpperCase());
            }else {
                Assert.assertEquals("Data did not match: ", dataSent.get(key), results.get(key));

            }




            }


        }

    @When("I update the {string} of {int} with the new value {int}")
    public void i_update_the_of_with_the_new_value(String column_name, int employee_id, int new_value) throws SQLException {
        String query = "UPDATE employees SET ? = ? WHERE employee_id = ?";


        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setInt(1, employee_id);
        preparedStatement.setInt(2, new_value);

        preparedStatement.executeUpdate();

        resultSet = DBUtilities.getResultSet(query);
        TempStorage.addData("employee_id", "" + employee_id);

    }
    @Then("{string} of {int} must be equal to {int}")
    public void of_must_be_equal_to(String column_name, int employee_id, int new_value) {
        String query = "select"  + column_name + " from employees where " + TempStorage.getKey() + " = " + TempStorage.getData(TempStorage.getKey());

        int actualSalary = Integer.getInteger(DBUtilities.getSingleCellValue(query, column_name).toString());


        Assert.assertEquals("The number of columns sent and received did not match", new_value, actualSalary);



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
