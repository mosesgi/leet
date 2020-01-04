package com.moses.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubStringWithAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        // Set<String> allStrs = new HashSet<>();
        // allCombinations(allStrs, "", words);
        
        // for(String str: allStrs){
        //     findAllApperance(result, 0, str, s);
        // }
        
        
        
        return result;
    }


    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};
        List<Integer> rst = new SubStringWithAllWords().findSubstring(s, words);
        System.out.println(Arrays.toString(rst.toArray()));

        words = new String[]{"word","good","best","word"};
        s = "wordgoodgoodgoodbestword";
        rst = new SubStringWithAllWords().findSubstring(s, words);
        System.out.println(Arrays.toString(rst.toArray()));


        words = new String[]{"foo", "bar"};
        s = "foobarfoobar";
        rst = new SubStringWithAllWords().findSubstring(s, words);
        System.out.println(Arrays.toString(rst.toArray()));

        words = new String[]{"a", "a"};
        s = "aaa";
        rst = new SubStringWithAllWords().findSubstring(s, words);
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