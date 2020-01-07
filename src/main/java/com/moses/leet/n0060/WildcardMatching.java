package com.moses.leet.n0060;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/wildcard-matching/
 */
public class WildcardMatching {
    Map<String, Boolean> cache = new HashMap<>();

    public boolean isMatch(String s, String p) {
        if(p.length()==0 && s.length() == 0){
            return true;
        }
        return recursiveMatchCache(s, p, 0, 0);
    }

    //Resolution: https://leetcode.com/problems/wildcard-matching/discuss/370736/Detailed-Intuition-From-Brute-force-to-Bottom-up-DP
    private boolean recursiveMatchCache(String s, String p, int pointerS, int pointerP) {
        String key = pointerS + "," + pointerP;
        if(cache.containsKey(key)){
            return cache.get(key);
        }

        boolean rst;
        if(pointerS == s.length() && pointerP == p.length()){
            rst = true;
        } else if(pointerP == p.length() && pointerS < s.length()){     // there are still characters in s.
            rst =  false;
        } else if(pointerS == s.length() && pointerP < p.length()){
            rst = p.charAt(pointerP) == '*' && recursiveMatchCache(s, p, pointerS, pointerP+1);
        } else if(p.charAt(pointerP) == '*'){      // star either match 0 or >=1 character(s)
            rst = recursiveMatchCache(s, p, pointerS, pointerP+1) || recursiveMatchCache(s, p, pointerS+1, pointerP);
        } else if(p.charAt(pointerP) == '?' || p.charAt(pointerP) == s.charAt(pointerS)){
            rst = recursiveMatchCache(s, p, pointerS+1, pointerP+1);
        } else {
            rst = false;
        }
        cache.put(key, rst);
        return rst;
    }

    //Brute force from leetcode forum. Also time limit exceed.
    private boolean recursiveMatch(String s, String p, int pointerS, int pointerP) {
        if(pointerS == s.length() && pointerP == p.length()){
            return true;
        }
        if(pointerP == p.length() && pointerS < s.length()){     // there are still characters in s.
            return false;
        }
        if(pointerS == s.length() && pointerP < p.length()){
            return p.charAt(pointerP) == '*' && recursiveMatch(s, p, pointerS, pointerP+1);
        }
        if(p.charAt(pointerP) == '*'){      // star either match 0 or >=1 character(s)
            return recursiveMatch(s, p, pointerS, pointerP+1) || recursiveMatch(s, p, pointerS+1, pointerP);
        } else if(p.charAt(pointerP) == '?' || p.charAt(pointerP) == s.charAt(pointerS)){
            return recursiveMatch(s, p, pointerS+1, pointerP+1);
        } else {
            return false;
        }
    }


    //time limit exceeded...
    public boolean recursiveMatch(String s, String p, boolean isPrevStar){
        if(p.length() == 0){
            return false;
        }
        if(p.length() == 1){
            if(p.charAt(0) == '*'){
                return true;
            } else if(p.charAt(0) == '?'){
                if(!isPrevStar){
                    return s.length() == 1;
                } else if(isPrevStar){
                    return s.length()>=1;
                }
            } else {
                if(isPrevStar){
                    return s.endsWith(p);
                } else {
                    return p.equals(s);
                }
            }
        }
        if(p.charAt(0) == '?'){
            if(s.length() == 0){
                return false;
            }
            if(isPrevStar){
                boolean anyMatch = false;
                for (int i = 0; i < s.length(); i++) {
                    boolean tmpMatch = recursiveMatch(s.substring(i+1), p.substring(1), false);
                    if (tmpMatch) {
                        anyMatch = true;
                        break;
                    }
                }
                return anyMatch;
            } else {
                return recursiveMatch(s.substring(1), p.substring(1), false);
            }
        } else if(p.charAt(0) == '*'){
            return recursiveMatch(s, p.substring(1), true);
        } else {
            if(s.length() == 0){
                return false;
            }
            if(isPrevStar) {
                boolean anyMatch = false;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == p.charAt(0)) {
                        boolean tmpMatch = recursiveMatch(s.substring(i + 1), p.substring(1), false);
                        if (tmpMatch) {
                            anyMatch = true;
                            break;
                        }
                    }
                }
                return anyMatch;
            } else {
                if(s.charAt(0) == p.charAt(0)){
                    return recursiveMatch(s.substring(1), p.substring(1), false);
                } else {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "aa", p = "a";
        System.out.println(new WildcardMatching().isMatch(s, p));

        s="abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        p="**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        System.out.println(new WildcardMatching().isMatch(s, p));

        s = "bbbab"; p = "*??a?";
        System.out.println(new WildcardMatching().isMatch(s, p));

        s = "b"; p = "*?*?*";
        System.out.println(new WildcardMatching().isMatch(s, p));

        s = ""; p = "?";
        System.out.println(new WildcardMatching().isMatch(s, p));

        s = "mississippi"; p = "m??*ss*?i*pi";
        System.out.println(new WildcardMatching().isMatch(s, p));

        s = "adceb"; p = "*a*b";
        System.out.println(new WildcardMatching().isMatch(s, p));

        s = "aa"; p = "*";
        System.out.println(new WildcardMatching().isMatch(s, p));

        s = "cb"; p = "?a";
        System.out.println(new WildcardMatching().isMatch(s, p));

        s = "acdcb"; p = "a*c?b";
        System.out.println(new WildcardMatching().isMatch(s, p));

        s = "abwerfibserq"; p = "a*bs*";
        System.out.println(new WildcardMatching().isMatch(s, p));

//        s = "aa"; p = "*";
//        System.out.println(new WildcardMatching().isMatch(s, p));
    }
}
