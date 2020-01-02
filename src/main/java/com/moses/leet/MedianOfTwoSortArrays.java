package com.moses.leet;

public class MedianOfTwoSortArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;

        int size1 = nums1.length;
        int size2 = nums2.length;
        int totalSize = size1 + size2;

        int ar1Left = 0;
        int ar2Left = 0;

        int[] mergedArr = new int[totalSize];

        for(int step = 0; step<totalSize; step++){
            if(ar1Left >= size1){
                mergedArr[step] = nums2[ar2Left++];
                continue;
            }
            if(ar2Left >= size2){
                mergedArr[step] = nums1[ar1Left++];
                continue;
            }
            if(nums1[ar1Left] < nums2[ar2Left]){
                mergedArr[step] = nums1[ar1Left++];
            } else {
                mergedArr[step] = nums2[ar2Left++];
            }
        }

        if(totalSize%2 == 0){
            result = (mergedArr[totalSize/2-1] + mergedArr[totalSize/2])/2.0;
        } else {
            result = mergedArr[totalSize/2];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,6,9};
        int[] nums2 = new int[]{2,5,10,12};

        System.out.println(new MedianOfTwoSortArrays().findMedianSortedArrays(nums1, nums2));



        nums1 = new int[]{1,2,4,5};
        nums2 = new int[]{8,9,10};

        System.out.println(new MedianOfTwoSortArrays().findMedianSortedArrays(nums1, nums2));
    }

}
