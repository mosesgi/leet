package com.moses.leet.n0540;

import java.util.Arrays;
import java.util.Random;

public class RandomPickWithWeight {
    class Solution {
        int[] weight;
        Random r = new Random();
        public Solution(int[] w) {
            weight = new int[w.length];
            int prev = 0;
            for(int i=0; i<w.length; i++){
                weight[i] = prev + w[i];
                prev = weight[i];
            }
        }

        public int pickIndex() {
            int max = weight[weight.length-1];
            int ran = r.nextInt(max+1);
            int idx = Arrays.binarySearch(weight, ran);
            if(idx < 0){
                idx = -idx-1;
            }
            return idx;
        }
    }
}
