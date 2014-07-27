package fr.robydev.robygo;

import java.util.ArrayList;

/**
 * Created by brodier on 7/25/14.
 */
public class Board {
    public static final int DEFAULT_SIZE=19;
    // Empty position are represented by a StonesGroup reference set to null
    public static final StonesGroup EMPTY=null;
    // Undefined Position
    public static final int UNDEF=-1;
    private StonesGroup[] position = new StonesGroup[DEFAULT_SIZE * DEFAULT_SIZE];
    private int koPos = UNDEF;
    private final int[][] ngbPositions = initNgbPos();
    private boolean blackTurn = true;
    private int size = DEFAULT_SIZE;

    private static int[][] initNgbPos(){
        int sz = DEFAULT_SIZE;
        int[][] ngbPos = new int[sz*sz][];
        int [] tmpNgb = new int[4];
        int nbNgb;
        for(int x = 0; x < sz; x++) {
            for(int y= 0; y < sz; y++) {
                int curPos = x + (y * sz);
                 nbNgb = 0;
                if(x != 0) { tmpNgb[nbNgb++] = curPos - 1 ; }
                if(y != 0) { tmpNgb[nbNgb++] = curPos - sz ; }
                if(x+1 != sz) { tmpNgb[nbNgb++] = curPos + 1 ; }
                if(y+1 != sz) { tmpNgb[nbNgb++] = curPos + sz ; }

                ngbPos[curPos] = new int[nbNgb];
                for(int i = 0; i < nbNgb; i++) {
                    ngbPos[curPos][i] = tmpNgb[i];
                }

            }
        }
        return ngbPos;
    }


    public Board(){

    }

    public boolean move(int pos){
        ArrayList<StonesGroup> groupsToCapture = null;
        ArrayList<StonesGroup> groupToJoin = null;
        int [] libs = new int[]{UNDEF,UNDEF,UNDEF,UNDEF};
        int nbLibs = 0;
        boolean newGroup = true;
        StonesGroup firstGroup = null;
        if(!isValid(pos)){
            return false;
        }
        int[] ngbs = ngbPositions[pos];
        for(int ngb: ngbs){
            StonesGroup g = position[ngb];
            if(g == EMPTY){
                libs[nbLibs++] = ngb;
                continue;
            } else {
               if(g.isOpponent(blackTurn)){
                   if(g.isInAtari()){
                       if(groupsToCapture == null){ groupsToCapture = new ArrayList<StonesGroup>(); }
                       groupsToCapture.add(g);
                   } else {
                     g.removeLiberty(pos);
                   }
               } else {
                   if(newGroup){
                       firstGroup = g;
                       newGroup = false;
                       g.addStone(pos);
                   } else {
                       firstGroup.addStone(pos);
                       firstGroup.joinWith(g,position);
                   }
               }
            }
        }

        if(newGroup){
            firstGroup = new StonesGroup(pos, blackTurn, libs);
        }
        if(groupsToCapture != null){
            for(StonesGroup gtr: groupsToCapture){
                removeGroup(gtr);
            }
        }
        position[pos] = firstGroup;
        blackTurn = !blackTurn;
        return true;
    }

    private void removeGroup(StonesGroup gpToRemove){
        for(int i: gpToRemove.getStones()){
            position[i] = EMPTY;
            for(int ngb: ngbPositions[i]){
                if(position[ngb] != EMPTY && position[ngb].isSameColor(blackTurn)){
                    position[ngb].addLiberty(i);
                }
            }
        }
    }

    public boolean isValid(int pos){
        if(pos == koPos || position[pos] != EMPTY){
            return false;
        }
        int [] ngbs = ngbPositions[pos];
        for(int ngb: ngbs) {
            if (position[ngb] == EMPTY) {
                return true;
            }
        }
        // All neighbors are occupied by stones check if capture or connect to a group that is not in atari
        for(int ngb: ngbs) {
            StonesGroup g = position[ngb];
            if(g.isOpponent(blackTurn) && g.isInAtari()){
                return true;
            } else if(!g.isSameColor(blackTurn) && !g.isInAtari()){
                return true;
            }
        }
        // Suicide move
        return false;
    }

    public String toString(){
        StringBuffer buff = new StringBuffer();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                StonesGroup posStatus =position[j+i*size];
                if(posStatus == EMPTY){
                    buff.append(".");
                } else if(posStatus.isSameColor(true)){
                    buff.append("X");
                } else {
                    buff.append("O");
                }
            }
            buff.append("\n");
        }
        return buff.toString();
    }

    public static int computePos(int x, int y){ return (x-1) + 19 * (y-1);}
    public static void main (String [] arg){
        Board b = new Board();
        b.move(computePos(4,4));
        b.move(computePos(5,4));
        b.move(computePos(3,5));
        b.move(computePos(6,5));
        b.move(computePos(4,6));
        b.move(computePos(5,6));
        b.move(computePos(5,5));
        System.out.println(b.toString());
        b.move(computePos(4,5));
        System.out.println(b.toString());
    }

}
