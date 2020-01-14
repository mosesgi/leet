package com.moses.leet.n0080;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                zero++;
            } else if(nums[i] == 1){
                one++;
            } else{
                two++;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(zero>0){
                nums[i] = 0;
                zero--;
            } else if(one >0){
                nums[i] = 1;
                one--;
            } else {
                nums[i] = 2;
                two--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1,1,0,2,0,2,1};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
