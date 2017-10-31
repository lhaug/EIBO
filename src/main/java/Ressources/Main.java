package Ressources;

import UEB01.MP3Player;
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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.text.Position;
import javax.swing.text.html.ImageView;

public class Main extends Application {
    private Scene scene;
    private Label albumtitel,songtitel,interpret,length;
    private Button play,pause,stop;
    private ProgressBar progress;
    private static MP3Player player = new MP3Player();
    public static void main(String[] args){
        launch(args);
        /**StaticScanner sc = new StaticScanner();
        String s;
        String[] command;
        Controller c = new Controller();

        do{
            s = sc.nextString();
            command = s.split(" ");
            c.doCommand(command);
        }while(!s.equalsIgnoreCase("quit"));**/
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Stage window = primaryStage;
        //Label
        albumtitel = new Label("Album");
        songtitel = new Label("Titel");
        interpret = new Label("Author");

        //Buttons
        play = new Button("play");
        play.setOnAction(e -> play("01_LastMembrane.mp3"));
        pause = new Button("pause");
        pause.setOnAction(e -> player.pause());
        stop = new Button("stop");
        stop.setOnAction(e -> player.stop());

        //progressbar
        progress = new ProgressBar();
        progress.setProgress(0);

        //Layout
        HBox progressbar = new HBox(20);
        progressbar.getChildren().add(progress);
        HBox PlayPauseStop = new HBox(20);
        PlayPauseStop.setAlignment(Pos.BASELINE_CENTER);
        PlayPauseStop.setPadding(new Insets(0,10,20,10));
        PlayPauseStop.getChildren().addAll(play,pause,stop);
        HBox leiste = new HBox(10);
        leiste.getChildren().addAll(albumtitel,songtitel,interpret);

        leiste.setPadding(new Insets(20,10,0,10));
        leiste.setAlignment(Pos.BASELINE_CENTER);
        BorderPane layout1 = new BorderPane();
        layout1.setTop(leiste);
        layout1.setBottom(PlayPauseStop);
        layout1.setCenter(progressbar);

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
