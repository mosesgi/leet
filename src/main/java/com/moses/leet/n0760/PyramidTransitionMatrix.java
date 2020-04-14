package com.moses.leet.n0760;

import java.util.*;

public class PyramidTransitionMatrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, Set<String>> allow = new HashMap<>();
        for(String s : allowed){
            String b = s.substring(0, 2);
            String t = s.substring(2);
            allow.putIfAbsent(b, new HashSet<>());
            allow.get(b).add(t);
        }

        return dfs(bottom, "", allow, 0);
    }

    private boolean dfs(String bottom, String top, Map<String, Set<String>> allow, int pos) {
        if(bottom.length()==1){
            return true;
        }
        if(pos == bottom.length()-1){
            return dfs(top, "", allow, 0);
        }
//        System.out.println(bottom + ", pos:" + pos);
        String base = bottom.substring(pos, pos+2);
        if(!allow.containsKey(base)){
            return false;
        }
        for(String p : allow.get(base)){
            if(dfs(bottom, top+p, allow, pos+1)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String bottom;
        List<String> allowed;
        bottom = "BCD";
        allowed = Arrays.asList("BCG", "CDE", "GEA", "FFF");
        System.out.println(new PyramidTransitionMatrix().pyramidTransition(bottom, allowed));

        bottom = "AABA";
        allowed = Arrays.asList("AAA", "AAB", "ABA", "ABB", "BAC");
        System.out.println(new PyramidTransitionMatrix().pyramidTransition(bottom, allowed));
    }
}
