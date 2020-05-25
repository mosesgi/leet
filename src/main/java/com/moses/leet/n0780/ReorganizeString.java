package com.moses.leet.n0780;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    //aaaaabbbc -
    //abaaaabbc - ababaaabc - abababaac - abababaca
    //aaaaabbbbccc - ababcabcabca
    //aaabccc
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> p = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        p.addAll(map.entrySet());
        Map.Entry<Character, Integer> entry = p.poll();
        if(entry.getValue()==1){
            return S;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < entry.getValue(); i++) {
            sb.append(entry.getKey());
        }

        int left = 1;

        boolean fulfilled = false;
        Character remainChar = null;
        int remainCnt = 0;
        while (left < sb.length() && !p.isEmpty()) {
            Map.Entry<Character, Integer> et = p.poll();
            int total = et.getValue();
            while (left < sb.length() && total >0 && sb.charAt(left - 1) == sb.charAt(left)) {
                sb.insert(left, et.getKey());
                total--;
                left+=2;
            }
            if(left == sb.length()){
                fulfilled = true;
                if(total > 0){
                    sb.append(et.getKey());
                    total--;
                    left = 1;
                }
                if(total > 0){
                    remainCnt = total;
                    remainChar = et.getKey();
                }
                break;
            }
        }
        if(!fulfilled){
            return "";
        }
        if(remainCnt > 0){
            left = 1;
            while(left<sb.length() && remainCnt > 0){
                sb.insert(left, remainChar);
                remainCnt--;
                left+=2;
            }
        }
        while(!p.isEmpty()){
            Map.Entry<Character, Integer> et = p.poll();
            int total = et.getValue();
            left = 1;
            while (left < sb.length() && total >0) {
                sb.insert(left, et.getKey());
                total--;
                left+=2;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String S;
        S = "zqugrfbsznyiwbokwkpvpmeyvaosdkedbgjogzdpwawwl";
        System.out.println(new ReorganizeString().reorganizeString(S));

        S = "eqmeyggvp";
        System.out.println(new ReorganizeString().reorganizeString(S));

        S = "zhmyo";
        System.out.println(new ReorganizeString().reorganizeString(S));

        S = "aaab";
        System.out.println(new ReorganizeString().reorganizeString(S));

        S = "aaaaabbbc";
        System.out.println(new ReorganizeString().reorganizeString(S));

        S = "aaaaabbbbccc";
        System.out.println(new ReorganizeString().reorganizeString(S));

        S = "aab";
        System.out.println(new ReorganizeString().reorganizeString(S));

    }
}
