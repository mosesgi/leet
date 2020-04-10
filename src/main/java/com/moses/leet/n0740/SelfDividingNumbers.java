package com.moses.leet.n0740;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        outer:for(int i=left; i<=right; i++){
            String tmp = i+"";
            for(char c : tmp.toCharArray()){
                int j = c-'0';
                if(j==0 || i%j!=0){
                    continue outer;
                }
            }
            list.add(i);
        }
        return list;
    }
}
