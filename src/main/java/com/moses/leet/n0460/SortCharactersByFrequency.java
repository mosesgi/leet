package com.moses.leet.n0460;

import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> p = new PriorityQueue<>();
        for(char c : map.keySet()){
            p.offer(new Pair(c, map.get(c)));
        }

        StringBuffer sb = new StringBuffer();
        while(!p.isEmpty()){
            Pair pair = p.poll();
            for(int i=0; i<pair.cnt; i++){
                sb.append(pair.c);
            }
        }
        return sb.toString();
    }

    class Pair implements Comparable<Pair>{
        char c;
        int cnt;

        Pair(char c, int cnt){
            this.cnt = cnt;
            this.c = c;
        }

        public int compareTo(Pair p){
            return p.cnt - this.cnt;
        }
    }
}
