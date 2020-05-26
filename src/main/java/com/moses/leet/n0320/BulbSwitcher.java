package com.moses.leet.n0320;

import java.util.Arrays;

public class BulbSwitcher {

    //I was soooooo close...
    //only square numbers will be switched odd times.
    public int bulbSwitchF(int n) {
        return (int)Math.sqrt(n);
    }


    public int bulbSwitch(int n) {
        if(n==0){
            return 0;
        }
        boolean[] ns = new boolean[n];
        for(int i = 1; i<=n ; i++){
            for(int j=i-1; j<n; j+=i){
                ns[j] = !ns[j];
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            if(ns[i]){
                cnt++;
            }
        }
        System.out.println(Arrays.toString(ns));
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new BulbSwitcher().bulbSwitch(3));
        System.out.println(new BulbSwitcher().bulbSwitch(4));
        System.out.println(new BulbSwitcher().bulbSwitch(99999));
        System.out.println(new BulbSwitcher().bulbSwitch(99999999));
    }
}
