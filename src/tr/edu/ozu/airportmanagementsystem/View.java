package tr.edu.ozu.airportmanagementsystem;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
// View class for Passenger Management System
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import tr.edu.ozu.planemanagement.*;
import tr.edu.ozu.flightmanagement.*;
import tr.edu.ozu.passengermanagement.*;




public class View extends JFrame {
    // Fields for UI components for Passenger
    private JTextField nameField;
    private JTextField surnameField;
    private JComboBox<String> passengerTypeBox;
    private JTextField luggageCountField;
    //private JTextField dateOfBirthField;
    private JFormattedTextField dateOfBirthField;
    private JButton addPassengerButton;
    private JButton removePassengerButton;
    private JButton updatePassengerButton;
    private JList<AirportPassenger> passengerList;
    private DefaultListModel<AirportPassenger> passengerListModel;
    //Fields for UI components for plane
    private JList<Hangar> hangarList;
    private DefaultListModel<Hangar> hangarListModel;
    private JButton addHangarButton;
    private JButton removeHangarButton;
    private JButton reserveHangarButton;
    private JButton resetHangarButton;
    private JList<Runway> runwayList;
    private DefaultListModel<Runway> runwayListModel;
    private JButton addRunwayButton;
    private JButton removeRunwayButton;
    private JButton reserveRunwayButton;
    private JButton resetRunwayButton;
    private JList<Plane> planeList;
    private DefaultListModel<Plane> planeListModel;
    private JTextField planeCodeField;
    private JTextField capacityField;
    private JButton addPlaneButton;
    private JButton removePlaneButton;
    private JList<Airport> airportList;
    private DefaultListModel<Airport> airportListModel;
    private JTextField airportCodeField;
    private JButton addAirportButton;
    private JButton removeAirportButton;
    //
    private JTextField departureAirportField;
    private JTextField landingAirportField;
    private JFormattedTextField departureDateField;
    private JFormattedTextField returnDateField;
    private JTextField flightPlaneCodeField;
    private JTextField ceilingPriceField;

    private JButton addFlightButton;
    private JButton removeFlightButton;

    private JList<Flight> flightList;
    private DefaultListModel<Flight> flightViewListModel;

    private JTextField soldToPassengerIdField;
    private JTextField discountPriceField ;
    private JButton buyTicketButton;
    private JButton cancelTicketButton;

    private JList<Ticket> ticketList;
    private DefaultListModel<Ticket> ticketViewListModel;


    public View(String title) {
        super(title);
        setTitle("Airport Management Systems");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 1300);

        //PASSENGER CONSTRUCTOR
        nameField = new JTextField(10);
        surnameField = new JTextField(10);
        passengerTypeBox = new JComboBox<>(new String[]{"Business", "Economy", "Family"});
        luggageCountField = new JTextField(10);
        SimpleDateFormat dateOfBirthFieldFormatter = new SimpleDateFormat("dd/MM/yyyy");
        dateOfBirthField = new JFormattedTextField(dateOfBirthFieldFormatter);
        dateOfBirthField.setColumns(10);
        dateOfBirthField.setValue(new Date());


        //dateOfBirthField=new JTextField(10);

        addPassengerButton = new JButton("Add");
        removePassengerButton = new JButton("Remove");
        updatePassengerButton = new JButton("Update");
        passengerListModel = new DefaultListModel<>();
        passengerList = new JList<>(passengerListModel);
        passengerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Create panels for layout
        JPanel passengerInputPanel = new JPanel();
        JPanel passengerButtonPanel = new JPanel();
        JPanel passengerListPanel = new JPanel();

        // Add components to panels
        passengerInputPanel.add(new JLabel("Name:"));
        passengerInputPanel.add(nameField);
        passengerInputPanel.add(new JLabel("Surname:"));
        passengerInputPanel.add(surnameField);
        passengerInputPanel.add(new JLabel("Passenger Type:"));
        passengerInputPanel.add(passengerTypeBox);
        passengerInputPanel.add(new JLabel("Luggage Count:"));
        passengerInputPanel.add(luggageCountField);
        passengerInputPanel.add(new JLabel("Date Of Birth:"));
        passengerInputPanel.add(dateOfBirthField);
        passengerButtonPanel.add(addPassengerButton);
        passengerButtonPanel.add(removePassengerButton);
        passengerButtonPanel.add(updatePassengerButton);
        passengerListPanel.add(new JScrollPane(passengerList));


