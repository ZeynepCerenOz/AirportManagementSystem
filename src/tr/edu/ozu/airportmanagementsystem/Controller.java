package tr.edu.ozu.airportmanagementsystem;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import tr.edu.ozu.planemanagement.*;
import tr.edu.ozu.flightmanagement.*;
import tr.edu.ozu.passengermanagement.*;


import static java.util.Objects.nonNull;

public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        //passenger listeners
        view.getAddPassengerButton().addActionListener(new Controller.AddPassengerButtonListener());
        view.getRemovePassengerButton().addActionListener(new Controller.RemovePassengerButtonListener());
        view.getUpdatePassengerButton().addActionListener(new Controller.UpdatePassengerButtonListener());
        view.getPassengerList().addListSelectionListener(new Controller.PassengerListSelectionHandler());

        //plane listeners

        view.getAddHangarButton().addActionListener(new Controller.AddHangarButtonListener());
        view.getRemoveHangarButton().addActionListener(new Controller.RemoveHangarButtonListener());
        view.getReserveHangarButton().addActionListener(new Controller.ReserveHangarButtonListener());
        view.getResetHangarButton().addActionListener(new Controller.ResetHangarButtonListener());

        view.getAddRunwayButton().addActionListener(new Controller.AddRunwayButtonListener());
        view.getRemoveRunwayButton().addActionListener(new Controller.RemoveRunwayButtonListener());
        view.getReserveRunwayButton().addActionListener(new Controller.ReserveRunwayButtonListener());
        view.getResetRunwayButton().addActionListener(new Controller.ResetRunwayButtonListener());

        view.getPlaneList().addListSelectionListener(new Controller.PlaneListSelectionHandler());
        view.getAddPlaneButton().addActionListener(new Controller.AddPlaneButtonListener());
        view.getRemovePlaneButton().addActionListener(new Controller.RemovePlaneButtonListener());

        view.getAirportList().addListSelectionListener(new Controller.AirportListSelectionHandler());
        view.getAddAirportButton().addActionListener(new Controller.AddAirportButtonListener());
        view.getRemoveAirportButton().addActionListener(new Controller.RemoveAirportButtonListener());

        //flight listeners
        view.getAddFlightButton().addActionListener(new AddFlightButtonListener());
        view.getFlightRemoveButton().addActionListener(new RemoveFlightButtonListener());
        view.getFlightList().addListSelectionListener(new FlightListSelectionHandler());

        view.getBuyTicketButton().addActionListener(new BuyTicketButtonListener());
        view.getCancelTicketButton().addActionListener(new CancelTicketButtonListener());
        view.getTicketList().addListSelectionListener(new TicketListSelectionHandler());

        //view.getSoldToPassengerIdField().addKeyListener(new FlightPassengerIdEnteredListener());
        //view.getNameField().getDocument().addDocumentListener(new NameDocumentListener());


        view.getLuggageCountField().addKeyListener(new LuggageCountKeyListener());
        view.getCapacityField().addKeyListener(new CapacityKeyListener());
        view.getNameField().addKeyListener(new NameKeyListener());
        view.getSurnameField().addKeyListener(new SurnameKeyListener());
        view.getAirportCodeField().addKeyListener(new AirportCodeKeyListener());
        view.getDepartureAirportField().addKeyListener(new DepartureAirportKeyListener());
        view.getLandingAirportField().addKeyListener(new LandingAirportKeyListener());

        view.getSoldToPassengerIdField().getDocument().addDocumentListener(new SoldToPassengerIdDocumentListener());
        view.getDepartureAirportField().addFocusListener(new DepartureAirportFocusListener());
        view.getLandingAirportField().addFocusListener(new LandingAirportFocusListener());
        view.getFlightPlaneCodeField().addFocusListener(new FlightPlaneCodeFocusListener());




    }
    //passenger methods and listeners

    public class  NameKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (Character.isDigit(c)) {
                //remove the character if it is not a digit
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public class  SurnameKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (Character.isDigit(c)) {
                //remove the character if it is not a digit
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public class LuggageCountKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!Character.isDigit(c)) {
                //remove the character if it is not a digit
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public class PassengerListSelectionHandler implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting())
            {
                int[] indices=view.getPassengerList().getSelectedIndices();
                if(indices.length==1) {
                    String name = view.getPassengerListModel().get(indices[0]).getName();
                    view.getNameField().setText(name);
                    String surname = view.getPassengerListModel().get(indices[0]).getSurname();
                    view.getSurnameField().setText(surname);
                    String passengerType = view.getPassengerListModel().get(indices[0]).getClass().getName().replace("Passenger","");
                    view.getPassengerTypeBox().setSelectedItem(passengerType);
                    int luggageCount = view.getPassengerListModel().get(indices[0]).getLuggageCount();
                    view.getLuggageCountField().setText(Integer.toString(luggageCount));
                    String dateOfBirth= view.getPassengerListModel().get(indices[0]).getDateOfBirth();
                    view.getDateOfBirthField().setText(dateOfBirth);
                }
                else{
                    view.showError("Please select only one row for passenger.");
                }

            }
        }
    }
    // Inner class for add button listener
    private class AddPassengerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the input from the text fields
            String name = view.getNameField().getText();
            String surname = view.getSurnameField().getText();
            String luggageCount= view.getLuggageCountField().getText();
            String passengerType = (String) view.getPassengerTypeBox().getSelectedItem();
            String dateOfBirth = view.getDateOfBirthField().getText();

            // Validate the input
            if (name.isEmpty() || surname.isEmpty()|| luggageCount.isEmpty()|| dateOfBirth.isEmpty()) {
                // Show error message if input is empty
                view.showError("Please enter name, surname, luggage count and date of birth.");
            } else {
                // Create a new passenger object
                AirportPassenger passenger = new AirportPassenger(name, surname,Integer.parseInt(luggageCount),dateOfBirth, model.getCurrentPassengerId());
                // Add the passenger to the model
                passenger=model.addPassenger(passenger,passengerType);
                // Add the passenger to the list
                view.getPassengerListModel().addElement(passenger);
                // Clear the text fields
                view.getNameField().setText("");
                view.getSurnameField().setText("");
                view.getLuggageCountField().setText("");
                view.getPassengerTypeBox().setSelectedIndex(0);
                view.getDateOfBirthField().setText("");
                view.getDateOfBirthField().setValue(new Date());
            }
        }
    }

    // Inner class for remove button listener
    private class RemovePassengerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the selected index from the list
            int index = view.getPassengerList().getSelectedIndex();

            // Validate the index
            if (index == -1) {
                // Show error message if no passenger is selected
                view.showError("Please select a passenger to remove.");
            } else {
                // Remove the passenger from the model
                model.removePassenger(index);
                // Remove the passenger from the list
                view.getPassengerListModel().removeElementAt(index);
                view.getNameField().setText("");
                view.getSurnameField().setText("");
                view.getLuggageCountField().setText("");
                view.getPassengerTypeBox().setSelectedIndex(0);
                view.getDateOfBirthField().setValue(new Date());


            }
        }
    }

    // Inner class for update button listener
    private class UpdatePassengerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the selected index from the list
            int index = view.getPassengerList().getSelectedIndex();

            // Validate the index
            if (index == -1) {
                // Show error message if no passenger is selected
                view.showError("Please select a passenger to update.");
            } else {
                // Get the input from the text fields
                String newName = view.getNameField().getText();
                String newSurname = view.getSurnameField().getText();
                String newPassengerType=(String) view.getPassengerTypeBox().getSelectedItem();
                String newLuggageCount= view.getLuggageCountField().getText();
                String newDateOfBirth= view.getDateOfBirthField().getText();
                // Validate the input
                if (newName.isEmpty() || newSurname.isEmpty()) {
                    // Show error message if input is empty
                    view.showError("Please enter name and surname.");
                } else if(!Arrays.asList("Business","Economy","Family").contains(newPassengerType)) {
                    view.showError("Please enter correct type.");
                }else if(newLuggageCount.isEmpty()) {
                    view.showError("Please enter luggage count.");
                }
                else if(newDateOfBirth.isEmpty()) {
                    view.showError("Please enter date of birth");
                }
                else{
                    // Get the selected passenger from the model
                    AirportPassenger passenger = model.getPassenger(index);
                    // Update the passenger details
                    passenger.setName(newName);
                    passenger.setSurname(newSurname);
                    passenger.setLuggageCount(Integer.parseInt(newLuggageCount));
                    passenger.setDateOfBirth(newDateOfBirth);
                    passenger=model.updatePassenger(index,passenger,newPassengerType);

                    // Update the list display
                    view.getPassengerListModel().setElementAt(passenger, index);
                    // Clear the text fields

                }
            }
        }
    }
    //plane methods and listeners


    public class CapacityKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!Character.isDigit(c)) {
                //remove the character if it is not a digit
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private class AirportListSelectionHandler implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent e){
            int[] indices=view.getAirportList().getSelectedIndices();
            if(indices.length==1){
                String AirportCode = view.getAirportListModel().get(indices[0]).getAirportCode();
                view.getAirportCodeField().setText(AirportCode);

            }

        }
    }


    public class   AirportCodeKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (Character.isDigit(c)) {
                //remove the character if it is not a digit
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public class   DepartureAirportKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (Character.isDigit(c)) {
                //remove the character if it is not a digit
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public class   LandingAirportKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (Character.isDigit(c)) {
                //remove the character if it is not a digit
                e.consume();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
    private class AddAirportButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String airportCode=view.getAirportCodeField().getText();
            if (airportCode.isEmpty()){
                view.showError("Please enter airport code.");
            }
            else {
                Airport airport = new Airport(model.getCurrentAirportId(),airportCode);
                model.addAirport(airport);
                view.getAirportListModel().addElement(airport);
                view.getAirportCodeField().setText("");
            }
        }
    }
    private class RemoveAirportButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int index=view.getAirportList().getSelectedIndex();

            if(index==-1){
                view.showError("Please select an airport to remove.");
            }
            else{
                model.removeAirport(index);
                view.getAirportListModel().removeElementAt(index);
                view.getAirportCodeField().setText("");
            }
        }
    }



    private class AddHangarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = view.getAirportList().getSelectedIndex();

            if (index == -1) {
                // Show error message if no passenger is selected
                view.showError("Please select a airport for hangar.");
            } else {
                Airport airport = model.getAirport(index);
                Hangar hangar = new Hangar(model.getCurrentHangarId(),airport.getAirportCode());
                model.addHangar(hangar);
                view.getHangarListModel().addElement(hangar);

            }

        }
    }

    private class RemoveHangarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = view.getHangarList().getSelectedIndex();

            if (index == -1) {
                // Show error message if no passenger is selected
                view.showError("Please select a hangar to remove.");
            } else {
                // Remove the passenger from the model
                model.removeHangar(index);
                // Remove the passenger from the list
                view.getHangarListModel().removeElementAt(index);
                view.getHangarList().clearSelection();


            }
        }
    }
    private class ReserveHangarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            int indexHangar=view.getHangarList().getSelectedIndex();
            int indexPlane=view.getPlaneList().getSelectedIndex();

            if(indexHangar==-1){
                view.showError("Please select a hangar to reserve");
                return;
            }
            if(indexPlane==-1){
                view.showError("Please select a plane to reserve hangar");
                return;
            }

                Hangar hangar = model.getHangar(indexHangar);
                Plane plane=model.getPlane(indexPlane);
                hangar.setReservedByPlaneCode(plane.getPlaneCode());
                model.reserveHangar(indexHangar,hangar);
                view.getHangarListModel().setElementAt(hangar, indexHangar);
                view.getHangarList().clearSelection();


        }
    }

    private class ResetHangarButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int indexHangar=view.getHangarList().getSelectedIndex();
            if(indexHangar==-1){
                view.showError("Please select a hangar to reset");
            }else{
                Hangar hangar = model.getHangar(indexHangar);
                hangar.setReservedByPlaneCode("Empty");
                view.getHangarListModel().setElementAt(hangar,indexHangar);
                view.getHangarList().clearSelection();
            }
        }
    }
    private class AddRunwayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index=view.getAirportList().getSelectedIndex();
            if(index==-1){
                view.showError("Please select an airport.");
            }
            else{
                Airport airport=model.getAirport(index);
                Runway runway = new Runway(model.getCurrentRunwayId(),airport.getAirportCode());
                model.addRunway(runway);
                view.getRunwayListModel().addElement(runway);
            }
        }

    }

    private class RemoveRunwayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = view.getRunwayList().getSelectedIndex();

            if (index == -1) {
                // Show error message if no passenger is selected
                view.showError("Please select a runway to remove.");
            } else {
                // Remove the passenger from the model
                model.removeRunway(index);
                // Remove the passenger from the list
                view.getRunwayListModel().removeElementAt(index);

            }
        }
    }
    private class ReserveRunwayButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            int indexRunway=view.getRunwayList().getSelectedIndex();
            int indexPlane=view.getPlaneList().getSelectedIndex();

            if(indexRunway==-1){
                view.showError("Please select a runway to reserve");
                return;
            }
            if(indexPlane==-1){
                view.showError("Please select a plane to reserve runway");
                return;
            }


                Runway runway = model.getRunway(indexRunway);
                Plane plane=model.getPlane(indexPlane);
                runway.setReservedByPlaneCode(plane.getPlaneCode());
                model.reserveRunway(indexRunway,runway);
                view.getRunwayListModel().setElementAt(runway, indexRunway);
                view.getRunwayList().clearSelection();

        }
    }

    private class ResetRunwayButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int indexRunway=view.getRunwayList().getSelectedIndex();
            if(indexRunway==-1){
                view.showError("Please select a runway to reset");
            }else{
                Runway runway = model.getRunway(indexRunway);
                runway.setReservedByPlaneCode("Empty");
                view.getRunwayListModel().setElementAt(runway,indexRunway);
                view.getRunwayList().clearSelection();
            }
        }
    }
    public class FlightPlaneCodeFocusListener implements FocusListener {
        public void focusGained(FocusEvent e) {
            // This method is triggered when the text field gains focus
        }

        public void focusLost(FocusEvent e) {
            // This method is triggered when the text field loses focus
            warn();
        }
        //İSTEDİĞİN KONTROLÜ YAP BURADA
        public void warn() {
            //burada istediğin kontrolü  yap
            String flightPlaneCode= view.getFlightPlaneCodeField().getText();
            if(flightPlaneCode.equals("")==true){
                return;
            }

            Plane plane=model.getPlaneByFlightPlaneCode(flightPlaneCode);
            if (!nonNull(plane)) {
                view.showError("Plane code code not found.");
                view.getFlightPlaneCodeField().setText("");
                view.getFlightPlaneCodeField().requestFocus();
            }


        }
    }

    private class PlaneListSelectionHandler implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent e){
            if (e.getValueIsAdjusting()){
                int[] indices=view.getPlaneList().getSelectedIndices();
                if(indices.length==1){
                    String planeCode = view.getPlaneListModel().get(indices[0]).getPlaneCode();
                    view.getPlaneCodeField().setText(planeCode);
                    String capacity = view.getPlaneListModel().get(indices[0]).getCapacity();
                    view.getCapacityField().setText(capacity);
                }
                else{
                    view.showError("Please select only one row for plane.");
                }
            }

        }
    }

    private class AddPlaneButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String planeCode=view.getPlaneCodeField().getText();
            String capacity=view.getCapacityField().getText();
            if(planeCode.isEmpty()){
                view.showError("Please enter plane code.");
            }
            if(capacity.isEmpty()){
                view.showError("Please enter capacity.");
            }
            else{
                Plane plane=new Plane(planeCode,capacity);
                model.addPlane(plane);
                view.getPlaneListModel().addElement(plane);
                view.getPlaneCodeField().setText("");
                view.getCapacityField().setText("");
            }
        }
    }
    private class RemovePlaneButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int index=view.getPlaneList().getSelectedIndex();

            if(index==-1){
                view.showError("Please select a plane to remove.");
            }
            else{
                model.removePlane(index);
                view.getPlaneListModel().removeElementAt(index);
                view.getPlaneCodeField().setText("");
                view.getCapacityField().setText("");
            }
        }
    }

    //flight methods and listeners

    public class DepartureAirportFocusListener implements FocusListener {
        public void focusGained(FocusEvent e) {
            // This method is triggered when the text field gains focus
        }

        public void focusLost(FocusEvent e) {
            // This method is triggered when the text field loses focus
            warn();
        }
        //İSTEDİĞİN KONTROLÜ YAP BURADA
        public void warn() {
            //burada istediğin kontrolü  yap
           String airportCode= view.getDepartureAirportField().getText();
            if(airportCode.equals("")==true){
                return;
            }
           Airport airport=model.getAirportByAirportCode(airportCode);
            if (!nonNull(airport)) {
                view.showError("Departure airport code not found.");
                view.getDepartureAirportField().requestFocus();
            }
            if(view.getDepartureAirportField().getText().equals(view.getLandingAirportField().getText())==true){
                view.showError("landing airport code and departure airport can't be same.");
                view.getDepartureAirportField().setText("");
                view.getDepartureAirportField().requestFocus();

            }


        }
    }
    public class LandingAirportFocusListener implements FocusListener {
        public void focusGained(FocusEvent e) {
            // This method is triggered when the text field gains focus
        }

        public void focusLost(FocusEvent e) {
            // This method is triggered when the text field loses focus
            warn();
        }

        //İSTEDİĞİN KONTROLÜ YAP BURADA
        public void warn() {

            //burada istediğin kontrolü  yap
            String airportCode= view.getLandingAirportField().getText();
            if(airportCode.equals("")==true){
                return;
            }
            Airport airport=model.getAirportByAirportCode(airportCode);
            if (!nonNull(airport)) {
                view.showError("Landing airport code not found.");
                view.getLandingAirportField().requestFocus();
            }
            if(view.getDepartureAirportField().getText().equals(view.getLandingAirportField().getText())==true){
                view.showError("landing airport code and departure airport can't be same.");
                view.getLandingAirportField().setText("");
                view.getLandingAirportField().requestFocus();
            }

        }
    }

    public class FlightListSelectionHandler implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting())
            {
                int[] indices=view.getFlightList().getSelectedIndices();
                Flight flight1;
                Flight flight2;

                if(indices.length==1)
                {
                    Flight flight =view.getFlightViewListModel().get(indices[0]);

                    if(flight.getFlightId()<flight.getPeerFlightId()){
                        flight1 =view.getFlightViewListModel().get(indices[0]);
                        flight2 =view.getFlightViewListModel().get(indices[0]+1);
                    }
                    else
                    {
                        flight2 =view.getFlightViewListModel().get(indices[0]);
                        flight1 =view.getFlightViewListModel().get(indices[0]-1);
                    }

                    String departureAirport = flight1.getDepartureAirport();
                    view.getDepartureAirportField().setText(departureAirport);
                    String landingAirport =  flight1.getLandingAirport();
                    view.getLandingAirportField().setText(landingAirport);
                    String departureDate = flight1.getFlightDate();
                    view.getDepartureDateField().setText(departureDate);
                    String returnDate = flight2.getFlightDate();
                    view.getReturnDateField().setText(returnDate);

                    String planeCode= flight1.getPlaneCode();
                    view.getFlightPlaneCodeField().setText(planeCode);
                    Double ceilingPrice= flight1.getCeilingPrice();
                    view.getCeilingPriceField().setText(String.valueOf(ceilingPrice));

                    //Flight flight = model.getFlight(indices[0]);
                    ArrayList<Ticket> tickets= flight.getTicketsToBeSold();
                    view.getTicketViewListModel().addAll(tickets);
                }
                else{
                    view.showError("Please select only one row for flight.");
                }

            }
        }
    }
    // Inner class for add button listener



    public class SoldToPassengerIdDocumentListener implements DocumentListener {
        @Override
        public void changedUpdate(DocumentEvent e) {
            warn();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            warn();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            warn();
        }


        public static boolean isInteger(String str) {
            try {
                Integer.parseInt(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        public void warn() {

            if( !isInteger(view.getSoldToPassengerIdField().getText()))
            {
                return;
            }

            int[] indicesFlight=view.getFlightList().getSelectedIndices();
            if(indicesFlight.length==1) {
                Flight flight = model.getFlight(indicesFlight[0]);

                int passengerId = Integer.parseInt(view.getSoldToPassengerIdField().getText());
                AirportPassenger passenger = model.getPassengerById(passengerId);
                if (nonNull(passenger)) {
                    view.getDiscountPriceField().setText(String.valueOf(((100-passenger.getDiscountRate())/100 )*flight.getCeilingPrice()));


                } else {
                    view.getDiscountPriceField().setText(String.valueOf( flight.getCeilingPrice()));
                }
            }
            else{
                view.showError("Please select a flight.");
            }

        }
    }

    private class AddFlightButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the input from the text fields
            String departureAirport = view.getDepartureAirportField().getText();
            String landingAirport = view.getLandingAirportField().getText();
            String returnDate= view.getReturnDateField().getText();
            String departureDate =  view.getDepartureDateField().getText();
            String planeCode = view.getFlightPlaneCodeField().getText();
            Double ceilingPrice = Double.valueOf(view.getCeilingPriceField().getText());

            // Validate the input
            if (departureAirport.isEmpty()) {
                // Show error message if input is empty
                view.showError("Please enter departureAirport.");
            }
            if(landingAirport.isEmpty()){
                view.showError("Please enter landing airport.");
            }
            if(departureDate.isEmpty()){
                view.showError("Please enter departure date.");
            }
            if(returnDate.isEmpty()){
                view.showError("Please enter return date.");
            }
            if (planeCode.isEmpty()){
                view.showError("Please enter plane code.");

            }



            else {
                // Create a new flight object
                Flight flight1 = new Flight(departureAirport, landingAirport,planeCode,departureDate, model.getCurrentflightId(),model.getCurrentflightId()+1,ceilingPrice,5,3);
                // Add the flight to the model
                model.addFlight(flight1);
                // Add the flight to the list
                view.getFlightViewListModel().addElement(flight1);

                Flight flight2 = new Flight(landingAirport, departureAirport,planeCode,returnDate, model.getCurrentflightId(),model.getCurrentflightId()-1,ceilingPrice,5,3);
                // Add the flight to the model
                model.addFlight(flight2);
                // Add the flight to the list
                view.getFlightViewListModel().addElement(flight2);
                // Clear the text fields
                view.getDepartureAirportField().setText("");
                view.getLandingAirportField().setText("");
                view.getFlightPlaneCodeField().setText("");
                view.getCeilingPriceField().setText("");
                view.getReturnDateField().setValue(new Date());
                view.getDepartureDateField().setValue(new Date());
            }
        }
    }

    // Inner class for remove button listener
    private class RemoveFlightButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the selected index from the list
            int index = view.getFlightList().getSelectedIndex();

            // Validate the index
            if (index == -1) {
                // Show error message if no flight is selected
                view.showError("Please select a flight to remove.");
            } else {
                // Remove the flight from the model

                Flight flight1=model.getFlight(index);
                if(flight1.getFlightId()<flight1.getPeerFlightId()){

                    model.removeFlight(index+1);
                    // Remove the flight from the list
                    view.getFlightViewListModel().removeElementAt(index+1);
                    model.removeFlight(index);
                    // Remove the flight from the list
                    view.getFlightViewListModel().removeElementAt(index);

                }else{
                    model.removeFlight(index);
                    // Remove the flight from the list
                    view.getFlightViewListModel().removeElementAt(index);
                    model.removeFlight(index-1);
                    // Remove the flight from the list
                    view.getFlightViewListModel().removeElementAt(index-1);
                }

                view.getDepartureAirportField().setText("");
                view.getLandingAirportField().setText("");
                view.getReturnDateField().setText("");
                view.getDepartureDateField().setText("");
                view.getFlightPlaneCodeField().setText("");
                view.getCeilingPriceField().setText("");

                view.getTicketViewListModel().clear();



            }
        }
    }



    public class TicketListSelectionHandler implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting())
            {
                int[] indices=view.getTicketList().getSelectedIndices();
                if(indices.length==1) {
                    int soldToPassengerId = view.getTicketViewListModel().get(indices[0]).getSoldToPassengerId();
                    view.getSoldToPassengerIdField().setText(String.valueOf(soldToPassengerId));
                    Double discountPrice = view.getTicketViewListModel().get(indices[0]).getDiscountPrice();
                    view.getDiscountPriceField().setText(String.valueOf(discountPrice));;
                }
                else{
                    view.showError("Please select only one row for ticket.");
                }

            }
        }
    }

    // Inner class for add button listener
    private class BuyTicketButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the input from the text fields
            int soldToPassengerId = Integer.parseInt(view.getSoldToPassengerIdField().getText());

            double ceilingPrice= Double.parseDouble(view.getCeilingPriceField().getText());

            // Validate the input
            if (soldToPassengerId==0 || ceilingPrice==0) {
                // Show error message if input is empty
                view.showError("Please enter passenger ID, discount price.");
            }
            else
            {
                int[] indicesFlight=view.getFlightList().getSelectedIndices();
                if(indicesFlight.length==1) {
                    Flight flight = model.getFlight(indicesFlight[0]);
                    int indexTicket = view.getTicketList().getSelectedIndex();

                    if (indexTicket == -1) {
                        // Show error message if no ticket is selected
                        view.showError("Please select a ticket seat.");
                    } else {
                        Ticket ticket = flight.getTicketAt(indexTicket);
                        AirportPassenger passenger = model.getPassengerById(soldToPassengerId);
                        if (passenger == null) {
                            view.showError("Passenger not found.");
                            return;
                        }
                        if (flight.isThereAnyTicketAlreadySoldToPassengerId(soldToPassengerId)) {
                            view.showError("A passenger cannot buy more than one ticket for the same flight.");
                            return;
                        }
                        if (passenger.getClass().getName().equals("tr.edu.ozu.passengermanagement.BusinessPassenger") != true) {
                            if (ticket.getClass().getName().equals("tr.edu.ozu.flightmanagement.VipTicket") == true) {
                                view.showError("VIP ticket can only be purchased by business passenger.");
                                return;
                            }
                        }
                        if(passenger.getClass().getName().equals("tr.edu.ozu.passengermanagement.BusinessPassenger")==true) {
                            if (ticket.getClass().getName().equals("tr.edu.ozu.flightmanagement.VipTicket") != true) {
                                view.showError("Business passenger can only purchase VIP ticket.");
                                return;
                            }
                        }

                        ticket.setSoldToPassengerId(soldToPassengerId );
                        ticket.setTicketId(view.getTicketViewListModel().size()+1);
                        ticket.setDiscountPrice(((100-passenger.getDiscountRate())/100 )*flight.getCeilingPrice());
                       view.getFlightList().clearSelection();
                       view.getTicketList().clearSelection();
                        view.getTicketViewListModel().setElementAt(ticket,indexTicket);
                         view.getSoldToPassengerIdField().setText("");
                        view.getDiscountPriceField().setText("");
                        view.getDepartureAirportField().setText("");
                        view.getLandingAirportField().setText("");
                        view.getDepartureDateField().setText("");
                        view.getReturnDateField().setText("");
                        view.getFlightPlaneCodeField().setText("");
                    }
                }
                else{
                    view.showError("Please select one row Flight.");
                }
            }
        }
    }

    // Inner class for remove button listener
    private class CancelTicketButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int[] indicesFlight=view.getFlightList().getSelectedIndices();
            if(indicesFlight.length==1) {
                Flight flight = model.getFlight(indicesFlight[0]);
                int indexTicket = view.getTicketList().getSelectedIndex();

                if (indexTicket == -1) {
                    // Show error message if no ticket is selected
                    view.showError("Please select a ticket seat.");
                } else {
                    Ticket ticket = flight.getTicketAt(indexTicket);
                    ticket.setSoldToPassengerId( 0);
                    ticket.setDiscountPrice(0);
                    view.getTicketViewListModel().setElementAt(ticket,indexTicket);
                    view.getSoldToPassengerIdField().setText("");
                    view.getDiscountPriceField().setText("");
                }
            }
            else{
                view.showError("Please select  Flight.");
            }
        }
    }


    }


