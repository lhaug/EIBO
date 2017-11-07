package main.java.UEB01;

import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;
import javafx.scene.image.Image;

public class MP3Player {

    PlaylistManager playlistManager = new PlaylistManager();
    Playlist playlist = new Playlist("1");
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
        for (int i=0;i<=playlist.getLength();i++) {
            audioplayer = minim.loadMP3File(playlist.getTrack(i).getFile());
            audioplayer.play();
        }
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

    public void skip(){

    }
    public void skipBack(){

    }
    public void shuffle(Boolean on){
        if(on){
           String f = playlistManager.getPlaylist(0).getTrack((int)(Math.random()*playlistManager.getPlaylist(0).getLength())).getFile();
            play(f);
        }
    }
    public void repeat(Boolean on){
        if(on){audioplayer.loop();}


    }
    public void setPlaylist(Playlist actPlaylist){
        playlistManager.setPlaylist(actPlaylist);
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
