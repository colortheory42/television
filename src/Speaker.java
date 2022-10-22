import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Optional;

public class Speaker {
    private final Optional<Sound> sound;

    public Speaker(boolean enabled) {
        if (enabled) {
            this.sound = Optional.of(new Sound());
        } else {
            this.sound = Optional.empty();
        }
    }

    public void playRandomSound() throws LineUnavailableException, InterruptedException {
        if (sound.isPresent()) {
            sound.get().random();
        } else {
            System.out.println("Muted random sound");
            Thread.sleep(300);
        }
    }

    public void playLoadingSound() throws LineUnavailableException, InterruptedException {
        if (sound.isPresent()) {
            sound.get().loading();
        } else {
            System.out.println("Muted loading sound");
            Thread.sleep(300);
        }
    }

    public void playSoundEffects() throws LineUnavailableException, InterruptedException, UnsupportedAudioFileException, IOException {
        if (sound.isPresent()) {
            sound.get().sound_effects();
        } else {
            System.out.println("Muted sound effects");
            Thread.sleep(300);
        }
    }
}
