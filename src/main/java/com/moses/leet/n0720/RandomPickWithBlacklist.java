package com.moses.leet.n0720;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomPickWithBlacklist {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        Random r;
        int M;
        public Solution(int N, int[] blacklist) {
            r = new Random();
            for(int i:blacklist){
                map.put(i, -1);
            }
            M = N-map.size();
            for(int b:blacklist){
                if(b<M){
                    while(map.containsKey(N-1)){
                        N--;
                    }
                    map.put(b, N-1);        //switch b with N-1
                    N--;
                }
            }
        }

        public int pick() {
            int p = r.nextInt(M);
            if(map.containsKey(p)){
                return map.get(p);
            }
            return p;
        }
    }
}
