package Payments;

public class CreditCard extends CardPayment {

    private CreditCardType typeOfCreditCard;

    public CreditCard(double availableFunds, String name, long cardNumber, CreditCardType type) {
        super(availableFunds, name, cardNumber);
        typeOfCreditCard = type;
    }

    public CreditCardType getCardType() {
        return typeOfCreditCard;
    }
}
