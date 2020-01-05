package com.moses.leet.n0040;

import java.lang.reflect.Array;
import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {
    int previousFirst;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        recursive(candidates, result, new ArrayList<>(), target);
        return new ArrayList<>(result);
    }

    private void recursive(int[] candidates, Set<List<Integer>> result, List<Integer> currList, int remaining){
        if(remaining == 0){
            previousFirst = currList.get(0);
            result.add(new ArrayList<>(currList));
            return;
        }
        for(int i=0; i<candidates.length; i++){
            if(candidates[i] == previousFirst){
                continue;
            }
            if(candidates[i]<=remaining){
                currList.add(candidates[i]);
                recursive(Arrays.copyOfRange(candidates, i+1, candidates.length), result, currList, remaining-candidates[i]);
                currList.remove(currList.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        int[] cand = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> list = new CombinationSumII().combinationSum2(cand, target);
        for(List<Integer> l : list){
            System.out.println(Arrays.toString(l.toArray()));
        }
        System.out.println();

        cand = new int[]{2,5,2,1,2};
        target = 5;
        list = new CombinationSumII().combinationSum2(cand, target);
        for(List<Integer> l : list){
            System.out.println(Arrays.toString(l.toArray()));
        }
        System.out.println();


    }
}
