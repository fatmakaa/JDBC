import org.junit.Test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountriesTest {

  // Gherkin Language


   /*
        Given --> pre-condition, pre-requisite
          User connects to the database
        And

        When  --> task  /action
          User sends the query to get the region ids from "countries" table

         And

         Then --> get the result and verify it
         Verify that the number of region ids greater than 10 is 49.

         And --> to avoid repetition of Given, When or Then, we use And
         User closes the connection


    */

    public static void main(String[] args) throws SQLException {

        // User connects to the database
        JDBCUtils.connectToDatabase("localHost","postgres","postgres","1245");
         JDBCUtils.createStatement();

       //  User sends the query to get the region ids from "countries" table
        String query = "SELECT id FROM countries";

       ResultSet rs1 = JDBCUtils.statement.executeQuery(query);

        List<Integer> idList = new ArrayList<>();

       while (rs1.next()){
       idList.add(rs1.getInt("id"));
       }

        System.out.println(idList);

       // Verify that the number of region ids greater than 10 is 49.
        int counter=0;
       for (int w:idList){
           if (w>10){
               counter++;
           }
       }

       System.out.println( "counter:" + counter);  // 40 ; the number of region id's which greater than 10 less than 49.






    }

}