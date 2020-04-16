package com.moses.leet.n0780;

import java.util.*;

public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<2; i++){
            for(int j=0; j<3; j++){
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        if(start.equals(target)){
            return 0;
        }
        int[][] directions = new int[][]{{-1, 0}, {1,0}, {0,-1}, {0,1}};
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int moves = 0;
        while(!q.isEmpty()){
            int size = q.size();
            moves++;
            for(int i=0; i<size; i++) {
                String cur = q.poll();
                List<String> poss = convert(cur, directions);
                for(String s : poss){
                    if(target.equals(s)){
                        return moves;
                    }
                    if(visited.contains(s)){
                        continue;
                    }
                    visited.add(s);
                    q.offer(s);
                }
            }
        }
        return -1;
    }

    List<String> convert(String s, int[][] directions){
        List<String> list = new ArrayList<>();
        char[][] ary = new char[2][3];
        int x=-1, y = -1;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            ary[i/3][i%3] = c;
            if(c == '0'){
                x = i/3;
                y = i%3;
            }
        }
        for(int[] dir:directions){
            int m = x+dir[0];
            int n = y+dir[1];
            if(m>=0 && m<2 && n>=0 && n<3){
                ary[x][y] = ary[m][n];
                ary[m][n] = '0';
                String str = "";
                for(int i=0; i<2; i++){
                    for(int j=0; j<3; j++){
                        str += ary[i][j];
                    }
                }
                ary[m][n] = ary[x][y];
                ary[x][y] = '0';
                list.add(str);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] board;
        board = new int[][]{{1,2,3},{4,0,5}};
        System.out.println(new SlidingPuzzle().slidingPuzzle(board));

        board = new int[][]{{1,2,3},{5,4,0}};
        System.out.println(new SlidingPuzzle().slidingPuzzle(board));

        board = new int[][]{{4,1,2},{5,0,3}};
        System.out.println(new SlidingPuzzle().slidingPuzzle(board));

        board = new int[][]{{3,2,4},{1,5,0}};
        System.out.println(new SlidingPuzzle().slidingPuzzle(board));
    }
}
