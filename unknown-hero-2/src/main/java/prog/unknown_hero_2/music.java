package prog.unknown_hero_2;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class music {
    public static void main(String[] args) throws Exception {

        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("11.Coin.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(inputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        Thread.sleep(10000); // looping as long as this thread is alive
    }
}