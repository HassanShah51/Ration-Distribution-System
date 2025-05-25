import javax.swing.*;
import java.awt.*;

public class UserDashboard extends TemplateFrame {
    public UserDashboard(User user) {
        super("User Dashboard");
        setLayout(null);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        // Panel position
        int panelWidth = 300;
        int panelHeight = 150;
        int verticalOffset = 100;

        int panelX = (screen.width - panelWidth) / 2;
        int panelY = ((screen.height - panelHeight) / 2) - verticalOffset;

        JPanel panel = new JPanel(null);
        panel.setOpaque(false);
        panel.setBounds(panelX, panelY, panelWidth, panelHeight);

        JButton request = new JButton("Request Ration");
        request.setFocusPainted(false); // Removes the border/focus ring

        JButton status = new JButton("Check Status");

        // Match main page button style
        request.setBounds(30, 20, 200, 45);
        status.setBounds(30, 80, 200, 45);

        panel.add(request);
        panel.add(status);
        add(panel);

        // Heading
        JLabel heading = new JLabel("User Dashboard");
        heading.setForeground(Color.white);
        heading.setFont(new Font("Arial", Font.BOLD, 28)); // Match main page title
        heading.setBounds(panelX + 5, panelY - 60, 400, 40);
        add(heading);

        // Actions
        request.addActionListener(e -> new RationRequestPage(user));
        status.addActionListener(e -> new RequestStatusPage(user));

        setVisible(true);
    }
}









