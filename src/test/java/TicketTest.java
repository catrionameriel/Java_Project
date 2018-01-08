import Venue.Ticket;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicketTest {

    private Ticket ticket;

    @Before
    public void before(){
        ticket = new Ticket(1, 10.50);
    }

    @Test
    public void canGetId(){
        assertEquals(1, ticket.getID());
    }

}
