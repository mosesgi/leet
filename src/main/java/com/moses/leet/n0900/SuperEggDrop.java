package com.moses.leet.n0900;

public class SuperEggDrop {
    //k=2,n=6.   3; 4; 5
    // k=3,n=14.  7; 11; 12; 13
    //k=2,n=18.  9; +7  = 8
    //k=4,n=18.  9; 14; 16; 17;  =4

    //TLE
    Integer[][] mem = null;
    public int superEggDrop(int K, int N) {
        if(mem == null){
            mem = new Integer[N+1][K+1];
        }
        if(mem[N][K] != null){
            return mem[N][K];
        }
        if(K==1){
            return N;
        }
        if(N==0){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++){
            res = Math.min(res, Math.max(superEggDrop(K-1, i-1), superEggDrop(K, N-i)) + 1);
        }
        mem[N][K] = res;
        return res;
    }
}
