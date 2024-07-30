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
    private JButton datePriceModifier;
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

    public void showHotels() {
        centerPanel.removeAll();
        centerPanel.setLayout(new FlowLayout());

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        centerPanel.add(new JScrollPane(displayArea));

        centerPanel.revalidate();
        centerPanel.repaint();
    }

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
        datePriceModifier = new JButton("Modify Date Price");

        centerPanel.add(changeNameButton);
        centerPanel.add(addRoomButton);
        centerPanel.add(removeRoomButton);
        centerPanel.add(changePriceButton);
        centerPanel.add(removeReservationButton);
        centerPanel.add(removeHotel);
        centerPanel.add(datePriceModifier);


        centerPanel.revalidate();
        centerPanel.repaint();
    }

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
        
        submitButton = new JButton("Modify Date Price");

        centerPanel.add(hotelName);
        centerPanel.add(hotelComboBox);
        centerPanel.add(startDateLabel);
        centerPanel.add(startDate);
        centerPanel.add(endDateLabel);
        centerPanel.add(endDate);
        centerPanel.add(rateLabel);
        centerPanel.add(rate);
        centerPanel.add(submitButton);

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    public Integer[] getAvailableRoomNumber(HotelModel model) {
        Hotel hotel = model.findHotelByName(hotelNameField.getText());
        String roomType = roomTypeComboBox.getSelectedItem().toString().toLowerCase();
        int checkIn = checkInField.getText() != null && !checkInField.getText().isEmpty() ? Integer.parseInt(checkInField.getText()) : 0;
        int checkOut = checkOutField.getText() != null && !checkOutField.getText().isEmpty() ? Integer.parseInt(checkOutField.getText()) : 0;
        Integer[] array = new Integer[50];
        int i = 0;
        // System.out.println("Start getAvailableRoomNumber");
        // System.out.println("Hotel: " + hotel.getName());
        // System.out.println("Room Type To Check " + roomType);
        // System.out.println("Check In: " + checkIn);
        // System.out.println("Check Out: " + checkOut);
        for (Room room : hotel.getRooms()) {
            // System.out.println("Room: " + room.getRoomNumber());
            // System.out.println("Room Type: " + room.getRoomType() + " || Value: " + room.getRoomType().equals(roomType));
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
        // System.out.println("Result: ");
        // for (int j = 0; j < i; j++) {
        //     System.out.println(result[j]);
        // }
        return null;
    }

    public boolean datesOverlap(int checkIn1, int checkOut1, int checkIn2, int checkOut2) {
        return (checkIn1 < checkOut2 && checkOut1 > checkIn2);
    }

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

    public String getSelectedHotelName() {
        return (String) hotelComboBox.getSelectedItem();
    }

    public String getRoomType() {
        return (String) roomTypeComboBox.getSelectedItem();
    }

    public int getSelectedRoomNumber() {
        return (int) roomNumberListComboBox.getSelectedItem();
    }

    public int getSelectedRoomNumberNonCombo() {
        return Integer.parseInt(roomNumberField.getText());
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public String getDiscountCode() {
        return discountTextField.getText();
    }

    public int getStartDate(){
        return Integer.parseInt(startDate.getText());
    }

    public int getEndDate(){
        return Integer.parseInt(endDate.getText());
    }

    public double getRate(){
        return Double.parseDouble(rate.getText());
    }

    public void setRoomNumbers(List<Integer> roomNumbers) {
        roomNumberComboBox.removeAllItems();
        for (int roomNumber : roomNumbers) {
            roomNumberComboBox.addItem(roomNumber);
        }
    }


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

    public void setPrintHotelsButtonListener(ActionListener listener) {
        printHotelsButton.addActionListener(listener);
    }

    public void setSearchRoomButtonListener(ActionListener listener) {
        searchRoomButton.addActionListener(listener);
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

    public void setSearchReservationButtonListener(ActionListener listener) {
        showReservationButton.addActionListener(listener);
    }

    public void setViewHotelDetailsButtonListener(ActionListener listener) {
        viewHotelDetailsButton.addActionListener(listener);
    }

    public void setViewSpecificRoomButtonListener(ActionListener listener) {
        viewSpecificRoom.addActionListener(listener);
    }

    public void setSearchHotelButtonListener(ActionListener listener) {
        searchButton.addActionListener(listener);
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

    public void setDatePriceModifierButtonListener(ActionListener listener) {
        datePriceModifier.addActionListener(listener);
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

    public void getRoomNumberOnTypeListener(ActionListener listener) {
        getRoomNumberOnType.addActionListener(listener);
    }
    

    public String getHotelName() {
        return hotelNameField.getText();
    }

    public String getNumRooms() {
        return numRoomsField.getText();
    }

    public int getRoomNumber() {
        // String roomNumberText;
        // int roomNumberInteger;
        // roomNumberText = roomNumberField.getText();
        // roomNumberInteger = Integer.parseInt(roomNumberText);

        // return roomNumberInteger;
        return (int) roomNumberListComboBox.getSelectedItem();
    }

    public int getRoomNumberNonComboBox() {
        String roomNumberText;
        int roomNumberInteger;
        roomNumberText = roomNumberField.getText();
        roomNumberInteger = Integer.parseInt(roomNumberText);

        return roomNumberInteger;
    }

    public String getNewHotelName() {
        return newHotelNameField.getText();
    }

    public String getNewRoomType() {
        return newRoomType.getText();
    }

    public String getNewPrice() {
        return newPriceField.getText();
    }

    public String getCustomerName() {
        return guestNameField.getText();
    }

    public String getSelectedHotel() {
        return selectedHotelField.getText();
    }

    public int getCheckIn() {
        //turn the string into an integer
        String checkInText;
        int checkInInteger;
        checkInText = checkInField.getText();
        checkInInteger = Integer.parseInt(checkInText);

        return checkInInteger;
    }

    public int getCheckOut() {
        //turn the string into an integer
        String checkOutText;
        int checkOutInteger;
        checkOutText = checkOutField.getText();
        checkOutInteger = Integer.parseInt(checkOutText);

        return checkOutInteger;
    }

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
