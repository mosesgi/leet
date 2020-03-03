package com.moses.leet.n0380;

import java.util.Arrays;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums){
        if(nums.length<2){
            return nums.length;
        }
        int[] inc = new int[nums.length];
        int[] dec = new int[nums.length];
        inc[0] = 1; dec[0] = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i-1]){
                inc[i] = dec[i-1] + 1;
                dec[i] = dec[i-1];      //inherit the dec value from previous element.
            } else if(nums[i] < nums[i-1]){
                dec[i] = inc[i-1] + 1;
                inc[i] = inc[i-1];
            } else {
                dec[i] = dec[i-1];
                inc[i] = inc[i-1];
            }
        }
        return Math.max(inc[nums.length-1], dec[nums.length-1]);
    }

    public int wiggleMaxLengthMineON2(int[] nums) {
        int[] inc = new int[nums.length];
        int[] dec = new int[nums.length];

        Arrays.fill(inc, 1);
        Arrays.fill(dec, 1);
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    inc[i] = Math.max(inc[i], dec[j] + 1);
                } else if(nums[i]<nums[j]){
                    dec[i] = Math.max(dec[i], inc[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i=0; i<inc.length; i++){
            if(inc[i] > max){
                max = inc[i];
            }
        }

        for(int i=0; i<dec.length; i++){
            if(dec[i] > max){
                max = dec[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1,7,4,9,2,5};
        System.out.println(new WiggleSubsequence().wiggleMaxLength(nums));
        nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        System.out.println(new WiggleSubsequence().wiggleMaxLength(nums));
        nums = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(new WiggleSubsequence().wiggleMaxLength(nums));
    }
}
