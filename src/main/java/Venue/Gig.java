package Venue;

import java.util.ArrayList;

public class Gig extends Event {

    private ArrayList<Artist> artists;
    private ArrayList<Ticket> soldTickets;
    private ArrayList<Ticket> unsoldTickets;
    private double ticketPrice;

    public Gig(int day, int month, int year, int capacity, double ticketPrice) {
        super(day, month, year, capacity);
        soldTickets = new ArrayList<>();
        unsoldTickets = new ArrayList<>();
        for(int i=0; i < capacity; i++){
            unsoldTickets.add(new Ticket(i));
        }
        artists = new ArrayList<>();
        this.ticketPrice = ticketPrice;
    }

    public int getNumberOfSoldTickets(){
        return soldTickets.size();
    }

    public int getNumberOfUnsoldTickets(){
        return unsoldTickets.size();
    }

    public int getNumberOfArtistsOnBill(){
        return artists.size();
    }

    public double getTicketPrice(){
        return ticketPrice;
    }

    public void setTicketPrice(double newPrice) {
        this.ticketPrice = newPrice;
    }

    public void addArtist(String newArtist) {
        Artist artist = new Artist(newArtist);
        artists.add(artist);
    }

    @Override
    public void sell() {

    }
}
