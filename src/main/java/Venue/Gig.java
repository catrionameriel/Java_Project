package Venue;

import java.util.ArrayList;

public class Gig extends Event {

    private ArrayList<Artist> artists;
    private ArrayList<Ticket> soldTickets;
    private ArrayList<Ticket> unsoldTickets;
    private double gigPrice;

    public Gig(int day, int month, int year, int capacity, double gigPrice) {
        super(day, month, year, capacity);
        soldTickets = new ArrayList<>();
        unsoldTickets = new ArrayList<>();
        fillUnsoldTickets();
        artists = new ArrayList<>();
        this.gigPrice = gigPrice;

    }

    private void fillUnsoldTickets(){
        for(int i=0; i < capacity; i++){
            unsoldTickets.add(new Ticket(i, this.gigPrice));
        }
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

    public void addArtist(String newArtist) {
        Artist artist = new Artist(newArtist);
        artists.add(artist);
    }

    public void addTicketToSold(Ticket ticket){
        soldTickets.add(ticket);
    }

    public Ticket removeFirstTicketFromUnsold(){
        return unsoldTickets.remove(0);
    }

    public void sell() {
       Ticket ticket = removeFirstTicketFromUnsold();
       addTicketToSold(ticket);

    }

    public double getGigPrice() {
        return gigPrice;
    }

    public void setGigPrice(double gigPrice) {
        this.gigPrice = gigPrice;
    }
}