        JPanel passengerMainPanel=new JPanel();
        passengerMainPanel.add(passengerInputPanel,BorderLayout.NORTH);
        passengerMainPanel.add(passengerButtonPanel,BorderLayout.CENTER);
        passengerMainPanel.add(passengerListPanel,BorderLayout.SOUTH);

        //PLANE CONSTRUCTOR
        hangarListModel=new DefaultListModel<>();
        hangarList=new JList<>(hangarListModel);
        addHangarButton=new JButton("Add Hangar");
        removeHangarButton=new JButton("Remove Hangar");
        reserveHangarButton=new JButton("Reserve Hangar");
        resetHangarButton=new JButton("Reset Hangar");
        runwayListModel=new DefaultListModel<>();
        runwayList=new JList<>(runwayListModel);
        addRunwayButton=new JButton("Add Runway");
        removeRunwayButton=new JButton("Remove Runway");
        reserveRunwayButton=new JButton("Reserve Runway");
        resetRunwayButton=new JButton("Reset Runway");
        planeCodeField=new JTextField(10);
        capacityField=new JTextField(10);
        addPlaneButton=new JButton("Add Plane");
        removePlaneButton=new JButton("Remove Plane");
        planeListModel=new DefaultListModel<>();
        planeList=new JList<>(planeListModel);
        airportCodeField=new JTextField(10);
        airportListModel=new DefaultListModel<>();
        airportList=new JList<>(airportListModel);
        addAirportButton=new JButton("Add Airport");
        removeAirportButton=new JButton("Remove Airport");


        JPanel planeInputPanel = new JPanel();
        JPanel planeButtonPanel = new JPanel();
        JPanel planeListPanel = new JPanel();

        planeInputPanel.add(new JLabel("Hangar"));
        planeButtonPanel.add(addHangarButton);
        planeButtonPanel.add(removeHangarButton);
        planeButtonPanel.add(reserveHangarButton);
        planeButtonPanel.add(resetHangarButton);
        planeListPanel.add(new JScrollPane(hangarList));
        planeInputPanel.add(new JLabel("Runway"));
        planeButtonPanel.add(addRunwayButton);
        planeButtonPanel.add(removeRunwayButton);
        planeButtonPanel.add(reserveRunwayButton);
        planeButtonPanel.add(resetRunwayButton);
        planeListPanel.add(new JScrollPane(runwayList));
        planeInputPanel.add(new JLabel("Plane"));
        planeInputPanel.add(new JLabel("Plane Code"));
        planeInputPanel.add(planeCodeField);
        planeInputPanel.add(new JLabel("Capacity"));
        planeInputPanel.add(capacityField);
        planeButtonPanel.add(addPlaneButton);
        planeButtonPanel.add(removePlaneButton);
        planeListPanel.add(new JScrollPane(planeList));
        planeInputPanel.add(new JLabel("Airport"));
        planeInputPanel.add(new JLabel("Airport Code"));
        planeInputPanel.add(airportCodeField);
        planeListPanel.add(new JScrollPane(airportList));
        planeButtonPanel.add(addAirportButton);
        planeButtonPanel.add(removeAirportButton);

        JPanel planeMainPanel=new JPanel();
        planeMainPanel.add(planeInputPanel,BorderLayout.NORTH);
        planeMainPanel.add(planeButtonPanel,BorderLayout.CENTER);
        planeMainPanel.add(planeListPanel,BorderLayout.SOUTH);

        //FLIGHT CONSTRUCTOR

        departureAirportField = new JTextField(10);
        landingAirportField = new JTextField(10);

        SimpleDateFormat departureDateFieldFormatter = new SimpleDateFormat("dd/MM/yyyy");
        departureDateField = new JFormattedTextField(departureDateFieldFormatter);
        departureDateField.setColumns(10);
        departureDateField.setValue(new Date());

        SimpleDateFormat returnDateFieldFormatter = new SimpleDateFormat("dd/MM/yyyy");
        returnDateField = new JFormattedTextField(returnDateFieldFormatter);
        returnDateField.setColumns(10);
        returnDateField.setValue(new Date());


        flightPlaneCodeField=new JTextField(10);
        ceilingPriceField=new JTextField(10);

