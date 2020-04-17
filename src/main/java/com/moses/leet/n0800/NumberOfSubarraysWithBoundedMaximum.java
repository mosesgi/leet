package com.moses.leet.n0800;

public class NumberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int res = 0;
        Integer start = null;
        int permutation = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] > R){
                if(start != null){
                    start = null;
                    permutation = 0;
                }
            }else{
                if(start == null){
                    start = i;
                }
                if(A[i] >=L){
                    permutation = i-start +1;
                    res += permutation;
                }else{
                    res += permutation;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A;
        int L, R;

        A = new int[]{2,9,2,5,6};
        L = 2;
        R = 8;
        System.out.println(new NumberOfSubarraysWithBoundedMaximum().numSubarrayBoundedMax(A, L, R));

        A = new int[]{2,1,4,3};
        L = 2;
        R = 3;
        System.out.println(new NumberOfSubarraysWithBoundedMaximum().numSubarrayBoundedMax(A, L, R));
    }
}
