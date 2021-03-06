package com.moses.leet.n0100;

import com.moses.leet.utils.PrintUtil;

import java.util.*;

/**
 * https://leetcode.com/problems/subsets-ii/
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), 0, res);
        return res;
    }

    void dfs(int[] nums, List<Integer> l, int start, List<List<Integer>> res){
        res.add(new ArrayList<>(l));
        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i] == nums[i-1]){
                continue;
            }
            l.add(nums[i]);
            dfs(nums, l, i+1, res);
            l.remove(l.size() -1);
        }
    }



    List<List<Integer>> list = new ArrayList<>();
    List<Integer> l = new ArrayList<>();

    public List<List<Integer>> subsetsWithDupOld(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<=nums.length; i++){
            backtrack(nums, i, 0, i);
        }
        return list;
    }

    private void backtrack(int[] nums, int totalLen, int currPos, int leftLen) {
        if(totalLen == 0){
            list.add(new ArrayList<>());
            return;
        }
        if(leftLen==0){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i=currPos; i < nums.length - leftLen + 1; i++){
            if(i>currPos && nums[i] == nums[i-1]){
                continue;
            }
            l.add(nums[i]);
            backtrack(nums, totalLen, i + 1, leftLen-1);
            l.remove(l.size()-1);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        PrintUtil.printNestedList(new SubsetsII().subsetsWithDup(nums));

        nums = new int[]{1,2,2,3,4};
        PrintUtil.printNestedList(new SubsetsII().subsetsWithDup(nums));

        nums = new int[]{1,2,2,2,3,3,3,4,5,5,5};
        PrintUtil.printNestedList(new SubsetsII().subsetsWithDup(nums));
    }
}
