package waldner.six.models;

import java.sql.Date;
import java.time.LocalDate;

public class Statement {

    public int statementID;

    public User user;

    public Date date;

    public String description;

    public double amount;

    public Category category;

    public boolean recurring;

    public LocalDate createdAt;

    public Statement() {
        this.statementID = -9;
        this.user =  new User();
        this.date = Date.valueOf(LocalDate.now());
        this.amount = 1232442.11;
        this.category = Category.Debts;
        this.recurring = false;
        this.createdAt = LocalDate.now();
    }

    // Getters and Setters
    public int getStatementID() {
        return this.statementID;
    }

    public void setStatementID(int statementID) {
        this.statementID = statementID;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date date() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double  getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean  getRecurring() {
        return this.recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public LocalDate getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    
}
