package com.moses.leet.n0660;

import java.util.HashMap;
import java.util.Map;

public class FourKeysKeyboard {
    Map<String, Integer> mem = new HashMap<>();
    public int maxA(int N) {
        return dfs(N,  0, 0);
    }


    int dfs(int N, int as, int copyAs){
        if(N==0){
            return as;
        }
        String key = N+"_"+as+"_"+copyAs;
        if(mem.containsKey(key)){
            return mem.get(key);
        }
        int a = dfs(N-1, as+1, copyAs);
        int b = 0;
        if(N>3){
            b = dfs(N-3, as*2, as);
        }
        int c = dfs(N-1, as+copyAs, copyAs);

        mem.put(key, Math.max(a, Math.max(b, c)));
        return mem.get(key);
    }

//    void dfs(int N, int n, int as, int copyAs, int prevPress){
//        if(n==N){
//            res = Math.max(res, as);
//            return;
//        }
//        if(prevPress == 0){
//            dfs(N, n + 1, as + 1, copyAs,1);
//        }else if(prevPress == 1) {
//            dfs(N, n + 1, as + 1, copyAs,1);
//            dfs(N, n + 1, as, copyAs,2);
//            dfs(N, n + 1, as + copyAs, copyAs,4);
//        }else if(prevPress == 2){
//            dfs(N, n + 1, as, as,3);
//        }else if(prevPress == 3){
//            dfs(N, n + 1, as+copyAs, as,4);
//        }else if(prevPress == 4){
//            dfs(N, n + 1, as+1, copyAs,1);
//            dfs(N, n + 1, as, copyAs,2);
//            dfs(N, n + 1, as+copyAs, copyAs,4);
//        }
//    }

}
