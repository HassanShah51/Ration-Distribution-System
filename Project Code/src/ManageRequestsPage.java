import javax.swing.*;
import java.awt.*;

public class ManageRequestsPage extends TemplateFrame {
    public ManageRequestsPage() {
        super("Manage Requests");
        setLayout(null);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int panelWidth = 480;
        int panelHeight = 220;
        int panelX = (screen.width - panelWidth) / 2;
        int panelY = (screen.height - panelHeight) / 2;

        // Heading
        JLabel heading = new JLabel("Manage Requests", SwingConstants.CENTER);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Arial", Font.BOLD, 28));
        heading.setBounds(panelX, panelY - 60, panelWidth, 40);
        add(heading);

        // Combo box for users
        JComboBox<String> users = new JComboBox<>(DataStore.requests.keySet().toArray(new String[0]));
        users.setBounds(panelX + 150, panelY + 20, 180, 25);
        users.setFocusable(false);
        users.setBorder(null);  // keep combo box borderless

        // Reason text field - restore default border and opaque background
        JTextField reason = new JTextField();
        reason.setBounds(panelX + 150, panelY + 60, 180, 25);
        reason.setBorder(UIManager.getBorder("TextField.border"));
        reason.setOpaque(true);
        reason.setBorder(null);
        reason.setForeground(Color.black);  // black text for visibility with border
        reason.setFont(new Font("Arial", Font.PLAIN, 16));
        reason.setBackground(Color.white);  // white background

        // Approve button - with border and filled background
        JButton approve = new JButton("Approve");
        approve.setBounds(panelX + 100, panelY + 110, 100, 35);
        approve.setFocusPainted(true);
        approve.setBorderPainted(true);
        approve.setContentAreaFilled(true);
        approve.setForeground(Color.black);
        approve.setFont(new Font("Arial", Font.BOLD, 16));

        // Reject button - with border and filled background
        JButton reject = new JButton("Reject");
        reject.setBounds(panelX + 240, panelY + 110, 100, 35);
        reject.setFocusPainted(true);
        reject.setBorderPainted(true);
        reject.setContentAreaFilled(true);
        reject.setForeground(Color.black);
        reject.setFont(new Font("Arial", Font.BOLD, 16));

        add(users);
        add(reason);
        add(approve);
        add(reject);

        approve.addActionListener(e -> {
            String email = (String) users.getSelectedItem();
            Request r = DataStore.getRequest(email);
            if (r != null) {
                Inventory.reduceStock(r.city, 10);
                r.approve();
                JOptionPane.showMessageDialog(this, "Request approved. 10kg deducted from " + r.city);
            }
        });

        reject.addActionListener(e -> {
            String email = (String) users.getSelectedItem();
            Request r = DataStore.getRequest(email);
            if (r != null) {
                r.reject(reason.getText());
                JOptionPane.showMessageDialog(this, "Request rejected.");
            }
        });

        setVisible(true);
    }
}



