package fr.robydev.robygo;

import java.util.ArrayList;

/**
 * Created by brodier on 7/25/14.
 */
public class Board {
    public static final int DEFAULT_SIZE=19;
    public static final int EMPTY=-1;
    public static final int KO=-2;
    private int[] position = new int[DEFAULT_SIZE * DEFAULT_SIZE];
    private int koPos = EMPTY;
    private ArrayList<StonesGroup> groups = new ArrayList<StonesGroup>();
    private final int[][] ngbPositions = initNgbPos();
    private boolean blackTurn = true;
    private int size = DEFAULT_SIZE;

    private static int[][] initNgbPos(){
        int sz = DEFAULT_SIZE;
        int[][] ngbPos = new int[sz*sz][];
        int tmpNgb[] = new int[4];
        int nbNgb;
        for(int x = 0; x < sz; x++) {
            for(int y= 0; y < sz; y++) {
                int curPos = x + (y * sz);
                 nbNgb = 0;
                if(x != 0) { nbNgb++;
                    tmpNgb[nbNgb] = curPos - 1 ;
                }
                if(y != 0) { nbNgb++;
                    tmpNgb[nbNgb] = curPos - sz ;
                }
                if(x+1 != sz) { nbNgb++;
                    tmpNgb[nbNgb] = curPos + 1 ;
                }
                if(y+1 != sz) { nbNgb++;
                    tmpNgb[nbNgb] = curPos + sz ;
                }

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
        int [] libs = new int[]{EMPTY,EMPTY,EMPTY,EMPTY};
        int nbLibs = 0;
        boolean newGroup = true;
        StonesGroup firstGroup = null;
        if(!isValid(pos)){
            return false;
        }
        int[] ngbs = ngbPositions[pos];
        for(int ngb: ngbs){
            if(position[ngb] == EMPTY){
                libs[nbLibs++] = position[ngb];
                continue;
            } else {
               StonesGroup g = groups.get(ngb);
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
                       firstGroup.joinWith(g,pos);
                   }
               }
            }
            if(newGroup){
                StonesGroup g = new StonesGroup(pos, blackTurn, libs);
                groups.add(g);
                position[pos] = groups.size() - 1;
            } else {

            }
        }


        return true;
    }

    public boolean isValid(int pos){
        if(position[pos] != EMPTY){
            return false;
        }
        int [] ngbs = ngbPositions[pos];
        for(int ngb: ngbs) {
            if (position[ngb] == EMPTY) {
                return true;
            } else if (position[ngb] == KO) {
                return false;
            }
        }
        // All neighbors are occupied by stones check if capture or connect to a group that is not in atari
        for(int ngb: ngbs) {
            int ngbPos = position[ngb];
            StonesGroup g = groups.get(ngbPos);
            if(g.isOpponent(blackTurn) && g.isInAtari()){
                return true;
            } else if(!g.isSameColor(blackTurn) && !g.isInAtari()){
                return true;
            }
        }
        // Suicide move
        return false;
    }

}
