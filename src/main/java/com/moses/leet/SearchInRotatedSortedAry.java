package com.moses.leet;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedAry {
    public int search(int[] nums, int target){
        int left = 0, right = nums.length-1, mid = (nums.length-1)/2;

        while(left<=mid && mid<=right){
            if(right-left<=2){
                if(target == nums[left]){
                    return left;
                } else if(target == nums[right]){
                    return right;
                } else if(target == nums[mid]){
                    return mid;
                } else {
                    return -1;
                }
            }
            if(target >= nums[left]){
                if(nums[left] < nums[mid] && target <=nums[mid]){
                    right = mid;
                } else if(nums[left] < nums[mid] && target > nums[mid]){
                    left = mid;
                } else if(nums[left] > nums[mid]){
                    right = mid;
                }
            } else if(target < nums[left]){
                if(nums[left] < nums[mid]){
                    left = mid;
                } else if(nums[left] > nums[mid] && target >= nums[mid]){
                    left = mid;
                } else if(nums[left]>nums[mid] && target <= nums[mid]){
                    right = mid;
                }
            }
            mid = (left+right)/2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(new SearchInRotatedSortedAry().search(nums, target));

        nums = new int[]{4,5,6,7,0,1,2};
        target = 3;
        System.out.println(new SearchInRotatedSortedAry().search(nums, target));

        nums = new int[]{2,3,4,5,6,0,1};
        target = 3;
        System.out.println(new SearchInRotatedSortedAry().search(nums, target));

        nums = new int[]{6,7,0,2,3,4};
        target = 3;
        System.out.println(new SearchInRotatedSortedAry().search(nums, target));
    }
}
