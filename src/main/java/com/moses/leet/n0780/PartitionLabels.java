package com.moses.leet.n0780;

import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        Map<Character, int[]> map = new HashMap<>();
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, new int[]{i, i});
            }else{
                map.get(c)[1] = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        int begin = 0;
        while(begin < S.length()){
            int end = map.get(S.charAt(begin))[1];
            for(int i=begin; i<=end; i++){
                char c = S.charAt(i);
                if(map.get(c)[1] > end){
                    end = map.get(c)[1];
                }
            }
            list.add(end-begin+1);
            begin = end+1;
        }
        return list;
    }

    public static void main(String[] args) {
        String S;
        S = "caedbdedda";
        System.out.println(Arrays.toString((new PartitionLabels().partitionLabels(S)).toArray()));

        S = "ababcbacadefegdehijhklij";
        System.out.println(Arrays.toString((new PartitionLabels().partitionLabels(S)).toArray()));
    }
}
