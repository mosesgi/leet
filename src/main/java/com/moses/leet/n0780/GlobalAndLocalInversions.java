package com.moses.leet.n0780;

public class GlobalAndLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        //所有的全局倒置都只能是局部倒置.
        //if A[i-2] > A[i....len-1]  return false
        //所以, A[i-2] > min(A[i....len-1]
        int min = Integer.MAX_VALUE;
        for(int i=A.length-1; i>=2; i--){
            min = Math.min(min, A[i]);
            if(A[i-2] > min){
                return false;
            }
        }
        return true;
    }


    public boolean isIdealPermutation1(int[] A) {
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
