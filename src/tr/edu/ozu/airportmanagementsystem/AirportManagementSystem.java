package tr.edu.ozu.airportmanagementsystem;
public class AirportManagementSystem {
    public void runAirportManagementSystem(){
        View view = new View("Airport Management System");
        Model model = new Model();
        Controller controller = new Controller(view, model);
    }
}
