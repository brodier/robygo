package fr.robydev.robygo;

import java.util.ArrayList;

/**
 * Created by brodier on 7/25/14.
 */
public class StonesGroup {
    private ArrayList<Integer> liberties;
    private ArrayList<Integer> stonesPos;
    private boolean blackColor;

    public StonesGroup(int pos, boolean isBlack, int[] libs){
        liberties = new ArrayList<Integer>();
        stonesPos = new ArrayList<Integer>();
        stonesPos.add(pos);
        blackColor = isBlack;
        for(Integer lib: libs){
            if(!lib.equals(Board.UNDEF)) liberties.add(lib);
        }
    }
    public ArrayList<Integer> getStones(){ return stonesPos; }
    public boolean isOpponent(boolean isBlack){
        return (isBlack != blackColor);
    }

    public boolean isSameColor(boolean isBlack){
        return (isBlack == blackColor);
    }

    public boolean isInAtari(){
        if (liberties.size() == 1) {
            return true;
        }
        else return false;
    }

    public void removeLiberty(int pos){
        liberties.remove(new Integer(pos));
    }

    public void addStone(Integer pos){
        stonesPos.add(pos);
        liberties.remove(pos);
    }

    public void addLiberty(Integer lib){
        if(!liberties.contains(lib)){
            liberties.add(lib);
        }
    }

    public int countLiberties(){ return liberties.size(); }
    public int countStones(){ return stonesPos.size(); }

    public void joinWith(StonesGroup other, StonesGroup[] pos){
        for(int stone: other.stonesPos){
            pos[stone]=this;
        }
        for(Integer lib:other.liberties){
            if(pos[lib] == Board.EMPTY && !liberties.contains(lib)){
                liberties.add(lib);
            }
        }
    }
}
