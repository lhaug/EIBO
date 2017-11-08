package main.java.UEB01;

import com.mpatric.mp3agic.Mp3File;
import ddf.minim.Minim;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class PlaylistManager {
    private List<Playlist> playlists;
    private Playlist list;
    public PlaylistManager(){
    }
    public Playlist createTrack(Playlist playlist)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("playlist.M3U"));
        String f;
        while(!(f = br.readLine()).equalsIgnoreCase("")) {
            Mp3File mp3;
            try {
                mp3 = new Mp3File(f);
                Track t = new Track(f, mp3.getId3v1Tag().getAlbum(), mp3.getId3v1Tag().getTitle(), mp3.getId3v1Tag().getArtist(),mp3.getId3v2Tag().getAlbumImage(), mp3.getId3v2Tag().getLength());
                playlist.add(t);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return playlist;
    }
    public List<Playlist> findPlaylist(String name){
        return null;
    }
    public Playlist getAllTracks(){
        return null;
    }
    public void setPlaylist(Playlist actPlaylist){
        playlists.add(actPlaylist); }
    public void deletePlaylist(Playlist actPlaylist){
        playlists.remove(actPlaylist);
    }
    public void updatePlaylist(Playlist actPlaylist){
        deletePlaylist(actPlaylist);
        setPlaylist(actPlaylist);
    }

    public Playlist getPlaylist(int i){
        return playlists.get(i);
    }




}
