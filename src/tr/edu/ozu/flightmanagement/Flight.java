package tr.edu.ozu.flightmanagement;

import java.util.ArrayList;

// Model class for Flight
public class Flight implements FlightManagementSystem {
    // Fields for departureAirport and landingAirport
    private String departureAirport;
    private String landingAirport;
    private String flightDate;
    private String planeCode;
    private int flightId;
    private int peerFlightId;
    private double ceilingPrice;
    private ArrayList<Ticket> ticketsToBeSold;




    // Constructor with parameters
    public Flight(String departureAirport, String landingAirport,String planeCode,String flightDate, int flightId,int peerFlightId, double ceilingPrice, int numberOfRegularSeats, int numberOfVIPSeats) {
        this.departureAirport = departureAirport;
        this.landingAirport = landingAirport;
        this.flightDate=flightDate;
        this.planeCode=planeCode;
        this.flightId=flightId;
        this.peerFlightId=peerFlightId;
        this.ceilingPrice=ceilingPrice;



      this.ticketsToBeSold = new ArrayList<Ticket>(numberOfRegularSeats+numberOfVIPSeats);

        for (int i = 0; i < numberOfVIPSeats; i++) {
            this.ticketsToBeSold.add(new VipTicket(i + 1));
        }

        for (int i = ticketsToBeSold.size(); i < numberOfVIPSeats+numberOfRegularSeats; i++) {
            this.ticketsToBeSold.add( new RegularTicket(i + 1));
        }

    }

    public Boolean isThereAnyTicketAlreadySoldToPassengerId(int passengerId){

        for(int i=0; i < ticketsToBeSold.size();i++){
            Ticket ticket=ticketsToBeSold.get(i);
            if(ticket.getSoldToPassengerId()==passengerId){
                return true;
            }
        }
        return false;
    }

    // Getter and setter methods for departureAirport and landingAirport
    public String getDepartureAirport() {
        return departureAirport;
    }
    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }
    public String getLandingAirport() {
        return landingAirport;
    }
    public void setLandingAirport(String landingAirport) {
        this.landingAirport = landingAirport;
    }


    public String getFlightDate(){
        return flightDate;
    }
    public void setFlightDate(String returnDate){
        this.flightDate=returnDate;
    }
    public String getPlaneCode(){
        return planeCode;
    }
    public void setPlaneCode(String planeCode){
        this.planeCode=planeCode;
    }
    public int getFlightId(){
        return flightId;
    }
    public void setFlightId(int flightId){
        this.flightId=flightId;
    }

    public int getPeerFlightId(){
        return peerFlightId;
    }
    public void setPeerFlightId(int peerFlightId){
        this.peerFlightId=flightId;
    }
    public double getCeilingPrice(){
        return ceilingPrice;
    }
    public void setCeilingPrice(double ceilingPrice){
        this.ceilingPrice=ceilingPrice;
    }

    public ArrayList<Ticket> getTicketsToBeSold(){
        return ticketsToBeSold;
    }


    public Ticket getTicketAt(int index){
        return ticketsToBeSold.get(index);
    }


    // Override toString method to display Flight details
    @Override
    public String toString() {
        return "Flight{" +
                "departureAirport='" + departureAirport + '\'' +
                ", landingAirport='" + landingAirport + '\'' + "Flight Id: "+ flightId+ '\''
                + "flight date= "+ flightDate + '\'' + "Plane Code " + planeCode + '\''+
                "ceiling Price='" + ceilingPrice + '\'' +
                "number of Seats='" + ticketsToBeSold.size() + '\'' +
                "peer flight Id'" + peerFlightId+ '\'' +
                '}';
    }
}