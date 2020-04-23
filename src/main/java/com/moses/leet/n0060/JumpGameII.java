package com.moses.leet.n0060;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int steps = 1;
        int cur = 0;
        while(cur < nums.length){
            int next = cur;
            if(cur + nums[cur] >= nums.length-1){
                return steps;
            }
            int max = 0;
            for(int i=cur; i<=cur+nums[cur] && i< nums.length; i++){
                if(i + nums[i] > max){
                    max = i+nums[i];
                    next = i;
                }
            }
            steps++;
            cur = next;
        }
        return steps;
    }

    public int jumpON2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for(int i=1; i<nums.length; i++){
            int steps = Integer.MAX_VALUE;
            for(int j=0; j<i; j++){
                if(nums[j] +j >=i){
                    steps = Math.min(steps, dp[j] + 1);
                }
            }
            dp[i] = steps;
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(new JumpGameII().jump(nums));

        nums = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(new JumpGameII().jump(nums));

        nums = new int[]{2,1};
        System.out.println(new JumpGameII().jump(nums));

        nums = new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        System.out.println(new JumpGameII().jump(nums));

        nums = new int[]{2,3,1,1,4};
        System.out.println(new JumpGameII().jump(nums));
    }


    public int jumpOld(int[] nums){
        return jumpRecursive(nums,0,0);
    }

    private int jumpRecursive(int[] nums, int currPos, int steps){
        if(currPos == nums.length-1){
            return steps;
        }
        int currVal = nums[currPos];
        if(currPos + currVal >= nums.length - 1){
            return steps + 1;
        }
        int tmpMaxSteps = 0;
        int tmpStep = 0;
        for(int i = currVal; i>=1; i--){
            if(nums[currPos+i] == 0){
                continue;
            }
            if(currPos + i + nums[currPos+i] >= nums.length-1){
                tmpStep = i;
                break;
            }
            if(currPos + i + nums[currPos+i] > tmpMaxSteps){
                tmpStep = i;
                tmpMaxSteps = currPos + i + nums[currPos+i];
            }
        }
        return jumpRecursive(nums, currPos + tmpStep, steps+1);
    }


}
