package com.moses.leet.n0280;

import java.util.*;

public class PerfectSquares {

    //DP solution. https://leetcode.com/problems/perfect-squares/discuss/71495/An-easy-understanding-DP-solution-in-Java
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i/j; j++){
                dp[i] = Math.min(dp[i], 1 + dp[i-j*j]);
            }
        }
        return dp[n];
    }

    //BFS solution
    public int numSquaresBfs(int n){
        List<Integer> squares = new ArrayList<>();
        int k=1;
        int tmp = k*k;
        while(tmp <=n){
            squares.add(tmp);
            k++;
            tmp = k*k;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        q.offer(null);
        int j=0;
        while(!q.isEmpty()){
            Integer curr = q.poll();
            if(curr == null){
                j++;
                q.offer(null);
                continue;
            }
            for(int i : squares){
                if(i>curr){
                    continue;
                }
                if(i==curr){
                    return j+1;
                }
                q.offer(curr-i);
            }
        }
        return 0;
    }


    //myself recursive version
    int level = Integer.MAX_VALUE;
    public int numSquaresRecursive(int n){
        List<Integer> squares = new ArrayList<>();
        int k=1;
        int tmp = k*k;
        while(tmp <=n ){
            squares.add(tmp);
            k++;
            tmp = k*k;
        }

        int rest = n;
        recursive(rest, squares, 0);
        return level;
    }

    private void recursive(int rest, List<Integer> squares, int lev) {
        if(lev >= level){
            return;
        }
        if(rest == 0){
            if(lev < level ){
                level = lev;
            }
            return;
        }
        if(rest < 0){
            return;
        }
        for(int i=squares.size()-1; i>=0; i--){
            Integer curr = squares.get(i);
            if(rest < curr){
                continue;
            }
            recursive(rest-curr, squares, lev + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
        System.out.println(new PerfectSquares().numSquares(13));
        System.out.println(new PerfectSquares().numSquares(131323));
    }
}
