package com.moses.leet.n0400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LexicographicalNumbers {
    // 4637
    // 1,10,100,1000,1001,1002...1009,101,...109,11,110,1100,1101,1102..1109,111,..119,12,120,1200
    // 2,20,200,2000...
    // 3,30,300,...
    // 4,40,400,4000,.......4600,...4637,464,465,466,..47,471,472,..,48,481,...49,491...499
    // 5,50,500,501,...51,511...599
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=9; i++){
            dfs(i, n, list);
        }
        return list;
    }

    void dfs(int prevInt, int n, List<Integer> list){
        if(prevInt > n){
            return;
        }
        list.add(prevInt);
        int leading = prevInt * 10;
        if(leading > n || leading/10 != prevInt){
            return;
        }
        for(int i=0; i<10; i++){
            dfs(leading + i, n, list);
        }
    }


    public List<Integer> lexicalOrder1(int n) {
        List<Integer> list = new ArrayList<>(n);
        recursive(1, n, list);
        return list;
    }

    private void recursive(int i, int n, List<Integer> list) {
        int end = i==1?8:9;
        for(int j=0; j<=end; j++){
            int tmp = i+j;
            if(tmp <= n){
                list.add(tmp);
                if(tmp*10 <=n ){
                    recursive(tmp*10, n, list);
                }
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LexicographicalNumbers().lexicalOrder(5000000).toArray()));
        System.out.println(Arrays.toString(new LexicographicalNumbers().lexicalOrder(4666).toArray()));
        System.out.println(Arrays.toString(new LexicographicalNumbers().lexicalOrder(356).toArray()));
        System.out.println(Arrays.toString(new LexicographicalNumbers().lexicalOrder(13).toArray()));
    }
}
