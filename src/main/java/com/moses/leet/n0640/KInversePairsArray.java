package com.moses.leet.n0640;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KInversePairsArray {
    public int kInversePairs(int n, int k) {
        Set<Integer> used = new HashSet<>();
        return dfs(n, used, k, 0, new ArrayList<>());
    }

    private int dfs(int n, Set<Integer> used, int k, int currK, List<Integer> list) {
        if(used.size() == n){
            if(currK == k){
                return 1;
            }else{
                return 0;
            }
        }
        if(currK > k){
            return 0;
        }
        int sum = 0;
        for(int i=1; i<=n; i++){
            if(used.contains(i)){
                continue;
            }
            int count= 0;
            for(int j=0; j<list.size(); j++){
                if(list.get(j) > i){
                    count++;
                }
            }
            used.add(i);
            list.add(i);
            sum+=dfs(n, used, k, currK+count, list);
            list.remove(list.size()-1);
            used.remove(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new KInversePairsArray().kInversePairs(3, 2));
        System.out.println(new KInversePairsArray().kInversePairs(3, 1));
        System.out.println(new KInversePairsArray().kInversePairs(3, 0));
    }


}
