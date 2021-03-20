package com.moses.leet.n0560;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Uf uf = new Uf(n);
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(isConnected[i][j] == 1){
                    uf.join(i, j);
                }
            }
        }

        int[] array = uf.uf;
        int result = 0;
        for(int i=0; i<n; i++){
            if(array[i] == i){
                result++;
            }
        }
        return result;
    }

    class Uf{
        int[] uf;

        public Uf(int n){
            uf = new int[n];
            for(int i=0; i<n; i++){
                uf[i] = i;
            }
        }

        int findRoot(int x){
            while(uf[x] != x){
                uf[x] = uf[uf[x]];
                x = uf[x];
            }
            return x;
        }

        //0,0,1

        void join(int a, int b){
            int aRoot = findRoot(a);
            int bRoot = findRoot(b);
            uf[aRoot] = bRoot;
        }

    }
}
