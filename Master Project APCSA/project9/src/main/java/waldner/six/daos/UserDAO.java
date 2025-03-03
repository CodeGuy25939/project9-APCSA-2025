package waldner.six.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import waldner.six.models.User;



public class UserDAO {
    // Database connection details
    private String url = "jdbc:mysql://localhost:3306/financialanalysis";
    private String username = "root";
    private String password = "#Whalez17";

    private Connection connection;
    private PreparedStatement pst;
    private Statement st;
    private String query;
    private ResultSet rs;
    public int userID;


    // Method to establish a connection to the database
    public void connectToUsers() throws SQLException {
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
            System.out.println("Connection Closed for connectToUsers....");
            throw new RuntimeException(e);
        }
    }

    // Method to close the database connection and other resources
    public void disconnectFromUsers() throws SQLException {
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
            System.out.println("Connection Closed for disconnectFromUsers....");
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
            connectToUsers();
            query = "INSERT INTO users(username, password, email, firstName, lastName, birthdate, netWorth, income, yearlySavingsGoal, monthlyBudget) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            disconnectFromUsers();
        } catch (Exception e) {
            disconnectFromUsers();
            throw new RuntimeException(e);
        }
    }

    // Method to read all records from the database
    public List<User>  readRecords() throws SQLException {
        List<User> userList = new ArrayList<>();
        try {
            connectToUsers();
            query = "SELECT * FROM users";
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setPersonID(rs.getInt("personID"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setBirthdate(rs.getDate("birthdate"));
                user.setNetWorth(rs.getDouble("netWorth"));
                user.setIncome(rs.getDouble("income"));
                user.setYearlySavingsGoal(rs.getDouble("yearlySavingsGoal"));
                user.setMonthlyBudget(rs.getDouble("monthlyBudget"));
                userList.add(user);
            }
            disconnectFromUsers();
            return userList;
        } catch (Exception e) {
            disconnectFromUsers();
            throw new RuntimeException(e);
        }
    }

    // Method to update an existing record in the database
    public void updateRecords(int personID, String username, String password, String email, String firstName, String lastName, java.sql.Date birthdate, Double netWorth, Double income, Double yearlySavingsGoal, Double monthlyBudget) throws SQLException {
        try {
            connectToUsers();
            query = "UPDATE users SET username=?, password=?, email=?, firstname=?, lastname=?, birthdate=?, networth=?, income=?, yearlysavingsgoal=?, monthlybudget=? WHERE personID=?";
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
            pst.setInt(11, personID);
            pst.executeUpdate();
            disconnectFromUsers();
        } catch (Exception e) {
            disconnectFromUsers();
            throw new RuntimeException(e);
        }
    }

    // Method to delete a record from the database
    public void deleteRecord(int personID) throws SQLException {
        try {
            connectToUsers();
            query = "DELETE FROM users WHERE personID = ?";
            pst = connection.prepareStatement(query);
            pst.setInt(1, personID);
            pst.executeUpdate();
            System.out.println("User Deleted Successfully");
            disconnectFromUsers();
        } catch (Exception e) {
            disconnectFromUsers();
            throw new RuntimeException(e);
        }
    }

    // Method to read all records from the database
    public boolean fetchOneRecord(String username, String password) throws SQLException {
        try {
            connectToUsers();
            query = "SELECT * FROM users where username=? AND password=?";
            pst = connection.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                userID = rs.getInt("personID");
                System.out.println(userID);
                disconnectFromUsers();
                return true;
            }
            disconnectFromUsers();
            return false;
        } catch (Exception e) {
            disconnectFromUsers();
            throw new RuntimeException(e);
        }
    }
}