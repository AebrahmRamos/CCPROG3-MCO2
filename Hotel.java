import java.util.*;


/**
 * This class represents a hotel containing the classes rooms and reservations
 */
public class Hotel {
    private String name;
    private ArrayList<Reservation> reservations;
    private ArrayList<Room> rooms;
    private Map<Integer, Double> modifiedDates;
    // private double earningsPerMonth;

    /**
     * Hotel Constructor where the amount of rooms is already provided
     * @param name the name of the hotel
     * @param rooms the amount of rooms in the hotel
     */
    public Hotel(String name, int rooms){
        int roomCounter;
        this.name = name;
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
        for(roomCounter = 0; roomCounter < rooms; roomCounter++){
            this.rooms.add(new Room(this.rooms.size()+1));
        }
        // this.earningsPerMonth = 0;
        this.modifiedDates = new HashMap<>();
        for (int i = 1; i <= 31; i++) {
            modifiedDates.put(i, 1.0);
        }
    }
    
    /**
     * Hotel Constructor where the amount of rooms is not provided and is automatically assigned 1 room
     * @param name the name of the hotel
     */
    public Hotel(String name){
        this.name = name;
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.rooms.add(new Room(1));
        this.modifiedDates = new HashMap<>();
        for (int i = 1; i <= 31; i++) {
            modifiedDates.put(i, 1.0);
        }
    }

    /**
     * Returns the name of the hotel
     * @return the name of the hotel
     */
    public String getName(){
        return this.name;
    }

    /**
     * Returns the rooms of the hotel
     * @return the rooms of the hotel
     */
    public ArrayList<Room> getRooms(){
        return this.rooms;
    }

    /**
     * Returns the reservations of the hotel
     * @return the reservations of the hotel
     */
    public ArrayList<Reservation> getReservations(){
        return this.reservations;
    }

    public void addReservation(Reservation reservation){
        this.reservations.add(reservation);
    }

    /**
     * Adds a room to the hotel
     */
    public void addRoom(String type){
        if (type.equals("standard")) {
            rooms.add(new Room(rooms.size()+1));
        } else if (type.equals("executive")) {
            rooms.add(new ExecutiveRoom(rooms.size()+1));
        } else if (type.equals("deluxe")) {
            rooms.add(new DeluxeRoom(rooms.size()+1));
        }
    }
    
    /**
     * Sets the name of the hotel
     *
     * @param name the new name of the hotel
     */
    public void setName(String name){
        this.name=name;
    }


    /**
     * Removes a room from the hotel
     * @param roomNumber the room number to be removed
     * @return true if successful, false if the room is occupied
     */
    public boolean removeRoom(int roomNumber){
        for (Room room : rooms){
            if (room.getRoomNumber() == roomNumber) {
                if(room.getReservations().size() == 0){
                    rooms.remove(room);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns the earnings per month
     * @return the earnings per month
     */
    public double getEarningsPerMonth(){
        double earnings = 0;
        for(Reservation reservation : reservations){
            earnings += reservation.getTotal();
        }
        return earnings;
    }

    /**
     * Returns the number of booked rooms in the given date
     * @param date the date to be checked
     * @return the number of booked rooms
     */
    public int numberBookedRooms(int date){
        int bookedRooms = 0;
        for (Room room : rooms) {
            if (!room.isAvailable(date)) {
                bookedRooms++;
            }
        }
        return bookedRooms;
    }

     /**
      * Returns the number of available rooms
      * @return the number of available rooms
      */
     public int numberAvailableRooms(){
         int availableRooms = 0;
         for(Room room : rooms){
             if(room.isAvailable(availableRooms)){
                 availableRooms++;
             }
         }
         return availableRooms;
     }

    /**
     * Updates the price per night of the rooms
     * @param price new price to set for each rooms of the hotel
     */
    public void setBasePrice(double price){
        for(Room room : rooms){
            room.setPrice(price);
        }
    }

    /**
     * Removes the reservation from the hotel
     * @param reservation  the reservation to be removed
     */
    public void removeReservation(Reservation reservation) {
        Room room = reservation.getRoom();
        room.removeOccupiedRange(reservation.getCheckIn(), reservation.getCheckOut());
        reservations.remove(reservation);
    }  

    /**
     * Method for outputting the reservation in a formatted way
     * @param hotel list of hotels
     */
    public void formattedReservation() {
        System.out.println("Hotel: " + getName());
        System.out.printf("%-5s | %-10s | %-8s | %-9s% | %-10s%n", "Room", "Guest Name", "Check-in", "Check-out", "Room Type");
        printBorder();
        for (Reservation reservation : getReservations()) {
            System.out.printf("%-5d | %-10s | %-8d | %-9d% | %-10s%n",
                reservation.getRoom().getRoomNumber(),
                reservation.getGuestName(),
                reservation.getCheckIn(),
                reservation.getCheckOut(),
                reservation.getRoom().getRoomType()
                );
        }
    }

    /**
     * Prints out border for styling
     */
    public void printBorder(){
        System.out.println("\n--------------------------------------------------\n");
    }


    public void addModifiedDates(Scanner scanner){
        int start, end;
        double rate;

        do {
            System.out.println("Enter the start date: ");
            start = scanner.nextInt();
            System.out.println("Enter the end date: ");
            end = scanner.nextInt();
            System.out.println("Enter the rate: ");
            rate = scanner.nextDouble();
        } while (start < 1 || start > 31 || end < 1 || end > 31 || rate < 0.5 || rate > 1.5 || start > end || start == end);
        
        for (int i = start; i <= end; i++) {
            this.modifiedDates.put(i, rate);
            System.out.println("Date " + i + " has been updated to " + rate);
        }
    }

    public void addModifiedDates(int start, int end, double rate){
        for (int i = start; i <= end; i++) {
            this.modifiedDates.put(i, rate);
            System.out.println("Date " + i + " has been updated to " + rate);
        }
    }

    public Map<Integer, Double> getModifiedDates(){
        return modifiedDates;
    }

    public List<Integer> getRoomNumberOnType(String type) {
        List<Integer> roomNumbers = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getRoomType().equals(type)) {
                roomNumbers.add(room.getRoomNumber());
            }
        }
        return roomNumbers;
    }
}
