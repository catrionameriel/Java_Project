package Venue;

public enum PaymentMethodType {

    CREDITCARD("Credit Card"),
    DEBITCARD("Debit Card"),
    CHEQUE("Cheque"),
    BACS("Bank Transfer"),
    CASH("Cash");

    private String paymentMethodName;

    PaymentMethodType(String name){
        paymentMethodName = name;
    }

    public String getPaymentMethodName(){
        return this.paymentMethodName;
    }

}
