import javax.swing.*;
import java.awt.*;

public class TemplateFrame extends JFrame {
    public TemplateFrame(String title) {
        super(title);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel background = new JLabel(new ImageIcon("FINAL.png"));
        background.setBounds(0, 0, getWidth(), getHeight());
        setContentPane(background);
        background.setLayout(null);

        JLabel heading = new JLabel("Digital Ration Distribution System", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 28));
        heading.setForeground(new Color(0x4B2E1A));
        heading.setBounds(650, 150, 600, 40);
        background.add(heading);
    }
}
