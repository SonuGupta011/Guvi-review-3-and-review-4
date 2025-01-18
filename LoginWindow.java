import javax.swing.*;
import java.awt.event.*;

public class LoginWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        JPanel panel = new JPanel();
        frame.setSize(300, 200);

        JLabel userLabel = new JLabel("Username");
        JTextField userText = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordText = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                char[] password = passwordText.getPassword();
                // Validate the login credentials
                System.out.println("Username: " + username);
                System.out.println("Password: " + new String(password));
            }
        });

        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(loginButton);
        
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
