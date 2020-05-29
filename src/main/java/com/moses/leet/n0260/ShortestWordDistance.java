package com.moses.leet.n0260;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 *
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 *
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 *
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            if(words[i].equals(word1)){
                l1.add(i);
            }else if(words[i].equals(word2)){
                l2.add(i);
            }
        }

        int min = words.length;
        for(int i:l1){
            for(int j:l2){
                min = Math.min(min, Math.abs(i-j));
            }
        }
        return min;
    }
}
