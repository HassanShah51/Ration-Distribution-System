import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Digital Ration Distribution System");
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);

            // Background image
            JLabel background = new JLabel(new ImageIcon("FINAL.png"));
            background.setBounds(0, 0, frame.getWidth(), frame.getHeight());
            frame.setContentPane(background);
            background.setLayout(null);

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            // Main Title
            JLabel mainTitle = new JLabel("Digital Ration Distribution System", SwingConstants.CENTER);
            mainTitle.setFont(new Font("Arial", Font.BOLD, 28));
            mainTitle.setForeground (new Color(0x4B2E1A));
            mainTitle.setBounds((screenSize.width - 600) / 2, 100, 600, 50);
            background.add(mainTitle);

            
            JLabel welcome = new JLabel("Welcome", SwingConstants.CENTER);
            welcome.setFont(new Font("Arial", Font.BOLD, 22));
            welcome.setForeground (Color.white);
            welcome.setBounds((screenSize.width - 300) / 2, 325, 300, 40);
            background.add(welcome);

            // Panel for buttons (moved further down)
            JPanel panel = new JPanel(null);
            panel.setOpaque(false);
            panel.setBounds((screenSize.width - 300) / 2, 385, 300, 200);

            Font buttonFont = new Font("Arial", Font.PLAIN, 16);

            JButton userLogin = new JButton("User Login");
            userLogin.setFont(buttonFont);
            userLogin.setFocusPainted(false);
            userLogin.setBorderPainted(false);

            JButton register = new JButton("Register");
            register.setFont(buttonFont);
            register.setFocusPainted(false);
            register.setBorderPainted(false);

            JButton adminLogin = new JButton("Admin Login");
            adminLogin.setFont(buttonFont);
            adminLogin.setFocusPainted(false);
            adminLogin.setBorderPainted(false);

            userLogin.setBounds(80, 10, 140, 40);
            register.setBounds(80, 70, 140, 40);
            adminLogin.setBounds(80, 130, 140, 40);

            panel.add(userLogin);
            panel.add(register);
            panel.add(adminLogin);

            background.add(panel);

            userLogin.addActionListener(e -> new LoginPage(false));
            register.addActionListener(e -> new RegisterPage());
            adminLogin.addActionListener(e -> new LoginPage(true));

            frame.setVisible(true);
        });
    }
}





