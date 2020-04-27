package com.moses.leet.n0100;

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    //dynamic programming. divide n
    //n=4, 0+3, 1+2, 2+1, 3+0
    //n=5, 0+4, 1+3, 2+2, 3+1, 4+0
    public int numTreesOld(int n) {
        if(n==0 || n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<n+1; i++){
            int tmp = 0;
            for(int j=0; j<i; j++){
                tmp+= dp[j]*dp[i-1-j];
            }
            dp[i] = tmp;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees().numTrees(3));
        System.out.println(new UniqueBinarySearchTrees().numTrees(4));
        System.out.println(new UniqueBinarySearchTrees().numTrees(5));
    }
}
