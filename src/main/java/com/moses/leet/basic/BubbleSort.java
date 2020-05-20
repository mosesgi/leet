package com.moses.leet.basic;

import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] nums){
        for(int i=nums.length-1; i>=0; i--){
            for(int j=0; j<i; j++){
                if(nums[j] > nums[j+1]){
                    int tmp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,3,1,6,7,10,3,9,8,6};
        new BubbleSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
