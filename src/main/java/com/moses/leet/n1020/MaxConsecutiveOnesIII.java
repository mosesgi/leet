package com.moses.leet.n1020;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int usedK = 0;
        int max = 0;
        int l = 0;
        for(int j=0; j<A.length; j++){
            if(A[j] == 1){
                max = Math.max(max, j-l+1);
            }else{
                A[j] = -1;
                if(usedK < K){
                    usedK++;
                }else{
                    while(l<A.length && A[l] != -1){
                        l++;
                    }
                    A[l] = 0;
                    l++;
                }
                max = Math.max(max, j-l+1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A;
        int K;
        A = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        K = 3;
        System.out.println(new MaxConsecutiveOnesIII().longestOnes(A, K));

        A = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        K = 2;
        System.out.println(new MaxConsecutiveOnesIII().longestOnes(A, K));
    }
}
