package com.moses.leet.n0240;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length==0){
            return list;
        } else if(nums.length == 1){
            list.add(String.valueOf(nums[0]));
            return list;
        }
        for(int i=0; i<nums.length; i++){
            int tmp = nums[i];
            int begin = i;
            while(i+1 < nums.length && nums[i+1] == tmp + 1){
                tmp = nums[i+1];
                i++;
            }
            int end = i;
            if(begin == end){
                list.add(String.valueOf(nums[i]));
            } else {
                list.add(nums[begin] + "->" + nums[end]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{0,1,2,4,5,7};
        System.out.println(Arrays.toString(new SummaryRanges().summaryRanges(nums).toArray()));

        nums = new int[]{0,2,3,4,6,8,9};
        System.out.println(Arrays.toString(new SummaryRanges().summaryRanges(nums).toArray()));
    }
}
