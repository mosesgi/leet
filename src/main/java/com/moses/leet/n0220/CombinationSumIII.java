package com.moses.leet.n0220;

import com.moses.leet.utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        rec(k, n, 0, 1, new ArrayList<>(), res);
        return res;
    }

    void rec(int k, int n, int sum, int start, List<Integer> l, List<List<Integer>> res){
        if(sum == n && k== 0){
            res.add(new ArrayList<>(l));
            return;
        }
        if(sum >= n){
            return;
        }
        for(int i=start; i<=9; i++){
            l.add(i);
            rec(k-1, n, sum+i, i+1, l, res);
            l.remove(l.size() -1);
        }
    }





    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3Old(int k, int n) {
        List<Integer> l = new ArrayList<>();
        recursive(0, 0, l, k, n, 1);
        return list;
    }

    private void recursive(int level, int tmpSum, List<Integer> l, int k, int n, int start){
        if(level > k){
            return;
        }
        if(tmpSum > n){
            return;
        }
        if(level == k ){
            if(tmpSum == n) {
                list.add(new ArrayList<>(l));
            }
            return;
        }
        for(int i=start; i<=9; i++){
            if(tmpSum + i <= n){
                l.add(i);
                recursive(level+1, tmpSum + i, l, k, n, i+1);
                l.remove(l.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        PrintUtil.printNestedList(new CombinationSumIII().combinationSum3(3,7));
        PrintUtil.printNestedList(new CombinationSumIII().combinationSum3(3,9));
        PrintUtil.printNestedList(new CombinationSumIII().combinationSum3(4,27));
    }
}
