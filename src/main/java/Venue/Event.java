package Venue;

import java.util.GregorianCalendar;

    public abstract class Event //implements ISell
    {

    protected GregorianCalendar date;
    protected int capacity;

    protected Event(int day, int month, int year, int capacity){
        this.date = new GregorianCalendar(year, month, day);
        this.capacity = capacity;
    }

    public GregorianCalendar getDate(){
        return this.date;
    }

    public void setDate(int newDay, int newMonth, int newYear){
        date = new GregorianCalendar(newYear, newMonth, newDay);
    }

//    public String getPrettyDate(){
//        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
//        return date.format(this.date.toString());
//    }

    public int getCapacity(){
        return this.capacity;
    }

    public void setCapacity(int newCapacity){
        capacity = newCapacity;
    }

}
