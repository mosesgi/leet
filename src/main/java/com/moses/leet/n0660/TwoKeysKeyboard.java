package com.moses.leet.n0660;

public class TwoKeysKeyboard {
    //7 -> A, AA, AAA
    //5 -> A, C, AA, AAA, AAAA, AAAAA
    //9 -> A, C, AA, AAA, C, AAAAAA, AAAAAAAAA
    //12 -> A, C, AA, AAA, C, AAAAAA, C, AAAAAAAAAAAA
    public int minStepsMine(int n) {
        int step = 0;
        if(n==1){
            return step;
        }
        while(true){
            boolean found = false;
            for(int i=2; i<n; i++){
                if(n%i==0){
                    n = n/i;
                    step+=i;
                    found = true;
                    break;
                }
            }
            if(!found){
                break;
            }
        }
        step += n;
        return step;
    }

    //Try DP. failed...
    public int minSteps(int n) {
        if(n==1){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[1] = 0;
        dp[2] = 2;
        if(n<=2){
            return dp[n];
        }
        for(int i=3; i <=n; i++){
            dp[i] = i;
            for(int j=i-1; j>1; j--){
                if(i%j==0){
                    dp[i] = dp[j] + i/j;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new TwoKeysKeyboard().minSteps(800));
        System.out.println(new TwoKeysKeyboard().minSteps(3));
        System.out.println(new TwoKeysKeyboard().minSteps(5));
        System.out.println(new TwoKeysKeyboard().minSteps(6));
        System.out.println(new TwoKeysKeyboard().minSteps(7));
        System.out.println(new TwoKeysKeyboard().minSteps(9));
        System.out.println(new TwoKeysKeyboard().minSteps(12));
    }

}
