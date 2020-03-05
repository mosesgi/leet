package com.moses.leet.n0400;

public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        if(A.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] sumWithoutK = new int[A.length];
        int[] rst = new int[A.length];

        int sum = 0;
        for(int i=0; i<A.length; i++){
            sum+=A[i];
        }
        for(int i=0; i<A.length; i++){
            sumWithoutK[i] = sum - A[i];
        }

        int factor = 0;
        for(int i=0; i<A.length; i++){
            rst[0] += A[i] * factor++;
            max = rst[0];
        }

        int changedPos = A.length-1;
        int lastFactor = A.length-1;
        for(int i=1; i<A.length; i++){
            rst[i] = rst[i-1] + sumWithoutK[changedPos] - lastFactor * A[changedPos];
            changedPos--;
            if(rst[i] > max){
                max = rst[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A;
        A = new int[]{4,3,2,6};
        System.out.println(new RotateFunction().maxRotateFunction(A));
    }
}
