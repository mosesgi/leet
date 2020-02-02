package com.moses.leet.n0140;

import java.util.*;

public class WordBreak {
    Map<String, Boolean> cache = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        //BFS. Beat 88.15%
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        Set<Integer> visited = new HashSet<>();
        int sLen = s.length();
        while(!q.isEmpty()){
            Integer pos = q.poll();
            if(visited.contains(pos)){
                continue;
            }
            if(pos == sLen){
                return true;
            }
            for(String dic : wordDict){
                int len = dic.length();
                if(pos+len <= sLen && s.substring(pos, pos+len).equals(dic)){
                    q.offer(pos+len);
                }
            }
            visited.add(pos);
        }
        return false;
//        return recursive(s, 0, wordDict);
    }




    //recursive, beat 10%
    private boolean recursive(String s, int pos, List<String> wordDict) {
        int sLen = s.length();
        if(pos == sLen){
            return true;
        }
        for(String dic : wordDict){
            int len = dic.length();
            String key = pos+"_"+dic;
            if( (cache.containsKey(key) && !cache.get(key)) || pos+len > sLen){
                continue;
            }
            if(cache.containsKey(key) && cache.get(key)){
                return cache.get(key);
            }
            if(s.substring(pos, pos+len).equals(dic)){
                boolean rst = recursive(s, pos+len, wordDict);
                cache.put(key, rst);
                if(rst){
                    return true;
                }
            } else {
                cache.put(key, false);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(new WordBreak().wordBreak(s, wordDict));

        s = "applepenapple";
        wordDict = Arrays.asList("apple", "pen");
        System.out.println(new WordBreak().wordBreak(s, wordDict));

        s = "catsandog";
        wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }
}
