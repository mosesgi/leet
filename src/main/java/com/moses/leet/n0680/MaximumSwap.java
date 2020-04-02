package com.moses.leet.n0680;

import java.util.*;

public class MaximumSwap {

    public int maximumSwap(int num) {
        // 10 numbers, store the last index occured for each number.
        int[] occur = new int[10];
        char[] ary = (num+"").toCharArray();
        for(int i=0; i<ary.length; i++){
            occur[ary[i]-'0'] = i;
        }

        for(int i=0; i<ary.length; i++){
            int cur = Integer.parseInt(ary[i]+"");
            for(int j=9; j>cur; j--){
                if(occur[j] > i){
                    char c = ary[i];
                    ary[i] = (char)(j+'0');
                    ary[occur[j]] =c;
                    return Integer.parseInt(new String(ary));
                }
            }
        }
        return num;
    }

    //O(NLogN)
    public int maximumSwapMine(int num) {
        TreeMap<Character, TreeSet<Integer>> map = new TreeMap<>();
        String nStr = num+"";
        for(int i=0; i<nStr.length(); i++){
            char c = nStr.charAt(i);
            if(map.containsKey(c)){
                map.get(c).add(i);
            }else{
                TreeSet<Integer> set = new TreeSet<>();
                set.add(i);
                map.put(c, set);
            }
        }
        char[] ary = nStr.toCharArray();
        for(int i=0; i<ary.length; i++){
            char c = ary[i];
            if(map.lastKey() > c){
                TreeSet<Integer> poses = map.get(map.lastKey());
                int idx = poses.last();
                ary[i] = ary[idx];
                ary[idx] = c;
                break;
            }else{
                map.get(c).remove(i);
                if(map.get(c).isEmpty()){
                    map.remove(c);
                }
            }
        }
        return Integer.parseInt(new String(ary));
    }
}
