import java.util.ArrayList;

// Model Class
public class HotelModel {
    private ArrayList<Hotel> hotels;
    private ArrayList<Reservation> reservations;

    /**
     * Represents a hotel model that contains a list of hotels and reservations.
     */
    public HotelModel() {
        this.hotels = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    /**
     * Returns the list of hotels.
     *
     * @return the list of hotels
     */
    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    /**
     * Returns the list of reservations in the hotel.
     *
     * @return the list of reservations
     */
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Adds a hotel to the list of hotels.
     *
     * @param hotel the hotel to be added
     */
    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    /**
     * Checks if a hotel name is duplicated in the list of hotels.
     * @param hotelName the name of the hotel to check for duplication
     * @return true if the hotel name is duplicated, false otherwise
     */
    public boolean isHotelNameDuplicated(String hotelName) {
        return hotels.stream().anyMatch(hotel -> hotel.getName().equalsIgnoreCase(hotelName));
    }

    /**
     * Finds a hotel in the list of hotels by its name.
     * 
     * @param hotelName the name of the hotel to search for
     * @return the Hotel object if found, or null if not found
     */
    public Hotel findHotelByName(String hotelName) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equalsIgnoreCase(hotelName)) {
                return hotel;
            }
        }
        return null;
    }

    /**
     * Adds a reservation to the list of reservations.
     *
     * @param reservation the reservation to be added
     */
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    /**
     * Removes a hotel from the list of hotels.
     *
     * @param hotel the hotel to be removed
     */
    public void removeHotel(Hotel hotel) {
        hotels.remove(hotel);
    }

    /**
     * Retrieves and prints the available rooms in the given hotel.
     *
     * @param hotel the hotel object containing the rooms
     */
    public void getAvailableRooms(Hotel hotel) {
        for (Room room : hotel.getRooms()) {
            if (room.isAvailable(room.getRoomNumber())) {
                System.out.println("Room number: " + room.getRoomNumber());
            }
        }
    }

    
}