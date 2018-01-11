import Venue.Gig;
import Venue.Ticket;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GigTest {

    private Gig gig1;
    private Ticket ticket;

    @Before
    public void before(){
        ticket = new Ticket(1, 12.50);
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
        assertEquals(12.50, gig1.getPrice(), 0.01);
    }

    @Test
    public void canSetPrice(){
        gig1.setGigPrice(10.50);
        assertEquals(10.50, gig1.getPrice(), 0.01);
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

    @Test
    public void canAddTicketToSold(){
        gig1.addTicketToSold(ticket);
        assertEquals(1, gig1.getNumberOfSoldTickets());
    }

    @Test
    public void canRemoveTicketFromUnsold(){
        gig1.removeFirstTicketFromUnsold();
        assertEquals(19999, gig1.getNumberOfUnsoldTickets());
    }

    @Test
    public void canSellTicket(){
        gig1.sell();
        assertEquals(19999, gig1.getNumberOfUnsoldTickets());
        assertEquals(1, gig1.getNumberOfSoldTickets());
    }

    @Test
    public void enoughTicketsToSell__True(){
        assertEquals(true, gig1.canSell());
    }

    @Test
    public void enoughTicketsToSell__False(){
        for (int i=0; i<gig1.getCapacity(); i++){
            gig1.removeFirstTicketFromUnsold();
        }
        assertEquals(false, gig1.canSell());
    }

//    How do I do a pretty date?

//    @Test
//    public void canGetPrettyDate(){
//        assertEquals("17/Jan/2018", gig1.getPrettyDate());
//    }


}
