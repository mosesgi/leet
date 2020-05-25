package com.moses.leet.n0500;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] cur = q.poll();

                for(int[] d : directions){
                    int x = cur[0];
                    int y = cur[1];
                    while(x + d[0] >= 0 && x+d[0]<maze.length && y+d[1] >=0 && y+d[1] < maze[0].length && maze[x+d[0]][y+d[1]] != 1){
                        x += d[0];
                        y += d[1];
                    }
                    if(visited[x][y]){
                        continue;
                    }
                    if(x == destination[0] && y==destination[1]){
                        return true;
                    }
                    q.offer(new int[]{x,y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}
