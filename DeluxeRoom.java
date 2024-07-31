/**
 * The DeluxeRoom class represents a deluxe room in a hotel.
 * It extends the Room class and adds additional functionality specific to deluxe rooms.
 */
public class DeluxeRoom extends Room {
    /**
     * Constructs a DeluxeRoom object with the specified room number.
     * The price of the deluxe room is set to 20% higher than the base price of a regular room.
     * The room type is set to "deluxe".
     *
     * @param roomNumber the room number of the deluxe room
     */
    public DeluxeRoom(int roomNumber) {
        super(roomNumber);
        this.setPrice(this.getPrice() * 1.2);
        this.setRoomType("deluxe");
    }
}
