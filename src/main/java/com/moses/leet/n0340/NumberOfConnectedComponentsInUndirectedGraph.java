package com.moses.leet.n0340;

public class NumberOfConnectedComponentsInUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int[] uf = new int[n];
        for(int i=0; i<uf.length; i++){
            uf[i] = i;
        }
        for(int[] ed : edges){
            join(uf, ed[0], ed[1]);
        }

        int res = 0;
        for(int i=0; i<uf.length; i++){
            if(uf[i] == i){
                res++;
            }
        }
        return res;
    }

    void join(int[] uf, int a, int b){
        int ra = findRoot(uf, a);
        int rb = findRoot(uf, b);
        uf[rb] = ra;
    }

    int findRoot(int[] uf, int a){
        while(uf[a] != a){
            uf[a] = uf[uf[a]];
            a = uf[a];
        }
        return a;
    }
}
