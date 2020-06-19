package com.moses.leet.n0500;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 *
 * Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
 *
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 *
 *
 *
 * Example 1:
 *
 * Input 1: a maze represented by a 2D array
 *
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 *
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
 *
 * Output: true
 *
 * Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
 *
 * Example 2:
 *
 * Input 1: a maze represented by a 2D array
 *
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 *
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
 *
 * Output: false
 *
 * Explanation: There is no way for the ball to stop at the destination.
 *
 *
 *
 * Note:
 *
 *     There is only one ball and one destination in the maze.
 *     Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
 *     The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
 *     The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 *
 */
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
