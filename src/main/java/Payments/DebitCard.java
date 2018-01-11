package Payments;

public class DebitCard extends CardPayment {

    private DebitCardType typeOfDebitCard;

    public DebitCard(String paymentName, double availableFunds, String name, long cardNumber, DebitCardType type) {
        super(paymentName, availableFunds, name, cardNumber);
        typeOfDebitCard = type;
    }

    public DebitCardType getDebitCardType(){
        return this.typeOfDebitCard;
    }

}
