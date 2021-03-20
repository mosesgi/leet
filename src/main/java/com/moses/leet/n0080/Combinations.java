package com.moses.leet.n0080;

import com.moses.leet.utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 */
public class Combinations {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 1, new ArrayList<>(), k);
        return result;
    }

    void backtrack(int n, int start, List<Integer> list, int k){
        if(list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=start; i<=n; i++){
            list.add(i);
            backtrack(n, i+1, list, k);
            list.remove(list.size()-1);
        }
    }


    public static void main(String[] args) {
        PrintUtil.printNestedList(new Combinations().combine(4, 2));
    }
}
