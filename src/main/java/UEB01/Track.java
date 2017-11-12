package main.java.UEB01;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;


public class Track {
    String file;
    String Album;
    String Titel;
    String Author;
    byte[] b;
    double length;

    public Track(String file,String Album, String Titel, String Author,byte[] b, double length){
        this.file=file;
        this.Album=Album;
        this.Titel=Titel;
        this.Author=Author;
        this.length=length;
        this.b=b;
    }

    public String getTitel(){
        return Titel;
    }

    public String getFile() {
        return file;
    }

    public String getAlbum(){return Album;}

    public String getAuthor(){ return Author;}

    public BufferedImage getImage() throws IOException {
        BufferedImage bi = ImageIO.read(new ByteArrayInputStream(b));
        return bi;
    }
}
