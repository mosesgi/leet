package com.moses.leet.n0680;

import com.moses.leet.n0320.BulbSwitcher;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BulbSwitcherII {
    public int flipLights(int n, int m) {
//        if(n>6){
//            n = 6 + n%6;
//        }
        n = Math.min(n, 6);
        int status=0;
        for(int i=0; i<n; i++){
            status |= (1<<i);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(status);
        for(int i=0; i<m; i++){
            int size = q.size();
            visited.clear();
            for(int j=0; j<size; j++) {
                int curr = q.poll();

                int p1 = flipAll(curr, n);
                if (!visited.contains(p1)) {
                    visited.add(p1);
                    q.offer(p1);
                }
                int p2 = flipEven(curr, n);
                if (!visited.contains(p2)) {
                    visited.add(p2);
                    q.offer(p2);
                }

                int p3 = flipOdd(curr, n);
                if (!visited.contains(p3)) {
                    visited.add(p3);
                    q.offer(p3);
                }

                int p4 = flip3k(curr, n);
                if (!visited.contains(p4)) {
                    visited.add(p4);
                    q.offer(p4);
                }
            }
        }
        return q.size();
    }



    private int flipAll(int curr, int n) {
        int xor = 0;
        for(int i=0; i<n; i++){
            xor |= (1<<i);
        }
        return curr ^ xor;
    }

    private int flipEven(int curr, int n) {
        for(int i=1; i<n; i+=2){
            curr ^= (1<<i);
        }
        return curr;
    }

    private int flipOdd(int curr, int n) {
        for(int i=0; i<n; i+=2){
            curr ^= (1<<i);
        }
        return curr;
    }

    private int flip3k(int curr, int n) {
        for(int i=0; i<n; i+=3){
            curr ^= (1<<i);
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(new BulbSwitcherII().flipLights(3,2));
    }
}
