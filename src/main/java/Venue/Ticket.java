package Venue;

public class Ticket implements ITransaction {

    private double price;
    private int id;

    public Ticket (int id, double price){
        this.id = id;
        this.price = price;
    }

    public int getID() {
        return id;
    }

    public double getTicketPrice(){
        return price;
    }

    public void setTicketPrice(double newPrice) {
        this.price = newPrice;
    }

    @Override
    public void sell() {

    }
}
