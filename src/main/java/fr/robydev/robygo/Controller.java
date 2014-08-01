package fr.robydev.robygo;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Scanner;

/**
 * Created by brodier on 8/1/14.
 */
public class Controller {

    public PrintStream out;
    public Scanner in;

    public Controller(Scanner input, PrintStream output){
        in = input;
        out = output;
    }

    public Command nextCmd() {
        String cmd, args = "";
        String [] cmdline;
        int id = -1;
        // read line and remove comment
        cmdline = in.nextLine().split("#", 2);
        cmdline = cmdline[0].split(" ",3);
        try{
            id = Integer.parseInt(cmdline[0]);
            cmd = cmdline[1];
            if(cmdline.length > 2) { args = cmdline[2]; }
        } catch(NumberFormatException e){
            cmd = cmdline[0];
            if(cmdline.length > 1) { args = cmdline[1]; }
        }

        try {
            Method m = Controller.class.getMethod("gtpCmd_" + cmd,String.class);
            Command req = (Command) m.invoke(args);
        } catch (NoSuchMethodException e) {
            return null;
        }

        return new Command(cmd,args,id);
    }

    public String postCommandWithId(String cmd, String args, int id){

    }
    public String postCommand(String cmd, String args){

    }

}
