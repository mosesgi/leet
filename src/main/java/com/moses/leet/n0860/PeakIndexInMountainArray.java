package com.moses.leet.n0860;

public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int l=0, r = A.length-1;
        while(l<=r){
            int m = l+(r-l)/2;
            if(A[m] > A[m-1] && A[m] > A[m+1]){
                return m;
            }
            if(A[m] > A[m+1]){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return -1;
    }
}
