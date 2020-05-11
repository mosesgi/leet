package com.moses.leet.n0240;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if(rows == 0){
            return 0;
        }
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int res = 0;
        for(int j=0; j<cols; j++){
            dp[0][j] = matrix[0][j] == '1'?1:0;
            res = Math.max(res, dp[0][j]);
        }

        for(int i=0; i<rows; i++){
            dp[i][0] = matrix[i][0] == '1'?1:0;
            res = Math.max(res, dp[i][0]);
        }


        for(int i=1; i<rows; i++){
            for(int j= 1; j<cols; j++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res*res;
    }



    int finalMax =0;
    public int maximalSquareOld(char[][] matrix) {

        int rows = matrix.length;
        if(rows == 0){
            return 0;
        }
        int cols = matrix[0].length;
        if(cols == 0){
            return 0;
        }
        int tmpMax = Math.max(rows, cols);
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j] == '0'){
                    continue;
                }
                int tmp = judgeSquare(matrix, i, j, rows, cols, tmpMax, 0);
                if(tmp>finalMax){
                    finalMax = tmp;
                }
            }
        }
        return finalMax*finalMax;
    }

    private int judgeSquare(char[][] matrix, int row, int col, int rows, int cols, int max, int level){
        if(max == 0){
            return 0;
        }
        int tmpRow = row;
        int tmpCol = col;
        while(tmpRow < rows && tmpRow<row+max && matrix[tmpRow][col] == '1'){
            tmpRow++;
        }
        while(tmpCol < cols && tmpCol<col+max && matrix[row][tmpCol] == '1'){
            tmpCol++;
        }
        int tmpMax = Math.min(tmpRow-row, tmpCol-col);
        if(tmpMax == 0){
            return -1;
        }
        if(tmpMax < finalMax - level){
            return -1;
        }
        int nextReturn = judgeSquare(matrix, row+1, col+1, rows, cols, tmpMax-1, level+1);
        return Math.min(nextReturn+1, tmpMax);
    }

    public static void main(String[] args) {
        char[][] matrix;
        matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }
}
