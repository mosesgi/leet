package com.moses.leet.n0160;

public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        } else if(nums.length == 2){
            return nums[0]<nums[1]?nums[0]:nums[1];
        }
        if(nums[0] < nums[nums.length-1]){
            return nums[0];
        }
        int mid = nums.length/2;
        return recursive(nums, 0, mid, nums.length-1);
    }

    private int recursive(int[] nums, int left, int mid, int right){
        if(left == right){
            return nums[left];
        } else if(left +1 == right){
            return nums[left]<nums[right]?nums[left]:nums[right];
        }
        if(nums[mid] < nums[left] && nums[mid] < nums[right]){
            right = mid;
            mid = (left+right)/2;
        } else if(nums[mid] > nums[left] && nums[mid] > nums[right]){
            left = mid;
            mid = (left+right)/2;
        }
        return recursive(nums, left, mid, right);
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{3,4,5,1,2};
        System.out.println(new FindMinInRotatedSortedArray().findMin(nums));

        nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(new FindMinInRotatedSortedArray().findMin(nums));

        nums = new int[]{6,7,0,1,3,4,5};
        System.out.println(new FindMinInRotatedSortedArray().findMin(nums));

        nums = new int[]{8,1,2,3,4,5,6,7};
        System.out.println(new FindMinInRotatedSortedArray().findMin(nums));

    }
}
