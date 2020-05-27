package com.moses.leet.n0840;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A.length == 0 || A[0].length == 0){
            return A;
        }
        for(int i=0; i<A.length; i++){
            int x = 0, y = A[0].length-1;
            while(x<=y){
                if(x!=y) {
                    int tmp = A[i][x];
                    A[i][x] = A[i][y];
                    A[i][y] = tmp;
                    A[i][x] = A[i][x] == 0 ? 1 : 0;
                    A[i][y] = A[i][y] == 0 ? 1 : 0;
                    x++;
                    y--;
                }else{
                    A[i][x] = A[i][x] == 0 ? 1 : 0;
                    break;
                }
            }
        }
        return A;
    }
}
