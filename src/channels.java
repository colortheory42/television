import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

public class channels {
    channels() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        image image = new image();

        sound sound = new sound();

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter a channel number: ");

        int channel_number = scanner.nextInt();

        JFrame loading_connecting_connected = new JFrame();

        loading_connecting_connected.setSize(image.width, image.height);

        loading_connecting_connected.setResizable(false);

        loading_connecting_connected.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel attempt_to_connect_to_television = new JLabel();

        JLabel Connecting = new JLabel();

        JLabel Connecting_Image = new JLabel();

        JLabel Connected_Image = new JLabel();

        JLabel Channels = new JLabel();

        BufferedImage[] paint = new BufferedImage[1];

        loading_connecting_connected.setTitle("loading");

        attempt_to_connect_to_television.setText("attempting to connect to television");

        loading_connecting_connected.add(attempt_to_connect_to_television);

        loading_connecting_connected.setVisible(true);

        sound.random();

        loading_connecting_connected.setTitle("loading.");

        attempt_to_connect_to_television.setText("attempting to connect to television.");

        loading_connecting_connected.add(attempt_to_connect_to_television);

        loading_connecting_connected.setVisible(true);

        sound.random();

        loading_connecting_connected.add(attempt_to_connect_to_television);

        loading_connecting_connected.repaint();

        loading_connecting_connected.setVisible(true);

        attempt_to_connect_to_television.setText("attempting to connect to television..");

        loading_connecting_connected.setTitle("loading..");

        sound.random();

        attempt_to_connect_to_television.setText("attempting to connect to television...");

        sound.random();

        loading_connecting_connected.setTitle("loading...");

        attempt_to_connect_to_television.setText("attempting to connect to television...");

        loading_connecting_connected.remove(attempt_to_connect_to_television);

        sound.random();

        loading_connecting_connected.setTitle("loading");

        loading_connecting_connected.repaint();

        sound.loading();
        Timer connecting_visual = new Timer(1000 / 60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    paint[0] = image.connecting();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                Connecting_Image.setIcon(new ImageIcon(paint[0]));

                loading_connecting_connected.add(Connecting_Image);

            }
        });

        connecting_visual.setInitialDelay(0);

        connecting_visual.start();

        loading_connecting_connected.setTitle("loading.");

        Connecting.setText("connecting.");

        loading_connecting_connected.add(Connecting);

        loading_connecting_connected.repaint();

        loading_connecting_connected.setVisible(true);

        sound.loading();

        loading_connecting_connected.setTitle("loading..");

        Connecting.setText("connecting..");

        loading_connecting_connected.repaint();

        loading_connecting_connected.setVisible(true);

        sound.loading();

        loading_connecting_connected.setTitle("loading..");

        Connecting.setText("connecting...");

        connecting_visual.setInitialDelay(0);

        connecting_visual.start();

        sound.loading();

        connecting_visual.stop();

        sound.sound_effects();

        loading_connecting_connected.remove(Connecting);

        loading_connecting_connected.remove(Connecting_Image);

        loading_connecting_connected.repaint();

        loading_connecting_connected.setVisible(true);

        paint[0] = image.connected();

        Connected_Image.setIcon(new ImageIcon(paint[0]));

        loading_connecting_connected.add(Connected_Image);

        loading_connecting_connected.setTitle("connected");

        loading_connecting_connected.repaint();

        loading_connecting_connected.setVisible(true);

        sound.loading();

        loading_connecting_connected.remove(Connecting_Image);

        loading_connecting_connected.remove(Connected_Image);

        loading_connecting_connected.setTitle("CH " + channel_number);

        loading_connecting_connected.repaint();

        loading_connecting_connected.setVisible(true);


        if (channel_number == 0) {

            Timer channel_number_0 = new Timer(1000 / 60, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    paint[0] = image.channel_0();

                    Channels.setIcon(new ImageIcon(paint[0]));

                    loading_connecting_connected.add(Channels);

                    loading_connecting_connected.repaint();

                    loading_connecting_connected.setVisible(true);

                }
            });

            channel_number_0.setInitialDelay(0);
            channel_number_0.start();
        }

    }

}
