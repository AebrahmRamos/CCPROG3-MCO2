public class DeluxeRoom extends Room {
    public DeluxeRoom(int roomNumber, int price) {
        super(roomNumber);
        this.setPrice(price*1.2);
        this.setRoomType("deluxe");
    }
}
