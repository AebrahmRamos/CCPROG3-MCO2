/**
 * The `ExecutiveRoom` class represents an executive room in a hotel.
 * It extends the `Room` class and adds additional functionality specific to executive rooms.
 */
public class ExecutiveRoom extends Room {
    /**
     * Constructs a new `ExecutiveRoom` object with the specified room number.
     * The price of the room is set to 35% higher than the base price of a regular room.
     * The room type is set to "executive".
     *
     * @param roomNumber the room number of the executive room
     */
    public ExecutiveRoom(int roomNumber) {
        super(roomNumber);
        this.setPrice(this.getPrice() * 1.35);
        this.setRoomType("executive");
    }
}
