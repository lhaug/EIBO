package main.java.Layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import main.java.UEB01.MP3Player;
import main.java.UEB01.Playlist;
import main.java.UEB01.PlaylistManager;
import main.java.UEB01.Track;

public class Controllbar {
    private PlaylistManager manager;
    private Playlist playlist;
    private MP3Player player;
    private Button play,pause,stop,next,previous;


    public Controllbar(PlaylistManager manager, Playlist playlist, MP3Player player){
        this.manager=manager;
        this.player=player;
        this.playlist=playlist;

    }

    public void init(BorderPane pane){
        play = new Button("\u23F5");
        play.setPrefSize(35,10);
        play.setOnAction(e -> player.play(playlist));
        pause = new Button("\u23F8");
        pause.setPrefSize(35,10);
        pause.setOnAction(e -> player.pause());
        stop = new Button("\u23F9");
        stop.setPrefSize(35,10);
        stop.setOnAction(e -> player.stop());
        next = new Button ("next");
        next.setPrefSize(50,10);
        previous = new Button("previous");
        previous.setPrefSize(50,10);
        HBox PlayPauseStop = new HBox(5);
        PlayPauseStop.setAlignment(Pos.BASELINE_CENTER);
        PlayPauseStop.setPadding(new Insets(0,5,20,5));
        PlayPauseStop.getChildren().addAll(previous,play,pause,stop,next);
        HBox.setHgrow(PlayPauseStop, Priority.ALWAYS);
        HBox.setHgrow(play,Priority.ALWAYS);
        HBox.setHgrow(pause,Priority.ALWAYS);
        HBox.setHgrow(stop,Priority.ALWAYS);
        pane.setBottom(PlayPauseStop);
    }

}
