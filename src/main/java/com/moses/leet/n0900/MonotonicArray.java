package com.moses.leet.n0900;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        Boolean inc = null;
        for(int i=1; i<A.length; i++){
            if(A[i] == A[i-1]){
                continue;
            }
            if(A[i] > A[i-1]){
                if(inc == null){
                    inc = true;
                }else if(!inc){
                    return false;
                }
            }else if(A[i] < A[i-1]){
                if(inc == null){
                    inc = false;
                }else if(inc){
                    return false;
                }
            }
        }
        return true;
    }
}
