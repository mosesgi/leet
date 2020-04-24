package com.moses.leet.n0060;

import java.math.BigDecimal;
import java.util.Arrays;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n){
        int[][] m = new int[n][n];
        int num = 1;
        int x = 0, y = 0, xz = n-1, yz = n-1;
        while(x<=xz && y<=yz){
            //right
            for(int i=y; i<=yz; i++){
                m[x][i] = num++;
            }
            x++;
            //down
            for(int i=x; i<=xz; i++){
                m[i][yz] = num++;
            }
            yz--;

            if(y>yz){
                break;
            }
            //left
            for(int i=yz; i>=y; i--){
                m[xz][i] = num++;
            }
            xz--;

            if(x>xz){
                break;
            }
            //up
            for(int i=xz; i>=x; i--){
                m[i][y] = num++;
            }
            y++;
        }
        return m;
    }


    public int[][] generateMatrixOld(int n){
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
