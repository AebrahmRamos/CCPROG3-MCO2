// HotelView.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class SystemGUI extends JFrame{
    private JButton addHotelButton;
    private JButton viewHotelButton;
    private JButton manageHotelButton;
    private JButton simulateBookingButton;
    private JButton printHotelsButton;
    private JButton exitButton;

    public SystemGUI() {
        // Set frame properties
        setTitle("Hotel Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create buttons
        addHotelButton = createStyledButton("Add Hotel");
        viewHotelButton = createStyledButton("View Hotel");
        manageHotelButton = createStyledButton("Manage Hotel");
        simulateBookingButton = createStyledButton("Simulate Booking");
        printHotelsButton = createStyledButton("Print Hotels");
        exitButton = createStyledButton("Exit");

        // Initialize the frame
        init();

        // Make frame visible
        setVisible(true);
      }
      
    public void init() {

      // Create Header Panel
      JPanel headerPanel = new JPanel();
      headerPanel.setLayout(new FlowLayout());
      headerPanel.setBackground(new Color(45, 48, 50));
      headerPanel.setPreferredSize(new Dimension(500, 50));
      
      JLabel headerLabel = new JLabel("Hotel Management System");
      headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
      headerLabel.setForeground(Color.WHITE);
      headerPanel.add(headerLabel);
      headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      add(headerPanel, BorderLayout.NORTH);

      // Create panel and layout
      JPanel menuPanel = new JPanel();
      menuPanel.setLayout(new GridLayout(3, 2, 15, 15));
      menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      menuPanel.setBackground(Color.LIGHT_GRAY); // Set a background color
      
      // Add buttons to the menuPanel
      menuPanel.add(addHotelButton);
      menuPanel.add(viewHotelButton);
      menuPanel.add(manageHotelButton);
      menuPanel.add(simulateBookingButton);
      menuPanel.add(printHotelsButton);
      menuPanel.add(exitButton);

      // Add menuPanel to the frame
      add(menuPanel, BorderLayout.CENTER);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(45, 48, 50));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEtchedBorder());
        return button;
    }

    public void setActionListener(ActionListener actionListener) {
        addHotelButton.addActionListener(actionListener);
        viewHotelButton.addActionListener(actionListener);
        manageHotelButton.addActionListener(actionListener);
        simulateBookingButton.addActionListener(actionListener);
        printHotelsButton.addActionListener(actionListener);
        exitButton.addActionListener(actionListener);
    }

    public JButton getAddHotelButton() {
        return addHotelButton;
    }

    public JButton getViewHotelButton() {
        return viewHotelButton;
    }

    public JButton getManageHotelButton() {
        return manageHotelButton;
    }

    public JButton getSimulateBookingButton() {
        return simulateBookingButton;
    }

    public JButton getPrintHotelsButton() {
        return printHotelsButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
}
