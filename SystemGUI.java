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

  private JLabel lblPage;

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
    JPanel southPanel = new JPanel();
    southPanel.setLayout(new FlowLayout());
    southPanel.setBackground(Color.decode("#CE2211"));

    btnAddHotel = new JButton("Add Hotel");
    southPanel.add(btnAddHotel);

    btnViewHotel = new JButton("View Hotel");
    southPanel.add(btnViewHotel);

    btnManageHotel = new JButton("Manage Hotel");
    southPanel.add(btnManageHotel);

    add(southPanel, BorderLayout.SOUTH);
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
