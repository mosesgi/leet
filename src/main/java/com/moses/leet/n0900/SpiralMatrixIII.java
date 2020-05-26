package com.moses.leet.n0900;

import com.moses.leet.utils.PrintUtil;

public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int size = R*C;
        int p = 0;
        int[][] rst = new int[size][2];
        int step = 0;
        int[][] directions = new int[][]{
                {0,1}, {1,0}, {0,-1}, {-1,0}
        };
        rst[p++] = new int[]{r0, c0};
        int x = r0;
        int y = c0;
        while(p<size){
            for(int i=0; i<directions.length; i++){
                if(i%2==0) {
                    step++;
                }
                int[] d = directions[i];
                for(int j=0; j<step; j++){
                    x+= d[0];
                    y+= d[1];
                    if(x>=0 && x<R && y>=0 && y<C){
                        rst[p++] = new int[]{x,y};
                        if(p == size){
                            return rst;
                        }
                    }
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        PrintUtil.printMatrix(new SpiralMatrixIII().spiralMatrixIII(1,4,0,0));
        PrintUtil.printMatrix(new SpiralMatrixIII().spiralMatrixIII(5,6,1,4));
    }
}
