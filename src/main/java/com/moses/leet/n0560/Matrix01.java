package com.moses.leet.n0560;

import com.moses.leet.utils.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] rst = new int[rows][cols];
        int[][] directions = new int[][]{
                {1,0},{-1,0},{0,1},{0,-1}
        };
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j] == 0){
                    rst[i][j] = 0;
                    continue;
                }
                int step = bfs(matrix, i, j, directions);
                rst[i][j] = step;
            }
        }
        return rst;
    }

    private int bfs(int[][] matrix, int i, int j, int[][] directions) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        int step = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k<size; k++){
                int[] curr = q.poll();
                for(int m = 0; m<directions.length; m++){
                    int tmpI = curr[0] + directions[m][0];
                    int tmpJ = curr[1] + directions[m][1];
                    if(tmpI < 0 || tmpI >=rows || tmpJ <0 || tmpJ >=cols){
                        continue;
                    }
                    if(matrix[tmpI][tmpJ] == 0){
                        return step;
                    }
                    q.offer(new int[]{tmpI, tmpJ});
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix;

        matrix = new int[][]{{1,0,1,1,0,0,1,0,0,1},
                {0,1,1,0,1,0,1,0,1,1},
                {0,0,1,0,1,0,0,1,0,0},
                {1,0,1,0,1,1,1,1,1,1},
                {0,1,0,1,1,0,0,0,0,1},
                {0,0,1,0,1,1,1,0,1,0},
                {0,1,0,1,0,1,0,0,1,1},
                {1,0,0,0,1,1,1,1,0,1},
                {1,1,1,1,1,1,1,0,1,0},
                {1,1,1,1,0,1,0,0,1,1}};
        PrintUtil.printMatrix(new Matrix01().updateMatrix(matrix));

        matrix = new int[][]{{0,0,0},
                {0,1,0},
                {0,0,0}};
        PrintUtil.printMatrix(new Matrix01().updateMatrix(matrix));

        matrix = new int[][]{{0,0,0},
                {0,1,0},
                {1,1,1}};
        PrintUtil.printMatrix(new Matrix01().updateMatrix(matrix));


    }
}
