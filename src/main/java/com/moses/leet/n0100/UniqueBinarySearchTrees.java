package com.moses.leet.n0100;

public class UniqueBinarySearchTrees {

    //dynamic programming. divide n
    //n=4, 0+3, 1+2, 2+1, 3+0
    //n=5, 0+4, 1+3, 2+2, 3+1, 4+0
    public int numTrees(int n) {
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
