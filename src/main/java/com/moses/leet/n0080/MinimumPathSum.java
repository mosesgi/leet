package com.moses.leet.n0080;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        for(int i=1; i<grid.length; i++){
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }
        for(int j=1; j<grid[0].length; j++){
            grid[0][j] = grid[0][j-1] + grid[0][j];
        }
        for(int i=1; i<grid.length; i++){
            for(int j=1; j<grid[0].length; j++){
                grid[i][j] = grid[i][j] + Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }


    public int minPathSumOld(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] rst = new int[rows][cols];
        for(int i=rows-1; i>=0; i--){
            for(int j=cols-1; j>=0; j--){
                if(i==rows-1 && j==cols-1){
                    rst[i][j] = grid[i][j];
                } else if(i==rows-1){
                    rst[i][j] = rst[i][j+1] + grid[i][j];
                } else if(j==cols-1){
                    rst[i][j] = rst[i+1][j] + grid[i][j];
                } else {
                    rst[i][j] = rst[i+1][j] < rst[i][j+1]? rst[i+1][j] + grid[i][j] : rst[i][j+1] + grid[i][j];
                }
            }
        }
        return rst[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(new MinimumPathSum().minPathSum(grid));


    }
}
