package com.moses.leet.n0800;

import java.util.*;

public class ValidTicTacToeState {
    public boolean validTicTacToe(String[] board) {
        Set<Integer> xPos = new HashSet<>();
        Set<Integer> oPos = new HashSet<>();
        int idx = 1;
        for(String s : board){
            for(char c : s.toCharArray()){
                if(c=='X'){
                    xPos.add(idx);
                }else if(c=='O'){
                    oPos.add(idx);
                }
                idx++;
            }
        }
        if(oPos.size()>xPos.size() || oPos.size()<xPos.size()-1){
            return false;
        }

        List<int[]> win = new ArrayList<>();
        win.add(new int[]{1,2,3});
        win.add(new int[]{4,5,6});
        win.add(new int[]{7,8,9});
        win.add(new int[]{1,4,7});
        win.add(new int[]{2,5,8});
        win.add(new int[]{3,6,9});
        win.add(new int[]{1,5,9});
        win.add(new int[]{3,5,7});

        int xWin = 0;
        int oWin = 0;
        for(int[] w : win){
            boolean winX = true;
            boolean winO = true;
            for(int i : w){
                if(!xPos.contains(i)){
                    winX = false;
                }
                if(!oPos.contains(i)){
                    winO = false;
                }
            }
            if(winX){
                xWin++;
            }
            if(winO){
                oWin++;
            }
        }
        if(xWin>=1 && oWin>=1){
            return false;
        }
        if(xWin >= 1 && oPos.size() >= xPos.size()){
            return false;
        }
        if(oWin >= 1 && xPos.size() > oPos.size()){
            return false;
        }
        return true;
    }
}
