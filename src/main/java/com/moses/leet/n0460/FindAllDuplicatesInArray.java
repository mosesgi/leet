package com.moses.leet.n0460;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesInArray {
    //Another way, flip nums[i-1] to negative. Result is the positive ones
    public List<Integer> findDuplicates(int[] nums) {
        //7,3,2,4,8,2,3,1
        //3,3,2,4,8,2,7,1
        //2,3,3,4,8,2,7,1
        //3,2,3,4,8,2,7,1
        //3,2,3,4,1,2,7,8
        //1,2,3,4,3,2,7,8

        //2,3,2,4,5,6,7,8
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            while(true){
                int curr = nums[i];
                if(nums[curr-1] != curr){
                    nums[i]^=nums[curr-1];
                    nums[curr-1]^=nums[i];
                    nums[i]^=nums[curr-1];
                } else {
                    break;
                }
            }
        }
        for(int i=0; i<nums.length; i++){
            if(i+1 != nums[i]){
                result.add(nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(Arrays.toString(new FindAllDuplicatesInArray().findDuplicates(nums).toArray()));
    }
}
