package com.moses.leet.n0080;

import com.moses.leet.utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 */
public class Combinations {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k){
        int[] array = new int[n];
        for(int i=1; i<=n; i++){
            array[i-1] = i;
        }
        List<Integer> l = new ArrayList<>();
        recursiveCombine(array, 0, k, l);
        return list;
    }

    private void recursiveCombine(int[] array, int currCursor, int leftK, List<Integer> l) {
        if(leftK==0){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i=currCursor; i<=array.length-leftK; i++){
            l.add(array[i]);
            recursiveCombine(array, i+1, leftK -1, l);
            l.remove(l.size()-1);
        }
    }


    public static void main(String[] args) {
        PrintUtil.printNestedList(new Combinations().combine(4, 2));
    }
}
