package com.moses.leet.n1260;

import java.util.*;

/**
 * Given a list of pairs of equivalent words synonyms and a sentence text, Return all possible synonymous sentences sorted lexicographically.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
 * text = "I am happy today but was sad yesterday"
 * Output:
 * ["I am cheerful today but was sad yesterday",
 * ​​​​​​​"I am cheerful today but was sorrow yesterday",
 * "I am happy today but was sad yesterday",
 * "I am happy today but was sorrow yesterday",
 * "I am joy today but was sad yesterday",
 * "I am joy today but was sorrow yesterday"]
 *
 *
 *
 * Constraints:
 *
 *     0 <= synonyms.length <= 10
 *     synonyms[i].length == 2
 *     synonyms[0] != synonyms[1]
 *     All words consist of at most 10 English letters only.
 *     text is a single space separated sentence of at most 10 words.
 *
 */
public class SynonymousSentences {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, String> uf = new HashMap<>();
        for(List<String> s : synonyms){
            union(s, uf);
        }
        Map<String, Set<String>> map = new HashMap<>();
        for(String k : uf.keySet()){
            String r = findRoot(k, uf);
            map.computeIfAbsent(r, z-> new TreeSet<>()).add(k);
        }
        String[] splits = text.split(" ");
        List<String> res = new ArrayList<>();
        dfs(splits, 0, uf, map, "", res);
        return res;
    }

    void dfs(String[] splits, int pos, Map<String, String> uf, Map<String, Set<String>> map, String str, List<String> res){
        if(pos == splits.length){
            res.add(str.trim());
            return;
        }
        String cur = splits[pos];
        String root = findRoot(cur, uf);
        if(map.containsKey(root)){
            for(String s : map.get(root)){
                dfs(splits, pos+1, uf, map, str+s+" ", res);
            }
        }else{
            dfs(splits, pos+1, uf, map, str+cur+" ", res);
        }
    }

    void union(List<String> s, Map<String, String> uf){
        String a = s.get(0);
        String b = s.get(1);
        uf.putIfAbsent(a, a);
        uf.putIfAbsent(b, b);
        String aRoot = findRoot(a, uf);
        String bRoot = findRoot(b, uf);
        if(!aRoot.equals(bRoot)){
            uf.put(b, a);
        }
    }

    String findRoot(String s, Map<String, String> uf){
        if(!uf.containsKey(s)){
            return s;
        }
        while(!s.equals(uf.get(s))){
            s = uf.get(s);
        }
        return s;
    }
}
