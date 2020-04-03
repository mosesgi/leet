package com.moses.leet.n0680;

import java.util.*;

public class MagicDictionary {
    Map<Integer, TrieNode> map;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        map.clear();
        for(String s : dict){
            int len = s.length();

            TrieNode root;
            if(!map.containsKey(len)){
                root = new TrieNode();
                map.put(len, root);
            }else{
                root = map.get(len);
            }

            root.constructOrigin(s);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        int len = word.length();
        if(!map.containsKey(len)){
            return false;
        }
        TrieNode root = map.get(len);
        return root.searchOrigin(word);
    }

    class TrieNode{
        TrieNode[] children;
        boolean isWord;
//        Set<String> originWords;
        Map<Integer, Set<String>> originWords;

        public TrieNode(){
            children = new TrieNode[26];
        }

        public void constructOrigin(String word){
            TrieNode root = this;
            StringBuilder sb = new StringBuilder(word);
            for(int i=0; i<sb.length(); i++){
                char c = sb.charAt(i);
                sb.deleteCharAt(i);
                root.construct(sb.toString(), word, i);
                sb.insert(i, c);
            }
        }

        public void construct(String word, String origin, int delPos){
            TrieNode curr = this;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(curr.children[c-'a'] == null){
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isWord = true;
            if(curr.originWords == null){
                curr.originWords = new HashMap<>();
            }
            Set<String> set = curr.originWords.getOrDefault(delPos, new HashSet<>());
            set.add(origin);
            curr.originWords.put(delPos, set);
        }

        public boolean searchOrigin(String word) {
            TrieNode root = this;
            StringBuilder sb = new StringBuilder(word);
            for(int i=0; i<sb.length(); i++){
                char c = sb.charAt(i);
                sb.deleteCharAt(i);
                if(root.search(sb.toString(), word, i)){
                    return true;
                }
                sb.insert(i, c);
            }
            return false;
        }

        public boolean search(String word, String origin, int delPos){
            TrieNode n = this;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(n.children[c-'a']== null){
                    return false;
                }
                n = n.children[c-'a'];
            }
            if(!n.isWord){
                return false;
            }
            if(n.originWords.size() == 0){
                return false;
            }
            if(!n.originWords.containsKey(delPos)){
                return false;
            }
            Set<String> originSet = n.originWords.get(delPos);
            if(originSet.size() == 1 && originSet.contains(origin)){
                return false;
            }else{
                return true;
            }
        }
    }

    public static void main(String[] args) {
        MagicDictionary md = new MagicDictionary();
        md.buildDict(new String[]{"hello","leetcode"});
        System.out.println(md.search("hhllo"));

    }
}
