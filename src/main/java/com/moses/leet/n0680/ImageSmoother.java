package com.moses.leet.n0680;

public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int rows = M.length;
        int cols = M[0].length;
        int[][] rst = new int[rows][cols];
        int[][] directions = new int[][]{
                {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}
        };

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int cnt = 1;
                int total = M[i][j];
                for(int[] dir : directions){
                    int x = i+dir[0];
                    int y = j+dir[1];
                    if(x>=0 && x<rows && y>=0 && y<cols){
                        cnt++;
                        total += M[x][y];
                    }
                }
                rst[i][j] = total/cnt;
            }
        }
        return rst;
    }
}
