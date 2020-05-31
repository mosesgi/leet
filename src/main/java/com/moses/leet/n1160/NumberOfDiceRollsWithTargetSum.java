package com.moses.leet.n1160;

public class NumberOfDiceRollsWithTargetSum {
    int mod = 1000000007;
    public int numRollsToTarget(int d, int f, int target) {
        Integer[][] mem = new Integer[d+1][target+1];
        return dfs(d, f, target, mem);
    }

    int dfs(int d, int f, int target, Integer[][] mem){
        if(target <= 0){
            return 0;
        }
        if(d*f < target){
            return 0;
        }
        if(d==1){
            return 1;
        }
        if(mem[d][target] != null){
            return mem[d][target];
        }
        long res = 0;
        for(int i=1; i<=f; i++){
            res += dfs(d-1, f, target - i, mem) % mod;
        }
        mem[d][target] = (int)(res%mod);
        return mem[d][target];
    }
}
