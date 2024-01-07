import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatement {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /*


        Purpose of Prepared Statement: If you'd like to parameterize the queries that you write you can use PreparedStatement now.


         */


        // Step 1: Specified my Driver for DB
        Class.forName("org.postgresql.Driver");

        // Step 2: Get the Connection
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:1245/postgres", "postgres", "1245");

        // Step 3: Create the Statement
        Statement statement = connection.createStatement();


        // Task 1: Update the company 'APPLE's number_of_employees value to 10000

        String query = "UPDATE companies SET number_of_employees = 10000 WHERE company = 'APPLE' ";
        //statement.executeUpdate(query);


        // Step 1: Create the proper query for PreparedStatement
        String companyName = "APPLE";
        int numOfEmployees = 10000;
        String query1 = "UPDATE companies SET number_of_employees = ? WHERE company = ? ";


        // Step 2: Create the Prepared Statement
        java.sql.PreparedStatement prepStatement = connection.prepareStatement(query1);



        // Step 3: Assign the parameters
        prepStatement.setInt(1,numOfEmployees);
        prepStatement.setString(2,companyName);


        //Step 4: Execute the Prepared Statement

        int updatedRowCount = prepStatement.executeUpdate();
        System.out.println("UpdatedRowCount" + updatedRowCount);


        // Task 2: Update Google's number_of_employees to 5000.
        prepStatement.setInt(1,5000);
        prepStatement.setString(2, "GOOGLE");
        int updatedRowCount1 = prepStatement.executeUpdate();
        System.out.println( updatedRowCount1); // it will return have many update ı get







    }
}
