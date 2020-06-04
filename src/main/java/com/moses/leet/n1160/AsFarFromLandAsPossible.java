package com.moses.leet.n1160;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized and return the distance.
 *
 * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 *
 * If no land or water exists in the grid, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation:
 * The cell (1, 1) is as far as possible from all the land with distance 2.
 *
 * Example 2:
 *
 * Input: [[1,0,0],[0,0,0],[0,0,0]]
 * Output: 4
 * Explanation:
 * The cell (2, 2) is as far as possible from all the land with distance 4.
 *
 *
 *
 * Note:
 *
 *     1 <= grid.length == grid[0].length <= 100
 *     grid[i][j] is 0 or 1
 *
 */
public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[][] directions = new int[][]{
                {-1, 0},{0,1},{0,-1},{1,0}
        };
        Integer max = null;
        while(!q.isEmpty()){
            int[] o = q.poll();
            for(int i=0; i<directions.length; i++){
                int[] d = directions[i];
                int x = o[0]+d[0];
                int y = o[1]+d[1];
                if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y] == 0){
                    grid[x][y] = grid[o[0]][o[1]]+1;
                    if(max == null){
                        max = grid[x][y];
                    }else{
                        max = Math.max(max, grid[x][y]);
                    }
                    q.offer(new int[]{x,y});
                }
            }
        }
        if(max == null){
            return -1;
        }
        return max-1;
    }
}
