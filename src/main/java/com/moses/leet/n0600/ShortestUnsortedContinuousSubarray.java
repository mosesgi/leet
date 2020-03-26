package com.moses.leet.n0600;

import java.util.Arrays;
import java.util.Stack;
import java.util.TreeMap;

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        boolean stopPush = false;
        for(int i=0; i<nums.length; i++){
            if(stopPush){
                while(!stack.isEmpty() && stack.peek()>nums[i]){
                    stack.pop();
                }
                continue;
            }
            if(stack.isEmpty() || nums[i] >= stack.peek()){
                stack.push(nums[i]);
            }else{
                while(!stack.isEmpty() && stack.peek()>nums[i]){
                    stack.pop();
                }
                stopPush = true;
            }
        }
        left = stack.size();
        if(left == nums.length){
            return 0;
        }

        stack = new Stack<>();
        stopPush = false;
        for(int i=nums.length-1; i>=0; i--){
            if(stopPush){
                while(!stack.isEmpty() && stack.peek()<nums[i]){
                    stack.pop();
                }
                continue;
            }
            if(stack.isEmpty() || nums[i] <= stack.peek()){
                stack.push(nums[i]);
            }else{
                while(!stack.isEmpty() && stack.peek()<nums[i]){
                    stack.pop();
                }
                stopPush= true;
            }
        }
        int right = stack.size();
        return nums.length-left-right;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{2,3,5,4,6,7,15};
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(nums));

        nums = new int[]{2,6,4,8,10,9,15};
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(nums));
    }

    //O(NLongN)
    public int findUnsortedSubarrayFirst(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int left = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[left] != sorted[left]){
                break;
            }else{
                left++;
            }
        }
        if(left == nums.length){
            return 0;
        }

        int right = nums.length-1;
        for(int i=nums.length-1; i>=0; i--){
            if(nums[right] != sorted[right]){
                break;
            }else{
                right--;
            }
        }
        return right-left+1;
    }



}
