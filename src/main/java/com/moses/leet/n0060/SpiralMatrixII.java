package com.moses.leet.n0060;

import java.util.Arrays;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n){
        int layer = 0;
        int currNum = 1;
        int[][] rst = new int[n][n];
        for(int i=n; i>n/2; i--){
            int x = layer;
            int y = layer;

            for(int j = layer; j<i; j++) {
                rst[x][y++] = currNum++;
            }
            y--;
            if(y==n-i && x== n-i){
                break;
            }
            x++;
            for(int j=layer+1; j<i; j++){
                rst[x++][y] = currNum++;
            }
            x--;
            y--;
            for(int j= i-1; j>layer; j--){
                rst[x][y--] = currNum++;
            }
            y++;

            if(x-1>layer) {
                x--;
                for (int j = i-1; j > layer+1; j--) {
                    rst[x--][y] = currNum++;
                }
                x++;
            } else {
                break;
            }
            layer++;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[][] result = new SpiralMatrixII().generateMatrix(3);
        for(int[] i:result){
            System.out.println(Arrays.toString(i));
        }
        System.out.println();

        result = new SpiralMatrixII().generateMatrix(1);
        for(int[] i:result){
            System.out.println(Arrays.toString(i));
        }
        System.out.println();


        result = new SpiralMatrixII().generateMatrix(5);
        for(int[] i:result){
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }
}
