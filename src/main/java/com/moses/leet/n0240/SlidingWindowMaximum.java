package com.moses.leet.n0240;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;


// O(N) should use Deque.
// https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation
public class SlidingWindowMaximum {
    //O(NK), not fast if descending array. But beats 100%...
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] rst = new int[nums.length-k+1];
        for(int i=0; i<=nums.length-k; i++){
            if(i==0){
                int max = nums[i];
                for(int j=1; j<k; j++){
                    if(nums[j] > max){
                        max = nums[j];
                    }
                }
                rst[i] = max;
                continue;
            }
            int prevMax = rst[i-1];
            if(nums[i+k-1] >= prevMax){
                rst[i] = nums[i+k-1];
                continue;
            }
            if(nums[i-1] == prevMax){
                int max = nums[i];
                for(int j=i+1; j<k+i; j++){
                    if(nums[j] > max){
                        max = nums[j];
                    }
                }
                rst[i] = max;
            } else {
                rst[i] = prevMax;
            }
        }
        return rst;
    }

    //O(NlgK)
    public int[] maxSlidingWindowNotOn(int[] nums, int k) {
        if(nums.length == 0){
            return new int[0];
        }
        if(k==1){
            return nums;
        }
        int[] result = new int[nums.length-k+1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<=nums.length-k; i++){
            if(i==0){
                for(int j=0; j<k; j++) {
                    if(map.containsKey(nums[i+j])){
                        map.put(nums[i+j], map.get(nums[i+j])+1);
                    } else {
                        map.put(nums[i + j], 1);
                    }
                }
                result[i] = map.lastKey();
                continue;
            }
            if(map.get(nums[i-1]) -1 <= 0){
                map.remove(nums[i-1]);
            } else {
                map.put(nums[i-1], map.get(nums[i-1])-1);
            }
            if(map.containsKey(nums[i+k-1])){
                map.put(nums[i+k-1], map.get(nums[i+k-1])+1);
            } else {
                map.put(nums[i+k-1], 1);
            }
            result[i] = map.lastKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums;
        int k;

        nums = new int[]{-7,-8,7,5,7,1,6,0};
        k=4;
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(nums, k)));

        nums = new int[]{1,3,1,2,0,5};
        k = 3;
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(nums, k)));

        nums = new int[]{1,2};
        k = 2;
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(nums, k)));

        nums = new int[]{1,3,-1,-3,5,3,6,7};
        k = 3;
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(nums, k)));
    }
}
