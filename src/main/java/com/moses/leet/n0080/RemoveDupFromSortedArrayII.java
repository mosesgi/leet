package com.moses.leet.n0080;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDupFromSortedArrayII {

    public int removeDuplicates(int[] nums){
        int count = 1;
        if(nums.length<2){
            return nums.length;
        }
        int pos = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[pos-1]){
                if(count <2){
                    count++;
                    nums[pos++] = nums[i];
                } else {
                    continue;
                }
            } else {
                count = 1;
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int end = new RemoveDupFromSortedArrayII().removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, end)));

        nums = new int[]{0,0,1,1,1,1,2,3,3};
        end = new RemoveDupFromSortedArrayII().removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, end)));
    }
}
