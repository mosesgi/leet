package com.moses.leet.n0800;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    //TLE
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> p = new PriorityQueue<>((o1, o2) -> {
            double a = (double)o1[0]/o1[1];
            double b = (double)o2[0]/o2[1];
            if(a==b){
                return 0;
            }else if(a<b){
                return -1;
            }else{
                return 1;
            }
        });
        for(int i=0; i<A.length-1; i++){
            for(int j= i+1; j<A.length; j++){
                p.offer(new int[]{A[i], A[j]});
            }
        }
        for(int i=1; i<K; i++){
            p.poll();
        }
        return p.poll();
    }

    public static void main(String[] args) {
        int[] A;
        int k;
        A = new int[]{1,29,47};
        k = 1;
        System.out.println(Arrays.toString(new KthSmallestPrimeFraction().kthSmallestPrimeFraction(A, k)));
    }
}
