package com.moses.leet.n0140;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break-ii/
 */
public class WordBreakII {

    Map<Integer, List<String>> cache = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        return recursive(s, 0, wordDict);
    }

    private List<String> recursive(String s, int pos, List<String> wordDict) {
        if(pos == s.length()){
            return null;
        }
        List<String> tmp = new ArrayList<>();
        if(cache.containsKey(pos)){
            return cache.get(pos);
        }
        for(String dict : wordDict){
            String key = pos + "_" + dict;
            int len = dict.length();
            if(pos+len <= s.length() && s.substring(pos, pos+len).equals(dict)){
                List<String> next = recursive(s, pos+len, wordDict);
                if(next == null){
                    tmp.add(dict);
                } else {
                    for(String str : next) {
                        tmp.add(dict + " " + str);
                    }
                }
            }
        }
        cache.put(pos, tmp);
        return tmp;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(Arrays.toString(new WordBreakII().wordBreak(s, wordDict).toArray()));

        s = "pineapplepenapple";
        wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(Arrays.toString(new WordBreakII().wordBreak(s, wordDict).toArray()));

        s = "catsandog";
        wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(Arrays.toString(new WordBreakII().wordBreak(s, wordDict).toArray()));
    }
}
