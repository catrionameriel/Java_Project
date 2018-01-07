package Customer;

public abstract class PaymentMethod {

    private double availableFunds;

    public PaymentMethod(double availableFunds){
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

}
