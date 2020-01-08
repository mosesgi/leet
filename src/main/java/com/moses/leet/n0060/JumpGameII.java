package com.moses.leet.n0060;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {

    public int jump(int[] nums){
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
}
