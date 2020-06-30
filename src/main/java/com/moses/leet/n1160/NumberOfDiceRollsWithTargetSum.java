package com.moses.leet.n1160;

public class NumberOfDiceRollsWithTargetSum {

    public int numRollsToTarget(int d, int f, int target) {
        int mod = 1000000007;
        int[][] dp = new int[d+1][target+1];
        for(int i=1; i<=f && i<=target; i++){
            dp[1][i] = 1;
        }
        for(int i=2; i<=d; i++){
            for(int j=1; j<=target; j++){
                long tmp = 0L;
                for(int k=1; k<=f; k++){
                    if(j >= k){
                        tmp += dp[i-1][j-k];
                    }
                }
                dp[i][j] = (int)(tmp % mod);
            }
        }
        return dp[d][target];
    }

    public static void main(String[] args) {
        int d, f, target;
        d = 10; f = 5; target = 27;
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(d, f, target));

        d = 30; f = 30; target = 500;
        System.out.println(new NumberOfDiceRollsWithTargetSum().numRollsToTarget(d, f, target));
    }



    int mod = 1000000007;
    public int numRollsToTargetRec(int d, int f, int target) {
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
