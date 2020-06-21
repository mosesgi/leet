package com.moses.leet.study;

import com.moses.leet.pojo.TreeNode;

import java.util.*;

public class Test {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        int res = 0;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<A.length; j++){
                for(int k=0; k<A.length; k++){
                    int p = Arrays.binarySearch(D, -A[i]-B[j]-C[k]);
                    if(p>=0){
                        int left = p;
                        int right = p;
                        while(left>0 && D[left-1] == D[left]){
                            left--;
                        }
                        while(right<D.length-1 && D[right+1] == D[right]){
                            right++;
                        }
                        res += (right-left+1);
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
