package Customer;

import Venue.ITransaction;

import java.util.ArrayList;

public class Customer {

    private ArrayList<ITransaction> basket;
    private ArrayList<PaymentMethod> paymentMethods;

    public Customer(){
        basket = new ArrayList<>();
        paymentMethods = new ArrayList<>();
    }

    public int countPaymentMethods() {
        return paymentMethods.size();
    }

    public void addPaymentMethod(PaymentMethod newPaymentMethod) {
        paymentMethods.add(newPaymentMethod);
    }

    public void removePaymentMethod(PaymentMethod paymentMethod) {
        paymentMethods.remove(paymentMethod);
    }

    public int countItemsInBasket() {
        return basket.size();
    }
}
