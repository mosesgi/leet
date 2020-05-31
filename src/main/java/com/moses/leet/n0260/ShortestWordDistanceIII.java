package com.moses.leet.n0260;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * <p>
 * word1 and word2 may be the same and they represent two individual words in the list.
 * <p>
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Input: word1 = “makes”, word2 = “coding”
 * Output: 1
 * Input: word1 = "makes", word2 = "makes"
 * Output: 3
 * Note:
 * You may assume word1 and word2 are both in the list.
 */
public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int idx1 = -1, idx2 = -1, res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                idx1 = i;
                if (idx2 >= 0) res = Math.min(res, Math.abs(idx2 - idx1));
            }
            if (words[i].equals(word2)) {
                idx2 = i;
                if (idx1 >= 0 && idx1 != idx2) {
                    res = Math.min(res, Math.abs(idx2 - idx1));
                }
            }
        }

        return res;
    }

    public int shortestWordDistanceONLogN(String[] words, String word1, String word2) {
        Map<String, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.computeIfAbsent(words[i], z -> new TreeSet<>()).add(i);
        }
        if (word1.equals(word2)) {
            TreeSet<Integer> poses = map.get(word1);
            Integer prev = null;
            int min = words.length;
            for (int j : poses) {
                if (prev == null) {
                    prev = j;
                } else {
                    min = Math.min(min, j - prev);
                    prev = j;
                }
            }
            return min;
        }

        int min = words.length;
        for (int i : map.get(word1)) {
            TreeSet<Integer> poses = map.get(word2);
            Integer lower = poses.lower(i);
            Integer higher = poses.higher(i);
            if (lower != null) {
                min = Math.min(min, i - lower);
            }
            if (higher != null) {
                min = Math.min(min, higher - i);
            }
        }
        return min;
    }
}
