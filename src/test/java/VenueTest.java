import Payments.CreditCard;
import Payments.CreditCardType;
import Payments.PaymentMethod;
import Venue.*;
import Customer.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class VenueTest {

    private Venue gigVenue;
    private Gig item;
    private PaymentMethodType creditCard;
    private Customer customer;
    private PaymentMethod card;

    @Before
    public void before(){
        card = new CreditCard(10000.00, "J Goodall", 1234567812345678L, CreditCardType.MASTERCARD);
        ArrayList<PaymentMethod> pMethods = new ArrayList<>();
        pMethods.add(card);
        customer = new Customer(pMethods);
        gigVenue = new Venue();
        gigVenue.addTPaymentMethodType(PaymentMethodType.CASH);
        gigVenue.addTPaymentMethodType(PaymentMethodType.CREDITCARD);
        gigVenue.addTPaymentMethodType(PaymentMethodType.DEBITCARD);
        item = new Gig(12,1, 2015,200, 12.50);
        creditCard = PaymentMethodType.CREDITCARD;
    }

    @Test
    public void totalSalesStartAtZero(){
        assertEquals(0, gigVenue.getTotalSales(), 0.001);
    }

    @Test
    public void totalRefundsStartAtZero(){
        assertEquals(0, gigVenue.getTotalRefunds(), 0.001);
    }

    @Test
    public void transactionsStartsAtNil(){
        assertEquals(0, gigVenue.countTransactions());
    }

    @Test
    public void canAddToTransactions(){
        gigVenue.addTransaction(item);
        assertEquals(1, gigVenue.countTransactions());
    }

    @Test
    public void canRemoveFromTransactions(){
        gigVenue.addTransaction(item);
        gigVenue.removeTransaction(item);
        assertEquals(0, gigVenue.countTransactions());
    }

    @Test
    public void canSetRefunds(){
        gigVenue.addToRefundAmount(5.00);
        assertEquals(5.00, gigVenue.getTotalRefunds(), 0.01);
    }

    @Test
    public void canSell(){
        gigVenue.addToSalesAmount(10.00);
        gigVenue.addToSalesAmount(10.00);
        assertEquals(20.00, gigVenue.getTotalSales(), 0.01);
    }

    @Test
    public void canGetFunds(){
        gigVenue.addToSalesAmount(10.00);
        gigVenue.addToSalesAmount(10.00);
        gigVenue.addToRefundAmount(5.00);
        assertEquals(15.00, gigVenue.getTotalFunds(), 0.01);
    }

    @Test
    public void canGetAllPaymentMethods(){
        assertNotNull(gigVenue.getAllPaymentMethods());
        assertEquals(3, gigVenue.countPaymentMethods());
    }

    @Test
    public void canRemovePaymentMethod(){
        gigVenue.removePaymentType(PaymentMethodType.CASH);
        assertEquals(2, gigVenue.countPaymentMethods());
    }

    @Test
    public void canSelectParticularPaymentMethod(){
        assertEquals(PaymentMethodType.CREDITCARD, gigVenue.selectPaymentType(creditCard));
    }

    @Test
    public void canAddToCustomersQueue() {
        gigVenue.addCustomerToQueue(customer);
        assertEquals(1, gigVenue.countCustomersInQueue());
    }

    @Test
    public void canRemoveCustomersFromQueue() {
        gigVenue.addCustomerToQueue(customer);
        gigVenue.removeCustomerFromQueue();
        assertEquals(0, gigVenue.countCustomersInQueue());
    }

    @Test
    public void canSellTicket() {
        gigVenue.addCustomerToQueue(customer);
        gigVenue.sellTicket(item);
        assertEquals(1, customer.countItemsInBasket());
    }

    @Test
    public void cannotSellTicketIfSoldOut() {
        for (int i=0; i< item.getCapacity(); i++){
            item.removeFirstTicketFromUnsold();
        }
        gigVenue.addCustomerToQueue(customer);
        gigVenue.sellTicket(item);
        assertEquals(0, customer.countItemsInBasket());
    }
}
