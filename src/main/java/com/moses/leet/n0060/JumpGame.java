package com.moses.leet.n0060;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {
    public boolean canJump(int[] nums){
        if(nums.length<=1){
            return true;
        }


        return jumpIterative(nums, 0);
//        return jumpIter(nums, nums.length-1);
    }


    private boolean jumpIterative(int[] nums, int pos) {
        for(int i=nums[pos]; i>0; i--){
            int newPos = pos+i;
            if(newPos >=nums.length-1){
                return true;
            }
            if(nums[newPos] == 0){
                continue;
            }
            //time limit exceeded if missing below code
            if(nums[newPos] + newPos <= nums[pos] + pos){
                continue;
            }
            boolean result = jumpIterative(nums, newPos);
            if(result){
                return true;
            }
        }
        return false;
    }

    private boolean jumpIter(int[] nums, int pos){
        if(pos==0){
            return true;
        }
        for(int i=pos-1; i>=0; i--){
            if(nums[i] >= pos-i){
                boolean result = jumpIter( nums,  i);
                if(result){
                    return true;
                }
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(new JumpGame().canJump(nums));

        nums = new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
        System.out.println(new JumpGame().canJump(nums));

        nums = new int[]{3,2,1,0,4};
        System.out.println(new JumpGame().canJump(nums));

        nums = new int[]{2,0};
        System.out.println(new JumpGame().canJump(nums));

        int[] bigNums = new int[25003];
        for(int i=25000; i>0; i--){
            bigNums[25000-i] = i;
        }
        bigNums[25000] = 1;
        bigNums[25001] = 0;
        bigNums[25002] = 0;
        System.out.println(new JumpGame().canJump(bigNums));
    }
}
