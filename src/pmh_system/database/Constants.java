package pmh_system.database;

public class Constants {
    public static final String APPS_TABLE = "applicants";
    static final String PAYMENTS_TABLE = "payments";
    static final String USERS_TABLE = "users";

    //USERS Table Column Names
    static final String USERS_ID = "userid";
    static final String USERNAME = "username";
    static final String USERS_EMAIL = "email";
    static final String USERS_NAME = "name";
    static final String PASSWORD = "password";

    //PAYMENTS Table Column Names
    static final String PAYMENTS_ID = "idpayments";
    static final String APPLICANT_ID = "applicantId";
    static final String PAYMENT = "paymentMethod";
    static final String CURRENCY = "currencyUsed";
    static final String INITIAL_AMOUNT = "initialAmount";
    static final String TOTAL_PAID = "totalPaid";
    static final String BALANCE = "balance";
    static final String ACCOUNT_NO = "accountNo";
    static final String EQUIVALENCY = "equivalency";
    static final String RATE = "exchangeRate";


    //APPLICANTS Table Column Names
    static final String APPLICANTS_ID = "id";
    public static final String APPS_SURNAME = "surname";
    public static final String APPS_NAME = "firstname";
    static final String APPS_DOB = "dateOfBirth";
    public static final String APPS_NAT_ID = "nationalId";
    static final String APPS_COUNTRY = "countryOfBirth";
    static final String APPS_NAT = "nationality";
    static final String APPS_CIVIL = "maritalStatus";
    static final String APPS_SEX = "gender";
    public static final String APPS_CELL = "cellNumber";
    public static final String APPS_EMAIL = "email";
    static final String APPS_ADD = "physicalAddress";
    static final String APPS_LOCALE = "preferredLocality";
    public static final String APPS_SIZE = "standSize";
    public static final String APPS_TYPE = "houseType";
    public static final String APPS_PERIOD = "repaymentPeriod";
    public static final String APPS_PROPERTY = "propertyValue";
    public static final String APPS_LOAN = "loanValue";
    public static final String APPS_SUBS = "monthlySubscription";
    static final String APPS_EMPLOYEE = "employmentStatus";
    static final String APPS_COMPANY = "companyName";
    static final String APPS_PHONE = "companyPhone";
    static final String APPS_K_NAME = "nameOfKin";
    static final String APPS_K_SURNAME = "surnameOfKin";
    static final String APPS_K_ID = "idOfKin";
    static final String APPS_K_DOB = "dobOfKin";
    static final String APPS_K_ADD = "addressOfKin";
    static final String APPS_K_PHONE = "phoneOfKin";
    static final String APPS_B_NAME = "beneficiaryName";
    static final String APPS_B_SURNAME = "beneficiarySurname";
    static final String APPS_B_SEX = "beneficiaryGender";
    static final String APP_B_AGE = "beneficiaryDob";
    static final String APPS_B_ID = "beneficiaryNatId";
    static final String APPS_B_REL = "beneficiaryRelationship";
    static final String APPS_B_NAME1 = "beneficiaryName1";
    static final String APPS_B_SURNAME1 = "beneficiarySurname1";
    static final String APPS_B_SEX1 = "beneficiaryGender1";
    static final String APPS_B_AGE1 = "beneficiaryDob1";
    static final String APPS_B_NATID1 = "beneficiaryNatId1";
    static final String APPS_B_REL1 = "beneficiaryRelationship1";
    static final String APPS_B_NAME2 = "beneficiaryName2";
    static final String APPS_B_SURNAME2 = "beneficiarySurname2";
    static final String APPS_B_SEX2 = "beneficiaryGender2";
    static final String APPS_B_AGE2 = "beneficiaryDob2";
    static final String APPS_B_NATID2 = "beneficiaryNatId2";
    static final String APPS_B_REL2 = "beneficiaryRelationship2";
}