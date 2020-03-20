package com.moses.leet.n0520;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            max = Math.max(max, i);
        }

        int[] rst = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] == max){
                while(!stack.isEmpty()){
                    int idx = stack.pop();
                    rst[idx] = nums[i];
                }
                rst[i] = -1;
                continue;
            }
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                int idx = stack.pop();
                rst[idx] = nums[i];
            }
            stack.push(i);
        }

        if(stack.isEmpty()){
            return rst;
        }
        for(int i=0; i<nums.length; i++){
            while(!stack.isEmpty()&& nums[i] > nums[stack.peek()]){
                int idx = stack.pop();
                rst[idx] = nums[i];
            }
            if(stack.isEmpty()){
                break;
            }
        }
        return rst;
        //5,3,2,1,4,8,6,9,3,1
        //8,7,6,9,8,6,4,3,2,1
    }


    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1,1,1,1,1};
        System.out.println(Arrays.toString(new NextGreaterElementII().nextGreaterElements(nums)));

        nums = new int[]{1,2,1};
        System.out.println(Arrays.toString(new NextGreaterElementII().nextGreaterElements(nums)));

        nums = new int[]{5,3,2,1,4,8,6,9,3,1};
        System.out.println(Arrays.toString(new NextGreaterElementII().nextGreaterElements(nums)));

        nums = new int[]{8,7,6,9,8,6,4,3,2,1};
        System.out.println(Arrays.toString(new NextGreaterElementII().nextGreaterElements(nums)));
    }
}
