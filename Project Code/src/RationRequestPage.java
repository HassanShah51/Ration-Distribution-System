import javax.swing.*;
import java.awt.*;

public class RationRequestPage extends TemplateFrame {
    public RationRequestPage(User user) {
        super("Request Ration");
        setLayout(null);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        // Increase panel size (e.g. width: 340, height: 180)
        int panelWidth = 340;
        int panelHeight = 180;
        int panelX = (screen.width - panelWidth) / 2;
        int panelY = (screen.height - panelHeight) / 2 - 75; // move up by ~75px (half inch)

        JPanel panel = new JPanel(null);
        panel.setOpaque(false);
        panel.setBounds(panelX, panelY, panelWidth, panelHeight);

        // Heading, also moved up by 75 px to align with panel
        JLabel heading = new JLabel("Request for Ration", SwingConstants.CENTER);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Arial", Font.BOLD, 28)); // same as before
        heading.setBounds(panelX - 30, panelY - 80, 360, 40);
        add(heading);

        // Label
        JLabel label = new JLabel("Select City:");
        label.setFont(new Font("Arial", Font.BOLD, 20)); // same as before
        label.setForeground(Color.white);
        label.setBounds(30, 20, 120, 25); // a little wider to fit label fully

        // Combo Box
        JComboBox<String> cities = new JComboBox<>(new String[]{"Lahore", "Karachi", "Islamabad"});
        cities.setBounds(160, 20, 140, 25); // moved right a bit for bigger panel

        // Submit Button, smaller width and height
        JButton submit = new JButton("Submit Request");
        submit.setBounds((panelWidth - 140) / 2, 90, 140, 30); // smaller and placed lower than before

        // Add components to panel
        panel.add(label);
        panel.add(cities);
        panel.add(submit);

        add(panel);

        // Action listener
        submit.addActionListener(e -> {
            String city = (String) cities.getSelectedItem();
            Request req = new Request(user.email, city);
            DataStore.addRequest(req);
            JOptionPane.showMessageDialog(this, "Request submitted to: " + city);
            dispose();
        });

        setVisible(true);
    }
}






