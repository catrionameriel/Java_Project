package Customer;

import Venue.Ticket;

import java.util.ArrayList;

public class Customer {

    private ArrayList<Ticket> basket;
    private ArrayList<PaymentMethod> paymentMethods;
    private double totalFunds;

    public Customer(ArrayList<PaymentMethod> paymentMethods){
        basket = new ArrayList<>();
        this.paymentMethods = new ArrayList<>(paymentMethods);
        setTotal();
    }

    private void setTotal(){
        this.totalFunds = 0;
        for (PaymentMethod pm : paymentMethods) {
            this.totalFunds += pm.getAvailableFunds();
        }
    }

    public int countPaymentMethods() {
        return paymentMethods.size();
    }

    public void addPaymentMethod(PaymentMethod newPaymentMethod) {
        paymentMethods.add(newPaymentMethod);
        setTotal();
    }

    public void removePaymentMethod(PaymentMethod paymentMethod) {
        paymentMethods.remove(paymentMethod);
        setTotal();
    }

    public int countItemsInBasket() {
        return basket.size();
    }

    public void addItemInBasket(Ticket item) {
        basket.add(item);
    }

    public void removeItemInBasket(Ticket item) {
        basket.remove(item);
    }

    public double getTotalFunds(){
        return totalFunds;
    }

    public void buyTicket(Ticket ticket, PaymentMethod paymentMethodChoice){
//        find price of ticket
//        take money away from paymentMethod
//        add ticket to ArrayList
//        update totalfunds
    }

}
