package com.moses.leet.n0480;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new ArrayList<>();
        if(words.length == 0){
            return list;
        }
        TrieNode root = new TrieNode();
        for(String s : words){
            TrieNode curr = root;
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(curr.children[c - 'a'] == null){
                    curr.children[c - 'a'] = new TrieNode();
                }
                if(i == s.length()-1) {
                    curr.children[c - 'a'].word = s;
                    curr.children[c-'a'].isWord = true;
                }
                curr = curr.children[c-'a'];
            }
        }

        for(String s : words) {
            boolean correct = dfs(s, root, 0, 0);
            if(correct){
                list.add(s);
            }
        }
        return list;
    }

    private boolean dfs(String s, TrieNode root, int idx, int cnt) {
        if(idx == s.length()){
            if(cnt>1){
                return true;
            }else{
                return false;
            }
        }
        int len = s.length();
        TrieNode curr = root;
        for(int i=idx; i<len; i++){
            char c = s.charAt(i);
            if(curr == null || curr.children[c-'a'] == null){
                return false;
            }
            if(curr.children[c-'a'].isWord){
                if(dfs(s, root, i+1, cnt+1)){
                    return true;
                }
            }
            curr = curr.children[c-'a'];
        }
        return false;
    }


    class TrieNode{
        boolean isWord;
        TrieNode[] children;
        String word;

        TrieNode(){
            children = new TrieNode[26];
        }

        TrieNode(String word){
            this.word = word;
            this.isWord = true;
            children = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        String[] words;
        words = new String[]{"a","b","ab","abc"};
        System.out.println(Arrays.toString(new ConcatenatedWords().findAllConcatenatedWordsInADict(words).toArray()));

        words = new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(Arrays.toString(new ConcatenatedWords().findAllConcatenatedWordsInADict(words).toArray()));
    }
}
