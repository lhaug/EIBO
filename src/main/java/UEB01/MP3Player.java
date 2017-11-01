package UEB01;

import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;
import javafx.scene.image.Image;

public class MP3Player {


    SimpleMinim minim = new SimpleMinim(true);
    SimpleAudioPlayer audioplayer;


    Boolean playing;
    public MP3Player(){
        this.playing=false;
    }

    public void play(String filename){
        playing=true;
        audioplayer = minim.loadMP3File(filename);
        audioplayer.play();
    }

    public void pause(){
        playing=false;
        audioplayer.pause();
    }

    public void play(){
        playing=true;
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

    public String getTitle(){
        return audioplayer.getMetaData().title();
    }
    public String getAlbum(){
        return audioplayer.getMetaData().album();
    }
    public String getAuthor(){
        return audioplayer.getMetaData().author();
    }
    public int getLength(){
        return audioplayer.getMetaData().length();
    }
    public Image getCover() { return null;}
    public Boolean isPlaying(){
        return playing;
    }

}
