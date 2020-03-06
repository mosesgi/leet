package com.moses.leet.n0420;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        //1,2,3,4,5
        //1,2,3; 2,3,4; 3,4,5; 1,2,3,4; 2,3,4,5;
        //num of 3s: len-3+1.  Sum from 1 to n =  n(n+1)/2

        List<Integer> ari = new ArrayList<>();
        int start = -1;
        for(int i=2; i<A.length; i++){
            if(A[i-1]-A[i-2] == A[i]-A[i-1]){
                if(start == -1){
                    start = i-2;
                }
            } else {
                if(start != -1 && i-start>2){
                    ari.add(i-start);
                    start = -1;
                }
            }
        }
        if(start != -1 && A.length-start>2){
            ari.add(A.length-start);
        }

        int sum = 0;
        for(int i : ari){
            int len = i-3+1;
            sum += len*(len+1)/2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A;
        A = new int[]{1,2,3,4};
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(A));

        A = new int[]{1,2,3,4,7,9,10,13,16,19,21,24};
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(A));
    }
}
