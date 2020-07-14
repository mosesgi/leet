package com.moses.leet.n1480;

public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int l = 0, r = n;
        int p = 0;
        while(l<n){
            res[p++] = nums[l++];
            res[p++] = nums[r++];
        }
        return res;
    }
}
