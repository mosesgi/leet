package com.moses.leet.n1260;

public class NumberOfClosedIslands {
    int[][] directions = new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    public int closedIsland(int[][] grid) {
        if(grid.length==0 || grid[0].length==0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        for(int j=0; j<cols; j++){
            if(grid[0][j] == 0){
                dfs(grid, 0, j, 3);
            }
            if(grid[rows-1][j] == 0){
                dfs(grid, rows-1, j, 3);
            }
        }
        for(int i=0; i<rows; i++){
            if(grid[i][0] == 0){
                dfs(grid, i, 0, 3);
            }
            if(grid[i][cols-1] == 0){
                dfs(grid, i, cols-1, 3);
            }
        }
        int res = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 0){
                    res++;
                    dfs(grid, i, j, 2);
                }
            }
        }
        return res;
    }

    void dfs(int[][] grid, int i, int j, int val){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] != 0){
            return;
        }
        grid[i][j] = val;
        for(int[] d: directions){
            int x = i+d[0];
            int y = j+d[1];
            dfs(grid, x, y, val);
        }
    }
}
