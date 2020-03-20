package com.moses.leet.n0520;

import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> capQueue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> proQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for(int i=0; i<Profits.length; i++){
            capQueue.offer(new int[]{Capital[i], Profits[i]});
        }

        for(int i=0; i<k; i++){
            while(!capQueue.isEmpty() && capQueue.peek()[0] <= W){
                proQueue.offer(capQueue.poll());
            }
            if(proQueue.isEmpty()){
                return W;
            }
            int[] profit = proQueue.poll();
            W+=profit[1];
        }
        return W;
    }


    public int findMaximizedCapitalTLE(int k, int W, int[] Profits, int[] Capital) {
        boolean[] used = new boolean[Profits.length];
        return W+dfs(k, W, Profits, Capital, used);
    }

    private int dfs(int k, int w, int[] profits, int[] capital, boolean[] used) {
        if(k==0){
            return 0;
        }
        int max = 0;
        for(int i=0; i<capital.length; i++){
            if(used[i]){
                continue;
            }
            int curCap = capital[i];
            if(w>=curCap){
                used[i] = true;
                max = Math.max(max, profits[i] + dfs(k-1, w+profits[i], profits, capital, used));
                used[i] = false;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int k,W;
        int[] Profits, Capital;
        k=2; W=0;
        Profits = new int[]{1,2,3};
        Capital = new int[]{0,1,1};
        System.out.println(new IPO().findMaximizedCapital(k, W, Profits, Capital));
    }
}
