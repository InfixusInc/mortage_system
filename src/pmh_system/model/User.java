package pmh_system.model;

import pmh_system.Main;

public class User {
    private String cashier;
    private String userName;
    private String email;
    private String password;

    public User() {
    }

    public User(String userName, String email, String name, String password) {
        this.userName = userName;
        this.email = email;
        this.cashier = name;
        this.password = password;
    }

    public String getCashier() {
        Main.cashier = cashier;
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}