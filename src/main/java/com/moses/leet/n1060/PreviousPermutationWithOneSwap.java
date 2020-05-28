package com.moses.leet.n1060;

public class PreviousPermutationWithOneSwap {
    public int[] prevPermOpt1(int[] A) {
        Integer last = null;
        for(int i=A.length-2; i>=0; i--){
            if(A[i] > A[i+1]){
                last = i;
                break;
            }
        }
        if(last == null){
            return A;
        }

        int toSwitch = A.length-1;
        while(A[last] == A[toSwitch]){
            toSwitch--;
        }
        for(int i=toSwitch; i>last; i--){
            if(A[i-1] != A[i]){
                toSwitch = i;
                break;
            }
        }
        int tmp = A[last];
        A[last] = A[toSwitch];
        A[toSwitch] = tmp;
        return A;
    }
}
