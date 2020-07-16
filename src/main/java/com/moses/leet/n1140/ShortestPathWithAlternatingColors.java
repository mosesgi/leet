package com.moses.leet.n1140;

import java.util.*;

public class ShortestPathWithAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Map<Integer, Set<Integer>> reds = new HashMap<>();
        Map<Integer, Set<Integer>> blues = new HashMap<>();
        for(int[] r : red_edges){
            reds.putIfAbsent(r[0], new HashSet<>());
            reds.get(r[0]).add(r[1]);
        }
        for(int[] b : blue_edges){
            blues.putIfAbsent(b[0], new HashSet<>());
            blues.get(b[0]).add(b[1]);
        }
        int[] red = new int[n];
        int[] blue = new int[n];
        Arrays.fill(red, Integer.MAX_VALUE);
        Arrays.fill(blue, Integer.MAX_VALUE);
        boolean[][] visited = new boolean[n][2];
        dfs(0, -1, reds, blues, 0, red, blue, visited);
        for(int i=0; i<red.length; i++){
            red[i] = Math.min(red[i], blue[i]);
            if(red[i] == Integer.MAX_VALUE){
                red[i] = -1;
            }
        }
        return red;
    }

    void dfs(int start, int redBlue, Map<Integer, Set<Integer>> reds, Map<Integer, Set<Integer>> blues,
             int steps, int[] red, int[] blue, boolean[][] visited){

        if(redBlue == -1){
            red[start] = 0;
            if(reds.containsKey(start)){
                for(int next : reds.get(start)){
                    dfs(next, 1, reds, blues, steps+1, red, blue, visited);
                }
            }
            if(blues.containsKey(start)){
                for(int next : blues.get(start)){
                    dfs(next,  0, reds, blues, steps+1, red, blue, visited);
                }
            }
        }else{
            if(redBlue==0){ //red
                if(steps >= red[start]){
                    return;
                }
                red[start] = steps;
                if(reds.containsKey(start)){
                    for(int next : reds.get(start)){
                        dfs(next,1, reds, blues, steps+1, red, blue, visited);
                    }
                }
            }else{
                if(steps >= blue[start]){
                    return;
                }
                blue[start] = steps;
                if(blues.containsKey(start)){
                    for(int next : blues.get(start)){
                        dfs(next,0, reds, blues, steps+1, red, blue, visited);
                    }
                }
            }
        }
    }


}
