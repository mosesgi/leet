package com.moses.leet.n0900;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 *
 * Each person may dislike some other people, and they should not go into the same group. 
 *
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 *
 * Return true if and only if it is possible to split everyone into two groups in this way.
 *
 *  
 *
 * Example 1:
 *
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 * Example 2:
 *
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Example 3:
 *
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 *  
 *
 * Constraints:
 *
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * There does not exist i != j for which dislikes[i] == dislikes[j].
 *
 */
public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] d : dislikes){
            map.computeIfAbsent(d[0], z-> new HashSet<>()).add(d[1]);
            map.computeIfAbsent(d[1], z-> new HashSet<>()).add(d[0]);
        }

        int[] visited = new int[N+1];
        for(int i=1; i<=N; i++){
            if(visited[i] != 0){
                continue;
            }
            if(!dfs(i, map, visited, 1)){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int i, Map<Integer, Set<Integer>> map, int[] visited, int color) {
        if(visited[i] == -color){
            return false;
        }else if(visited[i] == color){
            return true;
        }
        visited[i] = color;
        for(int k : map.getOrDefault(i, new HashSet<>())){
            if(!dfs(k, map, visited, -color)){
                return false;
            }
        }
        return true;
    }
}
