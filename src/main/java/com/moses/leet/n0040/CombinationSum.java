package com.moses.leet.n0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();

        return list;
    }

    private void recursive(List<List<Integer>> rstList, int[] candidates, int remaining){

    }

    public static void main(String[] args) {
        int[] cand = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> list = new CombinationSum().combinationSum(cand, target);
        for(List<Integer> l : list){
            System.out.println(Arrays.toString(l.toArray()));
        }
        System.out.println();


    }
}
