package com.moses.leet.n0280;

import java.util.ArrayList;
import java.util.List;

/**
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
 *
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 *
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n). There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
 */
public class FindTheCelebrity {
    public int findCelebrity(int n) {
        int cand = 0;
        for(int j=1; j<n; j++){
            if(knows(cand, j)){
                cand = j;
            }
        }

        for(int i=0; i<n; i++){
            if(i==cand){
                continue;
            }
            if(knows(cand, i)){
                return -1;
            }
            if(!knows(i, cand)){
                return -1;
            }
        }
        return cand;
    }

    public int findCelebrityOld(int n) {
        List<Integer> cand = new ArrayList<>();
        for(int i=0; i<n; i++){
            boolean know0 = true;
            for(int j=0; j<n; j++){
                if(i==j){
                    continue;
                }
                if(knows(i, j)){
                    know0 = false;
                    break;
                }
            }
            if(know0){
                cand.add(i);
            }
        }
        for(int i : cand){
            boolean allKnown = true;
            for(int j=0; j<n; j++){
                if(j==i){
                    continue;
                }
                if(!knows(j, i)){
                    allKnown = false;
                    break;
                }
            }
            if(allKnown){
                return i;
            }
        }
        return -1;
    }

    public int findCelebrityFirst(int n) {
        int[] ind = new int[n];
        int[] outd = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    continue;
                }
                if(knows(i, j)){
                    outd[i]++;
                    ind[j]++;
                }
            }
        }
        for(int i=0; i< n; i++){
            if(ind[i] == n-1 && outd[i] == 0){
                return i;
            }
        }
        return -1;
    }

    boolean knows(int a, int b){
        return false;
    }
}
