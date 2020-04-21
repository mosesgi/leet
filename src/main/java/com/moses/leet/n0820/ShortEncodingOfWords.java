package com.moses.leet.n0820;

import java.util.Arrays;

public class ShortEncodingOfWords {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        int[] ary = new int[words.length];
        for(int i=0; i<ary.length; i++){
            ary[i] = i;
        }

        for(int i=0; i<words.length-1; i++){
            for(int j= i+1; j<words.length; j++){
                if(words[j].endsWith(words[i])){
                    ary[i] = j;
                    break;
                }
            }
        }

        int res = 0;
        for(int i=0; i<ary.length; i++){
            if(ary[i] == i){
                res += words[i].length()+1;
            }
        }
        return res;
    }
}
