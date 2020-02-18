package com.moses.leet.n0240;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        for(int i=0; i<nums.length; i++){
            if(i==0){
                result[i] = 1;
                continue;
            }
            result[i] = result[i-1] * nums[i-1];
        }

        int right = 1;
        for(int i= nums.length-2; i>=0; i--){
            right = right * nums[i+1];
            result[i] = result[i] * right;
        }

        return result;
    }

    public int[] productExceptSelfTwoArray(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        for(int i=0; i<nums.length; i++){
            if(i==0){
                left[i] = 1;
                continue;
            }
            left[i] = left[i-1] * nums[i-1];
        }
        for(int i= nums.length-1; i>=0; i--){
            if(i == nums.length-1){
                right[i] = 1;
                continue;
            }
            right[i] = right[i+1] * nums[i+1];
        }

        int[] result = new int[len];
        for(int i=0; i<len; i++){
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
