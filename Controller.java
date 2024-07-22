import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener, DocumentListener{

  private SystemGUI systemGUI;
  private ManagementSystem managementSystem;

  public Controller(SystemGUI systemGUI, ManagementSystem managementSystem){
    this.systemGUI = systemGUI;
    this.managementSystem = managementSystem;

    systemGUI.setActionListener(this);
    systemGUI.setDocumentListener(this);
  }

  @Override
  public void insertUpdate(DocumentEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insertUpdate'");
  }

  @Override
  public void removeUpdate(DocumentEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'removeUpdate'");
  }

  @Override
  public void changedUpdate(DocumentEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'changedUpdate'");
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    if(e.getActionCommand().equals("Add Hotel")){
      // Add Hotel
    }else if(e.getActionCommand().equals("View Hotel")){
      // View Hotel
    }else if(e.getActionCommand().equals("Manage Hotel")){
      // Manage Hotel
    }else if(e.getActionCommand().equals("Simulate Booking")){
      // Simulate Booking
    }else if(e.getActionCommand().equals("Print Hotels")){
      // Print Hotels
    }else if(e.getActionCommand().equals("Exit")){
      // Exit
      System.exit(0);
    }

  }
  
}
