package com.moses.leet.n0280;

import java.util.*;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
 *
 * Example 1:
 *
 * Input:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 *
 * Output: "wertf"
 * Example 2:
 *
 * Input:
 * [
 *   "z",
 *   "x"
 * ]
 *
 * Output: "zx"
 * Example 3:
 *
 * Input:
 * [
 *   "z",
 *   "x",
 *   "z"
 * ]
 *
 * Output: "" 
 *
 * Explanation: The order is invalid, so return "".
 * Note:
 *
 * You may assume all letters are in lowercase.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 *
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        if(words.length==0){
            return "";
        }
        if(words.length == 1){
            return words[0];
        }
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Set<Character>> ind = new HashMap<>();
        for(int i=0; i<words.length-1; i++){
            String a = words[i];
            String b = words[i+1];
            for(char c : a.toCharArray()){
                ind.putIfAbsent(c, new HashSet<>());
            }
            for(char c : b.toCharArray()){
                ind.putIfAbsent(c, new HashSet<>());
            }
            int len = Math.min(a.length(), b.length());
            boolean foundDiff = false;
            for(int j=0; j<len; j++){
                char ca = a.charAt(j);
                char cb = b.charAt(j);

                if(ca != cb){
                    map.computeIfAbsent(ca, z -> new HashSet<>()).add(cb);
                    ind.computeIfAbsent(cb, z -> new HashSet<>()).add(ca);
                    foundDiff = true;
                    break;
                }
            }
            if(!foundDiff && b.length() < a.length()){
                return "";
            }
        }

        Set<Character> visited = new HashSet<>();
        Queue<Character> q = new LinkedList<>();
        for(char c : ind.keySet()){
            if(ind.get(c).size() == 0){
                q.offer(c);
            }
        }


        String res = "";
        while(!q.isEmpty()){
            char c = q.poll();
            if(visited.contains(c)){
                continue;
            }
            visited.add(c);
            res += c;
            for(char d : map.getOrDefault(c, new HashSet<>())){
                ind.get(d).remove(c);
                if(ind.get(d).size() == 0){
                    q.offer(d);
                }
            }
        }

        for(char c : ind.keySet()){
            if(ind.get(c).size() != 0){
                return "";
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words;
        words = new String[]{"za","zb","ca","cb"};
        System.out.println(new AlienDictionary().alienOrder(words));

        words = new String[]{"wrt","wrf","er","ett","rftt"};
        System.out.println(new AlienDictionary().alienOrder(words));
    }
}
