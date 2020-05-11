package com.moses.leet.n0240;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int start = nums[i];
            int j= i;
            while(j+1 < nums.length && nums[j+1] == nums[j]+1){
                j++;
            }
            if(nums[i] == nums[j]){
                res.add(nums[i]+"");
            }else{
                res.add(nums[i] + "->" + nums[j]);
                i = j;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{0,1,2,4,5,7};
        System.out.println(Arrays.toString(new SummaryRanges().summaryRanges(nums).toArray()));

        nums = new int[]{0,2,3,4,6,8,9};
        System.out.println(Arrays.toString(new SummaryRanges().summaryRanges(nums).toArray()));
    }
}
