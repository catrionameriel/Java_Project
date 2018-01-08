import Customer.CreditCard;
import Customer.CreditCardType;
import Customer.Customer;
import Customer.PaymentMethod;
import Venue.ITransaction;
import Venue.Ticket;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer1;
    private Customer customer2;
    private PaymentMethod card;
    private PaymentMethod card2;
    private Ticket ticket;

    @Before
    public void before(){
        ticket = new Ticket(2, 10.50);
        card = new CreditCard(10000.00, "J Goodall", 1234567812345678L, CreditCardType.MASTERCARD);
        card2 = new CreditCard(5000, "J Goodall", 1234567812345677L, CreditCardType.VISA);
        ArrayList<PaymentMethod> pMethods = new ArrayList<>();
        pMethods.add(card);
        ArrayList<PaymentMethod> emptyPMethod = new ArrayList<>();
        customer1 = new Customer(pMethods);
        customer2 = new Customer(emptyPMethod);
    }

    @Test
    public void paymentMethodsStartsAtZeroIfNoCards(){
        assertEquals(0, customer2.countPaymentMethods());
    }

    @Test
    public void canCountPaymentMethods(){
        assertEquals(1, customer1.countPaymentMethods());
    }

    @Test
    public void canAddPaymentMethods(){
        customer2.addPaymentMethod(card);
        assertEquals(1, customer2.countPaymentMethods());
    }

    @Test
    public void canRemovePaymentMethods(){
        customer2.addPaymentMethod(card);
        customer2.removePaymentMethod(card);
        assertEquals(0, customer2.countPaymentMethods());
    }

    @Test
    public void basketStartAtZero(){
        assertEquals(0, customer1.countItemsInBasket());
    }

    @Test
    public void totalFundsAreZeroIfNoPaymentMethods(){
        assertEquals(0, customer2.getTotalFunds(), 0.01);
    }

    @Test
    public void totalFundsCanInitializeFromCreditCardFunds(){
        assertEquals(10000.00, customer1.getTotalFunds(), 0.01);
    }

    @Test
    public void canGetTotalFundsAfterAddCard(){
        customer2.addPaymentMethod(card);
        customer2.addPaymentMethod(card2);
        assertEquals(2, customer2.countPaymentMethods());
        assertEquals(15000, customer2.getTotalFunds(), 0.01);
    }

    @Test
    public void canAddItemToBasket(){
        customer1.addItemInBasket(ticket);
        assertEquals(1, customer1.countItemsInBasket());
    }

    @Test
    public void canRemoveItemInBasket(){
        customer1.addItemInBasket(ticket);
        customer1.removeItemInBasket(ticket);
        assertEquals(0, customer1.countItemsInBasket());
    }
}
