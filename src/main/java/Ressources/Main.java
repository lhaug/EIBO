package main.java.Ressources;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import main.java.UEB01.MP3Player;
import com.sun.javaws.progress.Progress;
import de.hsrm.mi.prog.util.StaticScanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import main.java.UEB01.Playlist;
import main.java.UEB01.PlaylistManager;

import javax.swing.text.Position;
import javax.swing.text.html.ImageView;

import java.io.*;
public class Main extends Application {
    private BufferedReader br;
    private Scene scene;
    private Label albumtitel,songtitel,interpret,length;
    private Button play,pause,stop;
    private ProgressBar progress;
    private javafx.scene.image.ImageView image1;
    private static MP3Player player = new MP3Player();
    public static void main(String[] args){
        launch(args);
     /**   StaticScanner sc = new StaticScanner();
        String s;
        String[] command;
        Controller c = new Controller();

        do{
            s = sc.nextString();
            command = s.split(" ");
            c.doCommand(command);
        }while(!s.equalsIgnoreCase("quit")); **/
    }

    @Override
    public void start(Stage primaryStage) throws IOException,Exception {
        PlaylistManager manager = new PlaylistManager();
        Playlist x = new Playlist("#1");
        player.setPlaylist(manager.createTrack(x));
        String u = "http://www.pngmart.com/image/29253";
        Image im1 = SwingFXUtils.toFXImage(player.getCover(),null);
        Stage window = primaryStage;
        //Label
        albumtitel = new Label("Album");
        songtitel = new Label("Titel");
        interpret = new Label("Author");

        //Buttons
        play = new Button("play");
        play.setStyle("-fx-graphic: url('http://www.pngmart.com/image/29253')");
        play.setOnAction(e -> {
            try {
                play(manager.createTrack(new Playlist("#1")).getTrack(1).getFile());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        pause = new Button("pause");
        pause.setOnAction(e -> player.pause());
        stop = new Button("stop");
        stop.setOnAction(e -> player.stop());


        //progressbar
        progress = new ProgressBar();
        progress.setProgress(0);
        image1 = new javafx.scene.image.ImageView();
        image1.setImage(im1);


        //Layout
        HBox progressbar = new HBox(20);
        progressbar.getChildren().add(progress);
        progressbar.setAlignment(Pos.BASELINE_CENTER);
        HBox.setHgrow(progress,Priority.ALWAYS);
        HBox PlayPauseStop = new HBox(20);
        PlayPauseStop.setAlignment(Pos.BASELINE_CENTER);
        PlayPauseStop.setPadding(new Insets(0,10,20,10));
        PlayPauseStop.getChildren().addAll(play,pause,stop);
        HBox.setHgrow(PlayPauseStop, Priority.SOMETIMES);
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.add(progressbar,1,1);
        grid.add(PlayPauseStop,1,2);
        GridPane.setMargin(progressbar,new Insets(10));
        grid.setAlignment(Pos.BASELINE_CENTER);
        HBox leiste = new HBox(10);
        leiste.getChildren().addAll(albumtitel,songtitel,interpret);

        leiste.setPadding(new Insets(20,10,0,10));
        leiste.setAlignment(Pos.BASELINE_CENTER);
        BorderPane layout1 = new BorderPane();
        layout1.setTop(leiste);
        layout1.setBottom(grid);
        layout1.setCenter(image1);




        //Scene
        scene = new Scene(layout1,300  ,300);
        window.setScene(scene);
        window.setTitle("MP3Player");
        window.show();
    }
    public void play(String filename){

        player.play(filename);

        albumtitel.setText(player.getAlbum());
        interpret.setText(player.getAuthor());
        songtitel.setText(player.getTitle());



    }
}
