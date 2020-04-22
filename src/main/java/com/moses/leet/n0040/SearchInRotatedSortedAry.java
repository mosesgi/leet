package com.moses.leet.n0040;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedAry {
    public int search(int[] nums, int target) {
        //4,5,6,7,0,1,2
        //6,7,0,1,2,4,5
        if(nums.length==0){
            return -1;
        }
        int l = 0, r = nums.length-1;
        while(l <= r){
            int m = l+(r-l)/2;
            if(nums[m] == target){
                return m;
            }
            if(nums[m] > nums[r]){
                if(target > nums[m] || target < nums[l]){
                    l = m+1;
                }else{
                    r = m-1;
                }
            }else if(nums[m] < nums[l]){
                if(target < nums[m] || target >= nums[l]){
                    r = m-1;
                }else{
                    l = m+1;
                }
            }else{
                if(nums[m] < target){
                    l = m+1;
                }else{
                    r = m-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums;
        int target;

        nums = new int[]{5,1,3};
        target = 5;
        System.out.println(new SearchInRotatedSortedAry().search(nums, target));

        nums = new int[]{4,5,6,7,0,1,2};
        target = 0;
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

    public int searchOld(int[] nums, int target){
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


}
