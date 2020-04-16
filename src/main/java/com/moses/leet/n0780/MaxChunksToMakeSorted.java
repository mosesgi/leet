package com.moses.leet.n0780;

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        //4,  3, 1, 6, 2, 5,| 7,|9,8,|12,14,11,10
        int chunks = 0;
        int left = 0;
        while(left < arr.length){
            int right = arr[left];
            while(left <= right && left < arr.length){
                if(arr[left] > right){
                    right = arr[left];
                }
                left++;
            }
            chunks++;
        }
        return chunks;
    }

    public static void main(String[] args) {
        int[] arr;
        arr = new int[]{4,3,2,1,0};
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(arr));

        arr = new int[]{1,0,2,3,4};
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(arr));

        arr = new int[]{4,  3, 1, 6,0, 2, 5, 7,9,8,12,14,11,10};
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(arr));
    }
}
