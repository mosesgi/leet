package com.moses.leet.n0060;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations-ii/
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
public class PermutationsII {
    List<List<Integer>> list = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> row = new ArrayList<>();
        recursive(nums, row);
        return list;
    }

    private void recursive(int[] nums, List<Integer> row){
        if(nums.length == 0 && !set.contains(row)){
            list.add(new ArrayList<>(row));
            set.add(new ArrayList<>(row));
            return;
        }
        for(int i=0; i<nums.length; i++){
            int k= 0;
            int[] tmpNum = new int[nums.length-1];
            for(int j=0; j<nums.length; j++){
                if(i==j){
                    continue;
                }
                tmpNum[k++] = nums[j];
            }
            row.add(nums[i]);
            recursive(tmpNum, row);
            row.remove(row.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> list = new PermutationsII().permuteUnique(nums);
        for(List l : list){
            System.out.println(Arrays.toString(l.toArray()));
        }
        System.out.println();


    }

}
