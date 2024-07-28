import java.util.ArrayList;

// Model Class
public class HotelModel {
    private ArrayList<Hotel> hotels;
    private ArrayList<Reservation> reservations;

    public HotelModel() {
        this.hotels = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public boolean isHotelNameDuplicated(String hotelName) {
        return hotels.stream().anyMatch(hotel -> hotel.getName().equalsIgnoreCase(hotelName));
    }

    public Hotel findHotelByName(String hotelName) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equalsIgnoreCase(hotelName)) {
                return hotel;
            }
        }
        return null;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void removeHotel(Hotel hotel) {
        hotels.remove(hotel);
    }

    public void getAvailableRooms(Hotel hotel) {
        for (Room room : hotel.getRooms()) {
            if (room.isAvailable(room.getRoomNumber())) {
                System.out.println("Room number: " + room.getRoomNumber());
            }
        }
    }

    
}