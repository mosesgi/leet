package com.moses.leet.n0800;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(0);
        dfs(0, graph, l, list);
        return list;
    }

    void dfs(int source, int[][] graph, List<Integer> l, List<List<Integer>> list){
        if(source == graph.length-1){
            list.add(new ArrayList<>(l));
            return;
        }
        int[] g = graph[source];
        for(int t : g){
            l.add(t);
            dfs(t, graph, l, list);
            l.remove(l.size()-1);
        }
    }
}
