package com.moses.leet.n0520;

import java.util.*;

public class FreedomTrail {
    public int findRotateSteps(String ring, String key) {
        int len = ring.length();
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i=0; i<len; i++){
            char c = ring.charAt(i);
            if(map.containsKey(c)){
                map.get(c).add(i);
            }else{
                List<Integer> set = new ArrayList<>();
                set.add(i);
                map.put(c, set);
            }
        }
        int[][] dp = new int[100][100];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(ring, key, 0, 0, map, dp);
    }

    private int dfs(String ring, String key, int keyPos, int ringPos, Map<Character, List<Integer>> map, int[][] dp){
        if(keyPos == key.length()){
            return 0;
        }
        char c = key.charAt(keyPos);
        if(c == ring.charAt(ringPos)){
            return 1+dfs(ring, key, keyPos+1, ringPos, map, dp);
        }

        if(dp[keyPos][ringPos] != -1){
            return dp[keyPos][ringPos];
        }
        List<Integer> poses = map.get(c);
        int totalSteps = Integer.MAX_VALUE;
        for(int j : poses){
            int curStep = Math.min(Math.abs(j+ring.length() - ringPos), Math.min(Math.abs(j-ringPos), Math.abs(ringPos+ring.length()-j)));
            int tmpSteps = curStep + dfs(ring, key, keyPos+1, j, map, dp)+1;
            totalSteps = Math.min(totalSteps, tmpSteps);
        }

        dp[keyPos][ringPos] = totalSteps;
        return totalSteps;
    }

    public static void main(String[] args) {
        String ring, key;
        ring = "caotmcaataijjxi";
        key = "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx";
        System.out.println(new FreedomTrail().findRotateSteps(ring, key));

        ring = "pqwcx";
        key = "cpqwx";
        System.out.println(new FreedomTrail().findRotateSteps(ring, key));

        ring = "godding";
        key = "gd";
        System.out.println(new FreedomTrail().findRotateSteps(ring, key));
    }
}
