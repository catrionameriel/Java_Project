package Customer;

import Payments.PaymentMethod;
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

    public void addItemInBasket(Ticket ticket) {
        basket.add(ticket);
    }

    public void removeItemInBasket(Ticket ticket) {
        basket.remove(ticket);
    }

    public double getTotalFunds(){
        return totalFunds;
    }

    public void setTotalFunds(double money){
        totalFunds += money;
    }

    public double getTotalOfBasket(){
        double total = 0;
        for (Ticket ticket : basket) {
            double price = ticket.getTicketPrice();
            total += price;
        }
        return total;
    }

    public void buyBasket(PaymentMethod paymentMethodChoice){
            double toPay = getTotalOfBasket();
            paymentMethodChoice.pay(toPay);
            setTotal();
    }

}
