package tr.edu.ozu.flightmanagement;

public class VipTicket extends Ticket {
    public VipTicket(int soldToPassengerId, int seatId, int ticketId, double discountPrice) {
        super(soldToPassengerId, seatId, ticketId, discountPrice);
    }

    public VipTicket(int seatId) {
        super(seatId);
    }


    @Override
    public String toString() {
        return "VipTİcket{" +
                ", ticket type='" + "VipTİcket" + '\'' +
                "Ticket Id: " + super.getTicketId() + '\'' +
                "sold To Passenger Id='" + super.getSoldToPassengerId() + '\'' +
                ", seat Id='" + super.getSeatId() + '\'' +
                ", discount Price='" + super.getDiscountPrice() + '\'' +
                '}';
    }
}
