package com.moses.leet.n0660;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        for(String s : dict){
            root.construct(s);
        }

        String[] strs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs.length; i++){
            sb.append(root.search(strs[i])).append(" ");
        }

        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    class TrieNode{
        boolean isWord;
        String word;
        TrieNode[] children;

        public TrieNode(){
            children = new TrieNode[26];
        }

        public void construct(String word){
            TrieNode n = this;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(n.children[c-'a'] == null){
                    n.children[c-'a'] = new TrieNode();
                }
                n = n.children[c-'a'];
            }
            n.isWord = true;
            n.word = word;
        }

        public String search(String word){
            TrieNode n = this;
            for(char c : word.toCharArray()){
                if(n.children[c-'a'] == null){
                    return word;
                }
                n = n.children[c-'a'];
                if(n.isWord){
                    return n.word;
                }
            }
            return word;
        }
    }
}
