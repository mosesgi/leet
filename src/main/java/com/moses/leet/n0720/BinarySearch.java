package com.moses.leet.n0720;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums;
        int target;
        nums = new int[]{5};
        target = 5;
        System.out.println(new BinarySearch().search(nums, target));

        nums = new int[]{-1,0,3,5,9,12};
        target=2;
        System.out.println(new BinarySearch().search(nums, target));

        target = 9;
        System.out.println(new BinarySearch().search(nums, target));

    }
}
