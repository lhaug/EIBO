package Ressources;

import de.hsrm.mi.prog.util.StaticScanner;

public class Main {

    public static void main(String[] args){

        StaticScanner sc = new StaticScanner();
        String s;
        String[] command;
        controller c = new controller();

        do{
            s = sc.nextString();
            command = s.split(" ");
            c.doCommand(command);
        }while(!s.equalsIgnoreCase("quit"));
    }
}
