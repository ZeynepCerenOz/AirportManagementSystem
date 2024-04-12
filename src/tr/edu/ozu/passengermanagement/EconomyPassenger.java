package tr.edu.ozu.passengermanagement;

public class EconomyPassenger extends AirportPassenger {
    public EconomyPassenger(String name, String surname,int luggageCount,String dateOfBirth, int passengerId) {
        super( name,  surname,luggageCount, dateOfBirth,  passengerId);
        super.setDiscountRate(30);
    }
    @Override
    public String toString() {
        return "EconomyPassenger{" +
                " type='" + "EconomyPassenger" + '\'' +
                ", Id='" +super.getPassengerId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", surname='" + super.getSurname() + '\'' +
                ", luggageCount='" + super.getLuggageCount() + '\'' +
                ", dateOfBirth='" + super.getDateOfBirth() + '\'' +
                '}';
    }
}
