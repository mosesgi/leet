package com.moses.leet.n1300;

import java.util.*;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, Set<Integer>> groups = new HashMap<>();
        for(int i=0; i<groupSizes.length; i++){
            groups.computeIfAbsent(groupSizes[i], z -> new HashSet<>()).add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int key : groups.keySet()){
            if(groups.get(key).size() <= key){
                res.add(new ArrayList<>(groups.get(key)));
                continue;
            }
            Iterator<Integer> iter = groups.get(key).iterator();
            int cnt = 0;
            List<Integer> l = new ArrayList<>();
            while(iter.hasNext()){
                l.add(iter.next());
                cnt++;
                if(cnt == key){
                    res.add(new ArrayList<>(l));
                    l.clear();
                    cnt=0;
                }
            }
            if(!l.isEmpty()){
                res.add(new ArrayList<>(l));
            }
        }
        return res;
    }
}
