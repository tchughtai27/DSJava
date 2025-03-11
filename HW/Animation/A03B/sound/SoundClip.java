package sound;

import java.io.File;
import javax.sound.sampled.*;

public class SoundClip {
    private String filePath;
    private Clip clip;
    private boolean loop;

    public SoundClip(String path) {
        filePath = path;
        open();
    }

    public void open() {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}
