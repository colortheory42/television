import java.awt.image.BufferedImage;

public class image {

    interface PixelPainter {
        int pixelColor(long t, int x, int y);
        default int toRGB(int a, int r, int g, int b) {
            return (a << 24) | (r << 16) | (g << 8) | b;
        }
        default BufferedImage drawFrame(long when, int width, int height) {
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgb = pixelColor(when, x, y);
                    image.setRGB(x, y, rgb);
                }
            }
            return image;
        }
    }

    static class RandomStatic implements PixelPainter {
        @Override
        public int pixelColor(long t, int x, int y) {
            int a = (int) (Math.random() * 255);
            int r = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);
            return toRGB(a, r, g, b);
        }
    }

    static class Connected implements PixelPainter {
        @Override
        public int pixelColor(long t, int x, int y) {
            return toRGB(255, 0, 255, 0);
        }
    }

    static class Disconnected implements PixelPainter {
        @Override
        public int pixelColor(long t, int x, int y) {
            return toRGB(255, 255, 0, 0);
        }
    }

    static class Channel_0 implements PixelPainter {
        @Override
        public int pixelColor(long t, int x, int y) {
            int a = 255;
            int r = x * 255;
            int g = y * 255;
            int b = (int) (x*y * (Math.random() * 255));
            return toRGB(a, r, g, b);
        }
    }

    static class Channel_1 implements PixelPainter {
        @Override
        public int pixelColor(long t, int x, int y) {
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
        public int pixelColor(long t, int x, int y) {
            int a = 255;
            int r = y * 255;
            int g = x * 255;
            int b = x * y * 255;
            return toRGB(a, r, g, b);
        }
    }

    static class Channel_3 implements PixelPainter {
        @Override
        public int pixelColor(long t, int x, int y) {
            int b = (int) (Math.random() * 255);
            return toRGB(255, x, y, b);
        }
    }

    static class Channel_4 implements PixelPainter {
        @Override
        public int pixelColor(long t, int x, int y) {
            int b = (int) (Math.random() * 255);
            return toRGB(255, y, x, b);
        }
    }

    // Note: Made this as an example of a time-varying Channel - hope it's in line with your vision!
    static class TimeSlider implements PixelPainter {
        @Override
        public int pixelColor(long t, int x, int y) {
            int slowMo = 15;
            int aOverTime = (int)((t/ slowMo) % 255);
            int b = (int) (Math.random() * 255);
            return toRGB(aOverTime, y + aOverTime, x + aOverTime, b);
        }
    }

}
