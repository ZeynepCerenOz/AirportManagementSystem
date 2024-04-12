package tr.edu.ozu.flightmanagement;

import java.util.ArrayList;

public interface FlightManagementSystem {
    Boolean isThereAnyTicketAlreadySoldToPassengerId(int passengerId);


    // Getter and setter methods for departureAirport and landingAirport
    String getDepartureAirport() ;
    void setDepartureAirport(String departureAirport) ;
    String getLandingAirport();
     void setLandingAirport(String landingAirport) ;


     String getFlightDate();
    void setFlightDate(String returnDate);
   String getPlaneCode();
    void setPlaneCode(String planeCode);
    int getFlightId();
    void setFlightId(int flightId);

   int getPeerFlightId();
    void setPeerFlightId(int peerFlightId);
    double getCeilingPrice();
   void setCeilingPrice(double ceilingPrice);

   ArrayList<Ticket> getTicketsToBeSold();


    Ticket getTicketAt(int index);

}
