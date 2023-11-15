package utilities;

import org.checkerframework.checker.units.qual.C;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtilities {

    private static final String URL = Config.getValue("dbUrl");
    private static final String USER = Config.getValue("dbUsername");
    private static final String PASSWORD = Config.getValue("dbPassword");


    /**
     * Establishes a connection to the database
     *
     * @return a Connection object
     */

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }




/*
Executes a SQL  query and returns the first cell value of the result set

@param query the SQL query
@return the first cell value

 */

    public static Object getSingleCellValue(String query, String columnName){
        Object result = null;
        try (
                Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
        ){  if(resultSet.next()) {
            result = resultSet.getObject(columnName);
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    /*
    Executes a SQL query and stores each row of the result set as a List of Strings
    @param query the SQL query
    @return a list of lists, each representing a row
     */

    public static List<List<String>> getQueryResultAsListOfList(String query) {
        List<List<String>> resultList = new ArrayList<>();
        ResultSet resultSet = getResultSet(query);

        try {
            while (resultSet.next()) {
                List<String> rowList = new ArrayList<>();
                for (int i = 1; i < resultSet.getMetaData().getColumnCount(); i++) {
                    rowList.add(resultSet.getString(i));
                }
                resultList.add(rowList);
            }

        } catch (SQLException e) {
        }
            return resultList;
        }


    /**
     * This method accepts String query, runs it and returns the output
     * as the object of ResultSet
     * @param query
     * @return ResultSet = results of the query
     */
    public static ResultSet getResultSet(String query) {
        ResultSet resultSet = null;

        try {
            Connection connection = getConnection();
           Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            }catch(SQLException e){
                e.printStackTrace();
            }

            return resultSet;


        }



    public static void printResults(String query){
        List<List<String>> results = getQueryResultAsListOfList(query);
        for(List<String> rows: results){
            System.out.println(rows);
        }
    }


    /**
     * Executes a SQL query and stores the result in a list of hashmaps.
     * Each hashmap represents a row with column names as keys and the corresponding cell values as values.
     *
     * @param query the SQL query
     * @return the result list
     */
    public static List<Map<String, Object>> getQueryResultAsList(String query) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Map<String, Object> rowMap = new HashMap<>();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {

                    if (resultSet.getObject(i).getClass().equals(BigDecimal.class)){
                        BigDecimal bd = (BigDecimal) resultSet.getObject(i);
                        rowMap.put(resultSet.getMetaData().getColumnName(i), bd.intValue());
                    }else{
                        rowMap.put(resultSet.getMetaData().getColumnName(i), resultSet.getObject(i));
                    }

                }
                resultList.add(rowMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }


}


