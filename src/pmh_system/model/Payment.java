package pmh_system.model;

public class Payment {
    private String currencyUsed;
    private String paymentMethod, totalPaid, balance, accountNo;
    private double exchangeRate, initialAmount, amountPaid, equivalency;

    public Payment() {
    }

    public Payment(String paymentMethod, String currencyUsed, double exchangeRate,
                   String sortedAccNo, double initialAmount, String equivalency) {
        this.paymentMethod = paymentMethod;
        this.currencyUsed = currencyUsed;
        this.exchangeRate = Double.parseDouble(String.valueOf(exchangeRate));
        this.accountNo = sortedAccNo;
        this.initialAmount = Double.parseDouble(String.valueOf(initialAmount));
        this.equivalency = Double.parseDouble(equivalency);
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public double getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(double initialAmount) {
        this.initialAmount = initialAmount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getEquivalency() {
        return equivalency;
    }

    public void setEquivalency(double equivalency) {
        this.equivalency = equivalency;
    }

    public String getCurrencyUsed() {
        return currencyUsed;
    }

    public void setCurrencyUsed(String currencyUsed) {
        this.currencyUsed = currencyUsed;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(String totalPaid) {
        this.totalPaid = totalPaid;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
}