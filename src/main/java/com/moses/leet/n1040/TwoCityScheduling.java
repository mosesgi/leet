package com.moses.leet.n1040;

import java.util.Arrays;

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        //先送到A，再选N个送到B， 送到B需要支付或返还（负值）cost[1] - cost[0]. 可正可负
        Arrays.sort(costs, (o1, o2) -> (o1[1] - o1[0]) - (o2[1]-o2[0]));
        int all = 0;
        int toB = 0;
        for(int i=0; i<costs.length; i++){
            all += costs[i][0];
            if(i < costs.length/2){
                toB += costs[i][1] - costs[i][0];
            }
        }
        return all + toB;

    }

    public static void main(String[] args) {
        int[][] costs;
        costs =new int[][]{{10,20},{30,200},{400,50},{30,20}};
        System.out.println(new TwoCityScheduling().twoCitySchedCost(costs));
    }

    public int twoCitySchedCostRec(int[][] costs) {
        int[][][] mem = new int[costs.length][costs.length][2];
        for(int i=0; i<costs.length; i++){
            for(int j=0; j<costs.length; j++){
                Arrays.fill(mem[i][j], -1);
            }
        }
        int[] res = dfs(costs, 0, 0, 0, mem);
        return res[0] + res[1];
    }

    int[] dfs(int[][] costs, int start, int a, int b, int[][][] mem){
        if(a == costs.length/2 && b == costs.length/2){
            return new int[]{0,0};
        }
        if(mem[a][b][0] != -1 || mem[a][b][1] != -1){
            return mem[a][b];
        }
        if(a < costs.length/2 && b < costs.length/2){
            int[] toA = dfs(costs, start+1, a+1, b, mem);
            int[] toB = dfs(costs, start+1, a, b+1, mem);
            int[] cur = costs[start];
            int[] res = new int[2];
            if(cur[0] + toA[0] + toA[1] <= cur[1] + toB[0] + toB[1]){
                res[0] = cur[0] + toA[0];
                res[1] = toA[1];
            }else{
                res[0] = toB[0];
                res[1] = cur[1] + toB[1];
            }
            mem[a][b] = res;
        } else if( a == costs.length/2){
            int[] toB = dfs(costs, start+1, a, b+1, mem);
            mem[a][b][0] = toB[0];
            mem[a][b][1] = costs[start][1] +  + toB[1];
        }else{
            int[] toA = dfs(costs, start+1, a+1, b, mem);
            mem[a][b][0] = costs[start][0] + toA[0];
            mem[a][b][1] = toA[1];
        }
        return mem[a][b];
    }
}
