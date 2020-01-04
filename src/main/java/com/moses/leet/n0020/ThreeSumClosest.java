package com.moses.leet.n0020;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target){
        int result = 0;
        int diff = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2; i++){
            for(int j = i+1; j<nums.length-1; j++){
                for(int k=j+1;k<nums.length; k++){
                    int tmp = nums[i]+nums[j]+nums[k];
                    if(Math.abs(tmp-target) < diff){
                        diff = Math.abs(tmp-target);
                        result = tmp;
                    }
                }
            }
        }
        return result;
    }

    public int threeSumClosestFast(int[] nums, int target){
        int result = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int l = i+1, r = nums.length-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r] == target){
                    return nums[i]+nums[l]+nums[r];
                }
                int tmpResult = nums[i]+nums[l]+nums[r];

                if(tmpResult < target) {
                    if (target - tmpResult < diff) {
                        diff = target - tmpResult;
                        result = tmpResult;
                    }
                    l++;
                } else if(tmpResult > target){
                    if(tmpResult - target < diff){
                        diff = tmpResult-target;
                        result = tmpResult;
                    }
                    r--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(new ThreeSumClosest().threeSumClosestFast(nums, 1));
    }
}
