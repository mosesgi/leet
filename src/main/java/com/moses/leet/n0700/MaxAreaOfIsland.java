package com.moses.leet.n0700;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int[][] directions = new int[][]{
                {-1, 0}, {1,0}, {0,-1}, {0,1}
        };
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0 || grid[i][j] == -1){
                    continue;
                }
                int island = dfs(grid, i, j, directions);
                max = Math.max(island, max);
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, int[][] directions) {
        int tmp = 1;
        grid[i][j] = -1;
        for(int k = 0; k<directions.length; k++){
            int[] dir = directions[k];
            int x = i+dir[0];
            int y = j+dir[1];
            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y] == 1){
                tmp += dfs(grid, x, y, directions);
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[][] grid;
        grid = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
    }


}
