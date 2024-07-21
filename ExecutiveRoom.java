public class ExecutiveRoom extends Room {
    public ExecutiveRoom(int roomNumber) {
        super(roomNumber);
        this.setPrice(this.getPrice()*1.35);
        this.setRoomType("executive");
    }
}
