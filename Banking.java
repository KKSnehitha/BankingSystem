import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Banking implements ActionListener {
  private JFrame mainFrame;
  private JTextField inputField;
  private JLabel balanceLabel;
  private JLabel msg;
  private long balance = 0;

  public Banking() {
    mainFrame = new JFrame("Simple Bank Application");
    mainFrame.setSize(400, 400);
    mainFrame.setFont(new Font("Arial", Font.BOLD, 18));
    mainFrame.setLayout(new FlowLayout());

    inputField = new JTextField(10);
    balanceLabel = new JLabel("Current balance: " + balance);
    msg = new JLabel("");
    JButton depositButton = new JButton("Deposit");
    JButton withdrawButton = new JButton("Withdraw");

    mainFrame.add(inputField);
    mainFrame.add(depositButton);
    mainFrame.add(withdrawButton);
    mainFrame.add(balanceLabel);
    mainFrame.add(msg);

    depositButton.addActionListener(this);
    withdrawButton.addActionListener(this);

    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      long amount = Long.parseLong(inputField.getText());

      if (e.getActionCommand().equals("Deposit")) {
        balance += amount;
        msg.setText("Credited: " + amount);
      } else {
        if (balance >= amount) {
          balance -= amount;
          msg.setText("Debited: " + amount);
        } else {
          msg.setText("Insufficient balance");
        }
      }

      balanceLabel.setText("Current balance: " + balance);
      inputField.setText("");
    } catch (NumberFormatException ex) {
      msg.setText("Please enter a valid number"); 
    }
  }

  public static void main(String[] args) {
    new Banking();
  }
}
