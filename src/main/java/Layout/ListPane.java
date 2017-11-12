package main.java.Layout;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import main.java.UEB01.Playlist;


public class ListPane {
    private ListView<String> lv;
    private Button open;
    private Playlist playlist;
    private StackPane stackPane;
    public ListPane(Playlist playlist){
        this.playlist=playlist;
    }

    public void init(BorderPane pane){

        lv = new ListView<>();
        for (int i = 0;i< playlist.getLength();i++){
            lv.getItems().add( playlist.getTrack(i).getTitel());
        }

        open = new Button("Open");
        open.setMinSize(50,5);
        StackPane.setAlignment(open, Pos.BOTTOM_LEFT);
        StackPane.setMargin(open, new Insets(0,0,5,5));

        stackPane = new StackPane();
        stackPane.getChildren().addAll(open,lv);

        pane.setCenter(stackPane);

    }

    public void setPlaylist(Playlist playlist){
        this.playlist=playlist;
    }

    public Button getOpen(){
        return open;
    }
}
