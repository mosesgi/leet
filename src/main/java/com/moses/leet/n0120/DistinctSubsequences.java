package com.moses.leet.n0120;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/distinct-subsequences/
 */
public class DistinctSubsequences {
    int count = 0;
    Map<Character, List<Integer>> index = new HashMap<>();

    public int numDistinct(String s, String t) {
        if(s.length() == 0){
            if(t.length() == 0){
                return 1;
            }
            return 0;
        }

        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(index.containsKey(c)){
                index.get(c).add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                index.put(c, l);
            }
        }
        int sLen = s.length();
        int tLen = t.length();
        int[][] cache = new int[sLen][tLen];
        for(int i=0; i<sLen; i++){
            for(int j= 0; j<tLen; j++){
                cache[i][j] = -1;
            }
        }
        return recursiveMap(s, t, 0, 0, s.length(), t.length(), cache);
    }

    //DP by myself!
    private int recursiveMap(String s, String t, int sPos, int tPos, int sLen, int tLen, int[][] cache){
        if(tPos == tLen){
            return 1;
        }
        if(sPos == sLen && tPos < tLen-1){
            return 0;
        }
        List<Integer> sPoses = index.get(t.charAt(tPos));
        if(sPoses == null || sPoses.isEmpty()){
            return 0;
        }
        int tmp = 0;
        for(int i=sPoses.size()-1; i>=0; i--){
            int currPos = sPoses.get(i);
            if(currPos<sPos){
                break;
            }

            if(cache[currPos][tPos] != -1){
                tmp += cache[currPos][tPos];
            } else {
                int cnt = recursiveMap(s, t, currPos + 1, tPos + 1, sLen, tLen, cache);
                cache[currPos][tPos] = cnt;
                tmp += cnt;
            }

        }
        return tmp;
    }

    //time limit exceeded
    private void recursiveCount(String s, String t, int sPos, int tPos, int sLen, int tLen) {
        if(tPos == tLen){
            count++;
            return;
        }
        if(sPos == sLen && tPos < tLen-1){
            return;
        }
        for(int i=sPos; i<=sLen-(tLen-tPos); i++){
            if(s.charAt(i) == t.charAt(tPos)){
                recursiveCount(s, t, i+1, tPos+1, sLen, tLen);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences().numDistinct("rabbbit", "rabbit"));
        System.out.println(new DistinctSubsequences().numDistinct("babgbag", "bag"));
        long begin = System.currentTimeMillis();
        System.out.println(new DistinctSubsequences().numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc"));
        System.out.println(System.currentTimeMillis()-begin + " ms");
    }
}
