package com.moses.leet.n0500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZumaGame {
    public int findMinStep(String board, String hand) {
        Map<Character, Integer> handMap = new HashMap<>();
        for(char c: hand.toCharArray()){
            handMap.put(c, handMap.getOrDefault(c, 0) + 1);
        }
        return dfs(new StringBuilder(board), handMap);
    }

    int dfs(StringBuilder board, Map<Character, Integer> hand){
        if(board.length() == 0){
            return 0;
        }else if(hand.isEmpty()){
            return -1;
        }
        List<Integer> poss = new ArrayList<>();
        for(int i=0; i<board.length(); i++){
            char curr = board.charAt(i);
            int left = i;
            while(i+1 < board.length() && board.charAt(i+1) == curr){
                i++;
            }
            if(i-left == 0){
                //1 ball
                if(hand.containsKey(curr) && hand.get(curr) >=2){
                    int handOrigin = hand.get(curr);
                    if(handOrigin == 2){
                        hand.remove(curr);
                    }else{
                        hand.put(curr, handOrigin-2);
                    }
                    StringBuilder tmp = new StringBuilder(board);
                    tmp.deleteCharAt(i);
                    shrink(tmp);
                    int next = dfs(tmp, hand);
                    if(next != -1) {
                        poss.add(2 + next);
                    }
                    hand.put(curr, handOrigin);
                }
            }else if(i-left == 1){
                //2 balls
                if(hand.containsKey(curr)){
                    int handOrigin = hand.get(curr);
                    if(handOrigin == 1){
                        hand.remove(curr);
                    }else{
                        hand.put(curr, handOrigin-1);
                    }
                    StringBuilder tmp = new StringBuilder(board);
                    tmp.delete(left, i+1);
                    shrink(tmp);
                    int next = dfs(tmp, hand);
                    if(next != -1){
                        poss.add(1+next);
                    }
                    hand.put(curr, handOrigin);
                }
            }
        }
        if(poss.isEmpty()){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for(int i : poss){
            min = Math.min(i, min);
        }
        return min;
    }

    void shrink(StringBuilder tmp){
        while(true){
            if(tmp.length() < 3){
                return;
            }
            int left = 0; int right = 0;
            for(int i=0; i<tmp.length(); i++){
                char c = tmp.charAt(i);
                left = i;
                while(i+1 < tmp.length() && tmp.charAt(i+1) == c){
                    i++;
                }
                right = i;
                if(right != left){
                    break;
                }
            }
            if(right-left >=2){
                tmp.delete(left, right+1);
            }else{
                return;
            }
        }
    }


    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder("RBBBRRR");
//        new ZumaGame().shrink(sb);
//        System.out.println(sb);
        String board, hand;
        board = "WRRBBW"; hand = "RB";
        System.out.println(new ZumaGame().findMinStep(board, hand));

        board = "WWRRBBWW"; hand = "WRBRW";
        System.out.println(new ZumaGame().findMinStep(board, hand));

        board = "G"; hand = "GGGGG";
        System.out.println(new ZumaGame().findMinStep(board, hand));

        board = "RBYYBBRRB"; hand = "YRBGB";
        System.out.println(new ZumaGame().findMinStep(board, hand));
    }

}
