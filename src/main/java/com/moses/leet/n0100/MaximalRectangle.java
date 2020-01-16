package com.moses.leet.n0100;

/**
 * https://leetcode.com/problems/maximal-rectangle
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix){
        int max = 0;
        for(int i =0; i<matrix.length; i++){
            for(int j =0; j< matrix[i].length; j++){
                if(matrix[i][j] == '0'){
                    continue;
                }
                int tmp = calculate(matrix, i, j);
                if(tmp > max){
                    max = tmp;
                }
            }
        }
        return max;
    }

    private int calculate(char[][] matrix, int beginI, int beginJ) {
        int tmpArea = 0;
        int maxLen = matrix[beginI].length - beginJ;
        for(int i=beginI; i<matrix.length; i++){
            if(matrix[i][beginJ] == '0'){
                break;
            }
            for(int j= beginJ; j<beginJ+maxLen; j++){
                if(matrix[i][j] == '0'){
                    maxLen = j-beginJ;
                    int currArea = maxLen * (i-beginI + 1);
                    if(currArea > tmpArea){
                        tmpArea = currArea;
                    }
                    break;
                } else if(j==beginJ+maxLen-1){
                    int currArea = (j-beginJ +1) * (i-beginI +1);
                    if(currArea > tmpArea){
                        tmpArea = currArea;
                    }
                }
            }

        }
        return tmpArea;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(new MaximalRectangle().maximalRectangle(matrix));

        matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','1','1','0','1'},
                {'1','1','1','1','1'},
                {'0','1','1','1','0'}
        };
        System.out.println(new MaximalRectangle().maximalRectangle(matrix));
    }
}
