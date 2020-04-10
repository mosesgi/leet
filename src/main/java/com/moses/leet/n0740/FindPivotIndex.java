package com.moses.leet.n0740;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        int left=0, right=0;
        for(int i=1; i<nums.length; i++){
            right+=nums[i];
        }
        if(right == 0){
            return 0;
        }
        for(int i=0; i<nums.length-1; i++){
            left+=nums[i];
            right-=nums[i+1];
            if(left == right){
                return i+1;
            }
        }
        return -1;
    }
}
