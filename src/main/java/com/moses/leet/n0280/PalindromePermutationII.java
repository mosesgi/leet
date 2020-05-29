package com.moses.leet.n0280;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 给定一个字符串 s ，返回其通过重新排列组合后所有可能的回文字符串，并去除重复的组合。
 *
 * 如不能形成任何回文排列时，则返回一个空列表。
 *
 * 示例 1：
 *
 * 输入: "aabb"
 * 输出: ["abba", "baab"]
 *
 */
public class PalindromePermutationII {
    /**
     * aaaabb
     * aabbaa, abaaba, baaaab,
     *
     * aaaabbc
     * aabcbaa, abacaba, baacaab
     */
    public List<String> generatePalindromes(String s) {
        int len = s.length();
        TreeMap<Character, Integer> cnt = new TreeMap<>();
        for(int i=0; i<len; i++){
            cnt.put(s.charAt(i), cnt.getOrDefault(s.charAt(i), 0) + 1);
        }

        boolean isOdd = len%2==1;
        int oddCnt = 0;
        List<Pair> l = new ArrayList<>();
        char oddChar = ' ';
        for(char c : cnt.keySet()){
            int count = cnt.get(c);
            if(count %2 == 1){
                oddCnt++;
                oddChar = c;
            }
            l.add(new Pair(c, count/2));
        }
        List<String> list = new ArrayList<>();
        if(isOdd && oddCnt != 1){
            return list;
        }
        if(!isOdd && oddCnt > 0){
            return list;
        }

        generate(l, "", oddChar, len/2, list);
        return list;
    }

    private void generate(List<Pair> l, String s, char oddChar, int len, List<String> list) {
        if(s.length() == len){
            StringBuilder rev = new StringBuilder(s);
            s = oddChar == ' '?s:s+oddChar;
            list.add(s+rev.reverse().toString());
            return;
        }
        for(int i=0; i<l.size(); i++){
            Pair p = l.get(i);
            if(p.cnt == 0){
                continue;
            }
            p.cnt--;
            generate(l, s+p.c, oddChar, len, list);
            p.cnt++;
        }
    }

    class Pair{
        char c;
        int cnt;

        public Pair(char c, int cnt){
            this.c = c;
            this.cnt = cnt;
        }
    }
}
