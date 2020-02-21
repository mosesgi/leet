package com.moses.leet.n0280;

public class HIndexII {
    public int hIndex(int[] citations){
        int size = citations.length;
        int left = 1;
        int right = citations.length;
        while(left<=right){
            if(left == right){
                if(citations[left-1] >= size-left+1){
                    return size-left+1;
                } else {
                    return size-left;
                }
            }
            int mid = (left+right)/2;
            if(citations[mid-1] >= size-mid){
                right = mid;
            } else if(citations[mid-1] < size-mid){
                left = mid+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] citations;
        citations = new int[]{1,1,3};
        System.out.println(new HIndexII().hIndex(citations));

        citations = new int[]{0,1,4,4,5,6};
        System.out.println(new HIndexII().hIndex(citations));

        citations = new int[]{1};
        System.out.println(new HIndexII().hIndex(citations));

        citations = new int[]{11,15};
        System.out.println(new HIndexII().hIndex(citations));

        citations = new int[]{0};
        System.out.println(new HIndexII().hIndex(citations));

        citations = new int[]{0,1};
        System.out.println(new HIndexII().hIndex(citations));


    }
}
