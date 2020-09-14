package com.moses.leet.n0980;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    //2,3,3,6
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for(int i=A.length-3; i>=0; i--){
            if(A[i] + A[i+1] > A[i+2]){
                return A[i] + A[i+1] + A[i+2];
            }
        }
        return 0;
    }
}
