package com.moses.leet.n0160;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinInRotatedSortedArrayII {
    //from solution
    public int findMin(int[] num) {
        int lo = 0;
        int hi = num.length - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (num[mid] > num[hi]) {
                lo = mid + 1;
            } else if (num[mid] < num[hi]) {
                hi = mid;
            } else { // when num[mid] and num[hi] are same
                hi--;
            }
        }
        return num[lo];
    }


    public int findMi1n(int[] nums) {
        //2,2,2,0,1
        //2,3,3,3,0,1
        //2,3,0,0,0,1
        //2,3,3,0,0,1
        int l=0, r = nums.length-1;
        while(l<=r){
            while(nums[l] == nums[r] && l<r){
                r--;
            }
            int m = l + (r-l)/2;
            if(nums[l] <= nums[r]){
                return nums[l];
            }
            if(nums[m] <= nums[r]){
                r=m;
            }else if(nums[m] >= nums[l]){
                l=m+1;
            }
        }
        return nums[l];
    }


    public int findMinOld(int[] nums) {
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
