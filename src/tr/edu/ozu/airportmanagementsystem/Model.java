package tr.edu.ozu.airportmanagementsystem;
import java.util.ArrayList;
import tr.edu.ozu.planemanagement.*;
import tr.edu.ozu.flightmanagement.*;
import tr.edu.ozu.passengermanagement.*;

public class Model {
    //passenger attributes
    private ArrayList<AirportPassenger> passengers;
   // private String[] columnNames = {"Name", "Surname", "Passenger Type"};
    private int currentPassengerId;
    //flight attributes
    private ArrayList<Flight> flights;
    private Integer currentFlightId=1;
    //plane attributes
    private ArrayList<Hangar> hangars;
    private ArrayList<Runway> runways;
    private ArrayList<Plane> planes;
    private ArrayList<Airport> airports;

    private int currentHangarId=1;
    private int currentRunwayId=1;
    private int currentAirportid=1;

    public Model(){
        //passenger constructor
        passengers = new ArrayList<>();
        this.currentPassengerId=1;
        //plane constr.
        hangars=new ArrayList<>();
        runways=new ArrayList<>();
        planes=new ArrayList<>();
        airports=new ArrayList<>();
        //flight constructor
        flights = new ArrayList<>();
    }
    //passenger methods
    public AirportPassenger getPassenger(int row) {
        return passengers.get(row);
    }
    public AirportPassenger addPassenger(AirportPassenger p, String passengerType) {
        currentPassengerId++;
        if(passengerType=="Business")
            p=new BusinessPassenger(p.getName(),p.getSurname(),p.getLuggageCount(),p.getDateOfBirth(),p.getPassengerId());
        else if(passengerType=="Economy")
            p=new EconomyPassenger(p.getName(),p.getSurname(),p.getLuggageCount(),p.getDateOfBirth(),p.getPassengerId());
        else if(passengerType=="Family")
            p=new FamilyPassenger(p.getName(),p.getSurname(),p.getLuggageCount(),p.getDateOfBirth(),p.getPassengerId());

        passengers.add(p);
        return p;
    }

    public void removePassenger(int row) {
        passengers.remove(row);
    }

    public AirportPassenger updatePassenger(int row, AirportPassenger p, String newPassengerType) {
        if(newPassengerType=="Business")
            p=new BusinessPassenger(p.getName(),p.getSurname(),p.getLuggageCount(),p.getDateOfBirth(),p.getPassengerId());
        else if(newPassengerType=="Economy")
            p=new EconomyPassenger(p.getName(),p.getSurname(),p.getLuggageCount(),p.getDateOfBirth(),p.getPassengerId());
        else if(newPassengerType=="Family")
            p=new FamilyPassenger(p.getName(),p.getSurname(),p.getLuggageCount(),p.getDateOfBirth(),p.getPassengerId());

        passengers.set(row,p);
        return p;
    }
    public int getCurrentPassengerId(){
        return currentPassengerId;

    }
    public AirportPassenger getPassengerById(int passengerId) {

        for (int i = 0; i < passengers.size(); i++) {

            AirportPassenger passenger = passengers.get(i);
            if (passenger.getPassengerId() == passengerId)
                return passenger;

        }

        return null;
    }
//plane methods
public int getCurrentHangarId(){
    return currentHangarId;
}
    public int getCurrentRunwayId(){
        return currentRunwayId;
    }

    public Airport getAirportByAirportCode(String airportCode) {

        for (int i = 0; i < airports.size(); i++) {

            Airport airport = airports.get(i);
            if (airport.getAirportCode().equals(airportCode)==true)
                return airport;

        }

        return null;
    }
    public Plane getPlaneByFlightPlaneCode(String flightPlaneCode) {

        for (int i = 0; i < planes.size(); i++) {

            Plane plane = planes.get(i);
            if (plane.getPlaneCode().equals(flightPlaneCode)==true)
                return plane;

        }

        return null;
    }

    public int getCurrentAirportId(){return currentAirportid; }


    public Airport getAirport(int row){
        return airports.get(row);
    }
    public void addAirport(Airport a){
        currentAirportid++;
        airports.add(a);
    }
    public void removeAirport(int row){
        airports.remove(row);
    }

    public Plane getPlane(int row) {
        return planes.get(row);
    }
    public void addPlane(Plane p){
        //what happens to plane code?

        planes.add(p);
    }
    public void removePlane(int row){
        planes.remove(row);
    }

    public Hangar getHangar(int row) {
        return hangars.get(row);
    }
    public void addHangar(Hangar h) {
        currentHangarId++;
        hangars.add(h);
    }
    public void removeHangar(int row){
        hangars.remove(row);
    }

    public void reserveHangar(int row, Hangar h) {
        hangars.set(row, h);
    }

    public void resetHangar(int row, Hangar h) {
        hangars.set(row, h);
    }

    public Runway getRunway(int row){
        return runways.get(row);
    }

    public void addRunway(Runway r) {
        currentRunwayId++;
        runways.add(r);
    }
    public void removeRunway(int row){
        runways.remove(row);
    }
    public void reserveRunway(int row, Runway r){
        runways.set(row,r);
    }
    public void resetRunway(int row, Runway r){
        runways.set(row, r);
    }

    //flight methods
    public int getCurrentflightId() {
        return currentFlightId;
    }

    public Flight getFlight(int row) {
        return flights.get(row);
    }
    public void addFlight(Flight p) {
        currentFlightId++;
        flights.add(p);
    }

    public void removeFlight(int row) {
        flights.remove(row);
    }

}
