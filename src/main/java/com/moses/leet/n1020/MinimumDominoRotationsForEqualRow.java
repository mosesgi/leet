package com.moses.leet.n1020;

import java.util.ArrayList;
import java.util.List;

public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int aa = 0;     //A[0] 在A中
        int ab = 1;     //A[0] 在B中
        int bb = 0;     //B[0] 在B中
        int ba = 1;     //B[0] 在A中
        for(int i=1; i<A.length; i++){
            if(aa != -1){
                if(A[i] == A[0]){

                }else if(B[i] == A[0]){
                    aa++;
                }else{
                    aa = -1;
                }
            }

            if(ab != -1){
                if(B[i] == A[0]){

                }else if(A[i] == A[0]){
                    ab++;
                }else{
                    ab = -1;
                }
            }

            if(bb != -1) {
                if (B[i] == B[0]) {

                }else if(A[i] == B[0]){
                    bb++;
                }else{
                    bb = -1;
                }
            }

            if(ba != -1) {
                if (A[i] == B[0]) {

                }else if(B[i] == B[0]){
                    ba++;
                }else{
                    ba = -1;
                }
            }
        }
        List<Integer> l = new ArrayList<>();
        if(aa != -1){
            l.add(aa);
        }
        if(ab != -1){
            l.add(ab);
        }
        if(ba != -1){
            l.add(ba);
        }
        if(bb != -1){
            l.add(bb);
        }
        if(l.size()==0){
            return -1;
        }
        int min = A.length;
        for(int i=0; i<l.size(); i++){
            min = Math.min(min, Math.min(l.get(i), A.length-l.get(i)));
        }
        return min;
    }
}
