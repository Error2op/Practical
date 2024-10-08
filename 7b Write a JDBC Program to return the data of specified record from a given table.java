import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDisplayTable {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/cricket";
        String username = "root";
        String password = "root";

        // Query to fetch data from a table
        String query = "SELECT * FROM employee";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement stmt = con.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Process the result set
            while (rs.next()) {
                // Assuming the table has 3 columns: id, name, and age
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                // Display the data
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
