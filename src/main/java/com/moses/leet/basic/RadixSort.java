package com.moses.leet.basic;

import java.util.Arrays;

public class RadixSort {
    public void sort(int[] nums){
        int max = 0;
        for(int i : nums){
            max = Math.max(max, i);
        }
        int maxLen = (""+max).length();

        int div = 1;
        int pos = 1;        //position in number.
        int[][] buckets = new int[10][nums.length];
        int[] cnt = new int[10];
        while(pos <= maxLen){
            for(int i=0; i<nums.length; i++){
                int lsd = (nums[i]/div)%10;
                buckets[lsd][cnt[lsd]++] = nums[i];
            }
            int p = 0;
            for(int i=0; i<10; i++){
                if(cnt[i] != 0){
                    for(int j=0; j<cnt[i]; j++){
                        nums[p++] = buckets[i][j];
                    }
                }
                cnt[i] = 0;
            }
            div *= 10;
            pos++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100};
        new RadixSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
