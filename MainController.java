import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MainController {
    private ManagementModel model;
    private ArrayList<Hotel> hotels = new ArrayList<>();
    private MainView view;

    public MainController(MainView view, ManagementModel model) {
        this.view = view;
        this.model = model;
        init();
    }

    public void init() {
        view.setAddHotelButtonListener(e -> {
            view.showAddHotelForm();
            addHotel();
        });

        view.setExitButtonListener(e -> System.exit(0));

        view.setViewHotelButtonListener(e -> {
            view.showViewHotelOptions();
            viewHotel();
        });

        view.setManageHotelButtonListener(e -> {
            view.showManageHotel();
            manageHotel();
        });

        view.setSimulateBookingButtonListener(e -> {
            view.showSimulateBooking();
            simulateBooking();
        });
    }

    public void addHotel() {
        view.setSubmitButtonListener(e -> {
            String hotelName = view.getHotelName();
            String numRoomsText = view.getNumRooms();
            try {
                int numRooms = Integer.parseInt(numRoomsText);
                if (!hotelName.trim().isEmpty() && numRooms > 1 && numRooms <= 50 && !isHotelNameDuplicated(hotelName)) {
                    hotels.add(new Hotel(hotelName, numRooms));
                    view.displayDefaultCenterPanel();
                    updateDisplay();
                } else {
                    JOptionPane.showMessageDialog(view, "Please enter a valid hotel name and number of rooms.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Number of rooms must be a valid integer.");
            }
        });
    }

    private boolean isHotelNameDuplicated(String hotelName) {
        return hotels.stream().anyMatch(hotel -> hotel.getName().equalsIgnoreCase(hotelName));
    }

    public void viewHotel() {
        view.setViewHotelDetailsButtonListener(e -> {
            // Logic for viewing hotel details
            
        });

        view.setViewSpecificRoomButtonListener(e -> {
            // Logic for viewing specific room details
        });

        view.setViewReservationButtonListener(e -> {
            // Logic for viewing reservations
        });

        view.setViewNumberOfBookedandAvailableRoomsButtonListener(e -> {
            // Logic for viewing booked and available rooms
        });
    }

    public void manageHotel() {
        view.setChangeNameButtonListener(e -> {
            // Logic for changing hotel name
        });

        view.setAddRoomButtonListener(e -> {
            // Logic for adding room
        });

        view.setRemoveRoomButtonListener(e -> {
            // Logic for removing room
        });

        view.setChangePriceButtonListener(e -> {
            // Logic for changing room price
        });

        view.setRemoveReservationButtonListener(e -> {
            // Logic for removing reservation
        });

        view.setRemoveHotelButtonListener(e -> {
            // Logic for removing hotel
        });
    }

    public void simulateBooking() {
        view.setAddReservationButtonListener(e -> {
            // Logic for adding reservation
        });
    }

    private Hotel findHotelByName(String hotelName) {
        return hotels.stream().filter(hotel -> hotel.getName().equalsIgnoreCase(hotelName)).findFirst().orElse(null);
    }

    private void updateDisplay() {
        StringBuilder displayText = new StringBuilder();
        for (Hotel hotel : hotels) {
            displayText.append("Hotel: ").append(hotel.getName()).append("\n");
            for (Room room : hotel.getRooms()) {
                displayText.append("  Room ").append(room.getRoomNumber()).append(": ").append(room.getRoomType()).append("\n");
            }
            displayText.append("\n");
        }
        view.display(displayText.toString());
    }
}
