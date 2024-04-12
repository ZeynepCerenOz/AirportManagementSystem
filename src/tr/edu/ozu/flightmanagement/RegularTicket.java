package tr.edu.ozu.flightmanagement;

public class RegularTicket extends Ticket {
    public RegularTicket(int soldToPassengerId, int seatId, int ticketId, double discountPrice) {
        super(soldToPassengerId, seatId, ticketId, discountPrice);
    }

    public RegularTicket(int seatId) {
        super( seatId);
    }


    @Override
    public String toString() {
        return "RegularTicket{" +
                ", ticket type='" + "RegularTicket" + '\'' +
                "Ticket Id: " + super.getTicketId() + '\'' +
                "sold To Passenger Id='" + super.getSoldToPassengerId() + '\'' +
                ", seat Id='" + super.getSeatId() + '\'' +
                ", discount Price='" + super.getDiscountPrice() + '\'' +
                '}';
    }
}
