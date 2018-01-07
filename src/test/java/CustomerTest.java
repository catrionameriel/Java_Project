import Customer.CreditCard;
import Customer.CreditCardType;
import Customer.Customer;
import Customer.PaymentMethod;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer1;
    private PaymentMethod card;

    @Before
    public void before(){
        customer1 = new Customer();
        card = new CreditCard(10000, "J Goodall", CreditCardType.MASTERCARD);
    }

    @Test
    public void paymentMethodsStartsAtZero(){
        assertEquals(0, customer1.countPaymentMethods());
    }

    @Test
    public void canAddPaymentMethods(){
        customer1.addPaymentMethod(card);
        assertEquals(1, customer1.countPaymentMethods());
    }

    @Test
    public void canRemovePaymentMethods(){
        customer1.addPaymentMethod(card);
        customer1.removePaymentMethod(card);
        assertEquals(0, customer1.countPaymentMethods());
    }

    @Test
    public void basketStartAtZero(){
        assertEquals(0, customer1.countItemsInBasket());
    }
}
