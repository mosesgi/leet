package com.moses.leet.n0600;

import java.util.LinkedList;
import java.util.Queue;

public class FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<expression.length(); ){
            StringBuilder aSb = new StringBuilder();
            while(expression.charAt(i) != '/'){
                aSb.append(expression.charAt(i++));
            }
            i++;
            StringBuilder bSb = new StringBuilder();
            while(i < expression.length() && expression.charAt(i) != '+' && expression.charAt(i) != '-'){
                bSb.append(expression.charAt(i++));
            }

            int a = Integer.parseInt(aSb.toString());
            int b = Integer.parseInt(bSb.toString());
            q.offer(new int[]{a,b});
        }

        int[] prev = new int[]{0,1};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int lcm = lcm(prev[1], cur[1]);
            prev[0] = prev[0]*(lcm/prev[1]) + cur[0]*(lcm/cur[1]);
            prev[1] = lcm;

            int gcd = gcd(prev[0], prev[1]);
            prev[0] = prev[0]/gcd;
            prev[1] = prev[1]/gcd;
        }
        //  56/32
        boolean isNeg = prev[0] * prev[1] < 0;
        String tmp = Math.abs(prev[0]) + "/" + Math.abs(prev[1]);
        return isNeg?"-"+tmp:tmp;
    }

    int lcm(int a, int b){
        int gcd = gcd(a, b);
        return a*b/gcd;
    }

    int gcd(int a, int b){
        while(b != 0){
            int t = b;
            b = a%b;
            a = t;
        }
        return a;
    }


    // 1/2+1/2+1/3
    // 1/3-1/2
    public String fractionAdditionFirst(String expression) {
        Queue<long[]> q = new LinkedList<>();
        for(int i=0; i<expression.length(); ){
            StringBuilder aSb = new StringBuilder();
            while(expression.charAt(i) != '/'){
                aSb.append(expression.charAt(i++));
            }
            i++;
            StringBuilder bSb = new StringBuilder();
            while(i < expression.length() && expression.charAt(i) != '+' && expression.charAt(i) != '-'){
                bSb.append(expression.charAt(i++));
            }

            int a = Integer.parseInt(aSb.toString());
            int b = Integer.parseInt(bSb.toString());
            q.offer(new long[]{a,b});
        }

        long[] prev = new long[]{0,1};
        while(!q.isEmpty()){
            long[] cur = q.poll();
            if(cur[1] == prev[1]){
                prev[0] = cur[0] + prev[0];
            }else{
                if(prev[1] % cur[1] == 0){
                    prev[0] = prev[0] + cur[0] * (prev[1]/cur[1]);
                } else if(cur[1] % prev[1] == 0){
                    prev[0] = prev[0] * (cur[1]/prev[1]) + cur[0];
                    prev[1] = cur[1];
                } else {
                    long common = prev[1] * cur[1];
                    long a = prev[0] * cur[1] + cur[0] * prev[1];
                    prev[0] = a;
                    prev[1] = common;
                }
            }
        }
        //  56/32
        boolean isNeg = false;
        if(prev[0] < 0){
            isNeg = true;
            prev[0] = -prev[0];
        }
        if(prev[0] == prev[1]){
            return isNeg?"-1/1":"1/1";
        }else if(prev[0] == 1 || prev[1] == 1){
            String tmp =  prev[0] + "/" + prev[1];
            return isNeg?"-"+tmp:tmp;
        }else if(prev[0] % prev[1] == 0){
            String tmp =  prev[0]/prev[1] + "/1";
            return isNeg?"-"+tmp:tmp;
        }else if(prev[1] % prev[0] == 0){
            String tmp =  "1/" + (prev[1]/prev[0]);
            return isNeg?"-"+tmp:tmp;
        }

        long small = prev[0] > prev[1]? prev[1]:prev[0];
        for(long i = small; i>0; i--){
            if(prev[0] % i == 0 && prev[1] % i == 0){
                prev[0] = prev[0]/i;
                prev[1] = prev[1]/i;
            }
        }
        String tmp =  prev[0]+"/" + prev[1];
        return isNeg?"-"+tmp:tmp;
    }



    public static void main(String[] args) {

        System.out.println(new FractionAdditionAndSubtraction().gcd(12,18));
        String e;

        e = "2/5-1/1-2/1";
        System.out.println(new FractionAdditionAndSubtraction().fractionAddition(e));

        e = "1/3-1/2";
        System.out.println(new FractionAdditionAndSubtraction().fractionAddition(e));

        e = "-1/2+1/2";
        System.out.println(new FractionAdditionAndSubtraction().fractionAddition(e));

        e = "-1/2+1/2+1/3";
        System.out.println(new FractionAdditionAndSubtraction().fractionAddition(e));

        e = "5/3+1/3";
        System.out.println(new FractionAdditionAndSubtraction().fractionAddition(e));

//        e = "-1/2+1/2";
//        System.out.println(new FractionAdditionAndSubtraction().fractionAddition(e));

    }
}
