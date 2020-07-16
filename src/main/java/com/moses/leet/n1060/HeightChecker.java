package com.moses.leet.n1060;

import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] origin = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        int res = 0;
        for(int i=0; i<origin.length; i++){
            if(origin[i] != heights[i]){
                res++;
            }
        }
        return res;
    }
}
