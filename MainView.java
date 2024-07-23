import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private JButton addHotelButton;
    private JButton viewHotelButton;
    private JButton manageHotelButton;
    private JButton simulateBookingButton;
    private JButton printHotelsButton;
    private JButton exitButton;
    private JLabel lblPage;
    private JPanel centerPanel;
    private JTextField hotelNameField;
    private JTextField numRoomsField;
    private JButton submitButton;
    private JTextArea displayArea;
    private JButton viewNumberOfBookedandAvailableRooms;
    private JButton viewSpecificRoom;
    private JButton viewReservation;
    private JButton searchButton;
    private JButton changeNameButton;
    private JButton addRoomButton;
    private JButton removeRoomButton;
    private JButton changePriceButton;
    private JButton removeReservationButton;
    private JButton removeHotel;   
    private JButton addReservationButton;

    public MainView() {
        // Set up the frame
        this.setTitle("Hotel Management System");
        this.setSize(500, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);

        this.setResizable(false);

        init();
    }

    private void init() {
        // NORTH PANEL
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        northPanel.setBackground(Color.decode("#0A285F"));

        JLabel lblPokedexex = new JLabel("Hotel Reservation System");
        northPanel.add(lblPokedexex);
        lblPokedexex.setForeground(Color.WHITE);
        lblPokedexex.setFont(new Font("Arial", Font.BOLD, 24));

        lblPage = new JLabel("Page");
        lblPage.setForeground(Color.WHITE);
        lblPage.setFont(new Font("Arial", Font.BOLD, 24));
        northPanel.add(lblPage);

        this.add(northPanel, BorderLayout.NORTH);

        // WEST PANEL
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(6,1));
        westPanel.setBackground(Color.decode("#dfdfdf"));

        addHotelButton = new JButton("Add Hotel");
        westPanel.add(addHotelButton);

        viewHotelButton = new JButton("View Hotel");
        westPanel.add(viewHotelButton);

        manageHotelButton = new JButton("Manage Hotel");
        westPanel.add(manageHotelButton);

        simulateBookingButton = new JButton("Simulate Booking");
        westPanel.add(simulateBookingButton);

        printHotelsButton = new JButton("Print Hotels");
        westPanel.add(printHotelsButton);

        exitButton = new JButton("Exit");
        westPanel.add(exitButton);

        this.add(westPanel, BorderLayout.WEST);

        // CENTER PANEL
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        displayDefaultCenterPanel();

        this.add(centerPanel, BorderLayout.CENTER);
    }

    void displayDefaultCenterPanel() {
        centerPanel.removeAll();
        centerPanel.setLayout(new FlowLayout());

        ImageIcon image = new ImageIcon("assets/ourHotel.png");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setIcon(new ImageIcon(image.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
        imageLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        centerPanel.add(imageLabel);
        
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    public void showAddHotelForm() {
        centerPanel.removeAll();
        //set to a gridlayout but not thick
        centerPanel.setLayout(new FlowLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel hotelNameLabel = new JLabel("Name of Hotel:");
        hotelNameField = new JTextField(25);
        JLabel numRoomsLabel = new JLabel("Number of Rooms:");
        numRoomsField = new JTextField(25);
        submitButton = new JButton("Submit");


        centerPanel.add(hotelNameLabel);
        centerPanel.add(hotelNameField);
        centerPanel.add(numRoomsLabel);
        centerPanel.add(numRoomsField);
        centerPanel.add(new JLabel()); // empty cell for spacing
        centerPanel.add(submitButton);

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    public void showViewHotelOptions() {
        centerPanel.removeAll();
        centerPanel.setLayout(new GridLayout(4, 1, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton viewHotelDetailsButton = new JButton("View Hotel");
        viewSpecificRoom = new JButton("View Specific Room");
        viewReservation = new JButton("View Reservation");
        viewNumberOfBookedandAvailableRooms = new JButton("View Number of Booked and Available Rooms");

        centerPanel.add(viewHotelDetailsButton);
        centerPanel.add(viewSpecificRoom);
        centerPanel.add(viewReservation);
        centerPanel.add(viewNumberOfBookedandAvailableRooms);

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    public void showManageHotel() {
        centerPanel.removeAll();
        centerPanel.setLayout(new GridLayout(6, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));

        changeNameButton = new JButton("Change Hotel Name");
        addRoomButton = new JButton("Add Room");
        removeRoomButton = new JButton("Remove Room");
        changePriceButton = new JButton("Change Room Price");
        removeReservationButton = new JButton("Remove Reservation");
        removeHotel = new JButton("Remove Hotel");

        centerPanel.add(changeNameButton);
        centerPanel.add(addRoomButton);
        centerPanel.add(removeRoomButton);
        centerPanel.add(changePriceButton);
        centerPanel.add(removeReservationButton);


        centerPanel.revalidate();
        centerPanel.repaint();
    }

    public void showSimulateBooking() {
        centerPanel.removeAll();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));

        JLabel selectedHotel = new JLabel("Select Hotel:");
        JTextField selectedHotelField = new JTextField(25);

        JLabel checkIn = new JLabel("Check In:");
        JTextField checkInField = new JTextField(25);

        JLabel checkOut = new JLabel("Check Out:");
        JTextField checkOutField = new JTextField(25);

        JLabel roomNumber = new JLabel("Room Number:");
        JTextField roomNumberField = new JTextField(25);

        addReservationButton = new JButton("Add Reservation");

        centerPanel.add(selectedHotel);
        centerPanel.add(selectedHotelField);
        centerPanel.add(checkIn);
        centerPanel.add(checkInField);
        centerPanel.add(checkOut);
        centerPanel.add(checkOutField);
        centerPanel.add(roomNumber);
        centerPanel.add(roomNumberField);
        centerPanel.add(addReservationButton);

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    

    public void display(String text) {
        centerPanel.removeAll();
        centerPanel.setLayout(new BorderLayout());

        displayArea = new JTextArea();
        displayArea.setText(text);
        displayArea.setEditable(false);

        centerPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    public void setAddHotelButtonListener(ActionListener listener) {
        addHotelButton.addActionListener(listener);
    }

    public void setSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public void setViewHotelButtonListener(ActionListener listener) {
        viewHotelButton.addActionListener(listener);
    }

    public void setViewSpecificRoomButtonListener(ActionListener listener) {
        viewSpecificRoom.addActionListener(listener);
    }

    public void setSearchHotelButtonListener(ActionListener listener) {
        searchButton.addActionListener(listener);
    }

    public void setViewHotelDetailsButtonListener(ActionListener listener) {
        viewSpecificRoom.addActionListener(listener);
    }

    public void setViewReservationButtonListener(ActionListener listener) {
        viewReservation.addActionListener(listener);
    }

    public void setViewNumberOfBookedandAvailableRoomsButtonListener(ActionListener listener) {
        viewNumberOfBookedandAvailableRooms.addActionListener(listener);
    }

    public void setManageHotelButtonListener(ActionListener listener) {
        manageHotelButton.addActionListener(listener);
    }

    public void setChangeNameButtonListener(ActionListener listener) {
        changeNameButton.addActionListener(listener);
    }

    public void setAddRoomButtonListener(ActionListener listener) {
        addRoomButton.addActionListener(listener);
    }

    public void setRemoveRoomButtonListener(ActionListener listener) {
        removeRoomButton.addActionListener(listener);
    }

    public void setChangePriceButtonListener(ActionListener listener) {
        changePriceButton.addActionListener(listener);
    }

    public void setRemoveReservationButtonListener(ActionListener listener) {
        removeReservationButton.addActionListener(listener);
    }

    public void setRemoveHotelButtonListener(ActionListener listener) {
        removeHotel.addActionListener(listener);
    }
    

    public void setSimulateBookingButtonListener(ActionListener listener) {
        simulateBookingButton.addActionListener(listener);
    }

    public void setAddReservationButtonListener(ActionListener listener) {
        addReservationButton.addActionListener(listener);
    }

    public void setExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }

    




    

    public String getHotelName() {
        return hotelNameField.getText();
    }

    public String getNumRooms() {
        return numRoomsField.getText();
    }
}
