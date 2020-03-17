package com.moses.leet.n0480;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int num = nums[nums.length/2];
        int sum = 0;
        for(int i : nums){
            sum += Math.abs(i-num);
        }
        return sum;
    }

    public int minMoves2Test(int[] nums) {
        //测出了中位数是最优解,但是怎么证明????
        //https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/94932/Why-median-is-better-than-average
        int min=nums[0], max=nums[0];
        for(int i:nums){
            if(i<min){
                min = i;
            }
            if(i>max){
                max = i;
            }
        }
        int minMove = Integer.MAX_VALUE;
        List<Integer> numList = new ArrayList<>();
        for(int i=min; i<=max; i++){
            int tmp = 0;
            for(int j:nums){
                tmp += Math.abs(j-i);
            }
            if(tmp < minMove){
                minMove = tmp;
                numList.clear();
                numList.add(i);
            } else if(tmp == minMove){
                numList.add(i);
            }
        }
        System.out.println(Arrays.toString(numList.toArray()));
        return minMove;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{1,1,1,5,100,100,100,100,100};  //100
        System.out.println(new MinimumMovesToEqualArrayElementsII().minMoves2(nums));

        nums = new int[]{1,1,1,5,100,100,100,100};      //5 ~ 100
        System.out.println(new MinimumMovesToEqualArrayElementsII().minMoves2(nums));

        nums = new int[]{1,5,10,20,70,100};      //10~20
        System.out.println(new MinimumMovesToEqualArrayElementsII().minMoves2(nums));

        nums = new int[]{1,2,3,4,5,10,20,30,100,1000,10000,100000,100000,100000};      //10
        System.out.println(new MinimumMovesToEqualArrayElementsII().minMoves2(nums));
    }
}
