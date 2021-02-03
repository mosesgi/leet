package com.moses.leet.n0400;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShuffleAnArray {
    static class Solution {
        int[] nums;
        Random r;
        public Solution(int[] nums) {
            r = new Random();
            this.nums = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                this.nums[i]=nums[i];
                list.add(nums[i]);
            }
            int[] rst = new int[nums.length];
            int len = nums.length;
            for(int i=list.size(); i>0; i--){
                int ind = r.nextInt(i);
                rst[len-i] = list.get(ind);
                if(ind != list.size()-1){
                    list.set(ind, list.get(list.size()-1));
                }
                list.remove(list.size()-1);
            }
            return rst;
        }
    }

    public static void main(String[] args) {
        Solution s = new ShuffleAnArray.Solution(new int[]{1,2,3,4});
        s.shuffle();
    }

}
