package main.java.Ressources;


import javafx.beans.value.ObservableListValue;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import main.java.Layout.Controllbar;
import main.java.Layout.Header;
import main.java.Layout.ImagePane;
import main.java.Layout.ListPane;
import main.java.UEB01.MP3Player;
import com.sun.javaws.progress.Progress;
import de.hsrm.mi.prog.util.StaticScanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import main.java.UEB01.Playlist;
import main.java.UEB01.PlaylistManager;
import main.java.UEB01.Track;


import java.io.*;
import java.util.Observable;
import java.util.Stack;

public class Main extends Application {
    private BufferedReader br;
    private Scene scene,scene2;
    private Header header;
    private Controllbar controllbar;
    private ImagePane imagePane;
    private ListPane listPane;
    private ListView<String>  lv;
    private ImageView image1;
    private Track actTrack;
    private BorderPane layout1,playlistlayout;
    private static MP3Player player = new MP3Player();
    public static void main(String[] args)throws IOException{
        launch(args);

      /**StaticScanner sc = new StaticScanner();
        String s;
        String[] command;
        Controller c = new Controller();

        do{
            s = sc.nextString();
            command = s.split(" ");
            c.doCommand(command);
        }while(!s.equalsIgnoreCase("quit"));
        **/
    }
    @Override
    public void start(Stage primaryStage) throws IOException,Exception {
        PlaylistManager manager = new PlaylistManager();
        Playlist x = new Playlist("#1");
        player.setPlaylist(manager.createTrack(x));
        actTrack = x.getTrack(0);
        Image im1 = SwingFXUtils.toFXImage(player.getCover(),null);
        Stage window = primaryStage;



        controllbar = new Controllbar(manager,x,player);
        imagePane = new ImagePane(player,scene2,window);
        header = new Header();
        listPane = new ListPane(x);


        //Layout
        layout1 = new BorderPane();
        header.init(layout1);
        controllbar.init(layout1);
        imagePane.init(layout1);
        layout1.setPrefSize(250,400);
        BorderPane.setAlignment(layout1,Pos.BASELINE_CENTER);
        //2. Layout
        playlistlayout = new BorderPane();
        controllbar.init(playlistlayout);
        listPane.init(playlistlayout);




        //Scene
        scene = new Scene(layout1,500,500);
        scene2 = new Scene(playlistlayout,500,500);
        imagePane.getClose().setOnAction(e -> window.setScene(scene2));
        listPane.getOpen().setOnAction(e -> window.setScene(scene));
        window.setScene(scene);
        window.setTitle("MP3Player");
        window.show();
    }


    public void play(String filename){
        player.play(filename);
        header.setAlbumLabel(actTrack.getAlbum());
        header.setInterpret(actTrack.getAuthor());
        header.setTitel(actTrack.getTitel());
        header.init(layout1);




    }
}
