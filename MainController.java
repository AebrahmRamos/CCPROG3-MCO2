import java.util.ArrayList;

import javax.swing.JOptionPane;


// Controller Class
public class MainController {
    private HotelModel model;
    private MainView view;

    public MainController(MainView view, HotelModel model) {
        this.model = model;
        this.view = view;
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
            showReservationForm(model);
        });

        view.setPrintHotelsButtonListener(e -> {
            view.printAllHotels(model);
        });

    }



    public void addHotel() {
        view.setSubmitButtonListener(e -> {
            String hotelName = view.getHotelName();
            String numRoomsText = view.getNumRooms();
            try {
                int numRooms = Integer.parseInt(numRoomsText);
                if (!hotelName.trim().isEmpty() && numRooms >= 1 && numRooms <= 50 && !model.isHotelNameDuplicated(hotelName)) {
                    model.addHotel(new Hotel(hotelName, numRooms));
                    view.displayDefaultCenterPanel();
                } else {
                    JOptionPane.showMessageDialog(view, "Please enter a valid hotel name and number of rooms.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Number of rooms must be a valid integer.");
            }
        });
    }

    public void viewHotel() {
        view.setViewHotelDetailsButtonListener(e -> {
            view.showHotelOverviewForm();
            viewHotelInformation();
        });

        view.setViewSpecificRoomButtonListener(e -> {
            view.showRoomOverviewForm();
            viewSpecificRoom();
        });

        view.setViewReservationButtonListener(e -> {
            view.showReservationsForm();
            showReservations();
        });

        view.setViewNumberOfBookedandAvailableRoomsButtonListener(e -> {
            view.showAvailableRooms();
        });
    }

    public void viewHotelInformation() {
        view.setSearchHotelButtonListener(e -> {
            String hotelName = view.getHotelName();
            Hotel hotel = model.findHotelByName(hotelName);
            if (hotel != null) {
                view.displayHotelInformation(hotel.getName(), hotel.getRooms().size(), hotel.getEarningsPerMonth());
            } else {
                JOptionPane.showMessageDialog(view, "Hotel not found.");
            }
        });
    }

    public void viewSpecificRoom() {
        view.setSearchRoomButtonListener(e -> {
            String hotelName = view.getHotelName();
            int roomNumber = view.getSelectedRoomNumberNonCombo();
            Hotel hotel = model.findHotelByName(hotelName);
            if (hotel != null) {
                Room room = hotel.getRooms().stream().filter(r -> r.getRoomNumber() == roomNumber).findFirst().orElse(null);
                if (room != null) {
                    view.displayRoomInformation(room.getRoomNumber(), room.getRoomType(), room.getPrice(), room.isAvailable(roomNumber));
                } else {
                    JOptionPane.showMessageDialog(view, "Room not found.");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Hotel not found.");
            }
        });
    }


    public void showReservations() {
        //show the reservations of a guest in a hotel displaying the room number, check-in and check-out dates, and the total price of the reservation
        view.setSearchReservationButtonListener(e -> {
            String hotelName = view.getHotelName();
            String guestName = view.getCustomerName();
            Hotel hotel = model.findHotelByName(hotelName);
            if (hotel != null) {
            boolean reservationFound = false;
            for (Reservation reservation : hotel.getReservations()) {
                if (reservation.getGuestName().equalsIgnoreCase(guestName)) {
                view.displayReservationInformation(reservation.getRoomNumber(), reservation.getGuestName() ,reservation.getCheckIn(), reservation.getCheckOut(), reservation.getTotal());
                reservationFound = true;
                }
            }
            if (!reservationFound) {
                JOptionPane.showMessageDialog(view, "No reservations found for the guest.");
            }
            } else {
            JOptionPane.showMessageDialog(view, "Hotel not found.");
            }
        });
    }

    public void manageHotel() {
        view.setChangeNameButtonListener(e -> {
            view.showChangeHotelName();
            changeHotelName();
        });

        view.setAddRoomButtonListener(e -> {
            view.showAddRoomForm();
            addRoom();
        });

        view.setRemoveRoomButtonListener(e -> {
            view.showRemoveRoomForm();
            removeRoom();
        });

        view.setChangePriceButtonListener(e -> {
            view.showChangePriceForm();
            changePrice();
        });

        view.setRemoveReservationButtonListener(e -> {
            view.showRemoveReservationForm();
            removeReservation();
        });

        view.setRemoveHotelButtonListener(e -> {
            view.showRemoveHotelForm();
            removeHotel();
        });

        view.setDatePriceModifierButtonListener(e -> {
            view.showDatePriceModifierForm(model);
            showDatePriceModifier();
        });
    }

    public void showDatePriceModifier() {
        view.setDatePriceModifierButtonListener(e -> {
            String hotelName = view.getSelectedHotelName();
            int startDate = view.getStartDate();
            int endDate = view.getEndDate();
            double rate = view.getRate();
            System.out.println("rate: " + rate);
            Hotel hotel = model.findHotelByName(hotelName);
            if (startDate < 1 || startDate > 31 || endDate < 1 || endDate > 31 || startDate > endDate) {
                JOptionPane.showMessageDialog(view, "Invalid date range.");
                return;
            } else if (rate < 0) {
                JOptionPane.showMessageDialog(view, "Rate must be a positive number.");
                return;
            }
            // System.out.println("hello");
            if (hotel != null) {
                model.findHotelByName(hotelName).addModifiedDates(startDate, endDate, rate);
                JOptionPane.showMessageDialog(view, "Date price modifier set successfully.");
            } else {
                JOptionPane.showMessageDialog(view, "Hotel not found.");
            }
        });
    }


    public void removeReservation() {
        String hotelName = view.getHotelName();
        String guestName = view.getCustomerName();
    
        Hotel hotel = model.findHotelByName(hotelName);
        if (hotel != null) {
            boolean reservationFound = false;
            for (Reservation reservation : hotel.getReservations()) {
                if (reservation.getGuestName().equalsIgnoreCase(guestName)) {
                    hotel.removeReservation(reservation);
                    reservationFound = true;
                    JOptionPane.showMessageDialog(view, "Reservation removed successfully.");
                    break;
                }
            }
            if (!reservationFound) {
                JOptionPane.showMessageDialog(view, "No reservations found for the guest.");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Hotel not found.");
        }
    }

    

    public void changeHotelName() {
        view.setChangeNameButtonListener(e -> {
            String hotelName = view.getHotelName();
            String newHotelName = view.getNewHotelName();
            Hotel hotel = model.findHotelByName(hotelName);
            int confirmation = yesNoOption("Are you sure you want to change the hotel name?", "Change Hotel Name");
            if (hotel != null && !model.isHotelNameDuplicated(newHotelName)) {
                if(confirmation == JOptionPane.NO_OPTION) {
                    return;
                }
                hotel.setName(newHotelName);
                JOptionPane.showMessageDialog(view, "Hotel name changed successfully.");
            } else {
                JOptionPane.showMessageDialog(view, "Invalid Hotel Name.");
            }
        });
    }

    public void addRoom() {
        view.setAddRoomButtonListener(e -> {
            String hotelName = view.getHotelName();
            String numRoomsText = view.getNumRooms();
            String roomType = view.getNewRoomType();
            int confirmation = yesNoOption("Are you sure you want to add a room?", "Add Room");
            try {
                int numRooms = Integer.parseInt(numRoomsText);
                Hotel hotel = model.findHotelByName(hotelName);
                if (hotel != null && hotel.getRooms().size() + numRooms <= 50) {
                    if(confirmation == JOptionPane.NO_OPTION) {
                        return;
                    }
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
                } else {
                    JOptionPane.showMessageDialog(view, "Invalid input.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Number of rooms must be a valid integer.");
            }
        });
    }

    public void removeRoom() {
        view.setRemoveRoomButtonListener(e -> {
            String hotelName = view.getHotelName();
            int roomNumber = view.getRoomNumberNonComboBox();
            Hotel hotel = model.findHotelByName(hotelName);
            int confirmation = yesNoOption("Are you sure you want to remove the room?", "Remove Room");
            if (hotel != null) {
                Room room = hotel.getRooms().stream().filter(r -> r.getRoomNumber() == roomNumber).findFirst().orElse(null);
                if (room != null ) {
                    if(confirmation == JOptionPane.NO_OPTION) {
                        return;
                    }
                    hotel.getRooms().remove(room);
                    JOptionPane.showMessageDialog(view, "Room removed successfully.");
                } else {
                    JOptionPane.showMessageDialog(view, "Room not found.");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Hotel not found.");
            }
        });
    }

    public void removeHotel() {
        view.setRemoveHotelButtonListener(e -> {
            String hotelName = view.getHotelName();
            Hotel hotel = model.findHotelByName(hotelName);
            int confirmation = yesNoOption("Are you sure you want to remove the hotel?", "Remove Hotel");
            if (hotel != null) {
                if(confirmation == JOptionPane.NO_OPTION) {
                    return;
                }
                model.removeHotel(hotel);
                JOptionPane.showMessageDialog(view, "Hotel removed successfully.");
            } else {
                JOptionPane.showMessageDialog(view, "Hotel not found.");
            }
        });
    }

    public void changePrice() {
        view.setChangePriceButtonListener(e -> {
            String hotelName = view.getHotelName();
            int roomNumber = view.getRoomNumberNonComboBox();
            String newPriceText = view.getNewPrice();
            int confirmation = yesNoOption("Are you sure you want to change the price?", "Change Price");
            try {
                double newPrice = Double.parseDouble(newPriceText);
                Hotel hotel = model.findHotelByName(hotelName);
                if (hotel != null) {
                    
                    Room room = hotel.getRooms().stream().filter(r -> r.getRoomNumber() == roomNumber).findFirst().orElse(null);
                    if (room != null && newPrice > 0) {
                        // check if there are no current reservations in the entire hotel
                        boolean noReservations = hotel.getReservations().isEmpty();
                        if (!noReservations) {
                            JOptionPane.showMessageDialog(view, "Cannot change price. There are reservations in the hotel.");
                            return;
                        }
                        if(confirmation == JOptionPane.NO_OPTION) {
                            return;
                        }
                        room.setPrice(newPrice);
                        JOptionPane.showMessageDialog(view, "Price changed successfully.");
                    } else {
                        JOptionPane.showMessageDialog(view, "Error changing price.");
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Hotel not found.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(view, "Price must be a valid number.");
            }
        });
    }

    private void showReservationForm(HotelModel model) {
        ArrayList<String> hotelNames = new ArrayList<>();
        for (Hotel hotel : model.getHotels()) {
            hotelNames.add(hotel.getName());
        }
        view.showBooking(hotelNames, model);
        view.setAddReservationButtonListener(e -> addReservation(model.getHotels()));
    }

    private void addReservation(ArrayList<Hotel> hotels) {
        String hotelName = view.getHotelName();
        String guestName = view.getCustomerName();
        int roomNumber = view.getRoomNumber();
        int checkIn = view.getCheckIn();
        int checkOut = view.getCheckOut();
        String discountCode;
        
        Hotel hotel = hotels.stream().filter(h -> h.getName().equalsIgnoreCase(hotelName)).findFirst().orElse(null);
        if (hotel != null) {
            Room room = hotel.getRooms().stream().filter(r -> r.getRoomNumber() == roomNumber).findFirst().orElse(null);
            if (room != null) {
                if (room.isAvailable(checkIn, checkOut)) {
                    Reservation reservation = new Reservation(room, guestName, checkIn, checkOut);
                    
                    reservation.updateTotalPrice(hotel.getModifiedDates());
                    //apply discount
                    discountCode = view.getDiscountCode();
                    // boolean discountApplied = reservation.applyDiscount(discountCode, hotel.getModifiedDates());

                    // apply the discount code with the updated total price
                    reservation.discountApplication(discountCode, hotel.getModifiedDates(), reservation);

                    //use the discountApplication method

                    
                    // Update total price based on modified dates
                    
                    hotel.addReservation(reservation);
                    room.addReservation(reservation);

                    JOptionPane.showMessageDialog(view, "Reservation added successfully.");
                    
                } else {
                    JOptionPane.showMessageDialog(view, "Room is not available for the selected dates.");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Room not found.");
            }
        } else {
            JOptionPane.showMessageDialog(view, "Hotel not found.");
        }
    }

    public int yesNoOption(String message, String title) {
        int confirmation = JOptionPane.showConfirmDialog(view, message, title, JOptionPane.YES_NO_OPTION);
        return confirmation;
    }
}




