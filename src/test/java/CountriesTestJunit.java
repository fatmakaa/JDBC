import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class CountriesTestJunit {


    /*

      Given
          User connects to the database
        When
          User sends the query to get the "phone code" from "countries" table
        Then
          Verify that the number of "phone code" greater than 300 is 13.
        And
          User closes the connection

     */

  @Test
  public void countriesTest(){

    // User connects to the database
    JDBCUtils.connectToDatabase("localHost","postgres","postgres","1245");
    JDBCUtils.createStatement();


    // User sends the query to get the "phone code" from "countries" table
    List<Object> codeList =JDBCUtils.getColumnList("phone_code","countries");  //data type object right now
    System.out.println("codeList:" + codeList);


       // Verify that the number of "phone code" greater than 300 is 13.


     //int numOfCodes = codeList.stream().filter(t-> (int)t>300).collect(Collectors.toList()).size();
     int numOfCodes = (int) codeList.stream().filter(t -> (int) t > 300).count();  //suggested by intelij, same thing

    System.out.println("numOfCodes: " +numOfCodes);

    //to verify
    //assertEquals(13,numOfCodes);   //it will control it, whether expected and actual value equal each other or not.

    //assertTrue(2==2); it is fine
   // assertFalse(2==2); it is not fine cuz ım looking for 2 values not equal each other




    // User closes the connection
    JDBCUtils.closeStatementAndConnection();







  }


}
