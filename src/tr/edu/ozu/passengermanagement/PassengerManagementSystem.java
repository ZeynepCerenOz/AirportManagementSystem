package tr.edu.ozu.passengermanagement;

public interface PassengerManagementSystem {
   double getDiscountRate();
   void setDiscountRate(double discountRate);
    String getName();
    void setName(String name);
    String getSurname();
    void setSurname(String surname);

   int getLuggageCount();
   void setLuggageCount(int luggageCount);
    String getDateOfBirth();
   void setDateOfBirth(String dateOfBirth);
    int getPassengerId();
    void setPassengerId(int passengerId);

}
