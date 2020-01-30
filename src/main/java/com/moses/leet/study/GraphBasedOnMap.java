package com.moses.leet.study;

import java.util.*;

public class GraphBasedOnMap {
    static Map<String, String[]> map = new HashMap<>();
    static{
        map.put("A", new String[] { "B", "C"});
        map.put("B", new String[] { "A", "C", "D" });
        map.put("C", new String[] { "A", "B", "D", "E" });
        map.put("D", new String[] { "B", "C", "E", "F" });
        map.put("E", new String[] { "C", "D" });
        map.put("F", new String[] { "D" });
    }

    public void BFS(String start){
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);
        while(!q.isEmpty()){
            String str = q.poll();
            System.out.print(str + " ");
            String[] siblings = map.get(str);
            for(String s : siblings){
                if(!visited.contains(s)) {
                    q.offer(s);
                    visited.add(s);
                }
            }
        }
        System.out.println();
    }

    public void DFS(String start){
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        stack.push(start);
        visited.add(start);
        while(!stack.isEmpty()){
            String curr = stack.pop();
            String[] strs = map.get(curr);
            for(String s : strs){
                if(!visited.contains(s)) {
                    stack.push(s);
                    visited.add(s);
                }
            }
            System.out.print(curr + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new GraphBasedOnMap().BFS("A");
        new GraphBasedOnMap().BFS("E");

        new GraphBasedOnMap().DFS("A");
    }
}
