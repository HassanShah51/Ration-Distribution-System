import javax.swing.*;
import java.awt.*;

public class LoginPage extends TemplateFrame {
    public LoginPage(boolean isAdmin) {
        super(isAdmin ? "Admin Login" : "User Login");

        JPanel panel = new JPanel(null);
        panel.setOpaque(false);
        panel.setBounds(600, 300, 480, 300);

        JLabel userLabel = new JLabel("Email/Username:");
        userLabel.setForeground(Color.white);
        userLabel.setFont(new Font("Arial", Font.BOLD, 17));
        userLabel.setBounds(20, 20, 130, 25);

        JTextField userField = new JTextField();
        userField.setBounds(160, 20, 200, 25);
        userField.setForeground(Color.BLACK);
        userField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.white);
        passLabel.setFont(new Font("Arial", Font.BOLD, 17));
        passLabel.setBounds(20, 60, 130, 25);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(160, 60, 200, 25);
        passField.setForeground(Color.BLACK);
        passField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        JButton login = new JButton("Login");
        login.setBounds(160, 110, 140, 40); // Centered and sized like RegisterPage button

        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(login);

        login.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if (isAdmin) {
                Admin a = DataStore.findAdmin(user, pass);
                if (a != null) {
                    JOptionPane.showMessageDialog(this, "Admin Login Successful");
                    new AdminDashboard();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid admin credentials");
                }
            } else {
                User u = DataStore.findUser(user, pass);
                if (u != null) {
                    JOptionPane.showMessageDialog(this, "User Login Successful");
                    new UserDashboard(u);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid user credentials");
                }
            }
        });

        add(panel);
        setVisible(true);
    }
}


