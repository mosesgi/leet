package com.moses.leet.n0900;

public class ProjectionAreaOf3DShapes {
    public int projectionArea(int[][] grid) {
        if(grid.length == 0 || grid[0].length==0){
            return 0;
        }
        int a = 0;

        int b = 0;
        for(int i=0; i<grid.length; i++){
            int row = 0;
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] > 0){
                    a++;
                }
                row = Math.max(row, grid[i][j]);
            }
            b+=row;
        }

        int c = 0;
        for(int j=0; j<grid[0].length; j++){
            int col = 0;
            for(int i=0; i<grid.length; i++){
                col = Math.max(col, grid[i][j]);
            }
            c+=col;
        }
        return a+b+c;
    }
}
