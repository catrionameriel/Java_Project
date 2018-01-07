import Venue.Artist;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArtistTest {

    private Artist taylorSwift;

    @Before
    public void before(){
        taylorSwift = new Artist("Taylor Sift");
    }

    @Test
    public void canGetName(){
        assertEquals("Taylor Sift", taylorSwift.getArtistName());
    }

    @Test
    public void canChangeName(){
        taylorSwift.setArtistName("Taylor Swift");
        assertEquals("Taylor Swift", taylorSwift.getArtistName());
    }

}
