package com.moses.leet.n0540;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BeautifulArrangement {

    public int countArrangement(int N) {
        boolean[] used = new boolean[N+1];
        Map<String, Integer> map = new HashMap<>();
        return dfs(N, used, 1, map);
    }

    private int dfs(int n, boolean[] used, int idx, Map<String, Integer> map) {
        if(idx == n+1){
            return 1;
        }

        int sum = 0;
        int com = serialize(used);
        String key = com+"_"+idx;
        if(map.containsKey(key)){
            return map.get(key);
        }
        for(int i=1; i<=n; i++){
            if(used[i]){
                continue;
            }
            if(i%idx == 0 || idx%i==0){
                used[i] = true;
                sum+=dfs(n, used, idx+1, map);
                used[i] = false;
            }
        }
        map.put(key, sum);
        return sum;
    }

    int serialize(boolean[] used){
        int r = 0;
        for(int i=0; i<used.length; i++){
            if(used[i]){
                r|= (1<<i);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new BeautifulArrangement().countArrangement(2));
        System.out.println(new BeautifulArrangement().countArrangement(10));
        System.out.println(new BeautifulArrangement().countArrangement(15));
    }
}
