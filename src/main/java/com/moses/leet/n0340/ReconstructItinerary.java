package com.moses.leet.n0340;

import java.util.*;

public class ReconstructItinerary {
    List<String> res = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for(List<String> l : tickets){
            map.putIfAbsent(l.get(0), new ArrayList<>());
            map.get(l.get(0)).add(l.get(1));
        }
        Map<String, boolean[]> visited = new HashMap<>();
        for(String k : map.keySet()){
            Collections.sort(map.get(k));
            visited.put(k, new boolean[map.get(k).size()]);
        }

        int n = tickets.size()+1;
        dfs(map, visited, "JFK", n);
        return res;
    }

    boolean dfs(Map<String, List<String>> map, Map<String, boolean[]> visited, String cur, int n){
        res.add(cur);
        if(res.size() == n){
            return true;
        }
        List<String> pos = map.get(cur);
        if(pos == null){
            res.remove(res.size()-1);
            return false;
        }

        for(int i=0; i<pos.size(); i++){
            boolean[] v = visited.get(cur);
            if(!v[i]){
                v[i] = true;
                if(dfs(map, visited, pos.get(i), n)){
                    return true;
                }
                v[i] = false;
            }
        }
        res.remove(res.size()-1);
        return false;
    }



    boolean flag = false;
    List<String> result = new ArrayList<>();
    public List<String> findItineraryOld(List<List<String>> tickets) {
        int count = tickets.size() + 1;
        Map<String, List<String>> map = new HashMap<>();
        for(List<String> l : tickets){
            if(map.containsKey(l.get(0))){
                map.get(l.get(0)).add(l.get(1));
            } else {
                List<String> p = new ArrayList<>();
                p.add(l.get(1));
                map.put(l.get(0), p);
            }
        }
        Set<String> keys = map.keySet();
        for(String key: keys){
            Collections.sort(map.get(key));
        }

        List<String> list = new ArrayList<>();
        list.add("JFK");
        recursive(list, map, 1, count);
        return result;
    }

    private void recursive(List<String> list, Map<String, List<String>> map, int cnt, int totalCnt) {
        if(cnt == totalCnt){
            flag = true;
            result.addAll(list);
            return;
        }
        String last = list.get(list.size()-1);
        if(!map.containsKey(last)){
            return;
        }
        List<String> allCities = map.get(last);
        for(String city : allCities){
            if(flag){
                break;
            }
            list.add(city);
            List<String> tmp = new ArrayList<>(allCities);
            tmp.remove(city);
            map.put(last, tmp);
            recursive(list, map, cnt+1, totalCnt);
            map.put(last, allCities);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<String>> tickets;

//        tickets = new ArrayList<>();
//        tickets.add(Arrays.asList("JFK","KUL"));
//        tickets.add(Arrays.asList("JFK","NRT"));
//        tickets.add(Arrays.asList("NRT","JFK"));
//        System.out.println(Arrays.toString(new ReconstructItinerary().findItinerary(tickets).toArray()));

        tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));
        System.out.println(Arrays.toString(new ReconstructItinerary().findItinerary(tickets).toArray()));

        tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));
        System.out.println(Arrays.toString(new ReconstructItinerary().findItinerary(tickets).toArray()));
    }
}
