import Venue.Ticket;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicketTest {

    private Ticket ticket;

    @Before
    public void before(){
        ticket = new Ticket(1);
    }

    @Test
    public void canGetId(){
        assertEquals(1, ticket.getID());
    }

//    @Test
//    public void canGetPrice(){
//        assertEquals(10.50, ticket.getTicketPrice(),0.01);
//    }
//
//    @Test
//    public void canSetPrice(){
//        ticket.setTicketPrice(11.50);
//        assertEquals(11.50, ticket.getTicketPrice(),0.01);
//    }

}
