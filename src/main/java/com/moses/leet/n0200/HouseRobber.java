package com.moses.leet.n0200;

//https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }


    public int robOld(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        Integer[] cache = new Integer[nums.length];
        return recursiveBetter(nums, 0, cache);
    }

    //origin
    private int recursiveBetter(int[] nums, int pos, Integer[] cache) {
        if(pos >= nums.length){
            return 0;
        }
        if(cache[pos] != null){
            return cache[pos];
        }
        //rob current and current+2  OR current+1 .
        int r1 = nums[pos] + recursiveBetter(nums, pos+2, cache);
        int r2 = recursiveBetter(nums, pos+1, cache);
        int sum = Math.max(r1, r2);
        cache[pos] = sum;
        return sum;
    }

    //origin
    private int recursive(int[] nums, int pos, Integer[] cache) {
        if(pos == nums.length-1){
            return nums[pos];
        }
        if(cache[pos] != null){
            return cache[pos];
        }

        int sum = 0;
        for(int i=pos; i<nums.length; i++){
            if(nums[i] > sum){
                sum = nums[i];
            }
            for(int j= i+2; j<nums.length; j++){
                int tmp = recursive(nums, j, cache);
                if(tmp+nums[i] > sum){
                    sum = tmp+nums[i];
                }
            }
        }
        cache[pos] = sum;
        return sum;
    }


    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1,2,3,1};
        System.out.println(new HouseRobber().rob(nums));

        nums = new int[]{2,7,9,3,1};
        System.out.println(new HouseRobber().rob(nums));

        nums = new int[]{2,7,9,3,1,4,8,2,3,4,6,1,2,9,3,7,18,24,22};
        System.out.println(new HouseRobber().rob(nums));

    }
}
