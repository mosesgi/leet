package com.moses.leet.n0700;

import java.util.*;

public class RedundantConnection {

    //disjoint set
    public int[] findRedundantConnection(int[][] edges) {
        int[] set = new int[edges.length+1];
        Arrays.fill(set, -1);
        for(int[] edge : edges){
            if(!union(edge[0], edge[1], set)){
                return edge;
            }
        }
        return new int[]{-1,-1};
    }

    int find(int x, int[] set){
        if(set[x] < 0){
            return x;
        }
        return find(set[x], set);
    }

    //return false if x and y are connected.
    boolean union(int x, int y, int[] set){
        int xr = find(x, set);
        int yr = find(y, set);
        if(xr == yr){
            return false;
        }

        //join sets by pointing root, and add weight to new root.
        //use bigger weights as new root. (negative value)
        if(set[xr] < set[yr]){
            int weight = set[yr];
            set[yr] = xr;
            set[xr] += weight;
        }else{
            int weight = set[xr];
            set[xr] = yr;
            set[yr] += weight;
        }
        return true;
    }

    //dfs, if dfs returns back to start, it's duplicate edge
    public int[] findRedundantConnectionDfs(int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=1; i<=edges.length; i++){
            map.put(i, new HashSet<>());
        }

        int[] rst = new int[]{1,1};
        for(int[] ints : edges){
            if(dfs(map, ints[0], ints[1], new HashSet<>())){
                return ints;
            }
            map.get(ints[0]).add(ints[1]);
            map.get(ints[1]).add(ints[0]);
        }
        return rst;
    }

    private boolean dfs(Map<Integer, Set<Integer>> map, int source, int target, Set<Integer> visited) {
        if(source == target){
            return true;
        }
        visited.add(source);
        for(Integer next : map.get(source)){
            if(!visited.contains(next)) {
                if (dfs(map, next, target, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    //My solution. Topology sort, but ugly...
    public int[] findRedundantConnectionMine(int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] ints : edges){
            Set<Integer> set = map.getOrDefault(ints[0], new HashSet<>());
            set.add(ints[1]);
            map.put(ints[0], set);
            set = map.getOrDefault(ints[1], new HashSet<>());
            set.add(ints[0]);
            map.put(ints[1], set);
        }

        List<Map.Entry<Integer, Set<Integer>>> list = new ArrayList<>();
        list.addAll(map.entrySet());
//        PriorityQueue<Map.Entry<Integer, Set<Integer>>> p = new PriorityQueue<>((o1, o2) -> o1.getValue().size() - o2.getValue().size());
//        PriorityQueue<Map.Entry<Integer, Set<Integer>>> p1 = new PriorityQueue<>((o1, o2) -> o1.getValue().size() - o2.getValue().size());
//        p.addAll(map.entrySet());
        while(true){
            boolean found = false;
            for(Map.Entry<Integer, Set<Integer>> entry: list){
                if(entry.getValue().size() == 1){
                    found = true;
                    for(Integer i : entry.getValue()){
                        map.get(i).remove(entry.getKey());
                    }
                    entry.getValue().clear();
                }
            }
            if(!found){
                break;
            }
        }

        Set<Integer> dups = new HashSet<>();
        for(Map.Entry<Integer, Set<Integer>> entry: list){
            if(entry.getValue().size() >1 ){
                dups.add(entry.getKey());
            }

        }
        for(int i=edges.length-1; i>=0; i--){
            int[] ints = edges[i];
            if(dups.contains(ints[0]) && dups.contains(ints[1])){
                return ints;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[][] edges;
        edges = new int[][]{{16,25},{7,9},{3,24},{10,20},{15,24},{2,8},{19,21},{2,15},{13,20},{5,21},{7,11},{6,23},{7,16},{1,8},{17,20},{4,19},{11,22},{5,11},{1,16},{14,20},{1,4},{22,23},{12,20},{15,18},{12,16}};
        System.out.println(Arrays.toString(new RedundantConnection().findRedundantConnection(edges)));
    }
}
