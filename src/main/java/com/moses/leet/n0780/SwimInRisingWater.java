package com.moses.leet.n0780;

import com.moses.leet.utils.PrintUtil;

import java.util.Arrays;

public class SwimInRisingWater {
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] visited = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(visited[i], -2);
        }
        visited[0][0] = grid[0][0]-1;
        int total = n * n - 1;
        for(int i=grid[0][0]; i<=total; i++){
//            PrintUtil.printMatrix(visited);
            if(expand(grid, visited, i)){
                return i;
            }
        }
        return total;
    }

    private boolean expand(int[][] grid, int[][] visited, int t) {
        for(int i=0; i<visited.length; i++){
            for(int j = 0; j<visited.length; j++){
                if(visited[i][j] >=-1 && visited[i][j]<=t-1){
                    if(dfs(grid, visited, i, j, t)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int[][] grid, int[][] visited, int i, int j, int t) {
        for(int[] d : dirs){
            int x = i+d[0];
            int y = j+d[1];
            if(x>=0 && x<grid.length && y>=0 && y<grid.length && visited[x][y] == -2 && grid[x][y] <= t){
                if(x==grid.length-1 && y==grid.length-1){
                    return true;
                }
                visited[x][y] = t;
                if(dfs(grid, visited, x, y, t)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid;

        grid = new int[][]{
                {11,15,3, 2},
                {6, 4, 0,13},
                {5, 8, 9,10},
                {1,14,12, 7}};
        System.out.println(new SwimInRisingWater().swimInWater(grid));

        grid = new int[][]{{0,2},{1,3}};
        System.out.println(new SwimInRisingWater().swimInWater(grid));

        grid = new int[][]{{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        System.out.println(new SwimInRisingWater().swimInWater(grid));
    }
}
