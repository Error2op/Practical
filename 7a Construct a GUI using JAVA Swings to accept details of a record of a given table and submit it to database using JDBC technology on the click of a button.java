import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeForm extends JFrame {
    // JDBC URL, username, and password of MySQL database
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/cricket";
    static final String JDBC_USER = "root"; // Your MySQL username
    static final String JDBC_PASSWORD = "root"; // Your MySQL password

    // Declare UI components
    private JTextField nameField, positionField, salaryField;
    private JButton submitButton;

    public EmployeeForm() {
        // Set up the frame
        setTitle("Employee Record Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Initialize labels and text fields
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        
        JLabel positionLabel = new JLabel("Position:");
        positionField = new JTextField();
        
        JLabel salaryLabel = new JLabel("Salary:");
        salaryField = new JTextField();
        
        submitButton = new JButton("Submit");

        // Add components to the frame
        add(nameLabel);
        add(nameField);
        add(positionLabel);
        add(positionField);
        add(salaryLabel);
        add(salaryField);
        add(submitButton);

        // Handle button click event
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitEmployeeRecord();
            }
        });
    }

    // Method to submit the record to the database
    private void submitEmployeeRecord() {
        String name = nameField.getText();
        String position = positionField.getText();
        double salary = Double.parseDouble(salaryField.getText());

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Load and register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the MySQL database
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // SQL query to insert a new employee
            String query = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);

            // Set the values for the SQL query
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, position);
            preparedStatement.setDouble(3, salary);

            // Execute the insert query
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Employee record added successfully!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        } finally {
            // Close the resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        EmployeeForm form = new EmployeeForm();
        form.setVisible(true);
    }
}
