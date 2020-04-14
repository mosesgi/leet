package com.moses.leet.n0760;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PrefixAndSuffixSearch {
    class WordFilter {
        Map<String, Integer> map;
        TrieNode pRoot;
        TrieNode sRoot;
        public WordFilter(String[] words) {
            pRoot = new TrieNode();
            sRoot = new TrieNode();
            map = new HashMap<>();
            for(int i=0; i<words.length; i++){
                String s = words[i];
                pRoot.construct(s);
                sRoot.constructSuffix(s);
                map.put(s, i);
            }
        }

        public int f(String prefix, String suffix) {
            Set<String> pSet = pRoot.search(prefix);
            Set<String> sSet = sRoot.search(new StringBuilder(suffix).reverse().toString());
            if(pSet == null || sSet == null){
                return -1;
            }
            int max = -1;
            for(String s : pSet){
                if(sSet.contains(s) && map.get(s) > max){
                    max = map.get(s);
                }
            }
            return max;
        }

        class TrieNode{
            TrieNode[] children;
            Set<String> strs;

            public TrieNode(){
                children = new TrieNode[26];
                strs = new HashSet<>();
            }

            public Set<String> search(String s){
                TrieNode cur = this;
                for(char c : s.toCharArray()){
                    cur = cur.children[c-'a'];
                    if(cur == null){
                        return null;
                    }
                }
                return cur.strs;
            }

            public void construct(String s){
                TrieNode cur = this;
                cur.strs.add(s);
                for(char c : s.toCharArray()){
                    if(cur.children[c-'a'] == null){
                        cur.children[c-'a'] = new TrieNode();
                    }
                    cur.children[c-'a'].strs.add(s);
                    cur = cur.children[c-'a'];
                }
            }

            public void constructSuffix(String s){
                String rev = new StringBuilder(s).reverse().toString();
                TrieNode cur = this;
                cur.strs.add(s);
                for(char c : rev.toCharArray()){
                    if(cur.children[c-'a'] == null){
                        cur.children[c-'a'] = new TrieNode();
                    }
                    cur.children[c-'a'].strs.add(s);
                    cur = cur.children[c-'a'];
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] strs;
        strs = new String[]{"apple"};
        WordFilter f = new PrefixAndSuffixSearch().new WordFilter(strs);
        System.out.println(f.f("a", "e"));
        System.out.println(f.f("b", ""));
    }
}
