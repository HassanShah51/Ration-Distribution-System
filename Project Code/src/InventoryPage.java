import javax.swing.*;
import java.awt.*;

public class InventoryPage extends TemplateFrame {
    public InventoryPage() {
        super("Inventory Management");
        setLayout(null);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int panelWidth = 480;
        int panelHeight = 250;
        int panelX = (screen.width - panelWidth) / 2;
        int panelY = (screen.height - panelHeight) / 2;

        // Heading
        JLabel heading = new JLabel("Inventory Management", SwingConstants.CENTER);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Arial", Font.BOLD, 28));
        heading.setBounds(panelX, panelY - 60, panelWidth, 40);
        add(heading);

        // Combo box for cities
        JComboBox<String> cities = new JComboBox<>(new String[]{"Lahore", "Karachi", "Islamabad"});
        cities.setBounds(panelX + 150, panelY + 20, 180, 25);
        cities.setFocusable(false);
        cities.setBorder(null);  // keep combo box borderless

        // Label to show stock
        JLabel stockLabel = new JLabel("Available Stock: ");
        stockLabel.setForeground(Color.white);
        stockLabel.setFont(new Font("Arial", Font.BOLD, 18));
        stockLabel.setBounds(panelX + 150, panelY + 60, 250, 25);

        // Quantity text field - with visible border and opaque background
        JTextField qty = new JTextField();
        qty.setBounds(panelX + 150, panelY + 90, 180, 25);
        qty.setBorder(UIManager.getBorder("TextField.border")); // Restore default border
        qty.setOpaque(true);// visible background
        qty.setBorder(null);
        qty.setForeground(Color.black);
        qty.setFont(new Font("Arial", Font.PLAIN, 16));

        // Update button - with visible border and filled background
        JButton update = new JButton("Add Stock");
        update.setBounds(panelX + 180, panelY + 140, 120, 35);
        update.setFocusPainted(true);
        update.setBorderPainted(true);
        update.setContentAreaFilled(true);
        update.setForeground(Color.black);
        update.setFont(new Font("Arial", Font.BOLD, 16));

        add(cities);
        add(stockLabel);
        add(qty);
        add(update);

        // Update stock label on city selection
        cities.addActionListener(e -> {
            String city = (String) cities.getSelectedItem();
            stockLabel.setText("Available Stock: " + Inventory.getStock(city) + " kg");
        });

        cities.setSelectedIndex(0); // Trigger initial stock update

        update.addActionListener(e -> {
            try {
                String city = (String) cities.getSelectedItem();
                int q = Integer.parseInt(qty.getText());
                Inventory.updateStock(city, q);
                stockLabel.setText("Available Stock: " + Inventory.getStock(city) + " kg");
                JOptionPane.showMessageDialog(this, "Stock updated: " + Inventory.getStock(city) + "kg in " + city);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid quantity.");
            }
        });

        setVisible(true);
    }
}



