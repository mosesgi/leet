package com.moses.leet.n0700;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> p = new PriorityQueue<>((o1, o2) -> {return !o1.getValue().equals(o2.getValue()) ?o1.getValue()-o2.getValue():o2.getKey().compareTo(o1.getKey());});
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            p.offer(entry);
            if(p.size() > k){
                p.poll();
            }
        }

        List<String> list = new ArrayList<>();
        for(int i=0; i<k; i++){
            list.add(p.poll().getKey());
        }
        Collections.reverse(list);
        return list;
    }


    public List<String> topKFrequentOld(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> p = new PriorityQueue<>((o1, o2) -> {return !o1.getValue().equals(o2.getValue()) ?o2.getValue()-o1.getValue():o1.getKey().compareTo(o2.getKey());});
        p.addAll(map.entrySet());
        List<String> list = new ArrayList<>();
        for(int i=0; i<k; i++){
            list.add(p.poll().getKey());
        }
        return list;
    }
}
