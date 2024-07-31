import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

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
    private JButton viewHotelDetailsButton;
    private JButton getRoomNumberOnType;
    private JTextField roomNumberField; 
    private JTextField newHotelNameField;
    private JTextField newRoomType;
    private JButton searchRoomButton;
    private JTextField startDate;
    private JTextField endDate;
    private JTextField rate;
    private JTextField newPriceField;
    private JTextField guestNameField;
    private JTextField selectedHotelField;
    private JTextField checkInField;
    private JTextField checkOutField;
    private JButton showReservationButton;
    private JTextField discountTextField;
    private JComboBox<String> hotelComboBox;
    private JComboBox<String> roomTypeComboBox;
    private JComboBox<Integer> roomNumberComboBox;
    private JComboBox<Integer> roomNumberListComboBox;
    private JButton datePriceModifierButton;



    /*
     * Constructor for the MainView class
     */
    public MainView() {
        // Set up the frame
        this.setTitle("Hotel Management System");
        this.setSize(500, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);

        this.setResizable(false);

        init();
    }

    /*
     * Initializes the components of the MainView
     */
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

    /*
     * Displays the default center panel
     */
    public void displayDefaultCenterPanel() {
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


    /*
     * shows the add hotel form
     */
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

    /*
     * Shows the view hotel options
     */
    public void showViewHotelOptions() {
        centerPanel.removeAll();
        centerPanel.setLayout(new GridLayout(4, 1, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        viewHotelDetailsButton = new JButton("View Hotel");
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

    /* 
     * shows the hotel overview form
     */
    public void showHotelOverviewForm() {
        centerPanel.removeAll();
        centerPanel.setLayout(new FlowLayout());

        JLabel hotelName = new JLabel("Search Hotel:");
        hotelNameField = new JTextField(25);
        searchButton = new JButton("Search");

        centerPanel.add(hotelName);
        centerPanel.add(hotelNameField);
        centerPanel.add(searchButton);

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /*
     * shows the room overview form
     */
    public void showRoomOverviewForm() {
        centerPanel.removeAll();
        centerPanel.setLayout(new FlowLayout());

        JLabel hotelName = new JLabel("Search Hotel:");
        hotelNameField = new JTextField(25);
        JLabel roomNumber = new JLabel("Room Number:");
        roomNumberField = new JTextField(25);
        searchRoomButton = new JButton("Search");


        centerPanel.add(hotelName);
        centerPanel.add(hotelNameField);
        centerPanel.add(roomNumber);
        centerPanel.add(roomNumberField);
        centerPanel.add(searchRoomButton);

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /*
     * shows the reservation overview form
     */
    public void showReservationsForm() {
        centerPanel.removeAll();
        centerPanel.setLayout(new FlowLayout());

        showReservationButton = new JButton("Search");
        JLabel hotelName = new JLabel("Search Hotel:");
        hotelNameField = new JTextField(25);
        JLabel guestName = new JLabel("Guest Name:");
        guestNameField = new JTextField(25);

        centerPanel.add(hotelName);
        centerPanel.add(hotelNameField);
        centerPanel.add(guestName);
        centerPanel.add(guestNameField);
        centerPanel.add(showReservationButton);

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /*
     * shows the hotels form
     */
    public void showHotels() {
        centerPanel.removeAll();
        centerPanel.setLayout(new FlowLayout());

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        centerPanel.add(new JScrollPane(displayArea));

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /*
     * shows the available rooms form
     */
    public void showAvailableRooms() {
        centerPanel.removeAll();
        centerPanel.setLayout(new FlowLayout());


        JLabel hotelName = new JLabel("Search Hotel:");
        hotelNameField = new JTextField(25);
        JLabel checkIn = new JLabel("Check In:");
        JTextField checkInField = new JTextField(2);
        JLabel checkOut = new JLabel("Check Out:");
        JTextField checkOutField = new JTextField(2);
        searchButton = new JButton("Search");

        centerPanel.add(hotelName);
        centerPanel.add(hotelNameField);
        centerPanel.add(checkIn);
        centerPanel.add(checkInField);
        centerPanel.add(checkOut);
        centerPanel.add(checkOutField);
        centerPanel.add(searchButton);

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /*
     * shows the manage hotel form
     */
    public void showManageHotel() {
        centerPanel.removeAll();
        centerPanel.setLayout(new GridLayout(6, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        changeNameButton = new JButton("Change Hotel Name");
        addRoomButton = new JButton("Add Room");
        removeRoomButton = new JButton("Remove Room");
        changePriceButton = new JButton("Change Room Price");
        removeReservationButton = new JButton("Remove Reservation");
        removeHotel = new JButton("Remove Hotel");
        datePriceModifierButton = new JButton("Modify Date Price");

        centerPanel.add(changeNameButton);
        centerPanel.add(addRoomButton);
        centerPanel.add(removeRoomButton);
        centerPanel.add(changePriceButton);
        centerPanel.add(removeReservationButton);
        centerPanel.add(removeHotel);
        centerPanel.add(datePriceModifierButton);


        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /*
     * shows the change hotel name form
     */
    public void showChangeHotelName() {
        centerPanel.removeAll();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));

        JLabel hotelName = new JLabel("Hotel Name:");
        hotelNameField = new JTextField(25);
        JLabel newHotelName = new JLabel("New Hotel Name:");
        newHotelNameField = new JTextField(25);
        changeNameButton = new JButton("Change Name");

        centerPanel.add(hotelName);
        centerPanel.add(hotelNameField);
        centerPanel.add(newHotelName);
        centerPanel.add(newHotelNameField);
        centerPanel.add(changeNameButton);

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /*
     * shows the add room form
     */
    public void showAddRoomForm() {
        centerPanel.removeAll();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));

        JLabel hotelName = new JLabel("Hotel Name:");
        hotelNameField = new JTextField(25);
        JLabel numRooms = new JLabel("Number of Rooms:");
        numRoomsField = new JTextField(25);
        JLabel roomType = new JLabel("Room Type:");
        newRoomType = new JTextField(25);
        addRoomButton = new JButton("Add Room");

        centerPanel.add(hotelName);
        centerPanel.add(hotelNameField);
        centerPanel.add(numRooms);
        centerPanel.add(numRoomsField);
        centerPanel.add(roomType);
        centerPanel.add(newRoomType);
        centerPanel.add(addRoomButton);

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /*
     * shows the remove room form
     */
    public void showRemoveRoomForm() {
        centerPanel.removeAll();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));

        JLabel hotelName = new JLabel("Hotel Name:");
        hotelNameField = new JTextField(25);
        JLabel roomNumber = new JLabel("Room Number:");
        roomNumberField = new JTextField(25);
        removeRoomButton = new JButton("Remove Room");

        centerPanel.add(hotelName);
        centerPanel.add(hotelNameField);
        centerPanel.add(roomNumber);
        centerPanel.add(roomNumberField);
        centerPanel.add(removeRoomButton);

        centerPanel.revalidate();
        centerPanel.repaint();
    }


    /*
     * shows the change price form
     */
    public void showChangePriceForm() {
        centerPanel.removeAll();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));

        JLabel hotelName = new JLabel("Hotel Name:");
        hotelNameField = new JTextField(25);
        JLabel roomNumber = new JLabel("Room Number:");
        roomNumberField = new JTextField(25);
        JLabel newPrice = new JLabel("New Price:");
        newPriceField = new JTextField(25);
        changePriceButton = new JButton("Change Price");

        centerPanel.add(hotelName);
        centerPanel.add(hotelNameField);
        centerPanel.add(roomNumber);
        centerPanel.add(roomNumberField);
        centerPanel.add(newPrice);
        centerPanel.add(newPriceField);
        centerPanel.add(changePriceButton);

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /*
     * shows the remove reservation form
     */
    public void showRemoveReservationForm() {
        centerPanel.removeAll();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));
    
        JLabel hotelNameLabel = new JLabel("Hotel Name:");
        hotelNameField = new JTextField(25);
        JLabel guestNameLabel = new JLabel("Guest Name:");
        guestNameField = new JTextField(25);
        removeReservationButton = new JButton("Remove Reservation");
    
        centerPanel.add(hotelNameLabel);
        centerPanel.add(hotelNameField);
        centerPanel.add(guestNameLabel);
        centerPanel.add(guestNameField);
        centerPanel.add(removeReservationButton);
    
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /*
     * shows the remove hotel form
     */
    public void showRemoveHotelForm() {
        centerPanel.removeAll();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));

        JLabel hotelName = new JLabel("Hotel Name:");
        hotelNameField = new JTextField(25);
        removeHotel = new JButton("Remove Hotel");

        centerPanel.add(hotelName);
        centerPanel.add(hotelNameField);
        centerPanel.add(removeHotel);

        centerPanel.revalidate();
        centerPanel.repaint();
    }

   
    /**
     * Displays the form for modifying the date and price of a hotel.
     * 
     * @param model The HotelModel object containing the list of hotels.
     */
    public void showDatePriceModifierForm(HotelModel model) {
        centerPanel.removeAll();
        centerPanel.setLayout(new FlowLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));

        ArrayList<String> hotelNames = new ArrayList<>();
        for (Hotel hotel : model.getHotels()) {
            hotelNames.add(hotel.getName());
        }
        JLabel hotelName = new JLabel("Hotel Name:");
        hotelComboBox = new JComboBox<>(hotelNames.toArray(new String[0]));
        JLabel startDateLabel = new JLabel("Start Date:");
        startDate = new JTextField(6);
        JLabel endDateLabel = new JLabel("End Date:");
        endDate = new JTextField(6);
        JLabel rateLabel = new JLabel("Rate:");
        rate = new JTextField(10);
        
        datePriceModifierButton = new JButton("Modify Date Price");

        centerPanel.add(hotelName);
        centerPanel.add(hotelComboBox);
        centerPanel.add(startDateLabel);
        centerPanel.add(startDate);
        centerPanel.add(endDateLabel);
        centerPanel.add(endDate);
        centerPanel.add(rateLabel);
        centerPanel.add(rate);
        centerPanel.add(datePriceModifierButton);

        centerPanel.revalidate();
        centerPanel.repaint();
    }


    /**
     * Retrieves an array of available room numbers based on the given hotel model.
     * 
     * @param model The hotel model containing the list of hotels.
     * @return An array of available room numbers, or null if no rooms are available.
     */
    public Integer[] getAvailableRoomNumber(HotelModel model) {
        Hotel hotel = model.findHotelByName(hotelNameField.getText());
        String roomType = roomTypeComboBox.getSelectedItem().toString().toLowerCase();
        int checkIn = checkInField.getText() != null && !checkInField.getText().isEmpty() ? Integer.parseInt(checkInField.getText()) : 0;
        int checkOut = checkOutField.getText() != null && !checkOutField.getText().isEmpty() ? Integer.parseInt(checkOutField.getText()) : 0;
        Integer[] array = new Integer[50];
        int i = 0;

        for (Room room : hotel.getRooms()) {

            if (room.getRoomType().equals(roomType) || roomType.equals("all")) {
                if (!roomOccupied(hotel, hotel.getName(), room.getRoomNumber(), checkIn, checkOut)) {
                    System.out.println("Room " + room.getRoomNumber() + " available");
                    array[i] = room.getRoomNumber();
                    i++;
                }
            }
        }
        if (i > 0) {
            Integer[] result = new Integer[i];
            for (int j = 0; j < i; j++) {
                if (array[j] != null && array[j] != 0) {
                    result[j] = array[j];
                }
            }
            return result;
        }
        
    
        System.out.println("Length: " + i);
        return null;
    }

    /**
     * Checks if two date ranges overlap.
     *
     * @param checkIn1  the check-in date of the first range
     * @param checkOut1 the check-out date of the first range
     * @param checkIn2  the check-in date of the second range
     * @param checkOut2 the check-out date of the second range
     * @return true if the date ranges overlap, false otherwise
     */
    public boolean datesOverlap(int checkIn1, int checkOut1, int checkIn2, int checkOut2) {
        return (checkIn1 < checkOut2 && checkOut1 > checkIn2);
    }

    /**
     * Checks if a room in a hotel is occupied during a specified period.
     * 
     * @param hotel the hotel object containing the rooms and reservations
     * @param hotelName the name of the hotel
     * @param roomNumber the number of the room to check
     * @param checkIn the check-in date of the period to check
     * @param checkOut the check-out date of the period to check
     * @return true if the room is occupied during the specified period, false otherwise
     */
    public boolean roomOccupied(Hotel hotel, String hotelName, int roomNumber, int checkIn, int checkOut) {
        for (Room room : hotel.getRooms()) {
            if (room.getRoomNumber() == roomNumber) {
                for (Reservation reservation : room.getReservations()) {
                    if (datesOverlap(reservation.getCheckIn(), reservation.getCheckOut(), checkIn, checkOut)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Displays the booking form on the main view.
     * 
     * @param hotelNames The list of hotel names to populate the hotel combo box.
     * @param model The HotelModel object used to retrieve available room numbers.
     */
    public void showBooking(ArrayList<String> hotelNames, HotelModel model) {
        centerPanel.removeAll();
        centerPanel.setLayout(new FlowLayout(1, 3, 10));
        
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));

        JLabel guestName = new JLabel("Guest Name: ");
        guestNameField = new JTextField(25);

        JLabel selectedHotel = new JLabel("Select Hotel: ");
        hotelComboBox = new JComboBox<>(hotelNames.toArray(new String[0]));

        JLabel checkIn = new JLabel("Check In: ");
        checkInField = new JTextField(2);

        JLabel checkOut = new JLabel("Check Out: ");
        checkOutField = new JTextField(2);

        JLabel roomType = new JLabel("Room Type: ");
        String[] roomTypes = {"All", "Deluxe", "Executive", "Standard"};
        roomTypeComboBox = new JComboBox<>(roomTypes);
        
        JButton getRoomNumberOnType = new JButton("Get Available Room Numbers");

        JLabel roomNumber = new JLabel("Room Number: ");
        roomNumberListComboBox = new JComboBox<Integer>();

        getRoomNumberOnType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer[] roomNumbers = getAvailableRoomNumber(model);
                if (roomNumbers != null) {
                    roomNumberListComboBox.setModel(new DefaultComboBoxModel<>(roomNumbers));
                }
        }});


        JLabel discountCode = new JLabel("Discount Code: ");
        discountTextField = new JTextField(25);

        addReservationButton = new JButton("Add Reservation");

        centerPanel.add(guestName);
        centerPanel.add(guestNameField);
        centerPanel.add(selectedHotel);
        centerPanel.add(hotelComboBox);
        centerPanel.add(checkIn);
        centerPanel.add(checkInField);
        centerPanel.add(checkOut);
        centerPanel.add(checkOutField);
        centerPanel.add(roomType);
        centerPanel.add(roomTypeComboBox);
        centerPanel.add(roomNumber);
        centerPanel.add(roomNumberListComboBox);
        centerPanel.add(getRoomNumberOnType);
        centerPanel.add(discountCode);
        centerPanel.add(discountTextField);
        centerPanel.add(addReservationButton);

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /**
     * Returns the name of the selected hotel from the hotelComboBox.
     *
     * @return the name of the selected hotel
     */
    public String getSelectedHotelName() {
        return (String) hotelComboBox.getSelectedItem();
    }

    /**
     * Retrieves the selected room type from the roomTypeComboBox.
     *
     * @return The selected room type as a String.
     */
    public String getRoomType() {
        return (String) roomTypeComboBox.getSelectedItem();
    }

    /**
     * Returns the selected room number from the roomNumberListComboBox.
     *
     * @return The selected room number as an integer.
     */
    public int getSelectedRoomNumber() {
        return (int) roomNumberListComboBox.getSelectedItem();
    }

    /**
     * Retrieves the selected room number from the room number field as an integer.
     *
     * @return The selected room number as an integer.
     */
    public int getSelectedRoomNumberNonCombo() {
        return Integer.parseInt(roomNumberField.getText());
    }

    /**
     * Displays a message dialog with the specified message.
     *
     * @param message the message to be displayed
     */
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * Retrieves the discount code entered by the user.
     *
     * @return the discount code entered in the discountTextField
     */
    public String getDiscountCode() {
        return discountTextField.getText();
    }

    /**
     * Retrieves the start date from the text field.
     * 
     * @return The start date as an integer.
     */
    public int getStartDate(){
        return Integer.parseInt(startDate.getText());
    }

    /**
     * Retrieves the end date from the text field.
     *
     * @return The end date as an integer.
     */
    public int getEndDate(){
        return Integer.parseInt(endDate.getText());
    }

    /**
     * Retrieves the rate value entered by the user.
     * 
     * @return The rate value as a double.
     */
    public double getRate(){
        return Double.parseDouble(rate.getText());
    }

    /**
     * Sets the room numbers in the roomNumberComboBox.
     * 
     * @param roomNumbers the list of room numbers to be set
     */
    public void setRoomNumbers(List<Integer> roomNumbers) {
        roomNumberComboBox.removeAllItems();
        for (int roomNumber : roomNumbers) {
            roomNumberComboBox.addItem(roomNumber);
        }
    }


    /**
     * Displays the reservation information on the center panel.
     * 
     * @param roomNumber the room number of the reservation
     * @param guestName the name of the guest
     * @param checkIn the check-in date of the reservation
     * @param checkOut the check-out date of the reservation
     * @param total the total price of the reservation
     */
    public void displayReservationInformation(int roomNumber, String guestName, int checkIn, int checkOut, double total) {
        centerPanel.removeAll();
        centerPanel.setLayout(new BorderLayout());
    
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding around the panel
    
        JLabel guestNameLabel = new JLabel("Guest Name: " + guestName);
        guestNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        guestNameLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    
        JLabel roomNumberLabel = new JLabel("Room Number: " + roomNumber);
        roomNumberLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        roomNumberLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    
        JLabel checkInLabel = new JLabel("Check In: " + checkIn);
        checkInLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        checkInLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    
        JLabel checkOutLabel = new JLabel("Check Out: " + checkOut);
        checkOutLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        checkOutLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    
        JLabel totalLabel = new JLabel("Total Price: " + total);
        totalLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        totalLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    
        infoPanel.add(guestNameLabel);
        infoPanel.add(roomNumberLabel);
        infoPanel.add(checkInLabel);
        infoPanel.add(checkOutLabel);
        infoPanel.add(totalLabel);
    
        centerPanel.add(infoPanel, BorderLayout.CENTER);
    
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /**
     * Displays the information of a room in the center panel.
     *
     * @param roomNumber   the room number
     * @param roomType     the room type
     * @param price        the price of the room
     * @param isAvailable  the availability of the room
     */
    public void displayRoomInformation(int roomNumber, String roomType, double price, boolean isAvailable) {
        centerPanel.removeAll();
        centerPanel.setLayout(new BorderLayout());
    
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding around the panel
    
        JLabel roomNumberLabel = new JLabel("Room Number: " + roomNumber);
        roomNumberLabel.setFont(new Font("Arial", Font.BOLD, 16));
        roomNumberLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    
        JLabel roomTypeLabel = new JLabel("Room Type: " + roomType);
        roomTypeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        roomTypeLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    
        JLabel priceLabel = new JLabel("Price: " + price);
        priceLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        priceLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    
        JLabel availabilityLabel = new JLabel("Availability: " + (isAvailable ? "Available" : "Not Available"));
        availabilityLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        availabilityLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    
        infoPanel.add(roomNumberLabel);
        infoPanel.add(roomTypeLabel);
        infoPanel.add(priceLabel);
        infoPanel.add(availabilityLabel);
    
        centerPanel.add(infoPanel, BorderLayout.CENTER);
    
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /**
     * Displays the hotel information on the center panel.
     * 
     * @param hotelName The name of the hotel.
     * @param numRooms The number of rooms in the hotel.
     * @param earningsPerMonth The earnings per month for the hotel.
     */
    public void displayHotelInformation(String hotelName, int numRooms, double earningsPerMonth) {
        centerPanel.removeAll();
        centerPanel.setLayout(new BorderLayout());
    
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding around the panel
    
        JLabel hotelNameLabel = new JLabel("Hotel Name: " + hotelName);
        hotelNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        hotelNameLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    
        JLabel numRoomsLabel = new JLabel("Number of Rooms: " + numRooms);
        numRoomsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        numRoomsLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    
        JLabel earningsPerMonthLabel = new JLabel("Earnings Per Month: " + earningsPerMonth);
        earningsPerMonthLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        earningsPerMonthLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

    
        infoPanel.add(hotelNameLabel);
        infoPanel.add(numRoomsLabel);
        infoPanel.add(earningsPerMonthLabel);

    
        centerPanel.add(infoPanel, BorderLayout.CENTER);
    
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    
    

    /**
     * Displays the given text in the center panel of the MainView.
     * 
     * @param text the text to be displayed
     */
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


    /**
     * Prints all hotels in the given HotelModel.
     * 
     * @param model the HotelModel containing the hotels to be printed
     */
    public void printAllHotels(HotelModel model){
        centerPanel.removeAll();
        centerPanel.setLayout(new FlowLayout());

        displayArea = new JTextArea(20, 20);
        displayArea.setEditable(false);

        for (Hotel hotel : model.getHotels()) {
            displayArea.append(hotel.getName() + "\n");
            displayArea.append("Number of Rooms: " + hotel.getRooms().size() + "\n");
            displayArea.append("Earnings Per Month: " + hotel.getEarningsPerMonth() + "\n");
            displayArea.append("\n");
        }

        centerPanel.add(new JScrollPane(displayArea));

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /**
     * Sets the ActionListener for the printHotelsButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setPrintHotelsButtonListener(ActionListener listener) {
        printHotelsButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the searchRoomButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setSearchRoomButtonListener(ActionListener listener) {
        searchRoomButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the addHotelButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setAddHotelButtonListener(ActionListener listener) {
        addHotelButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the submitButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setSubmitButtonListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the viewHotelButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setViewHotelButtonListener(ActionListener listener) {
        viewHotelButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the showReservationButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setSearchReservationButtonListener(ActionListener listener) {
        showReservationButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the viewHotelDetailsButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setViewHotelDetailsButtonListener(ActionListener listener) {
        viewHotelDetailsButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the viewSpecificRoomButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setViewSpecificRoomButtonListener(ActionListener listener) {
        viewSpecificRoom.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the searchButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setSearchHotelButtonListener(ActionListener listener) {
        searchButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the showAvailableRoomsButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setViewReservationButtonListener(ActionListener listener) {
        viewReservation.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the viewNumberOfBookedandAvailableRoomsButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setViewNumberOfBookedandAvailableRoomsButtonListener(ActionListener listener) {
        viewNumberOfBookedandAvailableRooms.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the simulateBookingButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setManageHotelButtonListener(ActionListener listener) {
        manageHotelButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the changeNameButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setChangeNameButtonListener(ActionListener listener) {
        changeNameButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the addRoomButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setAddRoomButtonListener(ActionListener listener) {
        addRoomButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the removeRoomButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setRemoveRoomButtonListener(ActionListener listener) {
        removeRoomButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the changePriceButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setChangePriceButtonListener(ActionListener listener) {
        changePriceButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the removeReservationButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setRemoveReservationButtonListener(ActionListener listener) {
        removeReservationButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the removeHotelButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setRemoveHotelButtonListener(ActionListener listener) {
        removeHotel.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the datePriceModifierButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setDatePriceModifierButtonListener(ActionListener listener) {
        datePriceModifierButton.addActionListener(listener);
    }
    
    /**
     * Sets the ActionListener for the addReservationButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setSimulateBookingButtonListener(ActionListener listener) {
        simulateBookingButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the exitButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setAddReservationButtonListener(ActionListener listener) {
        addReservationButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the exitButton.
     * 
     * @param listener the ActionListener to be set
     */
    public void setExitButtonListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }

    /**
     * Sets the ActionListener for the getRoomNumberOnType button.
     * 
     * @param listener the ActionListener to be set
     */
    public void getRoomNumberOnTypeListener(ActionListener listener) {
        getRoomNumberOnType.addActionListener(listener);
    }
    
    /**
     * Retrieves the hotel name from the hotelNameField.
     * 
     * @return the hotel name as a String
     */
    public String getHotelName() {
        return hotelNameField.getText();
    }

    /**
     * Retrieves the number of rooms from the numRoomsField.
     * 
     * @return the number of rooms as a String
     */
    public String getNumRooms() {
        return numRoomsField.getText();
    }


    /**
     * Returns the selected room number from the roomNumberListComboBox.
     *
     * @return the selected room number
     */
    public int getRoomNumber() {
        return (int) roomNumberListComboBox.getSelectedItem();
    }

    /**
     * Retrieves the room number from the text field.
     * 
     * @return The room number as an integer.
     */
    public int getRoomNumberNonComboBox() {
        String roomNumberText;
        int roomNumberInteger;
        roomNumberText = roomNumberField.getText();
        roomNumberInteger = Integer.parseInt(roomNumberText);

        return roomNumberInteger;
    }

    /**
     * Retrieves the new hotel name from the newHotelNameField.
     * 
     * @return the new hotel name as a String
     */
    public String getNewHotelName() {
        return newHotelNameField.getText();
    }

    /**
     * Retrieves the new room type from the newRoomTypeField.
     * 
     * @return the new room type as a String
     */
    public String getNewRoomType() {
        return newRoomType.getText();
    }

    /**
     * Retrieves the new price from the newPriceField.
     * 
     * @return the new price as a String
     */
    public String getNewPrice() {
        return newPriceField.getText();
    }

    /**
     * Retrieves the guest name from the guestNameField.
     * 
     * @return the guest name as a String
     */
    public String getCustomerName() {
        return guestNameField.getText();
    }

    /**
     * Retrieves the selected hotel from the hotelComboBox.
     * 
     * @return the selected hotel as a String
     */
    public String getSelectedHotel() {
        return selectedHotelField.getText();
    }

    /**
     * Retrieves the check-in date from the checkInField.
     * 
     * @return the check-in date as an integer
     */
    public int getCheckIn() {
        //turn the string into an integer
        String checkInText;
        int checkInInteger;
        checkInText = checkInField.getText();
        checkInInteger = Integer.parseInt(checkInText);

        return checkInInteger;
    }

    /**
     * Retrieves the check-out date from the checkOutField.
     * 
     * @return the check-out date as an integer
     */
    public int getCheckOut() {
        //turn the string into an integer
        String checkOutText;
        int checkOutInteger;
        checkOutText = checkOutField.getText();
        checkOutInteger = Integer.parseInt(checkOutText);

        return checkOutInteger;
    }

    /**
     * Displays the reservations in a formatted manner.
     * 
     * @param reservations the list of reservations to be displayed
     */
    public void displayReservations(ArrayList<Reservation> reservations) {
        String text = "";
        for (Reservation reservation : reservations) {
            text += "Guest Name: " + reservation.getGuestName() + "\n";
            text += "Room Number: " + reservation.getRoomNumber() + "\n";
            text += "Check In: " + reservation.getCheckIn() + "\n";
            text += "Check Out: " + reservation.getCheckOut() + "\n";
            text += "Total Price: " + reservation.getTotal() + "\n";
            text += "\n";
        }

        display(text);
    }


}
