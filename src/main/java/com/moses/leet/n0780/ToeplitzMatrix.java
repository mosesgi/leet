package com.moses.leet.n0780;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int j=0; j<cols; j++){
            int start = matrix[0][j];
            int x = 1, y = j+1;
            while(x<rows && y<cols){
                if(matrix[x][y] != start){
                    return false;
                }
                x++;
                y++;
            }
        }
        for(int i=1; i<rows; i++){
            int start = matrix[i][0];
            int x = i+1, y = 1;
            while(x<rows && y<cols){
                if(matrix[x][y] != start){
                    return false;
                }
                x++;
                y++;
            }
        }
        return true;
    }

}
