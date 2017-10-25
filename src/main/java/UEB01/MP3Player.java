package UEB01;

import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;

public class MP3Player {


    SimpleMinim minim = new SimpleMinim(true);
    SimpleAudioPlayer audioplayer;



    public MP3Player(){
    }

    public void play(String filename){
        audioplayer = minim.loadMP3File(filename);
        audioplayer.play();
    }

    public void pause(){
        audioplayer.pause();
    }

    public void play(){
        audioplayer.play();
    }

    public void balance(float value){
        audioplayer.setBalance(value);
    }

    public void volume(float value){
        audioplayer.setGain(value);
    }

    public void stop(){
        minim.stop();
    }
}
