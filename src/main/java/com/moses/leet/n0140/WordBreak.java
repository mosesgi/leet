package com.moses.leet.n0140;

import java.util.*;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        Set<String> set = new HashSet<>(wordDict);
        for(int i=0; i<s.length(); i++){
            if(set.contains(s.substring(0, i+1))){
                dp[i] = true;
            }
        }

        for(int i=1; i<s.length(); i++){
            if(dp[i-1]){
                for(int j=i; j<s.length(); j++){
                    if(set.contains(s.substring(i, j+1))){
                        dp[j] = true;
                    }
                }
            }
        }
        return dp[s.length()-1];
    }

    public boolean wordBreakBfs(String s, List<String> wordDict) {
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


    public boolean wordBreakDfs(String s, List<String> wordDict) {
        Boolean[] mem = new Boolean[s.length()];
        Set<String> set = new HashSet<>();
        int maxLen = 0;
        for(String dict : wordDict){
            maxLen = Math.max(maxLen, dict.length());
            set.add(dict);
        }
        return dfs(s, 0, maxLen, set, mem);
    }

    boolean dfs(String s, int start, int maxLen, Set<String> set, Boolean[] mem){
        if(start == s.length()){
            return true;
        }
        if(mem[start] != null){
            return mem[start];
        }
        for(int i=start; i<start+maxLen && i<s.length(); i++){
            if(set.contains(s.substring(start, i+1))){
                if(dfs(s, i+1, maxLen, set,mem)){
                    mem[start] = true;
                    return true;
                }
            }
        }
        mem[start] = false;
        return false;
    }





    Map<String, Boolean> cache = new HashMap<>();
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
