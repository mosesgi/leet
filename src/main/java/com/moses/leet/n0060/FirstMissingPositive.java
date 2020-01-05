package com.moses.leet.n0060;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int[] rst = new int[nums.length];
        for(int i: nums){
            if(i<=nums.length && i>0){
                rst[i-1] = 1;
            }
        }
        for(int i=0; i<rst.length; i++){
            if(rst[i] == 0){
                return i+1;
            }
        }
        return rst.length+1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));

        nums = new int[]{1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));

        nums = new int[]{1,2,3,4,5};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));

        nums = new int[]{3,4,-1,1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));

        nums = new int[]{7,8,9,11,12};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));

//        nums = new int[]{1,2,0};
//        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }
}
