package com.moses.leet.n0800;

import java.util.*;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        LinkedList<String> q = new LinkedList<>();
        q.offer(S);
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if(Character.isDigit(c)){
                continue;
            }
            int size = q.size();
            for(int j=0; j<size; j++) {
                String cur = q.poll();
                char[] chars = cur.toCharArray();
                chars[i] = Character.toUpperCase(c);
                q.offer(new String(chars));

                chars[i] = Character.toLowerCase(c);
                q.offer(new String(chars));
            }
        }
        return q;
    }

    //Slow, typical BFS
    public List<String> letterCasePermutationSlow(String S) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(S);
        visited.add(S);
        while(!q.isEmpty()){
            String cur = q.poll();
            StringBuilder sb = new StringBuilder(cur);
            for(int i=0; i<sb.length(); i++){
                char c = sb.charAt(i);
                if(Character.isLetter(c)){
                    sb.setCharAt(i, Character.isLowerCase(c)?Character.toUpperCase(c):Character.toLowerCase(c));
                }
                String n = sb.toString();
                if(visited.contains(n)){
                    continue;
                }
                visited.add(n);
                q.offer(n);
                sb.setCharAt(i, c);
            }
        }
        return new ArrayList<>(visited);
    }
}
