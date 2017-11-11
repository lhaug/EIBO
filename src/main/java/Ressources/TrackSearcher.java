package main.java.Ressources;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TrackSearcher {
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        walk("C:\\users\\Florian\\Music");

    }

    public static void walk(String path) throws IOException {
        File playlist = new File("playlist.M3U");
        bw = new BufferedWriter(new FileWriter(playlist, playlist.exists()));
        File root = new File(path);
        File[] list = root.listFiles();

       /** for (File file : list
                ) {
            String f = file.toString();
            if(file.isDirectory()){
                walk(file.toString());
            }
            if (f.endsWith(".mp3")) {
                try {
                    bw.write(f);
                    bw.newLine();
                    bw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }**/
            try {

             Files.walk(Paths.get(path)).filter(Files::isRegularFile).forEach((f) ->{
             String file = f.toString();
             if(file.endsWith(".mp3")){
             try {
             bw.write(file);
             bw.newLine();
             }catch(Exception e){
             e.printStackTrace();
             }
             }
             } );
             bw.close();}catch (Exception e){
             e.printStackTrace();
             }

        }

    }

