import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Screen {

    private final JFrame mainFrame;
    private final JLabel screenLabel;

    public Screen() {
        this.mainFrame = new JFrame();
        this.screenLabel = new JLabel();
    }

    public void initFrame(int width, int height) {
        mainFrame.setResizable(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screenLabel.setHorizontalAlignment(SwingConstants.CENTER);
        screenLabel.setVerticalAlignment(SwingConstants.CENTER);
        screenLabel.setVerticalTextPosition(SwingConstants.CENTER);
        screenLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        screenLabel.setFont(new Font("Arial", Font.BOLD, 28));
        mainFrame.add(screenLabel);
        mainFrame.setSize(width, height);
        mainFrame.setVisible(true);
    }

    public void addKeyListener(Television tv, CableBox cableBox) {
        mainFrame.addKeyListener(new CableBoxListener(tv, cableBox));
    }

    public void clearOutput() {
        screenLabel.setText("");
    }

    public void updateImage(BufferedImage img) {
        screenLabel.setIcon(new ImageIcon(img));
        mainFrame.repaint();
    }

    public void updateOutput(String message) {
        screenLabel.setText(message);
    }

    public void updateTitle(String title) {
        mainFrame.setTitle(title);
    }

    public int getWidth() {
        return this.mainFrame.getWidth();
    }

    public int getHeight() {
        return this.mainFrame.getHeight();
    }


}
