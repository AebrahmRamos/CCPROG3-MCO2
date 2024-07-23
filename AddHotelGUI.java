import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionListener;

public class AddHotelGUI {
  JFrame frame = new JFrame();
  JLabel label = new JLabel("ADDED HOTEL");

  private JButton backButton;

  public AddHotelGUI() {
    label.setBounds(20, 50, 100, 30);
    label.setFont(new Font(null, Font.PLAIN, 25));

    frame.setSize(500, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setLocationRelativeTo(null);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.add(label);

    backButton = createStyledButton("Back");
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
