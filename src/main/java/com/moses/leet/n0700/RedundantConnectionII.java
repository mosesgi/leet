package com.moses.leet.n0700;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


//TODO: NOT FINISHED
public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        //1. 造成两个parent (而且删的那个不能是Root)
        //2. 造成根Root消失 (至少有一个Node入度为0)

        Map<Integer, Integer> parentMap = new HashMap<>();      //key: child, value: parent
        Map<Integer, Integer> indoorMap = new HashMap<>();      //入度计数
        int[] cand1 = new int[2], cand2 = new int[2];
        boolean isDupParents = false;
        for(int[] edge : edges){
            if(parentMap.containsKey(edge[1])){
                cand1 = new int[]{parentMap.get(edge[1]), edge[1]};
                cand2 = edge;
                isDupParents = true;
            }
            parentMap.put(edge[1], edge[0]);
            indoorMap.put(edge[1], indoorMap.getOrDefault(edge[1], 0) + 1);
        }

        if(isDupParents){
            if(!indoorMap.containsKey(cand1[0])){
                return cand2;
            }else{
                return cand1;
            }
        }

        //Root消失, 环判断, 倒找到第一条

        return new int[]{-1,-1};
    }
}
