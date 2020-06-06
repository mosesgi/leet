package com.moses.leet.n1060;

import java.util.*;

public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] res = new int[N+1];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] p : paths){
            map.computeIfAbsent(p[0], z-> new HashSet<>()).add(p[1]);
            map.computeIfAbsent(p[1], z-> new HashSet<>()).add(p[0]);
        }
        for(int i=1; i<=N; i++){
            Set<Integer> colors = new HashSet<>(Arrays.asList(1,2,3,4));
            for(int j : map.getOrDefault(i, new HashSet<>())){
                if(res[j] != 0){
                    colors.remove(res[j]);
                }
            }
            if(res[i]==0){
                res[i] = colors.iterator().next();
            }
        }
        return Arrays.copyOfRange(res, 1, res.length);
    }

    public static void main(String[] args) {
        int n; int[][] paths;
        n=3;
        paths = new int[][]{{1,2},{2,3},{3,1}};
        System.out.println(Arrays.toString(new FlowerPlantingWithNoAdjacent().gardenNoAdj(n, paths)));
    }
}
