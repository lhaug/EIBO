package main.java.Ressources;
import main.java.UEB01.MP3Player;
import main.java.UEB01.Playlist;
import main.java.UEB01.PlaylistManager;

import java.io.IOException;

public class Controller {
    private MP3Player player  = new MP3Player();

    private PlaylistManager manager = new PlaylistManager();
    private Playlist playlist = new Playlist("1");

    public Controller(){
    }


    public void init()throws IOException{
        manager.createTrack(playlist);

    }
    public  void  doCommand(String command[]){

        for (int i = 0; i < command.length; i++) {

            switch (command[i]) {
                case "play":
                    if(command.length>i+1){
                        player.play(command[i+1]);}
                    else player.play();
                    break;

                case "pause":
                    player.pause();
                    break;

                case "balance":
                    player.balance(Float.parseFloat(command[i+1]));
                    break;

                case "volume":
                    player.volume(Float.parseFloat(command[i+1]));
                    break;
                case "stop":
                    player.stop();
                    break;
                case "shuffle":
                    player.shuffle(true);
                    break;
            }
        }
    }
}
