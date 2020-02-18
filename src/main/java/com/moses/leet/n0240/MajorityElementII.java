package com.moses.leet.n0240;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length==0){
            return new ArrayList<>();
        }
        Integer first = null, second = null, firstCnt = 0, secondCnt = 0;
        for(Integer i: nums){
            if(i.equals(first)){
                firstCnt++;
            } else if(i.equals(second)){
                secondCnt++;
            } else if(firstCnt==0){
                first = i;
                firstCnt = 1;
            } else if(secondCnt == 0){
                second = i;
                secondCnt = 1;
            } else {
                firstCnt--;
                secondCnt--;
            }
        }

        firstCnt = 0;
        secondCnt = 0;

        for(Integer i : nums){
            if(i.equals(first)){
                firstCnt++;
            } else if(i.equals(second)){
                secondCnt++;
            }
        }

        List<Integer> list = new ArrayList<>();
        int min = nums.length/3;
        if(firstCnt >min){
            list.add(first);
        }
        if(secondCnt > min){
            list.add(second);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{2,2,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9};
        System.out.println(Arrays.toString(new MajorityElementII().majorityElement(nums).toArray()));

        nums = new int[]{1,2};
        System.out.println(Arrays.toString(new MajorityElementII().majorityElement(nums).toArray()));

        nums = new int[]{3,2,3};
        System.out.println(Arrays.toString(new MajorityElementII().majorityElement(nums).toArray()));

        nums = new int[]{1,1,1,3,3,2,2,2};
        System.out.println(Arrays.toString(new MajorityElementII().majorityElement(nums).toArray()));

    }
}
