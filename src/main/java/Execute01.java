
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Step 1: Define the DB Driver
        Class.forName("org.postgresql.Driver");

        // Step 2: Create the Connection
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:1245/postgres", "postgres", "1245");

        // Step 3: Create the Statement
        Statement statement = con.createStatement();

        // Step 4: Run the Query
        // Example 1: Create a table called workers and add "worker_id, worker_name, salary" columns.
        /*
                If we're not getting any data from the query, boolean == false
                If we do, true. ResultSet.
         */
        boolean query1 = statement.execute("CREATE TABLE IF NOT EXISTS workers(worker_id INT, worker_name VARCHAR(50), salary REAL)");
        System.out.println(query1);

        // Task 1: Create a column called "city", with datatype VARCHAR(20) in the workers table.
        //boolean query2 = statement.execute("ALTER TABLE workers ADD COLUMN city VARCHAR(20)");
        //System.out.println(query2);

        // Task 2: Remove the table "workers"
        String query2 = "DROP TABLE IF EXISTS workers";
        statement.execute(query2);


        // Step 5: Close the statement, connection
        statement.close();
        con.close();

    }
}

// module-info.java