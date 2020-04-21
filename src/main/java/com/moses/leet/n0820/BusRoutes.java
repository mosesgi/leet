package com.moses.leet.n0820;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Set<Integer>[] rs = new HashSet[routes.length];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<routes.length; i++){
            rs[i] = new HashSet<>();
            for(int r : routes[i]){
                rs[i].add(r);
            }
        }
        Set<Integer> visitedRoute = new HashSet<>();
        q.offer(S);

        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int cur = q.poll();
                if(cur == T){
                    return res;
                }
                for(int j=0; j<rs.length; j++){
                    if(visitedRoute.contains(j)){
                        continue;
                    }

                    Set<Integer> route = rs[j];
                    if(route.contains(cur)){
                        for(Integer r : route){
                            if(r != cur){
                                q.offer(r);
                            }
                        }
                        visitedRoute.add(j);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] routes; int S, T;
        routes = new int[][]{{1, 2, 7}, {3, 6, 7}};
        S = 1; T=6;
        System.out.println(new BusRoutes().numBusesToDestination(routes, S, T));
    }
}
