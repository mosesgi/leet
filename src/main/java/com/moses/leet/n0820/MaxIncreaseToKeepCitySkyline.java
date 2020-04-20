package com.moses.leet.n0820;

public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] rowMax = new int[rows];
        int[] colMax = new int[cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }

        int res = 0;
        for(int i=0; i<rows; i++) {
            for (int j = 0; j < cols; j++) {
                int target = Math.min(rowMax[i], colMax[j]);
                res += (target - grid[i][j]);
            }
        }
        return res;
    }
}
