package com.moses.leet.n0100;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchInRotatedSortedArrayII {

    public boolean searchCheat(int[] nums, int target){
        Arrays.sort(nums);
        int result = Arrays.binarySearch(nums, target);
        return result >=0;
    }

    public boolean search(int[] nums, int target){
        int left = 0;
        if(nums.length == 0) return false;
        if(nums.length == 1) return nums[0] == target;
        int right = nums.length-1;
        while(right >=0 && nums[left] == nums[right]){
            right--;
        }
        if(right == -1){
            return nums[0] == target;
        }

        while(left<right){
            int middle = left + (right-left)/2;
            if(nums[middle] == target){
                return true;
            }
            if(right-left == 1){
                return nums[middle] == target || nums[left] == target || nums[right] == target;
            }

            if(nums[middle] >= nums[left]){     //rotate is on right
                if(target < nums[left]){
                    left = middle;
                } else if(target >= nums[left] && target < nums[middle]){
                    right = middle;
                } else {
                    left = middle;
                }
            } else {        //rotate is on left
                if(target > nums[right]){
                    right = middle;
                } else if(target <=nums[right] && target > nums[middle]){
                    left = middle;
                } else {
                    right = middle;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,6,0,0,1,2};
        int target = 0;
        System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));

        nums= new int[]{-9,-9,-9,-8,-8,-7,-7,-7,-7,-6,-6,-6,-6,-6,-6,-6,-6,-6,-5,-5,-5,-5,-5,-4,-4,-4,-3,-3,-3,-3,-3,-3,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-1,-1,-1,-1,-1,-1,0,0,0,1,1,2,2,2,2,2,2,2,3,3,3,3,4,4,4,4,4,5,5,5,5,5,5,5,6,6,6,7,7,7,7,7,8,9,9,9,10,10,10,10,10,10,10,-10,-9,-9,-9,-9};
        target = 2;
        System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));

        nums = new int[]{3,1,2,2,2};
        target = 1;
        System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));

        nums = new int[]{1,1,3,1};
        target = 3;
        System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));

        nums = new int[]{3,1,1};
        target = 2;
        System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));

        nums = new int[]{1,1,3};
        target = 3;
        System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));

        nums = new int[]{2,5,6,0,0,1,2};
        target = 3;
        System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));

        nums = new int[]{2,5,6,7,8,1,2};
        target = 5;
        System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));

        nums = new int[]{2,5,6,0,0,1,1,2};
        target = 5;
        System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));
    }
}
