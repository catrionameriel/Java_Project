package Payments;

public abstract class CardPayment extends PaymentMethod {

    private String nameOnCard;
    private long cardNumber;


    protected CardPayment(double availableFunds, String name, long cardNumber) {
        super(availableFunds);
        nameOnCard = name;
        this.cardNumber = cardNumber;
    }

    public String getNameOnCard(){
        return nameOnCard;
    }

    public long getCardNumber(){
        return this.cardNumber;
    }

}
