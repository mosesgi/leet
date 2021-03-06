package com.moses.leet.n0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, new ArrayList<Integer>(), 0, target, res);
        return res;
    }

    void dfs(int[] candidates, List<Integer> l, int pos, int remain, List<List<Integer>> res){
        if(pos >= candidates.length){
            return;
        }
        if(remain == 0){
            res.add(new ArrayList<>(l));
            return;
        }else if(remain < 0){
            return;
        }
        for(int i=pos; i<candidates.length; i++){
            l.add(candidates[i]);
            dfs(candidates, l, i, remain-candidates[i], res);
            l.remove(l.size() -1);
        }
    }



    public List<List<Integer>> combinationSumOld(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        recursive(list, new ArrayList<>(), candidates, target);
        return list;
    }

    private void recursive(List<List<Integer>> rstList, List<Integer> sList, int[] candidates, int remaining){
        if(remaining == 0){
            rstList.add(new ArrayList<>(sList));
            return;
        }
        for(int i=0; i<candidates.length; i++){
            if(candidates[i]<=remaining){
                sList.add(candidates[i]);
                recursive(rstList, sList, Arrays.copyOfRange(candidates, i, candidates.length), remaining-candidates[i]);
                sList.remove(sList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] cand = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> list = new CombinationSum().combinationSum(cand, target);
        for(List<Integer> l : list){
            System.out.println(Arrays.toString(l.toArray()));
        }
        System.out.println();

        cand = new int[]{2,3,5};
        target = 7;
        list = new CombinationSum().combinationSum(cand, target);
        for(List<Integer> l : list){
            System.out.println(Arrays.toString(l.toArray()));
        }
        System.out.println();

        cand = new int[]{2,3,5};
        target = 8;
        list = new CombinationSum().combinationSum(cand, target);
        for(List<Integer> l : list){
            System.out.println(Arrays.toString(l.toArray()));
        }
        System.out.println();
    }
}
