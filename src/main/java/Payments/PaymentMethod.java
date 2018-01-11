package Payments;

public abstract class PaymentMethod {

    private double availableFunds;
    private String name;

    public PaymentMethod(String paymentName, double availableFunds){
        this.name = paymentName;
        this.availableFunds = availableFunds;
    }

    public double getAvailableFunds(){
        return availableFunds;
    }

    public void pay(double price){
        availableFunds -= price;
    }

    public void getRefund(double refund){
        availableFunds += refund;
    }

    public String getPaymentName(){
        return this.name;
    }

}
