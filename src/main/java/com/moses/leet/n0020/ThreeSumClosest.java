package com.moses.leet.n0020;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        // -4,-1,1,2

        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int result = 0;
        for(int i=0; i<nums.length-2; i++){
            int left = i+1;
            int right = nums.length-1;

            while(left < right){
                int tmp = nums[i] + nums[left] + nums[right];
                if(tmp == target){
                    return target;
                } else if (tmp<target) {
                    left++;
                } else {
                    right--;
                }
                if(Math.abs(target - tmp) < minDiff){
                    minDiff = Math.abs(target-tmp);
                    result = tmp;
                }
            }
        }
        return result;
    }



    public int threeSumClosestOld(int[] nums, int target){
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
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, 1));
    }
}
