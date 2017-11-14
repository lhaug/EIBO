package main.java.UEB01;

import de.hsrm.mi.eibo.simpleplayer.SimpleAudioPlayer;
import de.hsrm.mi.eibo.simpleplayer.SimpleMinim;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class MP3Player {


    Playlist actPlaylist;
    SimpleMinim minim = new SimpleMinim(true);
    SimpleAudioPlayer audioplayer;
    Boolean playing;
    int track = 0;

    public MP3Player(){
        this.playing=false;
    }

    public void play(String filename){
        playing=true;
        audioplayer = minim.loadMP3File(filename);
        audioplayer.play();
    }

    public void play(Playlist playlist){
        actPlaylist = playlist;
        audioplayer = minim.loadMP3File(actPlaylist.getTrack(track).getFile());
        audioplayer.play();

        while(!audioplayer.isPlaying() && track < playlist.getLength()){
            audioplayer = minim.loadMP3File(actPlaylist.getTrack(track++).getFile());
            audioplayer.play();
        }
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

    public void skip(){
        if(track < actPlaylist.getLength()){
        play(actPlaylist.getTrack(track++).getFile());}
    }
    public void skipBack(){
        if(track > 0){
        play(actPlaylist.getTrack(track--).getFile());}
        else{ track = actPlaylist.getLength()-1; play(actPlaylist.getTrack(track--).getFile());}
    }

    public void shuffle(Boolean on){
        if(on){
            play(actPlaylist.getTrack(
                    (int) (Math.random()*actPlaylist.getLength())).getFile());
        }
    }

    public void repeat(Boolean on){
        if(on){audioplayer.loop();}


    }
    public void setPlaylist(Playlist playlist){
        actPlaylist=playlist;

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
    public BufferedImage getCover() throws IOException { return actPlaylist.getTrack(0).getImage();}
    public Boolean isPlaying(){
        return playing;
    }

}
