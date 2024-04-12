// Model class for Passenger
package tr.edu.ozu.passengermanagement;
//this class has not been made abstract because it is used for making it easy to pass parameters in AddPassengerButtonListener
public class AirportPassenger implements PassengerManagementSystem {
    // Fields for name and surname
    private String name;
    private String surname;
    private int luggageCount;
    private String dateOfBirth;
    private int passengerId;
    private double discountRate;

    // Constructor with parameters
    public AirportPassenger(String name, String surname, int luggageCount, String dateOfBirth, int passengerId) {
        this.name = name;
        this.surname = surname;
        this.luggageCount=luggageCount;
        this.dateOfBirth=dateOfBirth;
        this.passengerId=passengerId;
        discountRate=0;
    }
    public AirportPassenger() {

    }

    // Getter and setter methods for name and surname
    public double getDiscountRate(){
        return discountRate;
    }
    public void setDiscountRate(double discountRate){
        this.discountRate=discountRate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getLuggageCount(){
        return luggageCount;
    }
    public void setLuggageCount(int luggageCount){
        this.luggageCount=luggageCount;
    }
    public String getDateOfBirth(){
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth=dateOfBirth;
    }
    public int getPassengerId(){
        return passengerId;
    }
    public void setPassengerId(int passengerId){
        this.passengerId=passengerId;
    }

    // Override toString method to display passenger details
    @Override
    public String toString() {//not used
        return "Passenger{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' + "Passenger Id: "+ passengerId+ '\''+ "passenger type= "+ this.getClass().getName() + '\''
                + "luggage count= "+ luggageCount + '\'' + "Date of Birth= " + dateOfBirth + '\''+
                '}';
    }
}