package waldner.six.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/*
 * This is not complete dont use
 */
public class StatementDAO {
    // Database connection details
    private String url = "jdbc:mysql://localhost:3306/financialanalysis";
    private String username = "root";
    private String password = "#Whalez17";

    private Connection connection;
    private PreparedStatement pst;
    private Statement st;
    private String query;
    private ResultSet rs;


    // Method to establish a connection to the database
    public void connectToStatements() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC Driver
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established successfully");
        } catch (Exception e) {
            if (st != null) {
                st.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (connection != null) {
                connection.close();
            }
            System.out.println("Connection Closed for connectToStatements....");
            throw new RuntimeException(e);
        }
    }

    // Method to close the database connection and other resources
    public void disconnectFromStatements() throws SQLException {
        try {
            if (st != null) {
                st.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (connection != null) {
                connection.close();
            }
            System.out.println("Connection Closed for disconnectFromStatements....");
        } catch (Exception e) {
            if (st != null) {
                st.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (connection != null) {
                connection.close();
            }
            throw new RuntimeException(e);
        }
    }

    // Method to close the statement and connection resources


    // Method to create a new record in the database
    public void createRecords(String username, String password, String email, String firstName, String lastName, java.sql.Date birthdate, Double netWorth, Double income, Double yearlySavingsGoal, Double monthlyBudget) throws SQLException {
        try {
            connectToStatements();
            query = "INSERT INTO statements(username, password, email, firstName, lastName, birthdate, netWorth, income, yearlySavingsGoal, monthlyBudget) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = connection.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, email);
            pst.setString(4, firstName);
            pst.setString(5, lastName);
            pst.setDate(6, birthdate);
            pst.setDouble(7, netWorth);
            pst.setDouble(8, income);
            pst.setDouble(9, yearlySavingsGoal);
            pst.setDouble(10, monthlyBudget);
            pst.executeUpdate();
            disconnectFromStatements();
        } catch (Exception e) {
            disconnectFromStatements();
            throw new RuntimeException(e);
        }
    }

    // Method to read all records from the database
    public void readRecords() throws SQLException {
        try {
            connectToStatements();
            query = "SELECT * FROM statements";
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("personID"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Weight: " + rs.getInt("weight"));
                System.out.println("Age: " + rs.getInt("age"));
            }
            disconnectFromStatements();
        } catch (Exception e) {
            disconnectFromStatements();
            throw new RuntimeException(e);
        }
    }

    // Method to update an existing record in the database
    public void updateRecords(int personID, String name, int weight, int age) throws SQLException {
        try {
            connectToStatements();
            query = "UPDATE statements SET name=?, weight=?, age=? WHERE personID=?";
            pst = connection.prepareStatement(query);
            pst.setString(1, name);
            pst.setInt(2, weight);
            pst.setInt(3, age);
            pst.setInt(4, personID);
            pst.executeUpdate();
            disconnectFromStatements();
        } catch (Exception e) {
            disconnectFromStatements();
            throw new RuntimeException(e);
        }
    }

    // Method to delete a record from the database
    public void deleteRecord(int personID) throws SQLException {
        try {
            connectToStatements();
            query = "DELETE FROM statements WHERE personID = ?";
            pst = connection.prepareStatement(query);
            pst.setInt(1, personID);
            pst.executeUpdate();
            System.out.println("User Deleted Successfully");
            disconnectFromStatements();
        } catch (Exception e) {
            disconnectFromStatements();
            throw new RuntimeException(e);
        }
    }

    // Method to read all records from the database
    public boolean fetchOneRecord(String username, String password) throws SQLException {
        try {
            connectToStatements();
            query = "SELECT * FROM statements where username=? AND password=?";
            pst = connection.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                disconnectFromStatements();
                return true;
            }
            disconnectFromStatements();
            return false;
        } catch (Exception e) {
            disconnectFromStatements();
            throw new RuntimeException(e);
        }
    }
}
