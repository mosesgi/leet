package com.moses.leet.n0040;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPos {
    public int searchInsert(int[] nums, int target){
        if(target < nums[0]){
            return 0;
        }else if(target > nums[nums.length-1]){
            return nums.length;
        }
        int l=0, r = nums.length-1;
        while(l<r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;        //右取中间，这种情况mid使用下取整。 否则mid应该上取整  l+(r-l+1)/2, 以避免1，2问题
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        int target = 3;
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


    public int searchInsertOld(int[] nums, int target){
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


}
