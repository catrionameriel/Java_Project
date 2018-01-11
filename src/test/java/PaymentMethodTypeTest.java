import Venue.PaymentMethodType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaymentMethodTypeTest {

    private PaymentMethodType creditCard;

    @Before
    public void before() {
        creditCard = PaymentMethodType.CREDITCARD;
    }

    @Test
    public void canGetType() {
        assertEquals("Credit Card", creditCard.getPaymentMethodName());
    }
}
