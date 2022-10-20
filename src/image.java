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
                int r = x;
                int g = y;
                int b = x*y;

                int p = (a << 24) | (r << 16) | (g << 8) | b;

                image.setRGB(x, y, p);
            }
        }

        return image;
    }
}
