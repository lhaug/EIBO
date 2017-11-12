package main.java.Layout;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.java.UEB01.MP3Player;

import java.io.IOException;

public class ImagePane {
    private MP3Player player;
    private ImageView image;
    private Button close;
    private Scene scene2;
    private Stage window;
    public ImagePane(MP3Player player,Scene scene2,Stage window){
        this.player=player;
        this.scene2=scene2;
        this.window=window;
    }

    public void init(BorderPane pane)throws IOException{
        Image im1 = SwingFXUtils.toFXImage(player.getCover(),null);
        image = new ImageView();
        image.setImage(im1);
        image.setPreserveRatio(true);

        close = new Button("close");
        close.setMinSize(50,5);
        StackPane.setAlignment(close, Pos.BOTTOM_LEFT);
        StackPane.setMargin(close,new Insets(0,0,5,5));

        StackPane imagepane = new StackPane();
        imagepane.getChildren().addAll(close,image);
        imagepane.setPadding(new Insets(10));
        imagepane.setAlignment(Pos.BASELINE_CENTER);

        pane.setCenter(imagepane);

    }

    public Button getClose(){
        return close;
    }

}
