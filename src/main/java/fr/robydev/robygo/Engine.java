package fr.robydev.robygo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by brodier on 7/28/14.
 */
public class Engine {

    private Scanner controller;
    private Board board;
    private ArrayList<Integer> movesHistory;
    private int capturedWhites;
    private int capturedBlacks;
    private float komi;
    private int mainTime;
    private int byoYomiTime;
    private int byoYomiStones;


    public Engine(Scanner s){
        controller = s;
    }


    public void run(){

    }


}
