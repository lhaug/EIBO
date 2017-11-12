package main.java.Layout;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import main.java.UEB01.MP3Player;

public class Header {
    private Label titel,album,interpret;

    public Header(){

    }

    public void init(BorderPane pane){
        titel = new Label("Titel");
        album = new Label("Album");
        interpret = new Label("Interpret");
        HBox leiste = new HBox(10);
        leiste.getChildren().addAll(album,titel,interpret);
        leiste.setPadding(new Insets(20,0,0,0));
        leiste.setAlignment(Pos.BASELINE_CENTER);
        pane.setTop(leiste);
    }

    public void setTitel(String s){
        titel.setText(s);
    }
    public void setAlbumLabel(String s){
        album.setText(s);
    }
    public void setInterpret(String s){
        interpret.setText(s);
    }
}
