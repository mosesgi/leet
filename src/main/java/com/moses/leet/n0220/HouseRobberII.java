package com.moses.leet.n0220;

import java.util.Arrays;

public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        } else if(nums.length == 1){
            return nums[0];
        }
        int[] cacheWithFirst = new int[nums.length];
        int[] cacheWithoutFirst = new int[nums.length];
        Arrays.fill(cacheWithFirst, -1);
        Arrays.fill(cacheWithoutFirst, -1);
        return recursive(nums, 0, null, cacheWithFirst, cacheWithoutFirst);
    }

    public int recursive(int[] nums, int currPos, Boolean firstRobbed, int[] cacheWithFirst, int[] cacheWithoutFirst){
        if(currPos == nums.length-1){
            if(firstRobbed) {
                return 0;
            } else {
                return nums[currPos];
            }
        }
        if(currPos >= nums.length){
            return 0;
        }

        Boolean rob1 = firstRobbed;
        Boolean rob2 = firstRobbed;
        if(firstRobbed == null ){
            if(currPos == 0) {
                rob1 = true;
            }
            rob2 = false;
        }
        if(firstRobbed != null){
            if(firstRobbed && cacheWithFirst[currPos] != -1){
                return cacheWithFirst[currPos];
            } else if(!firstRobbed && cacheWithoutFirst[currPos] != -1){
                return cacheWithoutFirst[currPos];
            }
        }
        int curr = nums[currPos] + recursive(nums, currPos + 2, rob1, cacheWithFirst, cacheWithoutFirst);
        int next = recursive(nums, currPos + 1, rob2, cacheWithFirst, cacheWithoutFirst);
        int tmpRst = Math.max(curr, next);
        if(firstRobbed!= null){
            if(firstRobbed){
                cacheWithFirst[currPos] = tmpRst;
            } else {
                cacheWithoutFirst[currPos] = tmpRst;
            }
        }
        return tmpRst;
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        System.out.println(new HouseRobberII().rob(nums));

        nums = new int[]{2,3,2};
        System.out.println(new HouseRobberII().rob(nums));

        nums = new int[]{1,2,3,1};
        System.out.println(new HouseRobberII().rob(nums));

        nums = new int[]{1,2,3,1,5,8,3,1,2,9,3};
        System.out.println(new HouseRobberII().rob(nums));
    }

}
