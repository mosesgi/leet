package com.moses.leet.n1000;

import java.util.HashSet;
import java.util.Set;

public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        Set<Integer>[] trusting = new Set[N+1];
        Set<Integer>[] trusted = new Set[N+1];
        for(int i=1; i<=N; i++){
            trusting[i] = new HashSet<>();
            trusted[i] = new HashSet<>();
        }
        for(int[] t : trust){
            trusting[t[0]].add(t[1]);
            trusted[t[1]].add(t[0]);
        }

        Integer cand = null;
        for(int i=1; i<=N; i++){
            if(trusting[i].size()==0 && trusted[i].size() == N-1){
                if(cand != null){
                    return -1;
                }else{
                    cand = i;
                }
            }
        }
        return cand==null?-1:cand;
    }
}
