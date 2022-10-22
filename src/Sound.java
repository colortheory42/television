import javax.sound.sampled.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Sound {

    public Component random() throws LineUnavailableException {

        byte[] buf = new byte[ 1 ];
        AudioFormat af = new AudioFormat( (float )44100, 8, 1, true, false );
        SourceDataLine sdl = AudioSystem.getSourceDataLine( af );
        sdl.open();
        FloatControl volume = (FloatControl) sdl.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(-20.0F);
        sdl.start();
        for( int i = 0; i < (float )44100; i++ ) {
            double angle = i / ( (float )44100 / (Math.random() * 441) ) * 2.0 * Math.PI;
            buf[ 0 ] = (byte )( Math.sin( angle ) * 100 );
            sdl.write( buf, 0, 1 );
        }
        sdl.drain();
        sdl.stop();


        return null;
    }


    public void sound_effects() throws LineUnavailableException, IOException, UnsupportedAudioFileException {

        File file = new File("src/data/television.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();

        return ;
    }

    public Component loading() throws LineUnavailableException {

        int random_value = (int) (Math.random() * 2);

        byte[] buf = new byte[ 1 ];
        AudioFormat af = new AudioFormat( (float )44100, 8, 1, true, false );
        SourceDataLine sdl = AudioSystem.getSourceDataLine( af );
        sdl.open();
        FloatControl volume = (FloatControl) sdl.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(-20.0F);
        sdl.start();
        for( int i = 0; i < (float )44100; i++ ) {
            double angle = i / ( (float )44100 / (random_value * 441) ) * 2.0 * Math.PI;
            buf[ 0 ] = (byte )( Math.sin( angle ) * 100 );
            sdl.write( buf, 0, 1 );
        }
        sdl.drain();
        sdl.stop();

        return null;
    }

}
