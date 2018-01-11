package Payments;

public class DebitCard extends CardPayment {

    private DebitCardType typeOfDebitCard;

    public DebitCard(double availableFunds, String name, long cardNumber, DebitCardType type) {
        super(availableFunds, name, cardNumber);
        typeOfDebitCard = type;
    }

    public DebitCardType getDebitCardType(){
        return this.typeOfDebitCard;
    }

}
