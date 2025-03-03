package waldner.six.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate; // Added import for java.sql.Date

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import waldner.six.App;
import waldner.six.daos.UserDAO;
import waldner.six.models.User;

public class PrimaryController {

    @FXML
    private TextField personidENTRY1;
    @FXML
    private TextField usernameENTRY1;
    @FXML
    private TextField passwordENTRY1;
    @FXML
    private TextField emailENTRY1;
    @FXML
    private TextField firstnameENTRY1;
    @FXML
    private TextField lastnameENTRY1;
    @FXML
    private DatePicker birthdateENTRY1;
    @FXML
    private TextField networthENTRY1;
    @FXML
    private TextField incomeENTRY1;
    @FXML
    private TextField yearlysavingsgoalENTRY1;
    @FXML
    private TextField monthlybudgetENTRY1;

    @FXML
    private Button createBTN1;
    @FXML
    private Button clearstuffBTN1;
    @FXML
    private Button gotologinBTN1;
    @FXML
    private Button quitappBTN1;

    User user = new User();
    UserDAO userDAO = new UserDAO();

    public void getTextFields() {
        user.username = usernameENTRY1.getText();
        user.password = passwordENTRY1.getText();
        user.email = emailENTRY1.getText();
        user.firstName = firstnameENTRY1.getText();
        user.lastName = lastnameENTRY1.getText();
        LocalDate localDate = birthdateENTRY1.getValue();
        String networth = networthENTRY1.getText();
        String income = incomeENTRY1.getText();
        String yearlysavingsgoal = yearlysavingsgoalENTRY1.getText();
        String monthlybudget = monthlybudgetENTRY1.getText();

        user.birthdate = Date.valueOf(localDate);
        user.netWorth = Double.valueOf(networth);
        user.income = Double.valueOf(income);
        user.yearlySavingsGoal = Double.valueOf(yearlysavingsgoal);
        user.monthlyBudget = Double.valueOf(monthlybudget);

    }



    @FXML
    private void createUser() throws IOException, SQLException {
        getTextFields();
        userDAO.createRecords(user.username, user.password, user.email, user.firstName, user.lastName, user.birthdate, user.netWorth, user.income, user.yearlySavingsGoal, user.monthlyBudget);
        App.setRoot("secondary");
    }

    @FXML
    private void clearPrimaryFields() throws IOException {
        usernameENTRY1.clear();
        passwordENTRY1.clear();
        emailENTRY1.clear();
        firstnameENTRY1.clear();
        lastnameENTRY1.clear();
        birthdateENTRY1.setValue(null);
        networthENTRY1.clear();
        incomeENTRY1.clear();
        yearlysavingsgoalENTRY1.clear();
        monthlybudgetENTRY1.clear();
    }

    @FXML
    private void goToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void quitApp() throws IOException {
        App.terminate();
    }

}