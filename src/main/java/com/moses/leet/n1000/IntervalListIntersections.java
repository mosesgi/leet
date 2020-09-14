package com.moses.leet.n1000;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        if(A.length==0 || B.length==0){
            return new int[0][0];
        }
        int i=0, j=0;
        while(i<A.length && j<B.length){
            int[] a = A[i];
            int[] b = B[j];
            if(a[0] > b[1]){
                j++;
            }else if(b[0] > a[1]){
                i++;
            }else{
                int start = Math.max(a[0], b[0]);
                int end = Math.min(a[1], b[1]);
                list.add(new int[]{start, end});
                if(end >= a[1]){
                    i++;
                }
                if(end >= b[1]){
                    j++;
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for(int k=0; k<list.size(); k++){
            res[k] = list.get(k);
        }
        return res;
    }


    public int[][] intervalIntersectionFirst(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        if(A.length==0 || B.length == 0){
            return new int[0][0];
        }
        int i=0, j=0;
        while(i<A.length && j<B.length){
            int[] a = A[i];
            int[] b = B[j];
            if(a[0] > b[1]){
                j++;
            }else if(b[0] > a[1]){
                i++;
            }else{
                if(a[0]==b[0] && a[1] == b[1]){
                    list.add(new int[]{a[0], a[1]});
                    i++;
                    j++;
                }else if(a[0]>=b[0] && a[1] <= b[1]){
                    list.add(new int[]{a[0], a[1]});
                    i++;
                }else if(a[0]<=b[0] && a[1] >= b[1]){
                    list.add(new int[]{b[0], b[1]});
                    j++;
                }else if(a[0]>b[0] && a[0] < b[1] && a[1]>b[1]){
                    list.add(new int[]{a[0], b[1]});
                    j++;
                }else if(a[0]<b[0] && a[1]>b[0] && a[1]<b[1]){
                    list.add(new int[]{b[0], a[1]});
                    i++;
                }else if(a[0] == b[1]){
                    list.add(new int[]{a[0], a[0]});
                    j++;
                }else if(a[1] == b[0]){
                    list.add(new int[]{b[0], b[0]});
                    i++;
                }
            }
        }

        int[][] res = new int[list.size()][2];
        for(int k=0; k<res.length; k++){
            res[k] = list.get(k);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] A, B;
        A = new int[][]{{14,16}};
        B = new int[][]{{7,13},{16,20}};
        new IntervalListIntersections().intervalIntersection(A, B);
    }
}
