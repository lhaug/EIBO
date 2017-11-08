package main.java.UEB01;

import com.mpatric.mp3agic.Mp3File;
import javazoom.spi.mpeg.sampled.file.tag.MP3Tag;

import javax.imageio.ImageIO;
import java.awt.*;
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

    public void setFile(String file) {
        this.file = file;
    }

    public BufferedImage getImage() throws IOException {
        BufferedImage bi = ImageIO.read(new ByteArrayInputStream(b));
        return bi;
    }
}
