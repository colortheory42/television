import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public class Television {
    private final Screen screen;
    private final Speaker speaker;
    private Optional<Timer> timer;

    public Television(boolean soundEnabled) {
        this.screen = new Screen();
        this.speaker = new Speaker(soundEnabled);
        this.timer = Optional.empty();
    }

    record Resolution(int width, int height){}

    public void start(Resolution res, Map<Integer, image.PixelPainter> channels)
            throws LineUnavailableException, InterruptedException, IOException, UnsupportedAudioFileException {
        screen.initFrame(res.width, res.height);
        changeChannel(new image.RandomStatic(), -1);
        loadingStage(6);
        screen.clearOutput();
        speaker.playSoundEffects();
        changeChannel(new image.Connected(), -1);
        screen.updateTitle("Connected");
        screen.addKeyListener(this, new CableBox(channels));
        screen.updateOutput("Please Select a Channel");
    }

    private void loadingStage(int numTicks) throws LineUnavailableException, InterruptedException {
        speaker.playLoadingSound();
        for (int i = 0; i <= numTicks; i++) {
            speaker.playRandomSound();
            screen.updateTitle("loading" + ".".repeat(i % 4));
            screen.updateOutput("connecting to television" + ".".repeat(i % 4));
        }
        speaker.playLoadingSound();
    }

    public void changeChannel(image.PixelPainter pp, int channelNumber) {
        screen.clearOutput();
        timer.ifPresent(Timer::stop);
        Timer tempTimer = new Timer(1000 / 60, e -> {
            int w = this.screen.getWidth();
            int h = this.screen.getHeight();
            BufferedImage img = pp.drawFrame(e.getWhen(), w, h);
            screen.updateImage(img);
        });
        tempTimer.setInitialDelay(0);
        timer = Optional.of(tempTimer);
        screen.updateTitle("CH " + channelNumber);
        tempTimer.start();
    }

    public void updateOutput(String msg) {
        screen.updateOutput(msg);
    }

}
