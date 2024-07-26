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
            view.showHotelOverviewForm();
            viewHotelInformation();
                       
        });

        view.setViewSpecificRoomButtonListener(e -> {
            // Logic for viewing specific room details
            view.showRoomOverviewForm();
        });

        view.setViewReservationButtonListener(e -> {
            // Logic for viewing reservations
            view.showReservationsForm();
        });

        view.setViewNumberOfBookedandAvailableRoomsButtonListener(e -> {
            // Logic for viewing booked and available rooms
            view.showAvailableRooms();
        });
    }

    public void viewHotelInformation() {
        view.setSearchHotelButtonListener(e -> {
            //view the hotel name, number of rooms, and earnings per month of a selected hotel
            String hotelName = view.getHotelName();
            for (Hotel hotel : hotels) {
                if (hotel.getName().equalsIgnoreCase(hotelName)) {
                    view.displayHotelInformation(hotel.getName(), hotel.getRooms().size(), hotel.getEarningsPerMonth());
                    return;
                }
            }
            JOptionPane.showMessageDialog(view, "Hotel not found.");


        });
    }

    public void manageHotel() {
        view.setChangeNameButtonListener(e -> {
            // Logic for changing hotel name
            view.showChangeHotelName();
        });

        view.setAddRoomButtonListener(e -> {
            // Logic for adding room
            view.showAddRoomForm();
        });

        view.setRemoveRoomButtonListener(e -> {
            // Logic for removing room
            view.showRemoveRoomForm();
        });

        view.setChangePriceButtonListener(e -> {
            // Logic for changing room price
            view.showChangePriceForm();
        });

        view.setRemoveReservationButtonListener(e -> {
            // Logic for removing reservation
            view.showRemoveReservationForm();
        });

        view.setRemoveHotelButtonListener(e -> {
            // Logic for removing hotel
            view.showRemoveHotelForm();
        });
    }

    public void simulateBooking() {
        view.setAddReservationButtonListener(e -> {
            // Logic for adding reservation
            view.showSimulateBooking();
        });
    }
}
