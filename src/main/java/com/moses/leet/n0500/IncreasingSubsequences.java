package com.moses.leet.n0500;

import com.moses.leet.utils.PrintUtil;

import java.util.*;

public class IncreasingSubsequences {
    //1,2,3,1,1
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>(),  rst);
        return rst;
    }

    private void dfs(int[] nums, int curIdx, List<Integer> tmpList, List<List<Integer>> rst) {
        add(rst, tmpList);
        if(curIdx == nums.length){
            return;
        }
        Set<Integer> used = new HashSet<>();
        for(int i=curIdx; i<nums.length; i++){
            if(used.contains(nums[i])){     //duplicate nums can be used once in one loop
                continue;
            }
            if(tmpList.isEmpty() || nums[i] >= tmpList.get(tmpList.size()-1)){
                used.add(nums[i]);
                tmpList.add(nums[i]);
                dfs(nums, i+1, tmpList, rst);
                tmpList.remove(tmpList.size()-1);
            }
        }
    }

    void add(List<List<Integer>> rst, List<Integer> tmpList){
        if(tmpList.size()>=2){
            rst.add(new ArrayList<>(tmpList));
        }
    }



    //Set handle duplicates. Slow
    public List<List<Integer>> findSubsequencesSet(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        dfsSet(nums, 0, Integer.MIN_VALUE, new ArrayList<Integer>(),  set);
        List<List<Integer>> list= new ArrayList<>(set);
        return list;
    }

    private void dfsSet(int[] nums, int curIdx, int prev, List<Integer> tmpList, Set<List<Integer>> rst) {
        if(curIdx == nums.length){
            return;
        }
        if(nums[curIdx] < prev){
            dfsSet(nums, curIdx+1, prev, tmpList, rst);
        }else {
            dfsSet(nums, curIdx + 1, prev, tmpList, rst);
            tmpList.add(nums[curIdx]);
            add(rst, tmpList);
            dfsSet(nums, curIdx + 1, nums[curIdx], tmpList, rst);
            tmpList.remove(tmpList.size()-1);
        }
    }

    void add(Set<List<Integer>> rst, List<Integer> tmpList){
        if(tmpList.size()>=2){
            rst.add(new ArrayList<>(tmpList));
        }
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{1,2,3,1,1};
        PrintUtil.printNestedList(new IncreasingSubsequences().findSubsequences(nums));

        nums = new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};


        nums = new int[]{4,3,2,1};
        PrintUtil.printNestedList(new IncreasingSubsequences().findSubsequences(nums));

        nums = new int[]{3,3,4,5,6,6};
        PrintUtil.printNestedList(new IncreasingSubsequences().findSubsequences(nums));

        nums = new int[]{4,6,7,7};
        PrintUtil.printNestedList(new IncreasingSubsequences().findSubsequences(nums));
    }
}
