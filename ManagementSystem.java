import java.util.Scanner;
import java.util.ArrayList;

/**
 * Driver class is the main entry point of the program
 */
public class ManagementSystem {

        /**
         * Displays the menu system for the Hotel Reservation System.
         * Allows the user to perform various operations such as adding a hotel, viewing hotels,
         * managing hotels, simulating bookings, and logging out.
         * 
         */
        public void menuSystem() {
        ArrayList<Hotel> hotels = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------------------------------\n");
        System.out.println("    Welcome to the Hotel Reservation System!");
        while (true) {
            Driver driver = new Driver();
            printMenu();
            System.err.print("Enter your choice: ");
            int choice = getInt(scanner);
            printBorder();
            
            switch (choice){
                case 1:
                    addHotel(hotels, scanner);
                    break;
                case 2:
                    if (hotels.isEmpty()){
                        System.out.print("|| No hotels exist. Please create a hotel first. ||");
                    } else {
                        printViewHotel(scanner, hotels);
                    }
                    break;
                case 3:
                    if (hotels.isEmpty()){
                        System.out.print("|| No hotels exist. Please create a hotel first. ||");
                    } else {
                        printManageHotel(driver, scanner, hotels);
                    }
                    break;
                case 4:
                    if (hotels.isEmpty()){
                        System.out.print("|| No hotels exist. Please create a hotel first. ||");
                    } else {
                        printSimulateBooking(driver, hotels, scanner);
                    }
                    break;
                case 5:
                    if (hotels.isEmpty()){
                        System.out.print("|| No hotels exist. Please create a hotel first. ||");
                    } else {
                        printHotels(hotels);
                    }
                    break;
                case 6:
                    System.out.println("Logging Out...");
                    scanner.close();
                    return;
                default:
                    System.out.println("\n || Invalid choice. Please try again. ||");
                    printBorder();
            }
            System.err.println("\n");
        }
      }

    /**
     * Prints the Main Menu Choices
     */
    public void printMenu() {
        printBorder();
        System.out.println("|| MAIN MENU ||");
        System.out.println("[1] Create Hotel");
        System.out.println("[2] View Hotel");
        System.out.println("[3] Manage Hotel");
        System.err.println("[4] Simulate Booking");
        System.out.println("[5] Print All Hotels");
        System.out.println("[6] Exit");
    }

    /**
     * Prints out border for styling
     */
    public void printBorder(){
        System.out.println("\n--------------------------------------------------\n");
    }

    /**
     * View Hotel menu
     * @param scanner used for obtaining the user's input
     * @param hotels list of hotels
     */
    public void printViewHotel(Scanner scanner, ArrayList<Hotel> hotels){
        int choice;
        while (true) {
            System.out.println("[1] View Hotel Overview");
            System.out.println("[2] View Hotel Date Availability");
            System.out.println("[3] View Room Information");
            System.out.println("[4] View Reservation Information");
            System.out.println("[5] Back to Main Menu");
            System.err.println("Enter your choice: ");
            choice = getInt(scanner);
            printBorder();

            switch (choice){
                case 1:
                    hotelOverview(scanner, hotels);
                    break;
                case 2:
                    printBookedForADate(scanner, hotels);
                    break;
                case 3:
                    viewRoomInformation(hotels, scanner);
                    break;
                case 4:
                    printReservations(hotels, scanner);
                    break;
                case 5:
                    System.out.print("\nBack to Main Menu");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    printBorder();
            }
        }
    }

