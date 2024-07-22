import javax.swing.*;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.ActionListener;


public class SystemGUI extends JFrame{
  private JButton btnAddHotel;
  private JButton btnViewHotel;
  private JButton btnManageHotel;
  private JButton btnSimBooking;
  private JButton btnPrintHotels;
  private JButton btnExit;

  private JTextField tfName;
  private JTextArea taDescription;
  
  public SystemGUI(){
    super("Hotel Management System");
    setLayout(new BorderLayout());

    init();

    setSize(800, 600);

    setResizable(false);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setVisible(true);
  }

  private void init() {
    JPanel westPanel = new JPanel();
    westPanel.setLayout(new GridLayout(6, 1));
    westPanel.setBackground(Color.decode("#f5f5f5"));

    btnAddHotel = new JButton("Add Hotel");
    westPanel.add(btnAddHotel);

    btnViewHotel = new JButton("View Hotel");
    westPanel.add(btnViewHotel);

    btnManageHotel = new JButton("Manage Hotel");
    westPanel.add(btnManageHotel);

    btnSimBooking = new JButton("Simulate Booking");
    westPanel.add(btnSimBooking);

    btnPrintHotels = new JButton("Print Hotels");
    westPanel.add(btnPrintHotels);

    btnExit = new JButton("Exit");
    westPanel.add(btnExit);

    add(westPanel, BorderLayout.WEST);
  }


  public void setActionListener(ActionListener actionListener){
    btnAddHotel.addActionListener(actionListener);
    btnViewHotel.addActionListener(actionListener);
    btnManageHotel.addActionListener(actionListener);
    btnSimBooking.addActionListener(actionListener);
    btnPrintHotels.addActionListener(actionListener);
    btnExit.addActionListener(actionListener);
  }

  public void setDocumentListener(DocumentListener documentListener){
    tfName.getDocument().addDocumentListener(documentListener);
    taDescription.getDocument().addDocumentListener(documentListener);
  }
}
