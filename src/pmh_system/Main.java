package pmh_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static boolean brr = false;
    public static String cashier, client, surname, firstName, natIdNo, countryOfBirth, nationality;
    public static String dob = " ", maritalStatus = " ", gender = " ";
    public static String cellNumber, email, physAdd, employmentStatus, companyName, companyPhone;
    public static String preferredLocality, standSize, houseType, repaymentPeriod;
    public static String kinName, nameOfKin, surnameOfKin, idOfKin, dobOfKin, phoneOfKin, addressOfKin;
    public static String benName, benSurname, benGender, benDob, benNatId, benRel;
    public static String benName1, benSurname1, benGender1, benDob1, benNatId1, benRel1;
    public static String benName2, benSurname2, benGender2, benDob2, benNatId2, benRel2;
    public static String benName3, benSurname3, benGender3, benDob3, benNatId3, benRel3;
    public static String benName4, benSurname4, benGender4, benDob4, benNatId4, benRel4;
    public static String benName5, benSurname5, benGender5, benDob5, benNatId5, benRel5;
    public static String benName6, benSurname6, benGender6, benDob6, benNatId6, benRel6;
    public static String benName7, benSurname7, benGender7, benDob7, benNatId7, benRel7;
    public static String benName8, benSurname8, benGender8, benDob8, benNatId8, benRel8;
    public static String benName9, benSurname9, benGender9, benDob9, benNatId9, benRel9;
    public static String amountPaid, currencyUsed, paymentMethod, sortedAccNo ;
    public static String totalPaid, balance;
    public static int accountNo, receiptNo;
    public static double loanValue, propertyValue, monthlySubscription,exchangeRate, initialAmount, equivalency;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("views/login.fxml"));
        primaryStage.setTitle("Mortgage Housing System ");
        primaryStage.setScene(new Scene(root, 1400, 678));
        primaryStage.show();
        primaryStage.setMaximized(true);
    }
}