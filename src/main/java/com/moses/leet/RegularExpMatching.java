package com.moses.leet;

import java.util.*;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 */
public class RegularExpMatching {

    public boolean isMatch(String s, String p){
        if(p.isEmpty()){
            return s.isEmpty();
        }

        boolean firstMatch = (!s.isEmpty()) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        if(p.length()>=2 && p.charAt(1) == '*'){
            boolean skipPatternStar = isMatch(s, p.substring(2));
            boolean subsequent = firstMatch && isMatch(s.substring(1), p);
            return skipPatternStar || subsequent;
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }




    public static void main(String[] args) {
        RegularExpMatching reg = new RegularExpMatching();
        System.out.println(reg.isMatch("aa", "a"));
        System.out.println(reg.isMatch("aa", "a*"));

        System.out.println(reg.isMatch("ab", ".*"));
        System.out.println(reg.isMatch("aab", "c*a*b"));
    }
}
