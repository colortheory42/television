import java.util.*;

public class CableBox {
    private Optional<Integer> currentChannel;
    private final List<Integer> buffer = new ArrayList<>();
    public Map<Integer, image.PixelPainter> channels;
    private final image.PixelPainter fail;

    record ChannelChoice(int channel, image.PixelPainter pp){}

    public CableBox(Map<Integer, image.PixelPainter> channels) {
        this.currentChannel = Optional.empty();
        this.channels = channels;
        this.fail = new image.Disconnected();
    }

    public Optional<ChannelChoice> up() {
        if (currentChannel.isEmpty()) {
            currentChannel = Optional.of(0);
        } else {
            currentChannel = currentChannel.map(n -> n + 1);
        }
        return currentChannel.map(c -> new ChannelChoice(c , channels.getOrDefault(c, fail)));
    }

    public Optional<ChannelChoice> down() {
        currentChannel = currentChannel.map(n -> n - 1);
        return currentChannel.map(c -> new ChannelChoice(c , channels.getOrDefault(c, fail)));
    }

    public Integer number(int n) {
        buffer.add(n);
        Optional<String> temp = buffer.stream().map(Object::toString).reduce((s, s2) -> s + s2);
        return Integer.parseInt(temp.get());
    }

    public Optional<ChannelChoice> enter() {
        Optional<String> temp = buffer.stream().map(Object::toString).reduce((s, s2) -> s + s2);
        var next = temp.map(Integer::parseInt);
        if (next.isEmpty()) {
            return Optional.empty();
        } else {
            this.buffer.clear();
            currentChannel = next;
            return next.map(n -> new ChannelChoice(n, channels.getOrDefault(n, fail)));
        }
    }

}
