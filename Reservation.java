import java.util.*;

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


    public boolean applyDiscount(String discountCode, Map<Integer, Double> modifiedDates) {
        if (discountCode.equals("I_WORK_HERE")) {
            this.totalPrice *= 0.9;
        } else if (discountCode.equals("STAY4_GET1")) {
            if ((checkOut - checkIn) >= 5) {
                totalPrice = 0;
                for (int i = checkIn+1; i < checkOut; i++) {
                    totalPrice += room.getPrice() * modifiedDates.get(i);
                }
                return true;
            } 
        } else if (discountCode.equals("PAYDAY")){
            if (checkIn <= 15 && checkOut > 15 || checkIn <= 30 && checkOut > 30) {
                this.totalPrice *= 0.93;
                return true;
            } 
        } 
        return false;
    }

    public void updateTotalPrice(Map<Integer, Double> modifiedDates) {
        totalPrice = 0;
        for (int i = checkIn; i < checkOut; i++) {
            System.out.println("\n i: " + i + " price: " + room.getPrice() + " modifiedDates: " + modifiedDates.get(i+1));
            totalPrice += room.getPrice() * modifiedDates.get(i+1);
        }
    }

}
