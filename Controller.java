import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener, DocumentListener{

  private SystemGUI systemGUI;
  private ManagementSystem managementSystem;
  private AddHotelGUI addHotelGUI;

  public Controller(SystemGUI systemGUI, ManagementSystem managementSystem){
    this.systemGUI = systemGUI;
    this.managementSystem = managementSystem;

    systemGUI.setActionListener(this);
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
    if(e.getSource() == systemGUI.getExitButton()){
      systemGUI.dispose();
    }
    else if(e.getSource() == systemGUI.getAddHotelButton()){
      systemGUI.dispose();
      AddHotelGUI addHotelGUI = new AddHotelGUI();
    }

    if(e.getSource() == addHotelGUI.getBackButton()){
      addHotelGUI.dispose();
      SystemGUI systemGUI = new SystemGUI();
    }
    
  }
  
}
