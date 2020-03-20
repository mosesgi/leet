package com.moses.leet.n0500;

import java.util.Arrays;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0){
            return new int[]{};
        }
        int cols = matrix[0].length;
        if(cols == 0){
            return new int[]{};
        }
        int size = rows * cols;
        int[] rst = new int[size];
        int idx = 0;
        boolean topRight = true;
        int i = 0, j = 0;
        while(idx < size){
            rst[idx++] = matrix[i][j];
            if(topRight){
                i--;
                j++;
            }else{
                i++;
                j--;
            }
            if(i<0 || j>=cols){
                topRight = false;
                if(j>=cols){
                    i+=2;
                    j--;
                }else if(i<0){
                    i++;
                }
            }
            if(j<0 || i>=rows){
                topRight = true;
                if(i>=rows){
                    j+=2;
                    i--;
                }else if(j<0){
                    j++;
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[][] matrix;
        matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(new DiagonalTraverse().findDiagonalOrder(matrix)));

        matrix = new int[][]{{2,5},{8,4},{0,-1}};
        System.out.println(Arrays.toString(new DiagonalTraverse().findDiagonalOrder(matrix)));

    }
}
