package com.moses.leet.n0680;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    // I made it!
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] maxLen = new int[len];
        int[] cnts = new int[len];

        int cnt = len;
        int max = -1;
        for(int i=0; i<len; i++){
            maxLen[i] = 1;
            cnts[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    if(maxLen[j] + 1 > maxLen[i]){
                        maxLen[i] = maxLen[j] + 1;
                        cnts[i] = cnts[j];
                    }else if(maxLen[j] +1 == maxLen[i]){
                        cnts[i] += cnts[j];
                    }
                }
            }

            if(maxLen[i] > max){
                cnt = cnts[i];
                max = maxLen[i];
            }else if(maxLen[i] == max){
                cnt += cnts[i];
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1,2,4,3,5,4,7,2};
        System.out.println(new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(nums));

        nums = new int[]{2,2,2,2,2};
        System.out.println(new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(nums));

        nums = new int[]{1,3,5,4,7};
        System.out.println(new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(nums));
    }
}
