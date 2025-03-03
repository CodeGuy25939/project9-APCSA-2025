package waldner.six.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import waldner.six.App;
import waldner.six.daos.UserDAO;
import waldner.six.models.User;

public class SecondaryController {

    @FXML
    private TextField usernameENTRY2;
    @FXML
    private TextField passwordENTRY2;

    @FXML
    private Button signinBTN2;
    @FXML
    private Button createanaccountBTN2;

    String supposedUsername;
    String supposedPassword;
    User user = new User();
    static UserDAO userDAO2 = new UserDAO();

    public void getTextFields() {
        supposedUsername = usernameENTRY2.getText();
        supposedPassword = passwordENTRY2.getText();
    }

    @FXML
    private void signIn() throws IOException, SQLException {
        getTextFields();
        if(userDAO2.fetchOneRecord(supposedUsername, supposedPassword)) {
            //WRITE CODE TO GO TO PAGE THREE WHERE USER INFO IS WRITTEN ACCORDINGLY
            App.setRoot("tertiary");
        }
        else {
            System.out.println("BAD USER OR PASE");
        }

    }
    
    @FXML
    private void goToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
}