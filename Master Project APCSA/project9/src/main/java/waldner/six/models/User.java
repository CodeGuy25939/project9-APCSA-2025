package waldner.six.models;
import java.sql.Date;
import java.time.LocalDate;

public class User {

    public int personID;
    public String username;
    public String password;
    public String email;
    public String firstName;
    public String lastName;
    public Date birthdate;
    public Double netWorth;
    public Double income;
    public Double yearlySavingsGoal;
    public Double monthlyBudget;

    // Constructor
    public User() {
        this.personID = 0;
        this.username = "ghfdf";
        this.password = "";
        this.email = "sdfgfhdgfh";
        this.firstName =  "";
        this.lastName = "";
        this.birthdate = Date.valueOf(LocalDate.now());
        this.netWorth = 0.0;
        this.income = 0.00;
        this.yearlySavingsGoal = 0.0;
        this.monthlyBudget = 0.0;
    }

    // Getters and Setters
    public int getPersonID() {
        return this.personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Double getNetWorth() {
        return this.netWorth;
    }

    public void setNetWorth(Double netWorth) {
        this.netWorth = netWorth;
    }

    public Double getIncome() {
        return this.income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getYearlySavingsGoal() {
        return this.yearlySavingsGoal;
    }

    public void setYearlySavingsGoal(Double yearlySavingsGoal) {
        this.yearlySavingsGoal = yearlySavingsGoal;
    }

    public Double getMonthlyBudget() {
        return this.monthlyBudget;
    }

    public void setMonthlyBudget(Double monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }
}

