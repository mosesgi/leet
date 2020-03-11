package com.moses.leet.n0440;

import java.util.*;

public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);
        q.offer(null);
        int steps = 1;
        while(!q.isEmpty()){
            String curr = q.poll();
            if(curr == null){
                steps++;
                if(q.isEmpty()){
                    break;
                }
                q.offer(null);
                continue;
            }
            List<String> list = nextMutations(curr, bank, visited);
            for(String s : list){
                if(s.equals(end)){
                    return steps;
                }
                visited.add(s);
                q.offer(s);
            }
        }
        return -1;
    }

    private List<String> nextMutations(String start, String[] bank, Set<String> visited){
        List<String> list = new ArrayList<>();
        outer: for(String s : bank){
            if(visited.contains(s)){
                continue;
            }
            if(start.length() != s.length()){
                continue;
            }
            int cnt = 0;
            for(int i=0; i<start.length(); i++){
                if(start.charAt(i) != s.charAt(i)){
                    cnt++;
                }
                if(cnt > 1){
                    continue outer;
                }
            }
            list.add(s);
        }
        return list;
    }

    public static void main(String[] args) {
        String start, end;
        String[] bank;

        start = "AACCGGTT";
        end = "AACCGGTA";
        bank = new String[]{"AACCGGTA"};
        System.out.println(new MinimumGeneticMutation().minMutation(start, end, bank));

        start = "AACCGGTT";
        end = "AAACGGTA";
        bank = new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(new MinimumGeneticMutation().minMutation(start, end, bank));

        start = "AAAAACCC";
        end = "AACCCCCC";
        bank = new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println(new MinimumGeneticMutation().minMutation(start, end, bank));
    }
}
