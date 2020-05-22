package com.moses.leet.n0260;

import java.util.*;

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        //12
        //2,6 -> 2,2,3
        //3,4
        return dfs(2, n);
    }

    List<List<Integer>> dfs(int start, int n){
        List<List<Integer>> list = new ArrayList<>();
        for(int i= start; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(n/i);
                list.add(tmp);
                List<List<Integer>> next = dfs(i, n/i);
                for(List<Integer> l : next){
                    l.add(i);
                    list.add(l);
                }
            }
        }
        return list;
    }



    Map<Integer, List<List<Integer>>> mem = new HashMap<>();
    public List<List<Integer>> getFactorsFirst(int n) {
        Set<List<Integer>> res = new HashSet<>();
        if(n==1){
            return new ArrayList<>(res);
        }
        if(mem.containsKey(n)){
            return mem.get(n);
        }
        Set<Integer> visited = new HashSet<>();
        for(int i=2; i<=n/2; i++){
            if(n%i == 0 && !visited.contains(i)){
                visited.add(i);
                visited.add(n/i);
                List<List<Integer>> next = getFactorsFirst(n/i);
                res.add(Arrays.asList(i, n/i));
                for(List<Integer> l : next){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.addAll(l);
                    Collections.sort(list);
                    res.add(list);
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>(res);
        mem.put(n, list);
        return list;
    }
}
