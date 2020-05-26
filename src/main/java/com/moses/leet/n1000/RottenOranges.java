package com.moses.leet.n1000;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][]{
                {-1,0},{1,0},{0,1},{0,-1}
        };
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] cur = q.poll();
                for(int[] d : directions){
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];
                    if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y] != 1){
                        continue;
                    }
                    grid[x][y] = 2;
                    q.offer(new int[]{x,y});
                }
            }
            if(!q.isEmpty()){
                steps++;
            }
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return steps;
    }
}
