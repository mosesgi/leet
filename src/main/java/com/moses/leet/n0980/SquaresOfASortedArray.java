package com.moses.leet.n0980;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int l = 0, r = A.length-1;
        int idx = res.length-1;
        while(l<r){
            int left = Math.abs(A[l]);
            int right = Math.abs(A[r]);
            if(left < right){
                res[idx--] = right*right;
                r--;
            }else if(left > right){
                res[idx--] = left*left;
                l++;
            }else{
                res[idx--] = left*left;
                res[idx--] = right*right;
                l++;
                r--;
            }
        }
        if(l==r){
            res[idx] = A[l] * A[l];
        }
        return res;
    }
}
