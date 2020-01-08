package com.moses.leet.n0060;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {
    /**
     * 3X3
     * [0,0] -> [0,2], [0,2] -> [2,2], [2,2] -> [2,0], [2,0] -> [0,0]
     * [0,1] -> [1,2], [1,2] -> [2,1], [2,1] -> [1,0], [1,0] -> [0,1]
     *
     * 4X4
     * [0,0] [0,3], [0,3] [3,3], [3,3] [3,0], [3,0] [0,0]
     * [0,1] [1,3], [1,3] [3,2], [3,2] [2,0], [2,0] [0,1]
     * [0,2] [2,3], [2,3] [3,1], [3,1] [1,0], [1,0] [0,2]
     * [1,1] [1,2], [1,2] [2,2], [2,2] [2,1], [2,1] [1,1]
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int allLevels = (n-1)/2;
        for(int i=0; i<=allLevels; i++) {
            rotateLevel(matrix, i, n);
        }
    }

    private void rotateLevel(int[][] matrix, int level, int size) {
        int loopPerLevel = size-2*level-1;
        for(int k=0; k<loopPerLevel; k++) {
            int i = level, j = k+level;
            int prev = matrix[i][j];
            for (int m = 0; m < 4; m++) {
                int tmpI = i;
                i = j;
                j = size - 1 - tmpI;
                int curr = matrix[i][j];
                matrix[i][j] = prev;
                prev = curr;
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        new RotateImage().rotate(matrix);
        for(int[] line:matrix){
            System.out.println(Arrays.toString(line));
        }
        System.out.println();

        matrix = new int[][]{
                {5, 1, 9,11},
                {2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        new RotateImage().rotate(matrix);
        for(int[] line:matrix){
            System.out.println(Arrays.toString(line));
        }
        System.out.println();


        matrix = new int[][]{
                {5, 1, 9,11, 13},
                {2, 4, 8,10, 12},
                {13, 3, 6, 7, 9},
                {15,14,12,16,18},
                {18,20,22,24,26}
        };
        new RotateImage().rotate(matrix);
        for(int[] line:matrix){
            System.out.println(Arrays.toString(line));
        }
        System.out.println();
    }
}
