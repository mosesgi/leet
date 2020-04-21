package com.moses.leet.n0820;

public class LargestSumOfAverages {
    public double largestSumOfAverages(int[] A, int K) {
        Double[][] mem = new Double[A.length][K+1];
        return rec(A, K, 0, mem);
    }

    private double rec(int[] A, int k, int pos, Double[][] mem) {
        if(pos >= A.length){
            return 0;
        }
        if(mem[pos][k] != null){
            return mem[pos][k];
        }
        if(k==1){
            int size = A.length-pos;
            int sum = 0;
            for(int i=pos; i<A.length; i++){
                sum += A[i];
            }
            mem[pos][k] = sum*1.0/size;;
            return mem[pos][k];
        }
        int remain = A.length-pos;
        int sum = A[pos];
        double max = Double.MIN_VALUE;
        for(int i=1; i<remain; i++){
            max = Math.max(max, sum*1.0/i + rec(A, k-1, pos+i, mem));
            sum+=A[pos+i];
        }
        mem[pos][k] =max;
        return max;
    }

    public static void main(String[] args) {
        int[] A; int k;
        A = new int[]{7,5,6,2,3};       //15.6667, 7, 5, 623
        k = 3;
        System.out.println(new LargestSumOfAverages().largestSumOfAverages(A, k));

        A = new int[]{4,1,7,5,6,2,3};       //13.5
        k = 3;
        System.out.println(new LargestSumOfAverages().largestSumOfAverages(A, k));

        A = new int[]{4,1,7,5,6,2,3};
        k = 4;
        System.out.println(new LargestSumOfAverages().largestSumOfAverages(A, k));

        A = new int[]{9,1,2,3,9,3,1,3,6,12,33,4,2,3,5,18};
        k = 8;
        System.out.println(new LargestSumOfAverages().largestSumOfAverages(A, k));
    }
}
