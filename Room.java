    import java.util.ArrayList;

    /**
     * This class represents a room containing the price, status, and room number as its identifier
     */
    public class Room {
        private double price;
        private int roomNumber;
        private ArrayList<Reservation> reservations;
        private String roomType;
        
        /**
         * Constructor for the Room class, sets a default price of 1299.0
         * @param roomNumber amount of roomNumber to be added
         */
        public Room(int roomNumber){
            this.price = 1299.0;
            this.roomNumber = roomNumber;
            this.reservations = new ArrayList<>();
            this.roomType = "standard";
        }

        /**
         * Sets the room type of the room.
         * 
         * @param roomType the new room type to be set
         */
        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        /**
         * Returns the type of the room.
         *
         * @return the room type
         */
        public String getRoomType() {
            return this.roomType;
        }


        /**
         * Adds the checkIn and checkOut dates for the reservation
         * @param checkIn check in date
         * @param checkOut check out date
         */
        public void addOccupiedRange(int checkIn, int checkOut){
            reservations.add(new Reservation(this, "Guest", checkIn, checkOut));
        }

        /**
         * Removes the checkIn and checkOut dates for the resrevation
         * @param checkIn check in date
         * @param checkOut check out date
         */
        public void removeOccupiedRange(int checkIn, int checkOut){
            for (Reservation reservation : reservations) {
                if (reservation.getCheckIn() == checkIn && reservation.getCheckOut() == checkOut) {
                    reservations.remove(reservation);
                    break;
                }
            }
        }

        /**
         * Method tht checks if the room is available
         * @param roomNumer room number to check
         * @return true if its in a reservation, false if not
         */
        public boolean isAvailable(int roomNumer) {
            for (Reservation reservation : reservations) {
                if (reservation.getRoom().getRoomNumber() == roomNumer) {
                    return false;
                }
            }
            return true;
        }

    public boolean isAvailable(int checkIn, int checkOut) {
        for (Reservation reservation : reservations) {
            if (checkIn < reservation.getCheckOut() && checkOut > reservation.getCheckIn()) {
                return false;
            }
        }
        return true;
    }

        /**
         * Sets the price of the room
         * @param newPrice new Price to be assigned
         */
        public void setPrice(double newPrice) {
            this.price = newPrice;
        }

        /**
         * Returns the room number
         * @return the room number
         */
        public int getRoomNumber(){
            return this.roomNumber;
        }

        /**
         * Returns the price of the room
         * @return the price of the room
         */
        public double getPrice(){
            return this.price;
        }

        /**
         * Method that returns the reservations
         * @return reservations
         */
        public ArrayList<Reservation> getReservations() {
            return this.reservations;
        }

        /**
         * method that adds the reservation to the arraylist of reservation
         * @param reservation resrevation to add to thhe list
         */
        public void addReservation(Reservation reservation){
            this.reservations.add(reservation);
        }

        /**
         * method that removes the reservation from the arraylist of reservations
         * @param reservation reservation to be removed from the list
         */
        public void removeReservation(Reservation reservation){
            this.reservations.remove(reservation);
        }



    }
