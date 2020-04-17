package com.moses.leet.n0800;

import java.util.*;

public class IsGraphBipartite {
    //use color
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];      //0 not visited, -1 black, 1 white
        for(int i=0; i<visited.length; i++){
            if(visited[i] == 0 && !dfs(i, visited, graph, 1)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int[] visited, int[][] graph, int color) {
        if(visited[node]!=0){
            return visited[node] == color;  //color to be used must be same with existing color
        }
        visited[node] = color;
        for(int i : graph[node]){
            if(!dfs(i, visited, graph, -color)){
                return false;
            }
        }
        return true;
    }


    public boolean isBipartiteMyOwn(int[][] graph) {
        if(graph == null || graph.length==0 ||graph.length==1 && graph[0].length==0){
            return true;
        }
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        for(int i=0; i<graph.length; i++){
            edges.put(i, new HashSet<>());
            for(int j=0; j<graph[i].length; j++){
                edges.get(i).add(graph[i][j]);
            }
        }
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for(int i=0; i<graph.length; i++){
            dfs(i, setA, setB, edges);
        }

        if(setB.isEmpty()){
            return false;
        }

        for(int i : setA){
            for(int j: setA){
                if(i==j){
                    continue;
                }
                if(edges.get(i).contains(j)){
                    return false;
                }
            }
        }

        for(int i : setB){
            for(int j: setB){
                if(i==j){
                    continue;
                }
                if(edges.get(i).contains(j)){
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(int i, Set<Integer> setA, Set<Integer> setB, Map<Integer, Set<Integer>> edges) {
        if(setB.contains(i) ||setA.contains(i)){
            return;
        }
        setA.add(i);
        for(int b:edges.get(i)){
            dfs(b, setB, setA, edges);
        }
    }

    public static void main(String[] args) {
        int[][] graph;
        graph = new int[][]{{1},{0,3},{3},{1,2}};
        System.out.println(new IsGraphBipartite().isBipartite(graph));
    }
}
