package com.moses.leet.n0880;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, Set<Integer>> obs = new HashMap<>();
        for(int[] o : obstacles){
            obs.computeIfAbsent(o[0], z->new HashSet<>()).add(o[1]);
        }
        int[][] directions = new int[][]{
                {-1,0}, {0,1}, {1,0}, {0,-1}
        };
        int max = 0;
        int a = 0, b = 0;
        int dirPos = 1;
        for(int i=0; i<commands.length; i++){
            int c = commands[i];
            if(c<0){
                dirPos = getDir(dirPos, c);
                continue;
            }
            int[] dir = directions[dirPos];
            for(int j=0; j<c; j++){
                int x = a+dir[0];
                int y = b+dir[1];
                if(obs.containsKey(x) && obs.get(x).contains(y)){
                    break;
                }
                a = x;
                b = y;
                max = Math.max(max, a*a + b*b);
            }
        }
        return max;
    }

    private int getDir(int dirPos, int command){
        if(command == -2){
            dirPos--;
            if(dirPos < 0){
                dirPos = 3;
            }
        }else if(command == -1){
            dirPos++;
            if(dirPos > 3){
                dirPos = 0;
            }
        }
        return dirPos;
    }

    public static void main(String[] args) {
        int[] commands;
        int[][] obs;
        commands = new int[]{4,-1,4,-2,4};
        obs = new int[][]{{2,4}};
        System.out.println(new WalkingRobotSimulation().robotSim(commands, obs));
    }
}
