import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MainController {
    private ArrayList<Hotel> hotels;
    private MainView view;

    public MainController(MainView view) {
        this.view = view;
        this.hotels = new ArrayList<>();

        this.view.setAddHotelButtonListener(new AddHotelListener());
        this.view.setViewHotelButtonListener(new ViewHotelListener());
        this.view.setManageHotelButtonListener(new ManageHotelListener());
        this.view.setSimulateBookingButtonListener(new SimulateBookingListener());
        this.view.setExitButtonListener(new ExitListener());

    }

    private boolean isHotelNameDuplicated(String hotelName) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equalsIgnoreCase(hotelName)) {
                return true;
            }
        }
        return false;
    }

    class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class AddHotelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.showAddHotelForm();
            view.setSubmitButtonListener(new SubmitHotelListener());
        }
    }

    class SubmitHotelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
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
        }
    }

    class ViewHotelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.showViewHotelOptions();
            view.setViewHotelDetailsButtonListener(new ViewHotelDetailsListener());
            view.setViewSpecificRoomButtonListener(new ViewSpecificRoomListener());
            view.setViewReservationButtonListener(new ViewReservationListener());
            view.setViewNumberOfBookedandAvailableRoomsButtonListener(new ViewBookedAvailableRoomsListener());
        }
    }

    class ViewHotelDetailsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Logic for viewing hotel details
        }
    }

    class ViewSpecificRoomListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Logic for viewing specific room details
        }
    }

    class ViewReservationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Logic for viewing reservations
        }
    }

    class ViewBookedAvailableRoomsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Logic for viewing booked and available rooms
        }
    }

    private Hotel findHotelByName(String hotelName) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equalsIgnoreCase(hotelName)) {
                return hotel;
            }
        }
        return null;
    }

    class ManageHotelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.showManageHotel();
            view.setChangeNameButtonListener(new ChangeNameListener());
            view.setAddRoomButtonListener(new AddRoomListener());
            view.setRemoveRoomButtonListener(new RemoveRoomListener());
            view.setChangePriceButtonListener(new ChangePriceListener());
            view.setRemoveReservationButtonListener(new RemoveReservationListener());
            view.setRemoveHotelButtonListener(new RemoveHotelListener());
        }
    }

    class ChangeNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Logic for changing hotel name
        }
    }

    class AddRoomListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Logic for adding room
        }
    }

    class RemoveRoomListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Logic for removing room
        }
    }

    class ChangePriceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Logic for changing room price
        }
    }

    class RemoveReservationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Logic for removing reservation
        }
    }

    class RemoveHotelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String hotelName = view.getHotelName();
            Hotel hotel = findHotelByName(hotelName);
            if (hotel != null) {
                hotels.remove(hotel);
                updateDisplay();
            } else {
                JOptionPane.showMessageDialog(view, "Hotel not found.");
            }
        }
    }

    class SimulateBookingListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.showSimulateBooking();
            view.setAddReservationButtonListener(new AddReservationListener());
        }
    }

    class AddReservationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Logic for adding reservation
        }
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
