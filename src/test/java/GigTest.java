import Venue.Gig;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GigTest {

    private Gig gig1;

    @Before
    public void before(){
        gig1 = new Gig(17,1, 2018, 20000, 12.50);
    }

    @Test
    public void canGetCapacity(){
        assertEquals(20000, gig1.getCapacity());
    }

    @Test
    public void canGetDate(){
        assertNotNull(gig1.getDate());
    }

    @Test
    public void canSetCapacity(){
        gig1.setCapacity(21000);
        assertEquals(21000, gig1.getCapacity());
    }

    @Test
    public void canSetDate(){
        gig1.setDate(18, 1, 2018);
        assertNotNull(gig1.getDate());
    }

    @Test
    public void ticketsSoldStartsAtZero(){
        assertEquals(0, gig1.getNumberOfSoldTickets());
    }

    @Test
    public void unsoldTicketsStartsAtCapacity(){
        assertEquals(20000, gig1.getNumberOfUnsoldTickets());
    }

    @Test
    public void canGetPrice(){
        assertEquals(12.50, gig1.getTicketPrice(), 0.01);
    }

    @Test
    public void canSetPrice(){
        gig1.setTicketPrice(10.50);
        assertEquals(10.50, gig1.getTicketPrice(), 0.01);
    }

    @Test
    public void addedArtistsStartAtZero(){
        assertEquals(0, gig1.getNumberOfArtistsOnBill());
    }

    @Test
    public void canAddArtistsToGig(){
        gig1.addArtist("Bonnie Prince Billy");
        assertEquals(1, gig1.getNumberOfArtistsOnBill());
    }

//    How do I do a pretty date?

//    @Test
//    public void canGetPrettyDate(){
//        assertEquals("17/Jan/2018", gig1.getPrettyDate());
//    }


}
