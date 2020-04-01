package com.moses.leet.n0660;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int center = Arrays.binarySearch(arr, x);

        if(center<0){
            center = -center-1;
            if(center-1>=0 && x-arr[center-1]<=arr[center]-x){
                center--;
            }
        }else{
            while(center-1>=0 && arr[center-1] == arr[center]){
                center--;
            }
        }

        int l = center, r = center;
        while(r-l+1 < k){
            if(l-1>=0 && r+1 < arr.length){
                if(Math.abs(x-arr[l-1]) <= Math.abs(x-arr[r+1])){
                    l--;
                }else{
                    r++;
                }
            }else if(l-1<0){
                r++;
            }else if(r+1>=arr.length){
                l--;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=l; i<=r; i++){
            list.add(arr[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr;
        int k, x;

        arr = new int[]{0,0,1,2,3,3,4,7,7,8};
        k=3; x=5;
        System.out.println(Arrays.toString(new FindKClosestElements().findClosestElements(arr, k, x).toArray()));


        arr = new int[]{1,2,3,4,5};
        k=4; x=3;
        System.out.println(Arrays.toString(new FindKClosestElements().findClosestElements(arr, k, x).toArray()));

        arr = new int[]{1,2,3,4,5};
        k=3; x=2;
        System.out.println(Arrays.toString(new FindKClosestElements().findClosestElements(arr, k, x).toArray()));

    }
}
