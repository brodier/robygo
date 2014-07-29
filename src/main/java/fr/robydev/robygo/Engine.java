package fr.robydev.robygo;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by brodier on 7/28/14.
 */
public class Engine extends Thread {
    protected static final Logger logger = Logger.getLogger(Engine.class.getName());

    private Scanner controller;
    private Board board;
    private ArrayList<Integer> movesHistory;
    private int capturedWhites;
    private int capturedBlacks;
    private float komi;
    private int mainTime;
    private int byoYomiTime;
    private int byoYomiStones;
    private static String[] cmdsList= {"protocol_version",
            "name",
            "version",
            "known_command",
            "list_commands",
            "quit",
            "boardsize",
            "clear_board",
            "komi",
            "play",
            "genmove"};

    public Engine(Scanner s){
        controller = s;
    }

    public String protocol_version(){
        return "2";
    }

    private String handleCmd(String cmd){
        boolean error = false;
        ArrayList<String> cmdList = new ArrayList<String>();
        for(String knownCommand: cmdsList){
            cmdList.add(knownCommand);
        }

        StringBuffer result = new StringBuffer("");
        String[] cmdLine = cmd.split(" ",2);
        int id = -1;
        boolean cmdIdPresent = true;
        try {
            id = Integer.parseInt(cmdLine[0]);
            cmd = cmdLine[1];
        } catch(NumberFormatException e){
            cmdIdPresent = false;
        }
        cmdLine = cmd.split(" ",2);
        String command = cmdLine[0];

        if(command.equals("protocol_version"))
            result.append("2");
        else if(command.equals("name"))
            result.append("RobyGo");
        else if(command.equals("version"))
            result.append("0.0.1");
        else if(command.equals("genmove")){
            result.append(" d4");
        } else if(command.equals("list_commands")){
           for(String knownCommand: cmdsList){
               result.append(knownCommand + "\n");
           }
        }
        else if(command.equals("known_command")){
          if(cmdList.contains(command)){
            result.append("true");
          } else {
              result.append("false");
          }

        } else if(!cmdList.contains(command)){
            error = true;
            result.append("unknown command # " + command);
        }

      if (error){
          result.insert(0, "? ");
      } else {
          result.insert(0, "= ");
      }
      if(cmdIdPresent){
          result.insert(1,Integer.toString(id));
      }

      result.append("\n\n");
      return result.toString();

    }

    public void run(){
        while(true){
            String cmd = controller.nextLine();
            System.err.println("Recieve commande : " + cmd);
            System.out.println(handleCmd(cmd));
        }
     }

    public static void main(String[] args){
        Engine e = new Engine(new Scanner(System.in));
        logger.info("Starting RobyGo Engine");

        try {
            e.run();
            e.join();
        } catch (InterruptedException e1) {
            logger.fatal("Exception on Engine thread", e1);
        }
        logger.info("Exiting RobyGo");
    }

}
