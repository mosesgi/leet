package com.moses.leet.n0280;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PerfectSquares {

    //DP solution. https://leetcode.com/problems/perfect-squares/discuss/71495/An-easy-understanding-DP-solution-in-Java


    //BFS solution
    public int numSquares(int n){
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
