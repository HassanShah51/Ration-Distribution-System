import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends TemplateFrame {
    public AdminDashboard() {
        super("Admin Dashboard");
        setLayout(null);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        int panelWidth = 300;
        int panelHeight = 150;
        int verticalOffset = 100;

        int panelX = (screen.width - panelWidth) / 2;
        int panelY = ((screen.height - panelHeight) / 2) - verticalOffset;

        // Panel to hold buttons (optional, can add buttons directly too)
        JPanel panel = new JPanel(null);
        panel.setOpaque(false);
        panel.setBounds(panelX, panelY, panelWidth, panelHeight);

        JButton inventory = new JButton("Manage Inventory");
        JButton manageReq = new JButton("Manage Requests");

        inventory.setBounds(30, 20, 200, 40);
        manageReq.setBounds(30, 80, 200, 40);

        // Remove button borders and outlines for flat look
        inventory.setFocusPainted(false);
        inventory.setBorderPainted(false);
        manageReq.setFocusPainted(false);
        manageReq.setBorderPainted(false);

        panel.add(inventory);
        panel.add(manageReq);
        add(panel);

        // Heading with same style as UserDashboard
        JLabel heading = new JLabel("Admin Dashboard", SwingConstants.CENTER);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Arial", Font.BOLD, 28));
        heading.setBounds(panelX, panelY - 50, panelWidth, 40);
        add(heading);

        inventory.addActionListener(e -> new InventoryPage());
        manageReq.addActionListener(e -> new ManageRequestsPage());

        setVisible(true);
    }
}





