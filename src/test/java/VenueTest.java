import Venue.Gig;
import Venue.PaymentMethodType;
import Venue.Venue;
import Venue.ITransaction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class VenueTest {

    private Venue gigVenue;
    private ITransaction item;
    private PaymentMethodType creditCard;

    @Before
    public void before(){
        gigVenue = new Venue();
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
        gigVenue.giveRefund(5.00);
        assertEquals(5.00, gigVenue.getTotalRefunds(), 0.01);
    }

    @Test
    public void canSell(){
        gigVenue.sell(10.00);
        gigVenue.sell(10.00);
        assertEquals(20.00, gigVenue.getTotalSales(), 0.01);
    }

    @Test
    public void canGetFunds(){
        gigVenue.sell(10.00);
        gigVenue.sell(10.00);
        gigVenue.giveRefund(5.00);
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
}