    /**
     * Prints the hotel overview
     * @param scanner used for obtaining the user's input
     * @param hotels list of hotels
     */
    public void hotelOverview(Scanner scanner, ArrayList<Hotel> hotels){
        // hotel name, number of rooms, earnings for the month, number of rooms booked for the month, number of rooms available for the month
        if (!hotels.isEmpty()) {
            // String hotelName = getHotelInput(hotels, scanner);
            System.out.println("Do you want to see the overview for all hotels or a specific one?");
            System.out.println("[1] All Hotels");
            System.out.println("[2] Specific Hotel");
            System.err.print("Enter your choice: ");
            int choice = getInt(scanner);
            printBorder();
            System.out.println();
            if (choice == 1) {
                for (Hotel hotel : hotels) {
                    System.out.println("Hotel: " + hotel.getName());
                    System.out.println("Number of rooms: " + hotel.getRooms().size());
                    System.out.println("Earnings for the month: " + hotel.getEarningsPerMonth());
                }
            } else {
                System.out.println("Enter the name of the hotel: ");
                String hotelName = scanner.nextLine();
                for (Hotel hotel : hotels) {
                    if (hotel.getName().equals(hotelName)) {
                        System.out.println("Hotel: " + hotel.getName());
                        System.out.println("Number of rooms: " + hotel.getRooms().size());
                        System.out.println("Earnings for the month: " + hotel.getEarningsPerMonth());
                    }
                }
                
            }
            printBorder();
        }

    }

