package com.moses.leet.n0700;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        char a = A.charAt(0);
        int cntA = 0;
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i) == a){
                cntA++;
            }
        }
        int cntB = 0;
        for(int i=0; i<B.length(); i++){
            if(B.charAt(i) == a){
                cntB++;
            }
        }
        int times = cntB/cntA;
        if(times == 0){
            times = 1;
        }
        StringBuilder sb = new StringBuilder(A);
        for(int i=1; i<times; i++){
            sb.append(A);
        }
        if(sb.indexOf(B) >= 0){
            return times;
        }
        sb.append(A);
        if(sb.indexOf(B) >= 0){
            return times+1;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedStringMatch().repeatedStringMatch("a", "aa"));
    }
}
