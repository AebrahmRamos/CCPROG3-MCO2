public class ExecutiveRoom extends Room {
    public ExecutiveRoom(int roomNumber, int price) {
        super(roomNumber);
        this.setPrice(price*1.35);
        this.setRoomType("executive");
    }
}
