package main.java.UEB01;

import com.mpatric.mp3agic.Mp3File;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    int i = 0;
    List<Track> playlist = new ArrayList<>();
    public Playlist(String name){ }
    public void add(Track t){
        playlist.add(i,t);
        i++;
    }
    public  Track getTrack(String name){
        for (Track track:playlist
             ) { if(track.getTitel().equalsIgnoreCase("name")){
                 return track;
        }
            
        }
        return null;
    }
    public Track getTrack(int i){
        return playlist.get(i);
    }

    public int getLength(){
        return playlist.size();
    }



}
