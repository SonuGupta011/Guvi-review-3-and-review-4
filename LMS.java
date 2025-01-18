import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LMS {
    private JFrame frame;
    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lms_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        LMS window = new LMS();
        window.frame.setVisible(true);
    }

    public LMS() {
        frame = new JFrame("Online Learning Management System");
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                authenticateUser();
            }
        });

        registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);
    }

    private void authenticateUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(frame, "Login Successful!");
                // Navigate to dashboard or courses screen
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Username or Password!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Database Error!");
        }
    }

    private void registerUser() {
        // Code for registration (could add a new user to the database)
    }
}