        addFlightButton = new JButton("Add Flight");
        removeFlightButton = new JButton("Remove Flight");

        flightViewListModel = new DefaultListModel<>();
        flightList = new JList<>(flightViewListModel);
        flightList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        flightList.setPreferredSize(new Dimension(800, 200));

        // Create panels for Flight
        JPanel generateFlightPanel1 = new JPanel();
        JPanel generateFlightPanel2 = new JPanel();
        JPanel generateFlightbuttonPanel = new JPanel();
        JPanel generateFlightlistPanel = new JPanel();

        // Add components to panels
        generateFlightPanel1.add(new JLabel("Departure Airport:"));
        generateFlightPanel1.add(departureAirportField);
        generateFlightPanel1.add(new JLabel("Landing Airport:"));
        generateFlightPanel1.add(landingAirportField);
        generateFlightPanel1.add(new JLabel("Departure Date:"));
        generateFlightPanel1.add(departureDateField);
        generateFlightPanel2.add(new JLabel("Return Date:"));
        generateFlightPanel2.add(returnDateField);
        generateFlightPanel2.add(new JLabel("Plane Code:"));
        generateFlightPanel2.add(flightPlaneCodeField);
        generateFlightPanel2.add(new JLabel("Ceiling Price:"));
        generateFlightPanel2.add(ceilingPriceField);

        generateFlightbuttonPanel.add(addFlightButton);
        generateFlightbuttonPanel.add(removeFlightButton);
        generateFlightlistPanel.add(new JScrollPane(flightList));


        soldToPassengerIdField = new JTextField(10);
        discountPriceField = new JTextField(10);
        // discountPriceField.setEnabled(false);

        buyTicketButton = new JButton("Buy Ticket");
        cancelTicketButton = new JButton("Cancel Ticket");

        ticketViewListModel = new DefaultListModel<>();
        ticketList = new JList<>(ticketViewListModel);
        ticketList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ticketList.setPreferredSize(new Dimension(800, 200));


        // Create panels for Ticket
        JPanel manageTicketsPanel = new JPanel();
        JPanel manageTicketsbuttonPanel = new JPanel();
        JPanel manageTicketslistPanel = new JPanel();


        // Add components to panels
        manageTicketsPanel.add(new JLabel("Passenger Id:"));
        manageTicketsPanel.add(soldToPassengerIdField);
        manageTicketsPanel.add(new JLabel("Ticket Price:"));
        manageTicketsPanel.add(discountPriceField);

        manageTicketsbuttonPanel.add(buyTicketButton);
        manageTicketsbuttonPanel.add(cancelTicketButton);
        manageTicketslistPanel.add(new JScrollPane(ticketList));

/*
        generateFlightlistPanel.setBounds(10,10,800,200);
              generateFlightPanel1.setBounds(10,200,800,200);
        generateFlightPanel2.setBounds(10,400,800,200);
        generateFlightbuttonPanel.setBounds(10,600,800,200);

        manageTicketslistPanel.setBounds(810,10,800,200);
        manageTicketsPanel.setBounds(810,200,800,200);
        manageTicketsbuttonPanel.setBounds(810,400,800,200);

 */

        /*Border br = BorderFactory.createLineBorder(Color.black);
        generateFlightlistPanel.setBorder(br);
        generateFlightPanel1.setBorder(br);
        generateFlightPanel2.setBorder(br);
        generateFlightbuttonPanel.setBorder(br);
        manageTicketslistPanel.setBorder(br);
        manageTicketsPanel.setBorder(br);
        manageTicketsbuttonPanel.setBorder(br);*/

        JPanel flightMainPanel=new JPanel();
        flightMainPanel.add(generateFlightlistPanel);
        flightMainPanel.add(generateFlightPanel1);
        flightMainPanel.add(generateFlightPanel2);
        flightMainPanel.add(generateFlightbuttonPanel);
        flightMainPanel.add(manageTicketslistPanel);
        flightMainPanel.add(manageTicketsPanel);
        flightMainPanel.add(manageTicketsbuttonPanel);

        JTabbedPane tabbedPane = new JTabbedPane();


      tabbedPane.addTab("Passenger Management System", passengerMainPanel);
        tabbedPane.addTab("Plane Management System", planeMainPanel);
        tabbedPane.addTab("Flight Management System", flightMainPanel);

