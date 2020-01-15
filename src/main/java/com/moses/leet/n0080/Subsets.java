package com.moses.leet.n0080;

import com.moses.leet.utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 */
public class Subsets {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<=size; i++){
            recursiveSubsets(nums, 0, i, l);
        }
        return list;
    }

    private void recursiveSubsets(int[] nums, int currPos,  int leftLen, List<Integer> l) {
        if(leftLen == 0){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i=currPos; i<nums.length; i++){
            l.add(nums[i]);
            recursiveSubsets(nums, i+1, leftLen-1, l);
            l.remove(l.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        PrintUtil.printNestedList(new Subsets().subsets(nums));


    }
}
