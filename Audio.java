import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
class Audio{
public void playSound() {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream
        		(new File("C:\\\\Users\\\\USER\\\\Downloads\\\\mixkit-air-whistle-punch-2048.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    } catch(Exception ex) {
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
    }}}