import javax.swing.*;
import java.awt.*;

public class RequestStatusPage extends TemplateFrame {
    public RequestStatusPage(User user) {
        super("Request Status");
        setLayout(null);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        // Heading moved downward by about 1.5 inches (≈113px)
        JLabel heading = new JLabel("Request Status", SwingConstants.CENTER);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Arial", Font.BOLD, 28));
        heading.setBounds((screen.width - 300) / 2, 333, 300, 40);
        add(heading);

        // Text area moved down accordingly
        JTextArea area = new JTextArea();
        area.setBounds((screen.width - 300) / 2, 393, 300, 100);
        area.setEditable(false);
        area.setBackground(Color.LIGHT_GRAY);
        area.setFont(new Font("Arial", Font.PLAIN, 14));

        Request req = DataStore.getRequest(user.email);
        if (req != null) {
            if ("Approved".equalsIgnoreCase(req.status)) {
                area.setText("City: " + req.city +
                        "\nStatus: " + req.status +
                        "\nYou may collect ration till next 7 days.");
            } else if ("Rejected".equalsIgnoreCase(req.status)) {
                area.setText("City: " + req.city +
                        "\nStatus: " + req.status +
                        "\nReason: " + req.reason);
            } else {
                area.setText("City: " + req.city +
                        "\nStatus: " + req.status);
            }
        } else {
            area.setText("No request found.");
        }

        add(area);
        setVisible(true);
    }
}





