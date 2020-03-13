package com.moses.leet.n0460;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumMovesToEqualArrayElements {

    //GOD DAMN MATH
    /**
     *
     * 共n个数, 最小值为min, 移动了k步, 最终值为f, 初始和为s0
     * k*(n-1) + s0 = n*f
     * min + k = f
     *
     * kn - k + s0 = n*min + kn
     * k = s0 - n*min
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = nums[0];
        for(int i : nums){
            sum+= i;
            if(i<min){
                min = i;
            }
        }
        return sum - nums.length * min;
    }


    public int minMovesTLE(int[] nums) {
        if(nums.length<=1){
            return 0;
        }

        int steps = 0;
        int maxValue= nums[0], maxPos = 0;
        boolean allSame = true;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != maxValue){
                allSame = false;
            }
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxPos = i;
            }
        }
        if(allSame){
            return 0;
        }

        int min = maxPos==0?nums[1]:nums[0];
        boolean allMinSame = true;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == maxValue){
                continue;
            }
            if(nums[i] != min){
                allMinSame = false;
                break;
            }
        }
        if(allMinSame){
            return maxValue - min;
        }

        while(true){
            allSame = true;
            int tmpMax = maxValue;
            int tmpPos = maxPos;
            for(int i=0; i<nums.length; i++){
                if(maxPos == i){
                    continue;
                }
                nums[i] = nums[i]+1;
                if(nums[i] != maxValue){
                    allSame = false;
                }
                if(nums[i] > tmpMax){
                    tmpMax = nums[i];
                    tmpPos = i;
                }
            }
            maxValue = tmpMax;
            maxPos = tmpPos;
            steps++;
            if(allSame){
                break;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{1,2147483647};
        System.out.println(new MinimumMovesToEqualArrayElements().minMoves(nums));

        nums = new int[]{1,2,3};
        System.out.println(new MinimumMovesToEqualArrayElements().minMoves(nums));

        nums = new int[]{1,2,3,4};
        System.out.println(new MinimumMovesToEqualArrayElements().minMoves(nums));

        nums = new int[]{1,2,3,4,5};
        System.out.println(new MinimumMovesToEqualArrayElements().minMoves(nums));

        nums = new int[]{1,2,3,4,5,6};
        System.out.println(new MinimumMovesToEqualArrayElements().minMoves(nums));

        nums = new int[]{3,4,3,4,5,6,7};
        System.out.println(new MinimumMovesToEqualArrayElements().minMoves(nums));
    }
}
