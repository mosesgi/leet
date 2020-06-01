package com.moses.leet.n1060;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LastStoneWeightII {
    int res = Integer.MAX_VALUE;
    public int lastStoneWeightIIMLE(int[] stones) {
        List<Integer> l = new ArrayList<>();
        for(int i : stones){
            l.add(i);
        }

        dfs(l);
        return res;
    }

    void dfs(List<Integer> l){
        if(l.size()==0){
            res = 0;
            return;
        }else if(l.size()==1){
            res = Math.min(res, l.get(0));
            return;
        }
        for(int i=0; i<l.size()-1; i++){
            for(int j=i+1; j<l.size(); j++){
                List<Integer> tmp = new ArrayList<>();
                for(int k=0; k<l.size(); k++){
                    if(k==i || k==j){
                        continue;
                    }
                    tmp.add(l.get(k));
                }
                if(l.get(i) != l.get(j)){
                    tmp.add(Math.abs(l.get(i) - l.get(j)));
                }
                dfs(l);
            }
        }
    }
}
