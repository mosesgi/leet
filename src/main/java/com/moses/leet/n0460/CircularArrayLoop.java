package com.moses.leet.n0460;

import java.util.HashSet;
import java.util.Set;

public class CircularArrayLoop {
    //O(N) time and O(1) space
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len; i++){
            if(nums[i] == 0){
                continue;
            }
            int slow = i, fast = getIndex(i, nums);
            while(nums[fast] * nums[i] > 0 && nums[getIndex(fast, nums)] * nums[i] > 0){
                if(slow == fast){
                    // check for loop with only one element
                    if(slow == getIndex(slow, nums)){
                        break;
                    }
                    return true;
                }
                slow = getIndex(slow, nums);
                fast = getIndex(getIndex(fast, nums), nums);
            }
            int j = i;      //标记已访问pos
            int val = nums[i];
            while(nums[j] * val > 0){
                int next = getIndex(j, nums);
                nums[j] = 0;
                j = next;
            }
        }
        return false;
    }

    private int getIndex(int i, int[] nums){
        int next = i+nums[i];
        if(next >= 0){
            return next % nums.length;
        }else{
            return next%nums.length+nums.length;
        }
    }

    //doesn't fulfill followup.
    public boolean circularArrayLoopMine(int[] nums) {
        for(int i=0; i<nums.length; i++){
            boolean forward = nums[i] > 0;
            int tmp = i + nums[i];
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            int prev = tmp;
            while(true){
                if(tmp >= nums.length){
                    while(tmp >=nums.length) {
                        tmp -= nums.length;
                    }
                } else if(tmp < 0){
                    while(tmp <0) {
                        tmp += nums.length;
                    }
                }
                if(prev == tmp){
                    break;
                }
                if(forward && nums[tmp] < 0){
                    break;
                }
                if(!forward && nums[tmp] > 0){
                    break;
                }
                if(visited.contains(tmp)){
                    if(visited.size()<2){
                        break;
                    }
                    return true;
                }
                visited.add(tmp);
                prev = tmp;
                tmp = tmp+nums[tmp];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{-2,-3,-9};
        System.out.println(new CircularArrayLoop().circularArrayLoop(nums));

        nums = new int[]{-1,-2,-3,-4,-5};
        System.out.println(new CircularArrayLoop().circularArrayLoop(nums));

        nums = new int[]{2,-1,1,2,2};
        System.out.println(new CircularArrayLoop().circularArrayLoop(nums));

        nums = new int[]{-1,2};
        System.out.println(new CircularArrayLoop().circularArrayLoop(nums));

        nums = new int[]{-2,1,-1,-2,-2};
        System.out.println(new CircularArrayLoop().circularArrayLoop(nums));
    }
}
