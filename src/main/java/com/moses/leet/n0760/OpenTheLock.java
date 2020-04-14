package com.moses.leet.n0760;

import java.util.*;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for(String s : deadends){
            deads.add(s);
            if("0000".equals(s)){
                return -1;
            }
        }
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String cur = q.poll();
                if(target.equals(cur)){
                    return steps;
                }
                StringBuilder sb = new StringBuilder(cur);
                for(int j=0; j<cur.length(); j++){
                    char origin = sb.charAt(j);
                    String nStr;
                    if(sb.charAt(j)=='0'){
                        sb.setCharAt(j, '9');
                        nStr = sb.toString();
                    }else{
                        sb.setCharAt(j, (char)(sb.charAt(j)-1));
                        nStr = sb.toString();
                    }
                    if(!deads.contains(nStr) && !visited.contains(nStr)) {
                        visited.add(nStr);
                        q.offer(nStr);
                    }

                    sb.setCharAt(j, origin);
                    if(sb.charAt(j) == '9'){
                        sb.setCharAt(j, '0');
                        nStr = sb.toString();
                    }else{
                        sb.setCharAt(j, (char)(sb.charAt(j)+1));
                        nStr = sb.toString();
                    }
                    sb.setCharAt(j, origin);
                    if(!deads.contains(nStr) && !visited.contains(nStr)) {
                        visited.add(nStr);
                        q.offer(nStr);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadEnds;
        String target;
        deadEnds = new String[]{"0201","0101","0102","1212","2002"};
        target = "0202";
        System.out.println(new OpenTheLock().openLock(deadEnds, target));

        deadEnds = new String[]{"8888"};
        target = "0009";
        System.out.println(new OpenTheLock().openLock(deadEnds, target));

        deadEnds = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        target = "8888";
        System.out.println(new OpenTheLock().openLock(deadEnds, target));

        deadEnds = new String[]{"0000"};
        target = "8888";
        System.out.println(new OpenTheLock().openLock(deadEnds, target));
    }
}
