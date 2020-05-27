package com.moses.leet.n0320;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];

        for(int i=0; i<A.length; i++){
            for(int j=0; j< B[0].length; j++){
                for(int k=0; k<A[0].length;k++){
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }
}
