package com.moses.leet.n0180;

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length()-t.length()) > 1){
            return false;
        }
        if(s.equals(t)){
            return false;
        }
        return dfs1(s, t, 0, 0);
    }

    boolean dfs1(String s, String t, int ps, int pt){
        while(ps < s.length() && pt < t.length()){
            if(s.charAt(ps) == t.charAt(pt)){
                ps++;
                pt++;
            }else{
                return dfs2(s, t, ps+1, pt+1) || dfs2(s, t, ps+1, pt) || dfs2(s, t, ps, pt+1);
            }
        }
        return s.length()-ps == 1 || t.length()-pt == 1;
    }

    boolean dfs2(String s, String t, int ps, int pt){
        while(ps < s.length() || pt < t.length()){
            if(ps >=s.length()){
                return false;
            }else if(pt>=t.length()){
                return false;
            }
            if(s.charAt(ps) == t.charAt(pt)){
                ps++;
                pt++;
            }else{
                return false;
            }
        }
        return true;
    }
}
