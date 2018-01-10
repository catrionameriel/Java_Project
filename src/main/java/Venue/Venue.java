package Venue;

import Customer.Customer;

import java.util.ArrayList;

public class Venue {

    private double totalSales;
    private double totalRefunds;
    private ArrayList<Event> listOfSales;
    private ArrayList<PaymentMethodType> paymentMethods;
    private ArrayList<Customer> customerQueue;


    public Venue(){
        totalSales = 0;
        totalRefunds = 0;
        listOfSales = new ArrayList<>();
        paymentMethods = new ArrayList<>();
        paymentMethods.add(PaymentMethodType.CASH);
        paymentMethods.add(PaymentMethodType.CREDITCARD);
        paymentMethods.add(PaymentMethodType.DEBITCARD);
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

    public void addTransaction(Event sale) {
        listOfSales.add(sale);
    }

    public void removeTransaction(Event sale) {
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

    public ArrayList<PaymentMethodType> getAllPaymentMethods(){
        return paymentMethods;
    }

    public void removePaymentType(PaymentMethodType paymentType){
        paymentMethods.remove(paymentType);
    }

    public int countPaymentMethods() {
        return paymentMethods.size();
    }

    public PaymentMethodType selectPaymentType(PaymentMethodType paymentType) {
        int index = paymentMethods.indexOf(paymentType);
        return paymentMethods.get(index);
    }

//    public customer Checkout

    public Ticket sellTicketToGig(ISell sale, PaymentMethodType paymentMethod){
//       check payment type is ok
//       check capacity
//
//       get customer
         Customer customer = customerQueue.get(0);
//
//       get price from item
         double price = sale.getGigPrice();
//
//       add that money to totalSales
         addToSalesAmount(price);

//       add to listOfSales
         listOfSales.add(sale);

//       trigger customer buying
//         customer.buyTicket(sale, paymentMethod);
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

    public boolean enoughTickets(Gig gig){
        return gig.getNumberOfUnsoldTickets() > 0;
    }
}
