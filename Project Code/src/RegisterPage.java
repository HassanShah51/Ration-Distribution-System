import javax.swing.*;
import java.awt.*;

public class RegisterPage extends TemplateFrame {
    public RegisterPage() {
        super("User Registration");

        JPanel panel = new JPanel(null);
        panel.setOpaque(false);
        panel.setBounds(600, 300, 480, 540);

        String[] labels = {"Name", "CNIC", "Phone", "City", "Income", "Email", "Password"};
        JTextField[] fields = new JTextField[7];

        for (int i = 0; i < 7; i++) {
            JLabel lbl = new JLabel(labels[i] + ":");
            lbl.setForeground(Color.white);
            lbl.setFont(new Font("Arial", Font.BOLD, 17)); // Increased font size
            lbl.setBounds(20, i * 50, 120, 25);

            fields[i] = new JTextField();
            fields[i].setBounds(150, i * 50, 200, 25);
            fields[i].setForeground(Color.BLACK);
            fields[i].setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

            panel.add(lbl);
            panel.add(fields[i]);
        }

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(160, 370, 140, 40); // Centered button
        panel.add(registerBtn);

        registerBtn.addActionListener(e -> {
            try {
                String name = fields[0].getText().trim();
                String cnic = fields[1].getText().trim();
                String phone = fields[2].getText().trim();
                String city = fields[3].getText().trim();
                String incomeStr = fields[4].getText().trim();
                String email = fields[5].getText().trim();
                String password = fields[6].getText().trim();

                for (int i = 0; i < 7; i++) {
                    if (fields[i].getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, labels[i] + " cannot be empty.");
                        return;
                    }
                }

                if (!cnic.matches("\\d{13}")) {
                    JOptionPane.showMessageDialog(this, "Invalid CNIC. Must be 13 digits.");
                    return;
                }

                if (!phone.matches("\\d{11}")) {
                    JOptionPane.showMessageDialog(this, "Invalid phone number. Must be 11 digits.");
                    return;
                }

                if (!city.equalsIgnoreCase("Lahore") &&
                        !city.equalsIgnoreCase("Karachi") &&
                        !city.equalsIgnoreCase("Islamabad")) {
                    JOptionPane.showMessageDialog(this, "Invalid city. Must be Lahore, Karachi, or Islamabad.");
                    return;
                }

                double income;
                try {
                    income = Double.parseDouble(incomeStr);
                    if (income < 0) {
                        JOptionPane.showMessageDialog(this, "Income must be a positive number.");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Income must be a valid number.");
                    return;
                }

                if (!email.contains("@") || !email.contains(".")) {
                    JOptionPane.showMessageDialog(this, "Invalid email format.");
                    return;
                }

                if (password.length() < 4) {
                    JOptionPane.showMessageDialog(this, "Password must be at least 4 characters long.");
                    return;
                }

                User user = new User(name, cnic, phone, city, income, email, password);

                if (user.isEligible()) {
                    DataStore.addUser(user);
                    JOptionPane.showMessageDialog(this, "Registration successful!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Income not eligible for ration.");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Something went wrong. Please check your input.");
            }
        });

        add(panel);
        setVisible(true);
    }
}






