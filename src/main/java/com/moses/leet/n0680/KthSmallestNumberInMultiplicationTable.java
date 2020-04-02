package com.moses.leet.n0680;

import java.util.PriorityQueue;

public class KthSmallestNumberInMultiplicationTable {

    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m*n;
        while(l < r){
            int mid = l+(r-l)/2;
            if(enough(mid, m, n, k)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }

    private boolean enough(int x, int m, int n, int k){
        int count = 0;
        for(int i=1; i<=m; i++){
            count+= Math.min(n, x/i);
        }
        return count>=k;
    }

    public int findKthNumberSlow(int m, int n, int k) {
        PriorityQueue<int[]> p = new PriorityQueue<>((o1, o2)->{return o1[0]*o1[1] - o2[0]*o2[1];});
        p.offer(new int[]{1,1});
        int idx = 0;
        int[] curr = new int[]{0,0};
        while(idx < k){
            curr = p.poll();
            int i = curr[0];
            int j = curr[1];
            if(i==3000 && j==3000){
                System.out.println();
            }
            if(i==j){
                if(i+1 <=m && j+1 <=n) {
                    p.offer(new int[]{i + 1, j + 1});
                }
                if(j+1 <=n) {
                    p.offer(new int[]{i, j + 1});
                }
                if(i+1 <=m) {
                    p.offer(new int[]{i + 1, j});
                }
            }else if(i<j && j+1<=n){
                p.offer(new int[]{i, j+1});
            }else if(i>j && i+1<=m){
                p.offer(new int[]{i+1, j});
            }
            idx++;
        }
        return curr[0] * curr[1];
    }

    public static void main(String[] args) {
        int m =15, n=15;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                System.out.print(i*j + "\t");
            }
            System.out.println();
        }
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Long.MAX_VALUE);
        long begin = System.nanoTime();
        System.out.println(new KthSmallestNumberInMultiplicationTable().findKthNumber(9895,28405, 100787757));
        System.out.println("Cost:" + (System.nanoTime()-begin));
        System.out.println(new KthSmallestNumberInMultiplicationTable().findKthNumber(3,3, 5));
        System.out.println(new KthSmallestNumberInMultiplicationTable().findKthNumber(2,3, 6));
    }
}
