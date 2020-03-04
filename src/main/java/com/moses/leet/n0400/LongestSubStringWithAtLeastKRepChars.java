package com.moses.leet.n0400;

import java.util.*;

public class LongestSubStringWithAtLeastKRepChars {
    //Top rated solution O(N), two pointers

    public int longestSubstringBest(String s, int k){
        char[] str = s.toCharArray();
        int[] counts = new int[26];
        int uniqueCnts, left, right, cntIdx, max = 0, tmpUnique, noLessThanK;

        for (uniqueCnts = 1; uniqueCnts <= 26; uniqueCnts++) {
            Arrays.fill(counts, 0);
            left = 0;
            right = 0;
            tmpUnique = 0;
            noLessThanK = 0;
            while (right < str.length) {
                if (tmpUnique <= uniqueCnts) {
                    cntIdx = str[right] - 'a';
                    if (counts[cntIdx] == 0)
                        tmpUnique++;
                    counts[cntIdx]++;
                    if (counts[cntIdx] == k)
                        noLessThanK++;
                    right++;
                }
                else {
                    cntIdx = str[left] - 'a';
                    if (counts[cntIdx] == k)
                        noLessThanK--;
                    counts[cntIdx]--;
                    if (counts[cntIdx] == 0)
                        tmpUnique--;
                    left++;
                }
                if (tmpUnique == uniqueCnts && tmpUnique == noLessThanK)
                    max = Math.max(right - left, max);
            }
        }

        return max;
    }

    //Mine second solution, cost too much time but works.
    public int longestSubstring(String s, int k) {
        Map<Character, SortedSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c= s.charAt(i);
            if(map.containsKey(c)){
                map.get(c).add(i);
            }else {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(i);
                map.put(c, set);
            }
        }

        TreeSet<Integer> insuff = new TreeSet<>();
        int insCnt = 0;
        for(Character c : map.keySet()){
            if(map.get(c).size() < k){
                insuff.addAll(map.get(c));
                insCnt++;
            }
        }

        if(insCnt==0){
            return s.length();
        } else if(insCnt == map.size()){
            return 0;
        }

        int len = 0;

        int start = 0;
        for (int i : insuff) {
            int tmp = isGood(map, k, start, i);
            if(tmp > len){
                len = tmp;
            }
            start = i+1;
        }
        int tm = isGood(map, k, start, s.length());
        if(tm > len){
            len = tm;
        }
        return len;
    }

    private int isGood(Map<Character, SortedSet<Integer>> map, int k, int start, int end){
        if(end-start < k){
            return 0;
        }
        Map<Character, SortedSet<Integer>> subMap = new HashMap<>();
        SortedSet<Integer> insuff = new TreeSet<>();
        boolean pass = true;
        int insuCnt = 0;
        for(Character c : map.keySet()){
            SortedSet<Integer> set = map.get(c);
            SortedSet<Integer> subSet = set.subSet(start, end);
            subMap.put(c, subSet);
            if(subSet.size()>0 && subSet.size() < k){
                insuff.addAll(subSet);
                pass = false;
                insuCnt++;
            }
        }
        if(insuCnt == map.size()){
            return 0;
        }

        if(!pass) {
            int newStart = start;
            int len = 0;
            for (int i : insuff) {
                int tmp = isGood(subMap, k, newStart, i);
                if(tmp > len){
                    len = tmp;
                }
                newStart = i+1;
            }
            int tm = isGood(subMap, k, newStart, end);
            if(tm > len){
                len = tm;
            }
            return len;
        } else {
            return end-start;
        }
    }

    public static void main(String[] args) {
        String s;
        int k;

        s = "aabcabb";
        k = 3;
        System.out.println(new LongestSubStringWithAtLeastKRepChars().longestSubstring(s, k));

        s = "aaabb";
        k = 3;
        System.out.println(new LongestSubStringWithAtLeastKRepChars().longestSubstring(s, k));

        s = "aacbbbdc";
        k = 2;
        System.out.println(new LongestSubStringWithAtLeastKRepChars().longestSubstring(s, k));

        s = "bbaaacbd";
        k = 3;
        System.out.println(new LongestSubStringWithAtLeastKRepChars().longestSubstring(s, k));

        s = "weitong";
        k = 2;
        System.out.println(new LongestSubStringWithAtLeastKRepChars().longestSubstring(s, k));

        s = "ababbc";
        k = 2;
        System.out.println(new LongestSubStringWithAtLeastKRepChars().longestSubstring(s, k));
    }



    public int longestSubstring_VERY_SLOW(String s, int k) {
        int[] cnt = new int[26];
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }
        if(isGood(cnt, k)){
            return s.length();
        }

        int len = 0;
        for(int i=0; i<s.length(); i++){
            int[] clone = cnt.clone();
            if(isGood(clone, k) && s.length()-i > len){
                len = s.length()-i;
            }
            for(int j=s.length()-1; j>i; j--){
                clone[s.charAt(j)-'a']--;
                if(isGood(clone, k) && j-i > len){
                    len = j-i;
                }
            }
            cnt[s.charAt(i)-'a']--;
        }
        return len;
    }

    private boolean isGood(int[] cnt, int k){
        for(int i : cnt){
            if(i == 0){
                continue;
            }
            if(i<k){
                return false;
            }
        }
        return true;
    }
}
