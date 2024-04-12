package tr.edu.ozu.planemanagement;
public class Runway implements PlaneManagementSystem {//airport id ekle
    private int runwayId;
    private String reservedByPlaneCode;
    private String airportCode;

    public Runway(int runwayId,String airportCode){
        this.runwayId=runwayId;
        this.reservedByPlaneCode="Empty";
        this.airportCode=airportCode;
    }

    @Override
    public String getPlaneCode() {
        return null;
    }

    @Override
    public String getCapacity() {
        return null;
    }

    public void setReservedByPlaneCode(String reservedByPlaneCode){
        this.reservedByPlaneCode=reservedByPlaneCode;
    }
    public String toString(){
        return "Runway{" + "runway: "+ runwayId + '\''
                + "Reserved By Plane: " +reservedByPlaneCode+'\''
                + "at airport " +airportCode+'\''
                +'}';
    }

}




