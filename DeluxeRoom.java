public class DeluxeRoom extends Room {
    public DeluxeRoom(int roomNumber) {
        super(roomNumber);
        this.setPrice(this.getPrice()*1.2);
        this.setRoomType("deluxe");
    }
}
