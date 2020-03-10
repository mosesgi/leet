package com.moses.leet.n0440;

import java.util.*;

public class ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        int[] cnt = new int[10];
        for(char c : s.toCharArray()){
            if(c=='z') cnt[0]++;
            if(c=='o') cnt[1]++;    // -0-2-4
            if(c=='w') cnt[2]++;
            if(c=='h') cnt[3]++;    // -8
            if(c=='u') cnt[4]++;
            if(c=='f') cnt[5]++;    // -4
            if(c=='x') cnt[6]++;
            if(c=='s') cnt[7]++;    // -6
            if(c=='g') cnt[8]++;
            if(c=='i') cnt[9]++;    // -5-6-8

        }

        cnt[3]-=cnt[8];
        cnt[5]-=cnt[4];
        cnt[7]-=cnt[6];
        cnt[1] = cnt[1] - cnt[0] - cnt[2] - cnt[4];
        cnt[9] = cnt[9] - cnt[5] - cnt[6] - cnt[8];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<cnt.length; i++){
            for(int j=0; j<cnt[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }


    //cannot resolve using ordinary recursive.... It must be O(n).
    public String originalDigitsTLE(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        TrieNode root = new TrieNode();

        for(String key : map.keySet()){
            TrieNode curr = root;
            for(int i=0; i<key.length(); i++){
                int ind = key.charAt(i)-'a';
                if(curr.children[ind] == null){
                    curr.children[ind] = new TrieNode();
                }
                if(i == key.length()-1){
                    curr.children[ind].val = map.get(key);
                }
                curr = curr.children[ind];
            }
        }

        List<Integer> list = new ArrayList<>();
        recursive(new StringBuilder(s), list, root, root);
        Collections.sort(list);
        StringBuilder result = new StringBuilder();
        for(int i : list){
            result.append(i);
        }
        return result.toString();
    }

    private boolean recursive(StringBuilder s, List<Integer> list, TrieNode root, TrieNode node) {
        if(node.val != null){
            list.add(node.val);
            node = root;
        }
        if(s.length() == 0){
            return true;
        }
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(node.children[c-'a'] != null){
                s.deleteCharAt(i);
                boolean rst = recursive(s, list, root, node.children[c-'a']);
                if(rst){
                    return rst;
                }
                s.insert(i, c);
            }
        }
        return false;
    }

    class TrieNode{
        Integer val;
        TrieNode[] children;
        TrieNode(){
            children = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        String s;
        s = "zerozero";
        System.out.println(new ReconstructOriginalDigitsFromEnglish().originalDigits(s));

        s = "zeor";
        System.out.println(new ReconstructOriginalDigitsFromEnglish().originalDigits(s));

        s = "owoztneoer";
        System.out.println(new ReconstructOriginalDigitsFromEnglish().originalDigits(s));

        s = "fviefuro";
        System.out.println(new ReconstructOriginalDigitsFromEnglish().originalDigits(s));
    }
}
