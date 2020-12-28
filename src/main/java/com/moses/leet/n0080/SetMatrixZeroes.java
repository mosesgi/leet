package com.moses.leet.n0080;

import com.moses.leet.utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        //set first row to 0 if any value is 0, indicating the column is all 0
        //set first column to 0 if any value is 0, indicating the row is all 0
        boolean firstRowZero = false, firstColumnZero = false;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] != 0){
                    continue;
                }
                if(i==0 && j==0){
                    firstRowZero = true;
                    firstColumnZero = true;
                }else if(i==0){
                    firstRowZero = true;
                } else if(j==0){
                    firstColumnZero = true;
                } else {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        PrintUtil.printMatrix(matrix);

        //when setting the values, leave the first row and column alone, treat them separately using flags
        for(int i=1; i<matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j=1; j<matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j=1; j<matrix[0].length; j++){
            if(matrix[0][j] == 0){
                for(int i=1; i<matrix.length; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstRowZero){
            for(int j=0; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
        if(firstColumnZero){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0] = 0;
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

    public void setZeroes1(int[][] matrix){
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




}
