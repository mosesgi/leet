package com.moses.leet.n0300;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int max = 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        //10,9,2,5,3,7,101,18,20,25,202,29
        for(int i=nums.length-2; i>=0; i--){
            for(int j = i+1; j<nums.length; j++){
                if(nums[j] > nums[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
        }

        for(int i=0; i<dp.length; i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    public int lengthOfLISRecursive(int[] nums) {
        int max = 0;

        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        //10,9,2,5,3,7,101,18,20,25,202,29
        for(int i=0; i<nums.length; i++){
            int tmpCnt = recursive(nums, nums[i], i, cache);
            if(tmpCnt > max){
                max = tmpCnt;
            }
        }
        return max;
    }

    private int recursive(int[] nums, int num, int idx, int[] cache) {
        int tmpMax = 0;
        for(int i=idx+1; i<nums.length; i++){
            if(nums[i] > num) {
                int tmp;
                if(cache[i] != -1){
                    tmp = cache[i];
                } else {
                    tmp = recursive(nums, nums[i], i, cache);
                }
                if(tmp > tmpMax){
                    tmpMax = tmp;
                }
            }
        }
        cache[idx] = tmpMax + 1;
        return tmpMax + 1;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));

        nums = new int[]{10,9,2,5,3,7,101,18,20,25,202,29};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }

}
