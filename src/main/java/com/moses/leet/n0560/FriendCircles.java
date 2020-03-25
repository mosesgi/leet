package com.moses.leet.n0560;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FriendCircles {
    public int findCircleNum(int[][] M) {
        int len = M.length;
        if(len == 0){
            return 0;
        }
        int cnt = 0;
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<len; i++){
            if(visited.contains(i)){
                continue;
            }
            bfs(M, i, visited);
            cnt++;
        }
        return cnt;
    }

    private void bfs(int[][] m, int i, Set<Integer> visited) {
        Queue<Integer> friends = new LinkedList<>();
        for(int j=0; j<m.length; j++){
            if(i==j || m[i][j] == 0 || m[i][j] == -1){
                continue;
            }
            friends.offer(j);
            m[i][j] = -1;
            m[j][i] = -1;
        }
        while(!friends.isEmpty()){
            int f = friends.poll();
            if(visited.contains(f)){
                continue;
            }
            visited.add(f);
            for(int j=0; j<m.length; j++){
                if(f==j || m[f][j] == 0 || m[f][j] == -1){
                    continue;
                }
                friends.offer(j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] m;
        m = new int[][]{
                {1,1,0},
                {1,1,1},
                {0,1,1}};
        System.out.println(new FriendCircles().findCircleNum(m));
    }


}
