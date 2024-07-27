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
            viewSpecificRoom();
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

    public void viewSpecificRoom() {
        view.setSearchRoomButtonListener(e -> {
            //view the room number, room type, price, and availability of a selected room
            String hotelName = view.getHotelName();
            int roomNumber = view.getRoomNumber();
            try {
                for (Hotel hotel : hotels) {
                    if (hotel.getName().equalsIgnoreCase(hotelName)) {
                        for (Room room : hotel.getRooms()) {
                            if (room.getRoomNumber() == roomNumber) {
                                view.displayRoomInformation(room.getRoomNumber(), room.getRoomType(), room.getPrice(), room.isAvailable(roomNumber));
                                return;
                            }
                        }
                        JOptionPane.showMessageDialog(view, "Room not found.");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(view, "Hotel not found.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Room number must be a valid integer.");
            }
        });
    }

    public void manageHotel() {
        view.setChangeNameButtonListener(e -> {
            // Logic for changing hotel name
            view.showChangeHotelName();
            changeHotelName();
        });

        view.setAddRoomButtonListener(e -> {
            // Logic for adding room
            view.showAddRoomForm();
            addRoom();
        });

        view.setRemoveRoomButtonListener(e -> {
            // Logic for removing room
            view.showRemoveRoomForm();
            removeRoom();
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
            removeHotel();
        });
    }

    public void changeHotelName() {
        view.setChangeNameButtonListener(e -> {
            // Logic for changing hotel name
            String hotelName = view.getHotelName();
            String newHotelName = view.getNewHotelName();
            for (Hotel hotel : hotels) {
                if (hotel.getName().equalsIgnoreCase(hotelName) && !isHotelNameDuplicated(newHotelName)) {
                    hotel.setName(newHotelName);
                    JOptionPane.showMessageDialog(view, "Hotel name changed successfully.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(view, "Invalid Hotel Name.");
        });
    }

    public void addRoom() {
        //allows the user to add a room to a selected hotel given the number of rooms and type
        view.setAddRoomButtonListener(e -> {
            String hotelName = view.getHotelName();
            String numRoomsText = view.getNumRooms();
            String roomType = view.getNewRoomType();
            try {
            int numRooms = Integer.parseInt(numRoomsText);
            for (Hotel hotel : hotels) {
                if (hotel.getName().equalsIgnoreCase(hotelName)) {
                    int originalNumRooms = hotel.getRooms().size();
                    for (int i = 0; i < numRooms; i++) {
                        hotel.addRoom(roomType);
                    }
                    int newNumRooms = hotel.getRooms().size();
                    if (newNumRooms - originalNumRooms == numRooms) {
                        JOptionPane.showMessageDialog(view, "Room added successfully.");
                    } else {
                        JOptionPane.showMessageDialog(view, "Failed to add room.");
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(view, "Hotel not found.");
            } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Number of rooms must be a valid integer.");
            }
        });
    }

    public void removeRoom() {
        //allows the user to remove a room from a selected hotel given the room number
        view.setRemoveRoomButtonListener(e -> {
            String hotelName = view.getHotelName();
            int roomNumber = view.getRoomNumber();
            for (Hotel hotel : hotels) {
                if (hotel.getName().equalsIgnoreCase(hotelName)) {
                    for (Room room : hotel.getRooms()) {
                        if (room.getRoomNumber() == roomNumber) {
                            hotel.getRooms().remove(room);
                            JOptionPane.showMessageDialog(view, "Room removed successfully.");
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(view, "Room not found.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(view, "Hotel not found.");
        });
    }

    public void removeHotel() {
        //allows the user to remove a hotel given the hotel name
        view.setRemoveHotelButtonListener(e -> {
            String hotelName = view.getHotelName();
            for (Hotel hotel : hotels) {
                if (hotel.getName().equalsIgnoreCase(hotelName)) {
                    hotels.remove(hotel);
                    JOptionPane.showMessageDialog(view, "Hotel removed successfully.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(view, "Hotel not found.");
        });
    }

    public void simulateBooking() {
        view.setAddReservationButtonListener(e -> {
            // Logic for adding reservation
            view.showSimulateBooking();
        });
    }
}
