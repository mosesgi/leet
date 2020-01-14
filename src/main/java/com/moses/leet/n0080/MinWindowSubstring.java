package com.moses.leet.n0080;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinWindowSubstring {

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen < tLen){
            return "";
        } else if(sLen == tLen){
            if(s.equals(t)){
                return s;
            } else {
                return "";
            }
        }
        boolean firstFound = false;
        String minStr = "";

        char[] tChars = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tChars){
            map.put(c, 0);
        }

        int left = 0;
        int right = left+tLen;
        boolean inMatching = false;
        while(right-left >=tLen){
            if(!inMatching){
                char leftChar = s.charAt(left);
                if(map.containsKey(leftChar)) {
                    inMatching = true;
                    map.put(leftChar, map.get(leftChar) + 1);
                    right = left+tLen;

                    for(int i=left; i<right; i++){
                        char c = s.charAt(i);
                        if(map.containsKey(c)){
                            map.put(c, map.get(c) + 1);
                        }
                    }
                    if(isMatching(map)){
                        return s.substring(left, right);
                    } else {

                    }

                }
            }






            if(inMatching){
                if(right-left >= tLen && isMatching(map) ){
                    String str = s.substring(left, right+1);
                    if(!firstFound){
                        minStr = str;
                    } else if(right-left < minStr.length()){
                        minStr = str;
                    }
                }
            }
        }

        return "";
    }

    private boolean isMatching(Map<Character, Integer> map){
        Set<Character> set = map.keySet();
        for(Character c: set){
            if(map.get(c) > 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new MinWindowSubstring().minWindow(s, t));

        s = "aaaaaaaaaaaabbbbbcdd";
        t = "abcdd";
        System.out.println(new MinWindowSubstring().minWindow(s, t));

        s = "bbaa";
        t = "aba";
        System.out.println(new MinWindowSubstring().minWindow(s, t));

        s = "CDEADOBECABEBANC";
        t = "ABC";
        System.out.println(new MinWindowSubstring().minWindow(s, t));

        s = "CDEADOBECODEBANC";
        t = "ABC";
        System.out.println(new MinWindowSubstring().minWindow(s, t));

        s = "abc";
        t = "cba";
        System.out.println(new MinWindowSubstring().minWindow(s, t));
    }


    //time limit exceeded. This is not O(n)
    public String minWindowInvalid(String s, String t){
        int sLen = s.length();
        int tLen = t.length();
        char[] tChars = t.toCharArray();

        if(sLen < tLen){
            return "";
        } else if(sLen == tLen){
            Map<Character, Integer> map = new HashMap<>();
            for(char c: tChars){
                if(map.containsKey(c)){
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
            for(int i=0; i<sLen; i++){
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    map.put(c, map.get(c) - 1);
                }
            }
            if(isMatching(map)){
                return s;
            }
        }

        int searchLen = tLen;

        while(searchLen <= sLen){
            Map<Character, Integer> map = new HashMap<>();
            for(char c: tChars){
                if(map.containsKey(c)){
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
            for(int i=0; i<=s.length()-searchLen; i++){
//                System.out.println("i=" + i + ", " + s.substring(i, i+searchLen));
                if(i==0){
                    for(int j=i; j<searchLen; j++){
                        char c = s.charAt(j);
                        if(map.containsKey(c)){
                            map.put(c, map.get(c) -1);
                        }
                    }
                    if(isMatching(map)){
                        return s.substring(0, searchLen);
                    }
                } else {
                    char prevLeft = s.charAt(i-1);
                    if(map.containsKey(prevLeft)){
                        map.put(prevLeft, map.get(prevLeft) + 1);
                    }
                    char newRight = s.charAt(i+searchLen-1);
                    if(map.containsKey(newRight)){
                        map.put(newRight, map.get(newRight) - 1);
                        if(isMatching(map)){
                            return s.substring(i, i+searchLen);
                        }
                    }
                }
            }
            searchLen++;
        }
        return "";
    }


}
