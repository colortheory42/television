import java.awt.image.BufferedImage;
import java.io.IOException;

public class image {

    static int width = 1920;
    static int height = 1080;
    public BufferedImage connecting() throws IOException {

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int a = (int) (Math.random() * 255);
                int r = (int) (Math.random() * 255);
                int g = (int) (Math.random() * 255);
                int b = (int) (Math.random() * 255);
                int p = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, p);

            }
        }
        return image;

    }

    public BufferedImage connected() {

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int a = 255;
                int r = 0;
                int g = 255;
                int b = 0;

                int p = (a << 24) | (r << 16) | (g << 8) | b;

                image.setRGB(x, y, p);
            }
        }

        return image;

    }

    public BufferedImage disconnected() {

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int a = 255;
                int r = 255;
                int g = 0;
                int b = 0;

                int p = (a << 24) | (r << 16) | (g << 8) | b;

                image.setRGB(x, y, p);
            }
        }

        return image;

    }

    public BufferedImage channel_0() {

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int a = 255;
                int r = x * 255;
                int g = y * 255;
                int b = (int) (x*y * (Math.random() * 255));

                int p = (a << 24) | (r << 16) | (g << 8) | b;

                image.setRGB(x, y, p);
            }
        }

        return image;
    }

    public BufferedImage channel_1() {

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int a = 255;
                int r = 0;
                int g = (int) (Math.random() * x * 255);
                int b = x * y * 255;

                int p = (a << 24) | (r << 16) | (g << 8) | b;

                image.setRGB(x, y, p);
            }
        }

        return image;
    }

    public BufferedImage channel_2() {

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int a = 255;
                int r = y * 255;
                int g = x * 255;
                int b = x * y * 255;

                int p = (a << 24) | (r << 16) | (g << 8) | b;

                image.setRGB(100, y, p);
                image.setRGB((int) (Math.random() * 42), y, p);
                image.setRGB(320, (int) (Math.random() * 420), p);
                image.setRGB(43, y, p);
            }
        }

        return image;
    }

    public BufferedImage channel_3() {

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int a = 255;
                int r = y;
                int g = x;
                int b = (int) (Math.random() * 255);
                int p = (a << 24) | (r << 16) | (g << 8) | b;

                image.setRGB(x, y, p);
            }
        }

        return image;
    }

    public BufferedImage channel_4() {

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = (int) Math.sin(Math.random()); x < width; x++) {

                int a = 255;
                int r = y;
                int g = x;
                int b = (int) (Math.random() * 255);
                int p = (a << 24) | (r << 16) | (g << 8) | b;

                image.setRGB(x, y, p);
            }
        }

        return image;
    }
}
