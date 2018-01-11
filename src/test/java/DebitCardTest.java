import Payments.DebitCard;
import Payments.DebitCardType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DebitCardTest {

    private DebitCard debitCard;

    @Before
    public void before(){
        debitCard = new DebitCard(2000, "P Docherty", 1234567812345678L, DebitCardType.MAESTRO);
    }

    @Test
    public void canGetAvailableFunds(){
        assertEquals(2000, debitCard.getAvailableFunds(), 0.01);
    }

    @Test
    public void canGetName(){
        assertEquals("P Docherty", debitCard.getNameOnCard());
    }

    @Test
    public void canGetCreditCardType(){
        assertEquals(DebitCardType.MAESTRO, debitCard.getDebitCardType());
    }

    @Test
    public void canGetCardNumber(){
        assertEquals(1234567812345678L, debitCard.getCardNumber());
    }


}
