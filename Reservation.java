/**
 * The representation class holds the information of a reservation made by a guest
 */
public class Reservation {
    private String guestName;
    private int checkIn;
    private int checkOut;    
    private double totalPrice;
    private Room room;  

    /**
     * Constructor for the Reservation class
     * @param room the room that the guest is reserving
     * @param guestName the name of the guest making the reservation
     * @param checkIn the day the guest is checking in
     * @param checkOut the day the guest is checking out
     */
    public Reservation(Room room, String guestName, int checkIn, int checkOut) {
        this.room = room;
        this.guestName = guestName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = ((checkOut - checkIn)) * room.getPrice();
    }

    /**
     * Returns the total price of the reservation
     * @return the total price of the reservation
     */
    public double getTotal() {
        return this.totalPrice;
    }

    /**
     * Returns the name of the guest making the reservation
     * @return the name of the guest making the reservation
     */
    public String getGuestName() {
        return this.guestName;
    }

    /**
     * Returns the day the guest is checking in
     * @return the day the guest is checking in
     */
    public int getCheckIn() {
        return this.checkIn;
    }

    /**
     * Returns the day the guest is checking out
     * @return the day the guest is checking out
     */
    public int getCheckOut() {
        return this.checkOut;
    }

    /**
     * Returns the room number of the room the guest is reserving
     * @return the room number of the room the guest is reserving
     */
    public int getRoomNumber(){
        return this.room.getRoomNumber();
    }

    /**
     * Returns the room the guest is reserving
     * @return the room the guest is reserving
     */
    public Room getRoom() {
        return this.room;
    }

}
