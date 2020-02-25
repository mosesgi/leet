package com.moses.leet.n0320;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if(s.length() == 0){
            return s;
        }
        TreeMap<Character, TreeSet<Integer>> map = new TreeMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.get(c).add(i);
            }else {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(i);
                map.put(c, set);
            }
        }

        String rst = "";
        int startPos = 0;
        while(true) {
            Character currChar = null;
            for (Character c : map.keySet()) {
                int pos = s.indexOf(c, startPos);
                boolean possible = checkPossible(map, c, s, pos, startPos);
                if (possible) {
                    currChar = c;
                    rst += c;
                    startPos = pos+1;
                    break;
                }
            }
            map.remove(currChar);
            if(map.isEmpty()){
                break;
            }
        }
        return rst;
    }

    private boolean checkPossible(TreeMap<Character, TreeSet<Integer>> map, Character c, String s, int pos, int startPos) {
        for(int i=startPos; i<pos; i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                continue;
            }
            if(map.get(ch).ceiling(pos) == null){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s;
        s = "bcabc";
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters(s));

        s = "cbacdcbc";
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters(s));

    }
}
