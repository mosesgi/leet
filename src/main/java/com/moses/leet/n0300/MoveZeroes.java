package com.moses.leet.n0300;

import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroesBetter(int[] nums){
        int nonZeroInd = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[nonZeroInd++] = nums[i];
            }
        }
        for(int i=nonZeroInd; i<nums.length; i++){
            nums[i] = 0;
        }
    }


    public void moveZeroes(int[] nums) {
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            while(i+cnt < nums.length && nums[i+cnt] == 0){
                cnt++;
            }
            if(i+cnt < nums.length) {
                nums[i] = nums[i + cnt];
            } else {
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{0,1,0,3,12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0,0,3,0,0,0,12,1,0,0};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }
}
