package Ressources;


import UEB01.MP3Player;

public class controller {
    private  MP3Player player  = new MP3Player();


    public controller(){
    }



    public  void  doCommand(String command[]){

        for (int i = 0; i < command.length; i++) {

            switch (command[i]) {
                case "play":
                    if(command.length>i+1){
                        player.play(command[i+1]);}
                    else player.play();
                    break;

                case "pause":
                    player.pause();
                    break;

                case "balance":

                    player.balance(Float.parseFloat(command[i+1]));
                    break;

                case "volume":
                    player.volume(Float.parseFloat(command[i+1]));
                    break;
                case "stop":
                    player.stop();
                    break;

            }
        }
    }
}
