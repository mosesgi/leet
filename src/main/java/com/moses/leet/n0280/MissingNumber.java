package com.moses.leet.n0280;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i] >= nums.length){
                continue;
            }
            int j = i;
            while(nums[j] != j && nums[j]<nums.length){
                int tmp = nums[j];
                nums[j] = nums[tmp];
                nums[tmp] = tmp;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
        return nums[nums.length-1]+1;
    }


    public int missingNumberOld(int[] nums){
        int[] ary = new int[nums.length+1];
        Arrays.fill(ary, -1);
        for(int i : nums){
            ary[i] = i;
        }
        for(int i=0; i<ary.length; i++){
            if(ary[i] == -1){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums;
//        nums = new int[]{3,0,1};
//        System.out.println(new MissingNumber().missingNumber(nums));

        nums = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(new MissingNumber().missingNumber(nums));
    }
}
