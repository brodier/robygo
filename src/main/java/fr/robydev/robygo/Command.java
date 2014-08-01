package fr.robydev.robygo;

/**
 * Created by brodier on 8/1/14.
 */
public class Command {

    String cmd = "";
    String args = "";
    int id = -1;

    public Command(String cmd, String args, int id){
        this.cmd = cmd;
        this.args = args;
        this.id = id;
    }
}

