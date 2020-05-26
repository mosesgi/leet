package com.moses.leet.n0500;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        //1,3,5,7,4,6
        int l=0, r = A.length-1;
        while(l<r){
            while(A[l]%2 == 0 && l<r){
                l++;
            }
            if(A[r]%2 == 0){
                int tmp = A[r];
                A[r] = A[l];
                A[l] = tmp;
            }
            r--;
        }
        return A;
    }
}
