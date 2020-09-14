package com.moses.leet.huawei;

import java.util.Arrays;
import java.util.Scanner;

//https://www.nowcoder.com/practice/1221ec77125d4370833fd3ad5ba72395?tpId=37&&tqId=21260&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
public class RabbitNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            int[] dp = new int[n+1];
            dp[1] = 1;
            for(int i=2; i<dp.length; i++){
                dp[i] = dp[i-1];
                if(i>2){
                    dp[i] += dp[i-2];
                }
            }
            System.out.println(dp[n]);
        }
    }
}
