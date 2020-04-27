package com.moses.leet.n0080;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * 找到match的字母,打开窗口,右指针右移. 找到全部字母后,左指针左移,直到不满足, 记录最小字符串. 然后再右指针右移, 以此循环
 */
public class MinWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> cnt = new HashMap<>();
        for(char c : t.toCharArray()){
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int min = Integer.MAX_VALUE;
        int start = -1, end = -1;
        Map<Character, Integer> dyn = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!cnt.containsKey(c)){
                continue;
            }
            dyn.put(c, dyn.getOrDefault(c, 0) + 1);

            //check if all >= cnt
            boolean fulfill = fulfill(cnt, dyn);

            while(fulfill){
                if(i-left+1 < min){
                    min = i-left+1;
                    start = left;
                    end = i;
                }
                char l = s.charAt(left++);
                if(cnt.containsKey(l)) {
                    dyn.put(l, dyn.get(l) - 1);
                    if (dyn.get(l) < cnt.getOrDefault(l, 0)) {
                        break;
                    }
                }
            }
        }
        if(start == -1 && end == -1){
            return "";
        }else{
            return s.substring(start, end+1);
        }
    }

    boolean fulfill(Map<Character, Integer> cnt, Map<Character, Integer> dyn){
        for(char k : cnt.keySet()){
            if(dyn.getOrDefault(k, 0) < cnt.get(k)){
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


    public String minWindowOld(String s, String t) {
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

        String minStr = "";

        Map<Character, Integer> map = new HashMap<>();
        for(char c : tChars){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int left = 0;
        int right = left;
        boolean matched = false;
        while(right < sLen){

            //find matched string by moving right cursor to righter.
            while(right < sLen){
                char currChar = s.charAt(right);
                if(map.containsKey(currChar)) {
                    map.put(currChar, map.get(currChar) - 1);

                    if(isMatching(map)){
                        matched = true;
                        if(minStr.length()==0 || (right-left +1 ) < minStr.length()){
                            minStr = s.substring(left, right+1);
                        }
                        break;
                    }
                }
                right++;
            }

            //once found matched string, try to shorten the string by moving left pointer to right.
            while(matched){
                char removeChar = s.charAt(left);
                if(map.containsKey(removeChar)){
                    map.put(removeChar, map.get(removeChar) + 1);
                    if(!isMatching(map)){
                        matched = false;
                        if(right-left+1 < minStr.length()){
                            minStr = s.substring(left, right+1);
                        }
                        right++;
                    }
                } else {
                    if(right-left+1 < minStr.length()){
                        minStr = s.substring(left, right+1);
                    }
                }
                left++;
            }

        }

        return minStr;
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
