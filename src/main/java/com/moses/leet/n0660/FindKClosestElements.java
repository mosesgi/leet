package com.moses.leet.n0660;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pivot = Arrays.binarySearch(arr, x);
        int l, r;
        if(pivot < 0){
            r = -pivot-1;
            if(r == arr.length){
                r = arr.length-1;
            }else if(r-1>=0 && x-arr[r-1] <= arr[r] - x){
                r--;
            }
            l = r;
        } else{
            r = pivot;
            while(r-1 >=0 && arr[r-1] == arr[r]){
                r--;
            }
            l = r;
        }
        while(r-l<k-1){
            if(l-1>=0 && r+1<arr.length){
                if(x - arr[l-1] <= arr[r+1] - x){
                    l--;
                }else{
                    r++;
                }
            }else if(l==0){
                r++;
            }else{
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
