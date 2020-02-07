package com.moses.leet.n0160;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        return recursive(nums, 0, nums.length-1);
    }

    private int recursive(int[] nums, int left, int right){
        if(nums[left] < nums[right]){
            return nums[left];
        }
        while(left+1<nums.length && nums[left]==nums[left+1] ){
            left++;
        }
        while(right-1>=left && nums[right]== nums[right-1]){
            right--;
        }
        if(nums[left]==nums[right] && right-1 >=left){
            right--;
        }
        if(left == right){
            return nums[left];
        } else if(left == right-1){
            return nums[left]<nums[right]?nums[left]:nums[right];
        }
        int mid = (left+right)/2;
        if(nums[mid] < nums[left] && nums[mid]<nums[right]){
            right = mid;
        } else if(nums[mid] > nums[left] && nums[mid]>nums[right]){
            left = mid;
        }
        return recursive(nums, left, right);
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{1,1,1};
        System.out.println(new FindMinInRotatedSortedArrayII().findMin(nums));

        nums = new int[]{3,4,5,1,2};
        System.out.println(new FindMinInRotatedSortedArrayII().findMin(nums));

        nums = new int[]{2,2,2,0,1};
        System.out.println(new FindMinInRotatedSortedArrayII().findMin(nums));

        nums = new int[]{5,5,6,7,7,7,7,7,7,7,7,7,7,0,1,3,3,4,5,5,5};
        System.out.println(new FindMinInRotatedSortedArrayII().findMin(nums));

        nums = new int[]{8,1,2,3,4,5,6,7};
        System.out.println(new FindMinInRotatedSortedArrayII().findMin(nums));

        nums = new int[]{8,8,8,0,0,0,0,0,1,2,};
        System.out.println(new FindMinInRotatedSortedArrayII().findMin(nums));
    }
}
