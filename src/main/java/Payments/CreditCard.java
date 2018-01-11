package Payments;

public class CreditCard extends CardPayment {

    private CreditCardType typeOfCreditCard;

    public CreditCard(String paymentName, double availableFunds, String name, long cardNumber, CreditCardType type) {
        super(paymentName, availableFunds, name, cardNumber);
        typeOfCreditCard = type;
    }

    public CreditCardType getCardType() {
        return typeOfCreditCard;
    }
}