        getContentPane().add(tabbedPane, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    //PASSENGER SETTER/GETTER

    // Getter methods for UI components
    public JTextField getNameField() {
        return nameField;
    }
    public JTextField getSurnameField() {
        return surnameField;
    }
    public JTextField getLuggageCountField(){return luggageCountField; }
    public JComboBox<String>  getPassengerTypeBox() {
        return passengerTypeBox;
    }
    public JFormattedTextField getDateOfBirthField(){ return dateOfBirthField; }

    public JButton getAddPassengerButton() {
        return addPassengerButton;
    }

    public JButton getRemovePassengerButton() {
        return removePassengerButton;
    }

    public JButton getUpdatePassengerButton() {
        return updatePassengerButton;
    }

    public JList<AirportPassenger> getPassengerList() {
        return passengerList;
    }

    public DefaultListModel<AirportPassenger> getPassengerListModel() {//getPassengerListModel
        return passengerListModel;
    }

    // Method to display error message
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    //PLANE SETTER/GETTER
    public JList<Hangar> getHangarList(){
        return hangarList;
    }
    public DefaultListModel<Hangar> getHangarListModel(){
        return hangarListModel;
    }
    public JButton getAddHangarButton(){
        return addHangarButton;
    }
    public JButton getRemoveHangarButton(){
        return removeHangarButton;
    }
    public JButton getReserveHangarButton(){
        return reserveHangarButton;
    }
    public JButton getResetHangarButton(){
        return resetHangarButton;
    }


    public JList<Runway> getRunwayList(){
        return runwayList;
    }
    public DefaultListModel<Runway> getRunwayListModel(){
        return runwayListModel;
    }
    public JButton getAddRunwayButton(){
        return addRunwayButton;
    }
    public JButton getRemoveRunwayButton(){
        return removeRunwayButton;
    }
    public JButton getReserveRunwayButton(){
        return reserveRunwayButton;
    }
    public JButton getResetRunwayButton(){
        return resetRunwayButton;
    }


    public JList<Plane> getPlaneList(){
        return planeList;
    }
    public DefaultListModel<Plane> getPlaneListModel(){
        return planeListModel;
    }
    public JTextField getPlaneCodeField(){
        return planeCodeField;
    }
    public JTextField getCapacityField(){
        return capacityField;
    }
    public JButton getAddPlaneButton(){
        return addPlaneButton;
    }
    public JButton getRemovePlaneButton(){
        return removePlaneButton;
    }

    public JList<Airport> getAirportList(){
        return airportList;
    }
    public DefaultListModel<Airport> getAirportListModel(){
        return airportListModel;
    }
    public JTextField getAirportCodeField(){
        return airportCodeField;
    }

    public JButton getAddAirportButton(){
        return addAirportButton;
    }
    public JButton getRemoveAirportButton(){
        return removeAirportButton;
    }

//FLIGHT GETTER/SETTER
public JTextField getDepartureAirportField() {
    return departureAirportField;
}
    public JTextField getLandingAirportField() {
        return landingAirportField;
    }
    public JFormattedTextField getReturnDateField(){return returnDateField; }
    public JFormattedTextField getDepartureDateField() {
        return departureDateField;
    }
    public JTextField getFlightPlaneCodeField(){ return flightPlaneCodeField; }
    public JTextField getCeilingPriceField(){ return ceilingPriceField; }
    public JButton getAddFlightButton() {
        return addFlightButton;
    }

    public JButton getFlightRemoveButton() {
        return removeFlightButton;
    }

    public JList<Flight> getFlightList() {
        return flightList;
    }

    public DefaultListModel<Flight> getFlightViewListModel() {//getFlightListModel
        return flightViewListModel;
    }

    public JTextField getSoldToPassengerIdField() {
        return soldToPassengerIdField;
    }
    public JTextField getDiscountPriceField() {
        return discountPriceField;
    }

    public JButton getBuyTicketButton() {
        return buyTicketButton;
    }

    public JButton getCancelTicketButton() {
        return cancelTicketButton;
    }

    public JList<Ticket> getTicketList() {
        return ticketList;
    }

    public DefaultListModel<Ticket> getTicketViewListModel() {//getFlightListModel
        return ticketViewListModel;
    }


}
