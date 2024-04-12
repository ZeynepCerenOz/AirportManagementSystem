package tr.edu.ozu.passengermanagement;

public class FamilyPassenger extends AirportPassenger {
    public FamilyPassenger(String name, String surname,int luggageCount,String dateOfBirth, int passengerId) {
        super( name,  surname, luggageCount, dateOfBirth,  passengerId);
        super.setDiscountRate(50);
    }
    @Override
    public String toString() {
        return "FamilyPassenger{" +
                " type='" + "FamilyPassenger" + '\'' +
                ", Id='" +super.getPassengerId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", surname='" + super.getSurname() + '\'' +
                ", luggageCount='" + super.getLuggageCount() + '\'' +
                ", dateOfBirth='" + super.getDateOfBirth() + '\'' +
                '}';
    }
}
