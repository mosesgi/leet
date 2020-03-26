package com.moses.leet.n0580;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int or = nums.length;
        int oc = nums[0].length;
        if(or * oc != r*c){
            return nums;
        }

        int[] d = new int[or*oc];
        int idx = 0;
        for(int i=0; i<or; i++){
            for(int j=0; j<oc; j++){
                d[idx++] = nums[i][j];
            }
        }

        idx=0;
        int[][] matrix = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                matrix[i][j] = d[idx++];
            }
        }
        return matrix;
    }
}
