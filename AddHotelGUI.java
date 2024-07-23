import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionListener;

public class AddHotelGUI {
  JFrame frame = new JFrame();

  private JButton backButton;

  public AddHotelGUI() {
    frame.setSize(500, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setLocationRelativeTo(null);
    frame.setLayout(null);
    frame.setVisible(true);

    backButton = createStyledButton("Back");
    //place the back button at the top left corner of the frame
    backButton.setBounds(10, 10, 50, 30);
    frame.add(backButton);
  }

  private JButton createStyledButton(String text) {
          JButton button = new JButton(text);
          button.setFont(new Font("Arial", Font.BOLD, 8));
          button.setForeground(Color.WHITE);
          button.setBackground(new Color(45, 48, 50));
          button.setFocusPainted(false);
          button.setBorder(BorderFactory.createEtchedBorder());
          return button;
      }

    public JButton getBackButton() {
        return backButton;
    }

    public void setActionListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public void dispose() {
        frame.dispose();
    }





}
