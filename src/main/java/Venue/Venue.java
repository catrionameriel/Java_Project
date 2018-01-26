package Venue;

import Customer.Customer;

import java.util.ArrayList;

public class Venue {

    private double totalSales;
    private double totalRefunds;
    private ArrayList<ISell> listOfSales;
    private ArrayList<PaymentMethodType> paymentMethods;
//    change the above to PaymentMethods rather than enum
    private ArrayList<Customer> customerQueue;


    public Venue() {
        totalSales = 0;
        totalRefunds = 0;
        listOfSales = new ArrayList<>();
        paymentMethods = new ArrayList<>();
//        change this to have to be added when instantiated
        customerQueue = new ArrayList<>();
    }

    public double getTotalSales() {
        return totalSales;
    }

    public double getTotalRefunds() {
        return totalRefunds;
    }

    public int countTransactions() {
        return listOfSales.size();
    }

    public void addTransaction(ISell sale) {
        listOfSales.add(sale);
    }

    public void removeTransaction(ISell sale) {
        listOfSales.remove(sale);
    }

    public void addToRefundAmount(double refund) {
        totalRefunds += refund;
    }

    public void addToSalesAmount(double price) {
        totalSales += price;
    }

    public double getTotalFunds() {
        return totalSales -= totalRefunds;
    }

    public ArrayList<PaymentMethodType> getAllPaymentMethods() {
        return paymentMethods;
    }

    public void addTPaymentMethodType(PaymentMethodType paymentMethod) {
        paymentMethods.add(paymentMethod);
    }

    public void removePaymentType(PaymentMethodType paymentType) {
        paymentMethods.remove(paymentType);
    }

    public int countPaymentMethods() {
        return paymentMethods.size();
    }

    public PaymentMethodType selectPaymentType(PaymentMethodType paymentType) {
        int index = paymentMethods.indexOf(paymentType);
        return paymentMethods.get(index);
    }

    public void addCustomerToQueue(Customer customer) {
        customerQueue.add(customer);
    }

    public int countCustomersInQueue() {
        return customerQueue.size();
    }

    public void removeCustomerFromQueue() {
        customerQueue.remove(0);
    }

    public void sellTicket(ISell eventItem){
        Customer customer = customerQueue.get(0);
        if(eventItem.canSell()) {
            Ticket ticket = eventItem.sell();
            customer.addItemInBasket(ticket);
        }
        listOfSales.add(eventItem);
    }

//    public boolean checkPaymentType(PaymentMethod paymentMethod){
//        for (PaymentMethodType pm : paymentMethods) {
//            if (paymentMethod)
//        }
//    }

    public void checkoutCustomer(){
//      check payment type is ok
//      get price from item
        Customer customer = customerQueue.get(0);
        double price = customer.getTotalOfBasket();
    //
//      add that money to totalSales
        addToSalesAmount(price);

//      trigger buying
//      customer.buyBasket(PaymentMethod paymentMethod);
        customer.clearBasket();
        removeCustomerFromQueue();
    }
}
