package com.moses.leet.n0180;

public class FindPeakElement {
    public int findPeakElementSolution(int[] nums){
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }



    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len==1){
            return 0;
        } else if(len == 2){
            return nums[0]<nums[1]?1:0;
        }
        int left = 0;
        if(nums[0] < nums[1]){
            left++;
        }
        int right = len-1;
        if(nums[right] < nums[right-1]){
            right--;
        }
        int mid = len/2;
        return recursive(nums, left, mid, right);
    }

    private int recursive(int[] nums, int left, int mid, int right) {
        if(left == right){
            if((left==0 ||nums[left] > nums[left-1]) && (left == nums.length-1 || nums[left]>nums[left+1])){
                return left;
            }
        } else if(left+1==right){
            if(nums[left] > nums[right] && (left==0 || nums[left]>nums[left-1])){
                return left;
            }else if(nums[right]>nums[left] && (right == nums.length-1 || nums[right] > nums[right+1] )){
                return right;
            }
        }
        if(right>left){
            if((left==0 ||nums[left]>nums[left-1]) && nums[left]>nums[left+1]){
                return left;
            }
            if(nums[right]>nums[right-1] && (right==nums.length-1 || nums[right]>nums[right+1])){
                return right;
            }
            if((mid==0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])){
                return mid;
            }
            int l = recursive(nums, left+1,  (left+mid)/2, mid-1);
            if(l!= -1){
                return l;
            }
            return recursive(nums, mid+1, (mid+right)/2, right-1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{2,3,4,3,2,1};
        System.out.println(new FindPeakElement().findPeakElement(nums));

        nums = new int[]{2,1,2};
        System.out.println(new FindPeakElement().findPeakElement(nums));

        nums = new int[]{1,2,3};
        System.out.println(new FindPeakElement().findPeakElement(nums));

        nums = new int[]{1,2,3,1};
        System.out.println(new FindPeakElement().findPeakElement(nums));

        nums = new int[]{1,2,1,3,5,6,4};
        System.out.println(new FindPeakElement().findPeakElement(nums));
    }

}
