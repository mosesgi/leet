package com.moses.leet.n0080;

import com.moses.leet.utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {


    public void setZeroes(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] zeroRows = new int[rows];
        int[] zeroCols = new int[cols];
        for(int i=0; i<zeroRows.length; i++){
            zeroRows[i] = 1;
        }
        for(int i=0; i<zeroCols.length; i++){
            zeroCols[i] = 1;
        }

        for(int i=0;i<rows; i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j] == 0){
                    zeroRows[i] = 0;
                    zeroCols[j] = 0;
                }
            }
        }

        for(int i=0;i<rows; i++){
            for(int j=0; j<cols; j++){
                if(zeroRows[i] == 0 || zeroCols[j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
    }


    //O(mn) bad idea
    public void setZeroesOmn(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] zeroes = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                zeroes[i][j] = 1;
            }
        }

        for(int i=0;i<rows; i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j] == 0){
                    for(int x=0; x<rows; x++){
                        for(int y=0; y<cols; y++){
                            if(x==i || y==j){
                                zeroes[x][y] = 0;
                            }
                        }
                    }
                }
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(zeroes[i][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
    }



    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        new SetMatrixZeroes().setZeroes(matrix);
        PrintUtil.printMatrix(matrix);

        matrix = new int[][]{
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        new SetMatrixZeroes().setZeroes(matrix);
        PrintUtil.printMatrix(matrix);
    }
}