    /**
     * Prints how many rooms are available and occupied for the given date
     * @param scanner used for obtaining the user's input
     * @param hotels list of hotels
     */
    public void printBookedForADate(Scanner scanner, ArrayList<Hotel> hotels){
        System.out.print("Enter the hotel name: ");
        String hotelName = scanner.nextLine();
        System.out.print("Enter the date: ");
        int date = getInt(scanner);
        int bookedRooms = 0, availableRooms = 0;
        //checks the check in and check out dates of the reservations and counts the number of booked rooms and available rooms
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(hotelName)) {
                bookedRooms = hotel.numberBookedRooms(date);
                availableRooms = hotel.numberAvailableRooms();
            }
        }

        System.out.println("Total Available Rooms: " + availableRooms);
        System.out.println("Total Occupied Rooms: " + bookedRooms);
        printBorder();
    }

    /**
     * Manage Hotel menu
     * @param driver to be able to use driver methods
     * @param scanner used for obtaining the user's input
     * @param hotels list of hotels
     */
    public void printManageHotel(Driver driver, Scanner scanner, ArrayList<Hotel> hotels){
        int choice;
        while (true) {
            System.out.println("[1] Change Hotel Name");
            System.out.println("[2] Add Room");
            System.out.println("[3] Remove Room");
            System.out.println("[4] Update Room Price");
            System.out.println("[5] Remove Reservation");
            System.out.println("[6] Remove Hotel");
            System.out.println("[7] Date Price Modifier");
            System.out.println("[8] Back to Main Menu");
            System.err.print("Enter your choice: ");
            choice = getInt(scanner);
            printBorder();

            switch (choice) {
                case 1:
                    changeHotelName(scanner, hotels);
                    break;
                case 2:
                    addRoom(hotels, scanner);
                    break;
                case 3:
                    removeRoom(hotels, scanner);
                    break;
                case 4:
                    // Update room price
                    updateRoomPrice(hotels, scanner);
                    break;
                case 5:
                    removeReservation(hotels, scanner);
                    break;
                case 6:
                    removeHotel(hotels, scanner);
                    if (hotels.isEmpty()) {
                        return;
                    } else {
                        break;
                    }
                case 7:
                    String hotelName = getHotelInput(hotels, scanner);
                    for (Hotel hotel : hotels) {
                        if (hotel.getName().equals(hotelName)) {
                            hotel.addModifiedDates(scanner);
                        }
                    }
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    printBorder();
            }
        }
    }




    /**
     * Method for changing a hotel's name
     * @param scanner used for obtaining the user's input
     * @param hotels list of hotels
     */
    public void changeHotelName(Scanner scanner, ArrayList<Hotel> hotels) {
        String hotelName = getHotelInput(hotels, scanner);
        System.out.print("Enter the new name for the hotel: ");
        String newName = scanner.nextLine();
        while (hotelExists(hotels, newName)) {
            System.out.print("Hotel name already exists. Enter a new one: ");
            newName = scanner.nextLine();
        }

        if(confirmAction(scanner)) {
            for (Hotel hotel : hotels) {
                if (hotel.getName().equals(hotelName)) {
                    hotel.setName(newName);
                    System.out.println("Hotel name changed to " + newName + ".");
                }
            }
        } else {
            System.out.println("Hotel name not changed.");
        }
    }

    /**
     * Method for updating the price of a hotel's room
     * @param scanner used for obtaining the user's input
     * @param hotels list of hotels
     */
    public void updateRoomPrice(ArrayList<Hotel> hotels, Scanner scanner){
        System.out.print("Enter the hotel name: ");
        String hotelName = scanner.nextLine();
        boolean hasReservations = false;

        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(hotelName)) {
                if (!hotel.getReservations().isEmpty()) {
                    hasReservations = true;
                    break;
                }
            }
        }

        if (!hasReservations) {
            System.out.print("Enter the new base price: ");
            double newPrice = scanner.nextDouble();
            scanner.nextLine();

            if (newPrice >= 100.0) {
                for (Hotel hotel : hotels) {
                    if (hotel.getName().equals(hotelName) && confirmAction(scanner)) {
                        hotel.setBasePrice(newPrice);
                        System.out.println("Base price updated successfully.");
                        break;
                    }
                    else {
                        System.out.println("Base price not updated.");
                    }
                }
            } else {
                System.out.println("Invalid base price. The price must be greater than or equal to 100.0");
            }
        } else {
            System.out.println("Cannot update base price. There are reservations in the chosen hotel.");
        }
    }

    /**
     * Method for removing a hotel
     * @param scanner used for obtaining the user's input
     * @param hotels list of hotels
     */
    public void removeHotel(ArrayList<Hotel> hotels, Scanner scanner) {
        if (!hotels.isEmpty()) {
            String name = getHotelInput(hotels, scanner);

            if (confirmAction(scanner)) {
                for (Hotel hotel : hotels) {
                    if (hotel.getName().equals(name)) {
                        hotels.remove(hotel);
                        System.out.println("Hotel " + name + " removed.");
                        return;
                    }
                }
            } else {
                System.out.println("Hotel " + name + " not removed.");
            }
        } else {
            System.out.println("No hotels exist.");
        }
    }

    /**
     * Method for adding a hotel
     * @param scanner used for obtaining the user's input
     * @param hotels list of hotels
     */
    public void addHotel(ArrayList<Hotel> hotels, Scanner scanner) {
        System.out.print("Enter the name of the hotel: ");
        String name = scanner.nextLine();
        while (hotelExists(hotels, name)) {
            System.out.print("Hotel name already exists. Enter a new one: ");
            name = scanner.nextLine();
        }

        System.out.println("Do you want to create a hotel with a default 1 room or specify the number of rooms?");
        System.out.println("[1] Default 1 room");
        System.out.println("[2] Specify number of standard rooms.\n    (Deluxe and Executive Rooms can be added later)");
        System.out.print("Enter your choice: ");
        int choice = getInt(scanner);
        if (choice == 1) {
            hotels.add(new Hotel(name));
        } else if(choice == 2) {
            System.out.print("Enter the number of rooms: ");
            int rooms = getInt(scanner);
            while (rooms < 1 || rooms > 50) {
                System.out.print("Invalid number of rooms. Enter a number between 1 and 50: ");
                rooms = getInt(scanner);
            }
            hotels.add(new Hotel(name, rooms));
        }

        System.out.print(name + " successfully added to the list of hotels");
    }

    /**
     * Method for adding a room to a hotel
     * @param scanner used for obtaining the user's input
     * @param hotels list of hotels
     */
    public void addRoom(ArrayList<Hotel> hotels, Scanner scanner) {
        if (!hotels.isEmpty()) {
            String name = getHotelInput(hotels, scanner);
            System.out.print("Enter the number of rooms to add: ");
            int rooms = getInt(scanner);
            while (rooms <= 0) {
                System.out.println("Cannot add 0 or negative rooms. Enter a valid number: ");
                rooms = getInt(scanner);
            }
            int totalRooms = 0;
            for (Hotel hotel : hotels) {
                if (hotel.getName().equals(name)) {
                    totalRooms = hotel.getRooms().size();
                    break;
                }
            }

            if (totalRooms >= 50) {
                System.out.println("Hotel " + name + " already has 50 rooms, cannot add more");
            } else {
                while ((totalRooms + rooms) > 50) {
                    System.out.println("Adding " + rooms + " rooms will exceed 50 rooms limit per hotel, enter a new number: ");
                    rooms = getInt(scanner);
                }

                if(confirmAction(scanner)) {
                    System.out.println("Enter type of room to add(standard, deluxe, executive): ");
                    String type = scanner.nextLine();
                    for (Hotel hotel : hotels) {
                        if (hotel.getName().equals(name)) {
                            for (int i = 0; i < rooms; i++) {
                                hotel.addRoom(type);
                            }
                            System.out.println(rooms + " rooms added to " + hotel.getName() + ".");
                        } 
                    }
                } else {
                    System.out.println("Rooms not added to " + name + ".");
                }
            }
        } else {
            System.out.println("No hotels exist.");
        }
    }

    /**
     * Method to remove a room from a hotel
     * @param scanner used for obtaining the user's input
     * @param hotels list of hotels
     */
    public void removeRoom(ArrayList<Hotel> hotels, Scanner scanner) {
        if (!hotels.isEmpty()) {
            String name = getHotelInput(hotels, scanner);
            System.out.println("Enter the room number to remove: ");
            int roomNumber = getInt(scanner);
            int totalRooms = 0;
            for (Hotel hotel : hotels) {
                if (hotel.getName().equals(name)) {
                    totalRooms = hotel.getRooms().size();
                    break;
                }
            }
            if (totalRooms == 1) {
                System.out.println("Cannot remove room. There is only 1 room in " + name + ".");
            } else {
                for (Hotel hotel : hotels) {
                    if (hotel.getName().equals(name)) {
                        if(confirmAction(scanner)){
                            if (hotel.removeRoom(roomNumber)) {
                                    System.out.println("Room " + roomNumber + " removed from " + hotel.getName() + ".");

                            } else {
                                System.out.println("Room " + roomNumber + " in " + hotel.getName() + " can't be removed.");
                            }
                        } else {
                            System.out.println("Room " + roomNumber + " in " + hotel.getName() + " not removed.");
                        
                        }
                    }
                }
            }
        } else {
            System.out.println("No hotels exist.");
        }
    }

    /**
     * Simulate Booking menu
     * @param driver to be able to use driver methods
     * @param scanner used for obtaining the user's input
     * @param hotels list of hotels
     */
    public void printSimulateBooking(Driver driver, ArrayList<Hotel> hotels, Scanner scanner) {
        // Simulate booking
        int choice;
        while (true) {
            System.out.println("\n[1] Add Reservation");
            System.out.println("[2] Remove Reservation");
            System.out.println("[3] Print Reservations");
            System.out.println("[4] Print Rooms");
            System.out.println("[5] Back to Main Menu");
            System.err.println("Enter your choice: ");
            choice = getInt(scanner);

            switch (choice) {
                case 1:
                    printHotels(hotels);
                    addReservation(hotels, scanner);
                    break;
                case 2:
                    removeReservation(hotels, scanner);
                    break;
                case 3:
                    printReservations(hotels, scanner);
                    break;
                case 4:
                    printRooms(hotels, scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    printBorder();
            }
        }
    }

    /**
     * Method for adding a reservation
     * @param scanner used for obtaining the user's input
     * @param hotels list of hotels
     */
    public void addReservation(ArrayList<Hotel> hotels, Scanner scanner) {
        if (!hotels.isEmpty()) {
            System.out.println("\nEnter guest name: ");
            String guestName = scanner.nextLine();
            System.out.println("Enter the check-in date: ");
            int checkIn = getInt(scanner);
            System.out.println("Enter the check-out date: ");
            int checkOut = getInt(scanner);

            while (checkIn < 1 || checkIn > 30 || checkOut <= 1 || checkOut > 31 || checkIn >= checkOut) {
                System.out.println("Invalid dates. Please enter valid dates.");
                System.out.println("Enter the check-in date: ");
                checkIn = getInt(scanner);
                System.out.println("Enter the check-out date: ");
                checkOut = getInt(scanner);
            }
    
            int count = 0, hotelCount = 0;
            System.out.println("Here are all the available rooms for each hotel: ");
            for (Hotel hotel : hotels) {
                System.out.println("\nHotel: " + hotel.getName());
                System.out.printf("%-5s || %-20s || %-15s%n", "Room", "Type", "Price");
                for (Room room : hotel.getRooms()) {
                    if (!roomOccupied(hotels, hotel.getName(), room.getRoomNumber(), checkIn, checkOut)) {
                        System.out.printf("%-5d || %-20s || %-15.2f%n", room.getRoomNumber(), room.getRoomType(), room.getPrice());
                        count++;
                        hotelCount++;
                    }
                }
                if (count == 0) {
                    System.out.println("No rooms available for " + hotel.getName());
                }
            }

            if (hotelCount != 0) {
                String hotelName = getHotelInput(hotels, scanner);
                while (!hotelHasAvailableRooms(hotels, hotelName, checkIn, checkOut)) {
                    System.out.println("No available rooms for " + hotelName + " on the given date range. Choose another one");
                    hotelName = getHotelInput(hotels, scanner);
                }

                System.out.println("Enter the room number: ");
                int roomNumber = getInt(scanner);
                while (roomNotExist(hotels, hotelName, roomNumber) || roomOccupied(hotels, hotelName, roomNumber, checkIn, checkOut)) {
                    System.out.println("Room does not exist or is occupied. Enter a valid room number: ");
                    roomNumber = getInt(scanner);
                }

                for (Hotel hotel : hotels) {
                    if (hotel.getName().equals(hotelName)) {
                        for (Room room : hotel.getRooms()) {
                            if (room.getRoomNumber() == roomNumber) {
                                room.addOccupiedRange(checkIn, checkOut);
                                hotel.addReservation(new Reservation(room, guestName, checkIn, checkOut));
                                System.out.println("Reservation added for " + guestName + " at " + hotelName + ".");
                            }
                        }
                    }
                }
                for (Hotel hotel : hotels) {
                    if (hotel.getName().equals(hotelName)) {
                        for (Reservation reservation : hotel.getReservations()) {
                            if (reservation.getGuestName().equals(guestName)) {
                                reservation.updateTotalPrice(hotel.getModifiedDates());
                                System.out.printf("Total Price: %.2f\n", reservation.getTotal());
                                System.out.println("Enter discount code (N/A if none): ");
                                String discountCode = scanner.nextLine();
                                while (!discountCode.equals("N/A") && !reservation.applyDiscount(discountCode, hotel.getModifiedDates())) {
                                    System.out.println("Invalid discount code. Enter a valid one: ");
                                    discountCode = scanner.nextLine();
                                }
                                if (!discountCode.equals("N/A")) {
                                    System.out.println("Total Discounted Price: " + reservation.getTotal());
                                }
                            }
                        }
                    }
                }

            } else {
                System.out.println("No rooms available for booking.");
            }
    
        } else {
            System.out.println("No hotels exist.");
        }
        printBorder();
    }
    
    /**
     * Method to check if a hotel has available rooms
     * @param hotels list of hotels
     * @param hotelName name of the hotel
     * @param checkIn check-in date
     * @param checkOut check-out date
     * @return true if hotel has available rooms, false if not
     */
    private boolean hotelHasAvailableRooms(ArrayList<Hotel> hotels, String hotelName, int checkIn, int checkOut) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(hotelName)) {
                for (Room room : hotel.getRooms()) {
                    if (!roomOccupied(hotels, hotelName, room.getRoomNumber(), checkIn, checkOut)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Method for removing/deleting a reservation
     * @param scanner used for obtaining the user's input
     * @param hotels list of hotels
     */
    public void removeReservation(ArrayList<Hotel> hotels, Scanner scanner) {
        String guestName;
        System.out.println("\nEnter guest name: ");
        guestName = scanner.nextLine();
        for (Hotel hotel : hotels) {
            int count = 0;
            if (!hotel.getReservations().isEmpty()){
                for(Reservation reservation : hotel.getReservations()) {
                    if (reservation.getGuestName().equals(guestName)) {
                        count++;
                    }
                }
                System.out.println("Number of reservations for " + guestName + " at " + hotel.getName() + ": " + count);
            } else {
                System.out.println("No reservations exist for " + guestName + " at " + hotel.getName());
            }
            for (int i = 0; i < hotel.getReservations().size(); i++) {
                if (hotel.getReservations().get(i).getGuestName().equals(guestName)) {
                    System.out.println("Room: " + hotel.getReservations().get(i).getRoom().getRoomNumber());
                    System.out.println("Check-in: " + hotel.getReservations().get(i).getCheckIn());
                    System.out.println("Check-out: " + hotel.getReservations().get(i).getCheckOut());
                    if (confirmAction(scanner)) {
                        Reservation reservationToRemove = hotel.getReservations().get(i);
                        hotel.removeReservation(reservationToRemove);
                        System.out.println("Reservation removed.");
                    }
                }
            }
        }
        
    }

    /**
     * Method for printing out either all the reservations from a specific hotel or across all hotels
     * @param scanner used for obtaining the user's input
     * @param hotels list of hotels
     */
    public void printReservations(ArrayList<Hotel> hotels, Scanner scanner) {
        System.out.println("\nDo you want to display all reservation across all hotels or bookings for a specific hotel? (all/hotel)");
        String choice = scanner.nextLine();
        if (choice.equals("all")) {
            System.out.println("\nDisplaying all reservations across all hotels:");
            for (Hotel hotel : hotels) {
                hotel.formattedReservation();
                printBorder();
            }
        } else {
            System.out.println("\nDisplaying all the reservations for: " + choice);
            for (Hotel hotel : hotels){
                if (hotel.getName().equals(choice)) {
                    hotel.formattedReservation();
                    printBorder();
                }
            }
        }
        
    }


    /**
     * Method for printing out either all the rooms in a specific hotel or across all hotels
     * @param scanner used for obtaining the user's input
     * @param hotels list of hotels
     */
    public void printRooms(ArrayList<Hotel> hotels, Scanner scanner) {
        System.out.println("\nDo you want to display all the rooms across all hotels or rooms for a specific hotel: (all/hotel name)");
        String choice = scanner.nextLine();
        if (choice.equals("all")) {
            System.out.println("\nDisplaying all rooms across all hotels:");
            for (Hotel hotel : hotels) {
                System.out.println("Hotel: " + hotel.getName());
                for (Room room : hotel.getRooms()) {
                    System.out.println("Room " + room.getRoomNumber());
                }
            }
        } else {
            System.out.println("\nDisplaying all rooms for: " + choice);
            for (Hotel hotel : hotels) {
                if (hotel.getName().equals(choice)) {
                    System.out.println("Hotel: " + hotel.getName());
                    for (Room room : hotel.getRooms()) {
                        System.out.println("Room " + room.getRoomNumber());
                    }
                }
            }
            
        }
        printBorder();
        
    }

    /**
     * Method to show the information about a room
     * @param scanner used for obtaining the user's input
     * @param hotels list of hotels
     */
    public void viewRoomInformation(ArrayList<Hotel> hotels, Scanner scanner){
        // room number, price, occupied
        System.out.print("Name of the hotel: ");
        String hotelName = scanner.nextLine();
        System.out.print("Room number: ");
        int roomNumber = getInt(scanner);
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(hotelName)) {
                for (Room room : hotel.getRooms()) {
                    if (room.getRoomNumber() == roomNumber) {
                        System.out.println("Room number: " + room.getRoomNumber());
                        System.out.println("Price: " + room.getPrice());
                        System.out.println("Occupied: " + !room.isAvailable(roomNumber));
                        printBorder();
                    }
                }
            }
        }
        printBorder();
    }

    /**
     * Method to print all the hotels
     * @param hotels list of hotels
     */
    public void printHotels(ArrayList<Hotel> hotels) {
        System.out.println("\nDisplaying all hotels:");
        for (Hotel hotel : hotels) {
            System.out.println("> " + hotel.getName());
        }
    }

    /**
     * Method to get an integer input without bugging out the input
     * @param scanner used for obtaining the user's input
     * @return the integer input
     */
    public static int getInt(Scanner scanner){
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    /**
     * Method to check if a hotel already exists
     * @param hotels list of hotels
     * @param name hotel name to check
     * @return true if hotel name exists, false if not
     */
    public boolean hotelExists(ArrayList<Hotel> hotels, String name) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to check if a room number already exist in a hotel
     * @param hotels list of hotels
     * @param name name of the hotel
     * @param roomNumber room number to check
     * @return false if room exists, true if it does not exist
     */
    public boolean roomNotExist(ArrayList<Hotel> hotels, String name, int roomNumber) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(name)) {
                for (Room room : hotel.getRooms()) {
                    if (room.getRoomNumber() == roomNumber) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Method to check if a room is occupied
     * @param hotels list of hotels
     * @param hotelName name of the hotel
     * @param roomNumber room number to check
     * @param checkIn check-in date
     * @param checkOut check-out date
     * @return true if room is occupied, false if not
     */
    public boolean roomOccupied(ArrayList<Hotel> hotels, String hotelName, int roomNumber, int checkIn, int checkOut) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(hotelName)) {
                for (Room room : hotel.getRooms()) {
                    if (room.getRoomNumber() == roomNumber) {
                        for (Reservation reservation : room.getReservations()) {
                            if (datesOverlap(reservation.getCheckIn(), reservation.getCheckOut(), checkIn, checkOut)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Method to check if two date ranges overlap
     * @param checkIn1 check-in date 1
     * @param checkOut1 check-out date 1
     * @param checkIn2 check-in date 2
     * @param checkOut2 check-out date 2
     * @return true if dates overlap, false if not
     */
    public boolean datesOverlap(int checkIn1, int checkOut1, int checkIn2, int checkOut2) {
        return (checkIn1 < checkOut2 && checkOut1 > checkIn2);
    }

    /**
     * Method that keeps on asking the user for a hotel name till a valid hotel name is provided
     * @param hotels list of hotels
     * @param scanner to get the user's input
     * @return the name of the name of the hotel
     */
    public String getHotelInput(ArrayList<Hotel> hotels, Scanner scanner) {
        System.out.println("\nEnter the name of the hotel: ");
        String name = scanner.nextLine();
        while (!hotelExists(hotels, name)) {
            System.out.print("Hotel does not exist. Enter a valid hotel name: ");
            name = scanner.nextLine();
        }
        return name;
    }

    /**
     * Method to print the border
     * @param scanner used for obtaining the user's input
     * @return true or false depending on the user's input
     
     */
    public boolean confirmAction(Scanner scanner){
        System.out.println("Are you sure you want to continue? (yes/no)");
        String choice = scanner.nextLine();
        if(choice.equals("yes")){
            return true;
        }
        return false;
    }

}
