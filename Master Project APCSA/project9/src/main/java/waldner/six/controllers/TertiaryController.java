package waldner.six.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import waldner.six.App;
import waldner.six.daos.UserDAO;
import waldner.six.models.User;


public class TertiaryController implements Initializable {

    @FXML
    private TextField personidENTRY3;
    @FXML
    private TextField usernameENTRY3;
    @FXML
    private TextField passwordENTRY3;
    @FXML
    private TextField emailENTRY3;
    @FXML
    private TextField firstnameENTRY3;
    @FXML
    private TextField lastnameENTRY3;
    @FXML
    private DatePicker birthdateENTRY3;
    @FXML
    private TextField networthENTRY3;
    @FXML
    private TextField incomeENTRY3;
    @FXML
    private TextField yearlysavingsgoalENTRY3;
    @FXML
    private TextField monthlybudgetENTRY3;

    @FXML
    private Button createBTN3;
    @FXML
    private Button clearstuffBTN3;
    @FXML
    private Button gotologinBTN3;
    @FXML
    private Button quitappBTN3;

    User user = new User();
    UserDAO userDAO = SecondaryController.userDAO2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            List<User> x = userDAO.readRecords();
            System.out.println("user id: "+ userDAO.userID);
            for(User usa : x) {
                System.out.println("person id: "+ usa.personID);
                if(userDAO.userID == usa.personID) {
                    user = usa;
                }
            }
            
            String personidString = String.valueOf(user.personID);
            String networthString = String.valueOf(user.netWorth);
            String incomeString = String.valueOf(user.income);
            String yearlysavingsgoalString = String.valueOf(user.yearlySavingsGoal);
            String monthlybudgetString = String.valueOf(user.monthlyBudget);

            // Set the text of the labels
            personidENTRY3.setText(personidString);
            usernameENTRY3.setText(user.username);
            passwordENTRY3.setText(user.password);
            emailENTRY3.setText(user.email);
            firstnameENTRY3.setText(user.firstName);
            lastnameENTRY3.setText(user.lastName);
            birthdateENTRY3.setValue(user.birthdate.toLocalDate());
            networthENTRY3.setText(networthString);
            incomeENTRY3.setText(incomeString);
            yearlysavingsgoalENTRY3.setText(yearlysavingsgoalString);
            monthlybudgetENTRY3.setText(monthlybudgetString);
        } catch (SQLException e) {
            e.printStackTrace();
            // Optionally, you can show an error message to the user
        }
    }

    public void getTextFields() {
        user.username = usernameENTRY3.getText();
        user.password = passwordENTRY3.getText();
        user.email = emailENTRY3.getText();
        user.firstName = firstnameENTRY3.getText();
        user.lastName = lastnameENTRY3.getText();
        LocalDate localDate = birthdateENTRY3.getValue();
        String networth = networthENTRY3.getText();
        String income = incomeENTRY3.getText();
        String yearlysavingsgoal = yearlysavingsgoalENTRY3.getText();
        String monthlybudget = monthlybudgetENTRY3.getText();

        user.birthdate = Date.valueOf(localDate);
        user.netWorth = Double.valueOf(networth);
        user.income = Double.valueOf(income);
        user.yearlySavingsGoal = Double.valueOf(yearlysavingsgoal);
        user.monthlyBudget = Double.valueOf(monthlybudget);

    }



    @FXML
    private void updateUser() throws IOException, SQLException {
        getTextFields();
        userDAO.updateRecords(user.personID, user.username, user.password, user.email, user.firstName, user.lastName, user.birthdate, user.netWorth, user.income, user.yearlySavingsGoal, user.monthlyBudget);
    }

    @FXML
    public void deleteUser(int userID) {
        JFrame frame = new JFrame("Delete Record");
        int response = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this record?", "Confirm Deletion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            try {
                userDAO.deleteRecord(user.personID);
                JOptionPane.showMessageDialog(frame, "Record deleted successfully.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(frame, "Error deleting record: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @FXML
    private void clearPrimaryFields() throws IOException {
        usernameENTRY3.clear();
        passwordENTRY3.clear();
        emailENTRY3.clear();
        firstnameENTRY3.clear();
        lastnameENTRY3.clear();
        birthdateENTRY3.setValue(null);
        networthENTRY3.clear();
        incomeENTRY3.clear();
        yearlysavingsgoalENTRY3.clear();
        monthlybudgetENTRY3.clear();
    }


    @FXML
    private void quitApp() throws IOException {
        App.terminate();
    }

}