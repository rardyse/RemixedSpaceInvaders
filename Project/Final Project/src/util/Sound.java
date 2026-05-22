package project.util;

import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.net.URL;

public class Sound implements AutoCloseable {  //AutoCloseable = classe peut être fermée ou nettoyée
    private final Clip audioClip;

    public Sound(String name) throws Exception{
        System.out.println("Tentative: /resources/" + name);
        System.out.println("Classe: " + Sound.class.getResource("/"));
        final URL url = Sound.class.getResource("/resources/" + name);
        System.out.println("URL: " + url);
        if (url == null) throw new Exception("Son not founded : " + name);
        audioClip = AudioSystem.getClip();
        audioClip.open(AudioSystem.getAudioInputStream(url));
    }

    public void play(){
        audioClip.start();
    }

    public void playInLoop(){
        audioClip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void repeat(int nb){
        audioClip.loop(nb);
    }

    public void stop(){
        audioClip.stop();
    }

    @Override
    public void close(){
        audioClip.close();
    }
}
