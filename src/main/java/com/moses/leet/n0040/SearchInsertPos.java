package com.moses.leet.n0040;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPos {

    public int searchInsert(int[] nums, int target){
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == target){
                return i;
            } else if(nums[i] > target) {
                if(i==0) return 0;
                return i;
            } else if(nums[i] < target){
                if(i==nums.length-1) return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 5;
        System.out.println(new SearchInsertPos().searchInsert(nums, target));

        nums = new int[]{1,3,5,6};
        target = 2;
        System.out.println(new SearchInsertPos().searchInsert(nums, target));

        nums = new int[]{1,3,5,6};
        target = 7;
        System.out.println(new SearchInsertPos().searchInsert(nums, target));

        nums = new int[]{1,3,5,6};
        target = 0;
        System.out.println(new SearchInsertPos().searchInsert(nums, target));

        nums = new int[]{1,3,5,6};
        target = 5;
        System.out.println(new SearchInsertPos().searchInsert(nums, target));

    }
}
