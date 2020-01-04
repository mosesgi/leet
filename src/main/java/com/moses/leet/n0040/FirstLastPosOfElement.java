package com.moses.leet.n0040;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FirstLastPosOfElement {
    public int[] searchRange(int[] nums, int target){
        int left = 0, right = nums.length - 1, mid = (left+right)/2;
        while(left <=mid && mid<=right){
            if(right-left <2){
                if(nums[left] != target && nums[right] != target){
                    return new int[]{-1, -1};
                }
            }

            if(nums[mid] == target){
                if(nums[left] < target) {
                    int newLeft = (left + mid) / 2;
                    left = newLeft>left?newLeft:(left+1);
                    boolean inLoop = false;
                    while(nums[left]==target){
                        left--;
                        inLoop = true;
                    }
                    if(inLoop) left++;
                }
                if(nums[right] > target) {
                    int newRight = (mid+right)/2;
                    right = newRight < right? newRight:(right-1);
                    boolean inLoop = false;
                    while(nums[right] == target){
                        right++;
                        inLoop = true;
                    }
                    if(inLoop) right--;
                }

                if(nums[left] == target && nums[right] == target){
                    return new int[]{left, right};
                }
            } else if(nums[mid] > target){
                right = mid;
                int newMid = (left+right)/2;
                mid = newMid<mid?newMid:mid-1;
            } else if(nums[mid] < target){
                left = mid;
                int newMid = (left+right)/2;
                mid = newMid>mid?newMid:mid+1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,6,6,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(new FirstLastPosOfElement().searchRange(nums, target)));

        nums = new int[]{0,0,1,1,1,2,2,3,3,3,4,4,4,4,5,5,6,6,6,8,10,10};
        target = 4;
        System.out.println(Arrays.toString(new FirstLastPosOfElement().searchRange(nums, target)));

        nums=new int[]{1,4};
        target = 4;
        System.out.println(Arrays.toString(new FirstLastPosOfElement().searchRange(nums, target)));

        nums=new int[]{1};
        target = 0;
        System.out.println(Arrays.toString(new FirstLastPosOfElement().searchRange(nums, target)));

        nums = new int[]{5,7,7,8,8,10};
        target = 6;
        System.out.println(Arrays.toString(new FirstLastPosOfElement().searchRange(nums, target)));

        nums = new int[]{5,7,7,8,8,10};
        target = 7;
        System.out.println(Arrays.toString(new FirstLastPosOfElement().searchRange(nums, target)));
    }
}
