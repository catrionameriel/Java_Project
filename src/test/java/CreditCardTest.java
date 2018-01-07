import Customer.CreditCard;
import Customer.CreditCardType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreditCardTest {

    private CreditCard creditCard;

    @Before
    public void before(){
        creditCard = new CreditCard(10000, "J Goodall", 1234567812345678, CreditCardType.VISA);
    }

    @Test
    public void canGetAvailableFunds(){
        assertEquals(10000, creditCard.getAvailableFunds(), 0.01);
    }

    @Test
    public void canGetName(){
        assertEquals("J Goodall", creditCard.getNameOnCard());
    }

    @Test
    public void canGetCreditCardType(){
        assertEquals(CreditCardType.VISA, creditCard.getCardType());
    }

    @Test
    public void canGetCardNumber(){
        assertEquals(1234567812345678, creditCard.getCardNumber());
    }

}
