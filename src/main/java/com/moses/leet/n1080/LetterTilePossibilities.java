package com.moses.leet.n1080;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LetterTilePossibilities {
    int cnt = 0;
    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        dfs(chars, used, "");
        return cnt;
    }

    void dfs(char[] chars, boolean[] used, String str){
        for(int i=0; i<chars.length; i++){
            if(used[i] || i>0 && chars[i] == chars[i-1] && !used[i-1]){
                continue;
            }
            cnt++;
            used[i] = true;
            dfs(chars, used, str + chars[i]);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        String tiles;
        tiles = "AAABBC";
        System.out.println(new LetterTilePossibilities().numTilePossibilities(tiles));
    }
}
