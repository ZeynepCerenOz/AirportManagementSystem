package tr.edu.ozu.planemanagement;
public class Plane implements PlaneManagementSystem {
    private String planeCode;
    private String capacity;


    public Plane(String planeCode, String capacity ){
        this.planeCode=planeCode;
        this.capacity=capacity;
    }
    public String getPlaneCode(){
        return planeCode;
    }

    public String getCapacity(){
        return capacity;
    }

    @Override
    public void setReservedByPlaneCode(String reservedByPlaneCode) {

    }

    public String toString(){
        return "Plane{ "+ "Code: "+ planeCode + '\'' + "Capacity " +capacity+'\''+ " }";
    }
}
