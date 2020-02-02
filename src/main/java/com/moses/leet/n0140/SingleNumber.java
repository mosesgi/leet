package com.moses.leet.n0140;

import java.util.Arrays;

public class SingleNumber {

    //XOR
    public int singleNumber(int[] nums) {
        int a = 0;
        for(int i=0; i<nums.length; i++){
            a^=nums[i];
        }
        return a;
    }

    //extra space during sort?
    public int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i==nums.length-1){
                return nums[i];
            }
            if(nums[i] != nums[i+1]){
                return nums[i];
            } else {
                i = i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1};
        System.out.println(new SingleNumber().singleNumber(nums));

        nums = new int[]{4,1,2,1,2};
        System.out.println(new SingleNumber().singleNumber(nums));

        nums = new int[]{1,1,2,3,3,4,4};
        System.out.println(new SingleNumber().singleNumber(nums));

        nums = new int[]{1,1,2,2,3,4,4};
        System.out.println(new SingleNumber().singleNumber(nums));
    }
}
