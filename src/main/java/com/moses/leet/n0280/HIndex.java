package com.moses.leet.n0280;

import java.util.Arrays;
import java.util.Comparator;

public class HIndex {
    public int hIndex(int[] citations) {
        int size = citations.length;
        if(size == 0){
            return 0;
        }
        Arrays.sort(citations);
        int k = 1;
        for(int i=size-1; i>=0; i--){
            if(citations[i] >= k){
                k++;
            }else {
                break;
            }
        }
        return k-1;
    }

    public static void main(String[] args) {
        int[] citations;

        citations = new int[]{1};
        System.out.println(new HIndex().hIndex(citations));

        citations = new int[]{11,15};
        System.out.println(new HIndex().hIndex(citations));

        citations = new int[]{1,3,1};
        System.out.println(new HIndex().hIndex(citations));

        citations = new int[]{0};
        System.out.println(new HIndex().hIndex(citations));

        citations = new int[]{1,0};
        System.out.println(new HIndex().hIndex(citations));

        citations = new int[]{3,0,6,1,5};
        System.out.println(new HIndex().hIndex(citations));
    }
}
