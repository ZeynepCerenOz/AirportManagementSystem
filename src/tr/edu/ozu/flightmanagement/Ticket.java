// Model class for Ticket
package tr.edu.ozu.flightmanagement;

public abstract class Ticket {
    // Fields for soldToPassengerId and seatId
    private int soldToPassengerId;
    private int seatId;
    private int ticketId;
    private double discountPrice;

    // Constructor with parameters
    public Ticket(int soldToPassengerId, int seatId,  int ticketId,double discountPrice) {
        this.soldToPassengerId = soldToPassengerId;
        this.seatId = seatId;
        this.ticketId=ticketId;
        this.discountPrice=discountPrice;
    }

    public Ticket(int seatId) {
        this.seatId = seatId;
    }


    // Getter and setter methods for soldToPassengerId and seatId
    public int getSoldToPassengerId() {
        return soldToPassengerId;
    }
    public void setSoldToPassengerId(int soldToPassengerId) {
        this.soldToPassengerId = soldToPassengerId;
    }
    public int getSeatId() {
        return seatId;
    }
    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getTicketId(){
        return ticketId;
    }
    public void setTicketId(int ticketId){
        this.ticketId=ticketId;
    }

    public double getDiscountPrice(){
        return discountPrice;
    }
    public void setDiscountPrice(double discountPrice){
        this.discountPrice=discountPrice;
    }

    // Override toString method to display ticket details
    @Override
    public String toString() {
        return "Ticket{" +
                ", ticket type='" + this.getClass().getName() + '\'' +
                "Ticket Id: "+ ticketId+ '\''+
                "sold To Passenger Id='" + soldToPassengerId + '\'' +
                ", seat Id='" + seatId + '\'' +
                ", discount Price='" + discountPrice + '\'' +
                '}';
    }
}