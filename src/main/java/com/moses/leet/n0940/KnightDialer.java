package com.moses.leet.n0940;

import java.util.*;

public class KnightDialer {
    int mod = 1000000007;
    List<Integer>[] pads = new List[10];

    public int knightDialer(int n) {
        pads[0] = Arrays.asList(4,6);
        pads[1] = Arrays.asList(8,6);
        pads[2] = Arrays.asList(7,9);
        pads[3] = Arrays.asList(4,8);
        pads[4] = Arrays.asList(3,9,0);
        pads[5] = new ArrayList<>();
        pads[6] = Arrays.asList(1,7,0);
        pads[7] = Arrays.asList(2,6);
        pads[8] = Arrays.asList(1,3);
        pads[9] = Arrays.asList(2,4);
        Integer[][] mem = new Integer[10][n];

        int result = 0;
        for(int i=0; i<10; i++){
            result += dfs(i, n-1, mem);
            result %= mod;
        }
        return result;
    }

    int dfs(int num, int remainTimes, Integer[][] mem){
        if(remainTimes == 0){
            return 1;
        }
        if(mem[num][remainTimes] != null){
            return mem[num][remainTimes];
        }
        int result = 0;
        for(int next : pads[num]){
            result += dfs(next, remainTimes-1, mem);
            result %= mod;
        }
        mem[num][remainTimes] = result;
        return result;
    }


    public int knightDialer1(int N) {
        int mod = 1000000007;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<10; i++){
            map.put(i, new ArrayList<>());
        }
        map.get(0).add(4);
        map.get(0).add(6);
        map.get(1).add(6);
        map.get(1).add(8);
        map.get(2).add(7);
        map.get(2).add(9);
        map.get(3).add(4);
        map.get(3).add(8);
        map.get(4).add(0);
        map.get(4).add(3);
        map.get(4).add(9);
        map.get(6).add(0);
        map.get(6).add(1);
        map.get(6).add(7);
        map.get(7).add(2);
        map.get(7).add(6);
        map.get(8).add(1);
        map.get(8).add(3);
        map.get(9).add(2);
        map.get(9).add(4);

        long[] mem = new long[10];
        Arrays.fill(mem, 1L);

        for(int i=2; i<=N; i++){
            long[] nMem = new long[10];
            for(int k=0; k<mem.length; k++) {
                for (int j : map.get(k)) {
                    nMem[j] += mem[k];
                    nMem[j] %= mod;
                }
            }
            mem = nMem;
        }
        long res = 0;
        for(int i=0; i<mem.length; i++){
            res+=mem[i];
        }
        return (int)(res%mod);
    }

    public static void main(String[] args) {
        System.out.println(new KnightDialer().knightDialer(305));
        System.out.println(new KnightDialer().knightDialer(1));
        System.out.println(new KnightDialer().knightDialer(2));
        System.out.println(new KnightDialer().knightDialer(3));
    }
}
