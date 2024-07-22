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
    throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
  }
  
}
