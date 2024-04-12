package tr.edu.ozu.planemanagement;
public class Hangar implements PlaneManagementSystem {//airport id ekle
    private int hangarId;
    private String reservedByPlaneCode;
    private String airportCode;

    public Hangar(int hangarId,String airportCode){
        this.hangarId=hangarId;
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
        return "Hangar{"+  "hangar: "+ hangarId + '\''
                + "Reserved By Plane: " +reservedByPlaneCode+'\''
                + "at airport: " +airportCode+'\''
                +'}';
    }

}
