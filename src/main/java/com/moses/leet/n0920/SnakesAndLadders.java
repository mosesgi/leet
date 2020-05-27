package com.moses.leet.n0920;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return 0;
        }
        int size = board.length * board[0].length;
        int[] bd = new int[size+1];
        boolean leftToRight = true;
        int idx = 1;
        for(int i=board.length-1; i>=0; i--){
            if(leftToRight){
                for(int j=0; j<=board[0].length-1; j++){
                    bd[idx++] = board[i][j];
                }
            }else{
                for(int j=board[0].length-1; j>=0; j--){
                    bd[idx++] = board[i][j];
                }
            }

            leftToRight = !leftToRight;
        }

        boolean[] visited = new boolean[size];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        visited[1] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int j=1; j<=6; j++){
                int next = cur[0]+j;
                if(next == size){
                    return cur[1]+1;
                }
                if(next >size || visited[next]){
                    continue;
                }
                visited[next] = true;
                if(bd[next] == -1){
                    q.offer(new int[]{next, cur[1]+1});
                }else{
                    if(bd[next] == size){
                        return cur[1]+1;
                    }
                    q.offer(new int[]{bd[next], cur[1]+1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] m;
        m = new int[][]{
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}};
        System.out.println(new SnakesAndLadders().snakesAndLadders(m));

    }
}
