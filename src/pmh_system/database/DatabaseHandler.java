package pmh_system.database;

import javafx.scene.control.Alert;
import pmh_system.model.User;

import java.sql.*;

import static pmh_system.Main.*;

public class DatabaseHandler extends Config {
    private static Connection dbConnection;

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser(User user) {
        String insert = "INSERT INTO " + Constants.USERS_TABLE + "(" + Constants.USERNAME + ","
                + Constants.USERS_EMAIL + "," + Constants.USERS_NAME + "," + Constants.PASSWORD + ")" + "VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCashier());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            dbConnection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            //attach exception message to string
            String msg = "" + e.getMessage();
            //pass the message to the alert
            Alert alert = new Alert(Alert.AlertType.WARNING, msg);
            alert.showAndWait();
        }
    }

    public ResultSet getUser(User user) {
        ResultSet resultSet = null;
        if (!user.getUserName().equals("") || !user.getPassword().equals("")) {
            String query = "SELECT * FROM " + Constants.USERS_TABLE + " WHERE "
                    + Constants.USERNAME + "=?" + " AND " + Constants.PASSWORD + "=?";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getPassword());
                resultSet = preparedStatement.executeQuery();

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                String msg = "" + e.getMessage();
                Alert alert = new Alert(Alert.AlertType.WARNING, msg);
                alert.showAndWait();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Please enter your credentials");
        }
        return resultSet;
    }

    public void registerApplicant() {
        ResultSet resultSet = null;
        // for insert a new applicant
        int applicantId = 0;
        String insert = "INSERT INTO " + Constants.APPS_TABLE + "(" + Constants.APPS_SURNAME + ","
                + Constants.APPS_NAME + "," + Constants.APPS_DOB + "," + Constants.APPS_NAT_ID + ","
                + Constants.APPS_COUNTRY + "," + Constants.APPS_NAT + "," + Constants.APPS_CIVIL + ","
                + Constants.APPS_SEX + "," + Constants.APPS_CELL + "," + Constants.APPS_EMAIL + ","
                + Constants.APPS_ADD + "," + Constants.APPS_LOCALE + "," + Constants.APPS_SIZE + ","
                + Constants.APPS_TYPE + "," + Constants.APPS_PERIOD + "," + Constants.APPS_LOAN + ","
                + Constants.APPS_PROPERTY + "," + Constants.APPS_SUBS + "," + Constants.APPS_EMPLOYEE + ","
                + Constants.APPS_COMPANY + "," + Constants.APPS_PHONE + "," + Constants.APPS_K_NAME + ","
                + Constants.APPS_K_SURNAME + "," + Constants.APPS_K_ID + "," + Constants.APPS_K_ADD + ","
                + Constants.APPS_K_DOB + "," + Constants.APPS_K_PHONE + "," + Constants.APPS_B_NAME + ","
                + Constants.APPS_B_SURNAME + "," + Constants.APPS_B_SEX + "," + Constants.APP_B_AGE + ","
                + Constants.APPS_B_ID + "," + Constants.APPS_B_REL + "," + Constants.APPS_B_NAME1 + ","
                + Constants.APPS_B_SURNAME1 + "," + Constants.APPS_B_SEX1 + "," + Constants.APPS_B_AGE1 + ","
                + Constants.APPS_B_NATID1 + "," + Constants.APPS_B_REL1 + "," + Constants.APPS_B_NAME2 + ","
                + Constants.APPS_B_SURNAME2 + "," + Constants.APPS_B_SEX2 + "," + Constants.APPS_B_AGE2 + ","
                + Constants.APPS_B_NATID2 + "," + Constants.APPS_B_REL2 + ")"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, surname);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, dob);
            preparedStatement.setString(4, natIdNo);
            preparedStatement.setString(5, countryOfBirth);
            preparedStatement.setString(6, nationality);
            preparedStatement.setString(7, maritalStatus);
            preparedStatement.setString(8, gender);
            preparedStatement.setString(9, cellNumber);
            preparedStatement.setString(10, email);
            preparedStatement.setString(11, physAdd);
            preparedStatement.setString(12, preferredLocality);
            preparedStatement.setString(13, standSize);
            preparedStatement.setString(14, houseType);
            preparedStatement.setString(15, repaymentPeriod);
            preparedStatement.setString(16, String.valueOf(propertyValue));
            preparedStatement.setString(17, String.valueOf(loanValue));
            preparedStatement.setString(18, String.valueOf(monthlySubscription));
            preparedStatement.setString(19, employmentStatus);
            preparedStatement.setString(20, companyName);
            preparedStatement.setString(21, companyPhone);
            preparedStatement.setString(22, nameOfKin);
            preparedStatement.setString(23, surnameOfKin);
            preparedStatement.setString(24, idOfKin);
            preparedStatement.setString(25, dobOfKin);
            preparedStatement.setString(26, addressOfKin);
            preparedStatement.setString(27, phoneOfKin);
            preparedStatement.setString(28, benName);
            preparedStatement.setString(29, benSurname);
            preparedStatement.setString(30, benDob);
            preparedStatement.setString(31, benGender);
            preparedStatement.setString(32, benNatId);
            preparedStatement.setString(33, benRel);
            preparedStatement.setString(34, benName1);
            preparedStatement.setString(35, benSurname1);
            preparedStatement.setString(36, benDob1);
            preparedStatement.setString(37, benGender1);
            preparedStatement.setString(38, benNatId1);
            preparedStatement.setString(39, benRel1);
            preparedStatement.setString(40, benName2);
            preparedStatement.setString(41, benSurname2);
            preparedStatement.setString(42, benDob2);
            preparedStatement.setString(43, benGender2);
            preparedStatement.setString(44, benNatId2);
            preparedStatement.setString(45, benRel2);

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1) {
                // get applicant id
                resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next())
                    applicantId = resultSet.getInt(1);
                accountNo = applicantId;
            }
            preparedStatement.close();
            dbConnection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            String msg = "" + e.getMessage();
            Alert alert = new Alert(Alert.AlertType.WARNING, msg);
            alert.showAndWait();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
                String msg = "" + e.getMessage();
                Alert alert = new Alert(Alert.AlertType.WARNING, msg);
                alert.showAndWait();
            }
        }
    }

    public void makePayment() {
        ResultSet resultSet = null;
        // for insert a new payment
        int paymentId = 0;
        String insert = "INSERT INTO " + Constants.PAYMENTS_TABLE + "("
                + Constants.PAYMENT + "," + Constants.CURRENCY + "," + Constants.INITIAL_AMOUNT + ","
                + Constants.ACCOUNT_NO + "," + Constants.EQUIVALENCY + "," + Constants.RATE + ","
                + Constants.APPLICANT_ID + ")" + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, paymentMethod);
            preparedStatement.setString(2, currencyUsed);
            preparedStatement.setString(3, String.valueOf(initialAmount));
            preparedStatement.setString(4, sortedAccNo);
            preparedStatement.setString(5, String.valueOf(equivalency));
            preparedStatement.setString(6, String.valueOf(exchangeRate));
            preparedStatement.setString(7, String.valueOf(accountNo));

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1) {
                resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next())
                    paymentId = resultSet.getInt(1);
                receiptNo = paymentId;
            }
            preparedStatement.close();
            dbConnection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            String msg = "" + e.getMessage();
            Alert alert = new Alert(Alert.AlertType.WARNING, msg);
            alert.showAndWait();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
                String msg = "" + e.getMessage();
                Alert alert = new Alert(Alert.AlertType.WARNING, msg);
                alert.showAndWait();
            }
        }
    }
}