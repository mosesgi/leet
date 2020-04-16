package com.moses.leet.n0780;

public class GlobalAndLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        //1,0,3,2,4,5
        //1,0,3,2,5,4
        //0,2,1,4,3,5
        //0,1,2,4,3,5
        for(int i=1; i<A.length; i++){
            if(A[i] - A[i-1] >3){
                return false;
            }
            if(A[i] < A[i-1]){
                if(A[i]-A[i-1] > 1 || A[i]!=i-1 || A[i-1] != i) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIdealPermutationSolutionFromDiscuss(int[] A) {
        //1,0,3,2,4,5
        //1,0,3,2,5,4
        //0,2,1,4,3,5
        //0,1,2,4,3,5
        for(int i=0; i<A.length; i++){
            if(Math.abs(i-A[i]) > 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A;
        A = new int[]{1,0,2};
        System.out.println(new GlobalAndLocalInversions().isIdealPermutation(A));

        A = new int[]{1,2,0};
        System.out.println(new GlobalAndLocalInversions().isIdealPermutation(A));
    }
}
