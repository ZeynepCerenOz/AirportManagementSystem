package tr.edu.ozu.planemanagement;

public class Airport {
    private int airportId;
    private String airportCode;

    public Airport(int airportId,String airportCode){
        this.airportId=airportId;
        this.airportCode=airportCode;
    }
    public int getAirportId(){
        return airportId;
    }
    public void setAirportId(int airportId){
        this.airportId=airportId;
    }
    public String getAirportCode(){
        return airportCode;
    }
    public void setAirportCode(String airportCode){
        this.airportCode=airportCode;
    }
    public String toString(){
        return "Airport{"+  "airport: "+ airportId + '\'' + "Airport Code: " +airportCode+'\''+'}';
    }

}
