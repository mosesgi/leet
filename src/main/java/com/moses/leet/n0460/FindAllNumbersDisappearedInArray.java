package com.moses.leet.n0460;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInArray {
    //Flip negative
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int curr = nums[i];
            if(curr < 0){
                curr = -curr;
            }
            if(nums[curr-1] > 0){
                nums[curr-1] = -nums[curr-1];
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }
        return list;
    }

    //7,3,2,4,8,2,3,1
    //3,3,2,4,8,2,7,1
    //2,3,3,4,8,2,7,1
    //3,2,3,4,8,2,7,1
    //3,2,3,4,1,2,7,8
    //1,2,3,4,3,2,7,8

    //2,3,2,4,5,6,7,8
    //2,2,3,4,5,6,7,8
    public List<Integer> findDisappearedNumbersMine(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length == 0){
            return list;
        }

        int index = 0;
        while(index < nums.length){
            if(nums[index] != index+1){
                if(nums[nums[index]-1] == nums[index]){
                    index++;
                }else {
                    swap(nums, index, nums[index] - 1);
                }
            }else{
                index++;
            }
        }

        for(int i = 0; i<nums.length; i++){
            if(nums[i] != i+1){
                list.add(i+1);
            }
        }
        return list;
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(Arrays.toString(new FindAllNumbersDisappearedInArray().findDisappearedNumbers(nums).toArray()));
    }
}
