package com.moses.leet.n0080;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] rst = new int[rows][cols];

        boolean obstacleMet = false;
        for(int i=rows-1; i>=0; i--){
            if(obstacleGrid[i][cols-1] == 1){
                rst[i][cols-1] = 0;
                obstacleMet = true;
                continue;
            }
            if(!obstacleMet) {
                rst[i][cols - 1] = 1;
            }
        }
        obstacleMet = false;
        for(int i=cols-1; i>=0; i--){
            if(obstacleGrid[rows-1][i] == 1){
                rst[rows-1][i] =0;
                obstacleMet = true;
                continue;
            }
            if(!obstacleMet) {
                rst[rows - 1][i] = 1;
            }
        }

        for(int i=rows-2; i>=0; i--){
            for(int j=cols-2; j>=0; j--){
                if(obstacleGrid[i][j] == 1){
                    rst[i][j] = 0;
                    continue;
                }
                rst[i][j] = rst[i][j+1] + rst[i+1][j];
            }
        }
        return rst[0][0];
    }


    public static void main(String[] args) {
        int[][] obstacle = new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(obstacle));

        obstacle = new int[][]{
                {0,0,0,0},
                {0,0,0,0},
                {0,0,1,0},
                {0,0,0,0}
        };
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(obstacle));
    }
}
