package tr.edu.ozu.passengermanagement;

public class BusinessPassenger extends AirportPassenger {
    public BusinessPassenger(String name, String surname, int luggageCount,String dateOfBirth, int passengerId) {
        super( name,  surname,  luggageCount, dateOfBirth,  passengerId);
        super.setDiscountRate(10);
    }

    @Override
    public String toString() {
        return "BusinessPassenger{" +
                " type='" + "BusinessPassenger" + '\'' +
                ", Id='" +super.getPassengerId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", surname='" + super.getSurname() + '\'' +
                ", luggageCount='" + super.getLuggageCount() + '\'' +
                ", dateOfBirth='" + super.getDateOfBirth() + '\'' +
                '}';
    }
}
