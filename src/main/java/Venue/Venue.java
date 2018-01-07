package Venue;

import java.util.ArrayList;

public class Venue {

    private double totalSales;
    private double totalRefunds;
    private ArrayList<ITransaction> transactions;
    private ArrayList<PaymentMethodType> paymentMethods;


    public Venue(){
        totalSales = 0;
        totalRefunds = 0;
        transactions = new ArrayList<>();
        paymentMethods = new ArrayList<>();
        paymentMethods.add(PaymentMethodType.CASH);
        paymentMethods.add(PaymentMethodType.CREDITCARD);
        paymentMethods.add(PaymentMethodType.DEBITCARD);

    }

    public double getTotalSales() {
        return totalSales;
    }

    public double getTotalRefunds() {
        return totalRefunds;
    }

    public int countTransactions() {
        return transactions.size();
    }

    public void addTransaction(ITransaction item) {
        transactions.add(item);
    }

    public void removeTransaction(ITransaction item) {
        transactions.remove(item);
    }

    public void giveRefund(double refund) {
        totalRefunds += refund;
    }

    public void sell(double price) {
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


}
