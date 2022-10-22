import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Television.Resolution original = new Television.Resolution(1920, 1080);
    public static Television.Resolution smallSquare = new Television.Resolution(500, 500);

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        Television tv = new Television(false);
        tv.start(smallSquare, initChannels());
    }

    private static Map<Integer, image.PixelPainter> initChannels() {
        Map<Integer, image.PixelPainter> channels = new HashMap<>();
        channels.put(0, new image.Channel_0());
        channels.put(1, new image.Channel_1());
        channels.put(2, new image.Channel_2());
        channels.put(3, new image.Channel_3());
        channels.put(4, new image.Channel_4());
        channels.put(5, new image.TimeSlider());
        return channels;
    }

}
