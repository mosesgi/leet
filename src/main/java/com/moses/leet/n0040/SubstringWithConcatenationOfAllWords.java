package com.moses.leet.n0040;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();

        Map<String, Integer> wordsMap = new HashMap<>();
        int wLen = 0;
        for(String w : words){
            wLen = w.length();
            wordsMap.put(w, wordsMap.getOrDefault(w, 0) + 1);
        }
        int len = words.length * wLen;
        outer: for(int i=0; i<=s.length()-len; i++){
            String sub = s.substring(i, i+wLen);
            if(wordsMap.containsKey(sub)){
                Map<String, Integer> map = new HashMap<>();
                map.put(sub, 1);
                for(int j=i+wLen; j<i+len; j+=wLen){
                    sub = s.substring(j, j+wLen);
                    if(!wordsMap.containsKey(sub)){
                        continue outer;
                    }
                    map.put(sub, map.getOrDefault(sub, 0) + 1);
                    if(map.get(sub) > wordsMap.get(sub)){
                        continue outer;
                    }
                }
                result.add(i);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};
        List<Integer> rst = new SubstringWithConcatenationOfAllWords().findSubstring(s, words);
        System.out.println(Arrays.toString(rst.toArray()));

        words = new String[]{"word","good","best","word"};
        s = "wordgoodgoodgoodbestword";
        rst = new SubstringWithConcatenationOfAllWords().findSubstring(s, words);
        System.out.println(Arrays.toString(rst.toArray()));


        words = new String[]{"foo", "bar"};
        s = "foobarfoobar";
        rst = new SubstringWithConcatenationOfAllWords().findSubstring(s, words);
        System.out.println(Arrays.toString(rst.toArray()));

        words = new String[]{"a", "a"};
        s = "aaa";
        rst = new SubstringWithConcatenationOfAllWords().findSubstring(s, words);
        System.out.println(Arrays.toString(rst.toArray()));
    }

    // public void findAllApperance(List<Integer> result, int startingIndex, String key, String source){
    //     int i = source.indexOf(key);
    //     if(i == -1) return;
    //     result.add(i+startingIndex);
    //     if(source.length() - i - key.length() <0){
    //         return;
    //     } else {
    //         findAllApperance(result, startingIndex+i+1, key, source.substring(i+1));
    //     }
    // }

    // public Set<String> allCombinations(Set<String> allStrs, String currStr, String[] words){
    //     if(words==null||words.length ==1){
    //         allStrs.add(currStr + words[0]);
    //         return allStrs;
    //     }
    //     for(int i=0; i<words.length; i++){
    //         String tmpStr = currStr + words[i];
    //         String[] newWords = new String[words.length - 1];
    //         int k = 0;
    //         for(int j=0; j<words.length; j++){
    //             if(j==i){
    //                 continue;
    //             }
    //             newWords[k++] = words[j];
    //         }
    //         allCombinations(allStrs, tmpStr, newWords);
    //     }
    //     return allStrs;
    // }


    
}