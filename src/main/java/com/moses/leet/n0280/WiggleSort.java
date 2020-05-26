package com.moses.leet.n0280;

import java.util.Arrays;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        //1,2,2,3,4; 1,4,2,3,2
        //1,2,3,4,5,6;  1,6,2,3,4,5; 1,6,2,5,3,4;

        //1,1,1,4,5,6
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i+=2){
            for(int j=nums.length-1; j>i; j--){
                int tmp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = tmp;
            }
        }

    }
}
