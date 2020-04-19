package com.moses.leet.n0020;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 */
public class RegularExpMatching {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean firstMatch = (!s.isEmpty()) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            boolean skipPatternStar = isMatch(s, p.substring(2));
            boolean subsequent = firstMatch && isMatch(s.substring(1), p);
            return skipPatternStar || subsequent;
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }


    //Wrong
    public boolean isMatchWrong(String s, String p){
        if(s.isEmpty()){
            return p.isEmpty();
        }
        return dfs(s, 0, p, 0);
    }

    private boolean dfs(String s, int sPos, String p, int pPos) {
        if(sPos == s.length() && pPos == p.length()){
            return true;
        }else{
            if(sPos == s.length() || pPos == p.length()){
                return false;
            }
        }
        boolean headMatch = s.charAt(sPos) == p.charAt(pPos) || p.charAt(pPos) == '.';
        if(pPos+1 < p.length() && p.charAt(pPos+1) == '*'){
            boolean skipP = dfs(s, sPos, p, pPos+2);
            boolean matching = headMatch && (dfs(s, sPos+1, p, pPos) || dfs(s, sPos+1, p, pPos+2));
            return skipP || matching;
        }else{
            return headMatch && dfs(s, sPos+1, p, pPos+1);
        }

    }


    public static void main(String[] args) {
        RegularExpMatching reg = new RegularExpMatching();
        System.out.println(reg.isMatch("mississippi", "mis*is*p*."));
        System.out.println(reg.isMatch("aa", "a*"));
        System.out.println(reg.isMatch("aa", "a"));

        System.out.println(reg.isMatch("ab", ".*"));
        System.out.println(reg.isMatch("aab", "c*a*b"));
    }
}
