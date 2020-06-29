package com.moses.leet.n0740;

import java.util.*;

/**
 *
 Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs,
 determine if two sentences are similar.

 For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the similar
 word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].

 Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good"
 are similar, then "great" and "fine" are similar.

 Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

 Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = []
 are similar, even though there are no specified similar word pairs.

 Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can
 never be similar to words2 = ["doubleplus","good"].

 Note:

 The length of words1 and words2 will not exceed 1000.
 The length of pairs will not exceed 2000.
 The length of each pairs[i] will be 2.
 The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 *
 */
public class SentenceSimilarityII {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length){
            return false;
        }
        if(pairs.isEmpty()){
            for(int i=0; i< words1.length; i++){
                if(!words1[i].equals(words2[i])){
                    return false;
                }
            }
            return true;
        }

        Map<String, Set<String>> map = new HashMap<>();
        for(List<String> p : pairs){
            map.computeIfAbsent(p.get(0), z -> new HashSet<>()).add(p.get(1));
            map.computeIfAbsent(p.get(1), z -> new HashSet<>()).add(p.get(0));
        }
        for(int i=0; i<words1.length; i++){
            if(!same(map, words1[i], words2[i], new HashSet<>())){
                return false;
            }
        }
        return true;
    }

    boolean same(Map<String, Set<String>> map, String a, String b, Set<String> visited){
        if(a.equals(b)){
            return true;
        }
        visited.add(a);
        if(!map.containsKey(a)){
            return false;
        }
        for(String s : map.get(a)){
            if(visited.contains(s)){
                continue;
            }
            if(same(map, s, b, visited)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words1, words2;
        List<List<String>> pairs = new ArrayList<>();
        words1 = new String[]{"great", "acting", "skills"};
        words2 = new String[]{"fine", "drama", "talent"};
        pairs.add(Arrays.asList("great","good"));
        pairs.add(Arrays.asList("fine","good"));
        pairs.add(Arrays.asList("drama","acting"));
        pairs.add(Arrays.asList("skills","talent"));

        System.out.println(new SentenceSimilarityII().areSentencesSimilarTwo(words1, words2, pairs));
    }

}
