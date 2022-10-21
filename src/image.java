import java.awt.image.BufferedImage;
import java.io.IOException;

public class image {

    static int width = 1920;
    static int height = 1080;

    interface PixelPainter {
        int pixelColor(int x, int y);
        default int toRGB(int a, int r, int g, int b) {
            return (a << 24) | (r << 16) | (g << 8) | b;
        }
        default BufferedImage drawFrame() {
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgb = pixelColor(x, y);
                    image.setRGB(x, y, rgb);
                }
            }
            return image;
        }
    }

    public BufferedImage connecting() throws IOException {
        return new Connecting().drawFrame();
    }

    public BufferedImage connected() {
        return new Connected().drawFrame();
    }

    public BufferedImage disconnected() {
        return new Disconnected().drawFrame();
    }

    public BufferedImage channel_0() {
        return new Channel_0().drawFrame();
    }

    public BufferedImage channel_1() {
        return new Channel_1().drawFrame();
    }

    public BufferedImage channel_2() {
        return new Channel_2().drawFrame();
    }

    public BufferedImage channel_3() {
        return new Channel_3().drawFrame();
    }

    public BufferedImage channel_4() {
        return new Channel_4().drawFrame();
    }


    static class Connecting implements PixelPainter {
        @Override
        public int pixelColor(int x, int y) {
            int a = (int) (Math.random() * 255);
            int r = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);
            return toRGB(a, r, g, b);
        }
    }

    static class Connected implements PixelPainter {
        @Override
        public int pixelColor(int x, int y) {
            return toRGB(255, 0, 255, 0);
        }
    }

    static class Disconnected implements PixelPainter {
        @Override
        public int pixelColor(int x, int y) {
            return toRGB(255, 255, 0, 0);
        }
    }

    static class Channel_0 implements PixelPainter {
        @Override
        public int pixelColor(int x, int y) {
            int a = 255;
            int r = x * 255;
            int g = y * 255;
            int b = (int) (x*y * (Math.random() * 255));
            return toRGB(a, r, g, b);
        }
    }

    static class Channel_1 implements PixelPainter {
        @Override
        public int pixelColor(int x, int y) {
            int a = 255;
            int r = 0;
            int g = (int) (Math.random() * x * 255);
            int b = x * y * 255;
            return toRGB(a, r, g, b);
        }
    }

    static class Channel_2 implements PixelPainter {

        /* Note: I actually edited how the pixel setting was done on this one since it
        seemed like the wrong numbers were being changed - all others have been left alone. */
        @Override
        public int pixelColor(int x, int y) {
            int a = 255;
            int r = y * 255;
            int g = x * 255;
            int b = x * y * 255;
            return toRGB(a, r, g, b);
        }
    }

    static class Channel_3 implements PixelPainter {
        @Override
        public int pixelColor(int x, int y) {
            int b = (int) (Math.random() * 255);
            return toRGB(255, x, y, b);
        }
    }

    static class Channel_4 implements PixelPainter {
        @Override
        public int pixelColor(int x, int y) {
            int b = (int) (Math.random() * 255);
            return toRGB(255, y, x, b);
        }
    }

}
