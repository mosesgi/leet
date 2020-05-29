package com.moses.leet.n1140;

public class MaximumOfAbsoluteValueExpression {
    public int maxAbsValExprWrong(int[] arr1, int[] arr2) {
        int minPos1=0, maxPos1 = arr1.length-1;
        int minPos2=0, maxPos2 = arr2.length-1;
        for(int i=0; i<arr1.length; i++){
            if(arr1[i] < arr1[minPos1]){
                minPos1 = i;
            }
            if(arr1[i] > arr1[maxPos1]){
                maxPos1 = i;
            }
            if(arr2[i] < arr2[minPos2]){
                minPos2 = i;
            }
            if(arr2[i] > arr2[maxPos2]){
                maxPos2 = i;
            }
        }

        int a = Math.abs(arr1[minPos1] - arr1[maxPos1]) + Math.abs(arr2[minPos1] - arr2[maxPos1]) + Math.abs(minPos1 - maxPos1);
        int b = Math.abs(arr1[minPos2] - arr1[maxPos2]) + Math.abs(arr2[minPos2] - arr2[maxPos2]) + Math.abs(minPos2 - maxPos2);
        return Math.max(a, b);
    }

    public int maxAbsValExprTLE(int[] arr1, int[] arr2) {
        /**
         * [1,2,3,4]
         * [-1,4,5,6]
         *
         * i:0,j:1,tmp:7
         * i:0,j:2,tmp:10
         * i:0,j:3,tmp:13
         * i:1,j:2,tmp:3
         * i:1,j:3,tmp:6
         * i:2,j:3,tmp:3
         */

        /**
         * [1,-2,-5,0,10]
         * [0,-2,-1,-7,-4]
         *
         * i:0,j:1,tmp:6
         * i:0,j:2,tmp:9
         * i:0,j:3,tmp:11
         * i:0,j:4,tmp:17
         * i:1,j:2,tmp:5
         * i:1,j:3,tmp:9
         * i:1,j:4,tmp:17
         * i:2,j:3,tmp:12
         * i:2,j:4,tmp:20
         * i:3,j:4,tmp:14
         */

        /**
         * [2,2,6,1,-7,-1,-7]
         * [6,1,-2,-10,-7,-6,-10]
         * i:0,j:1,tmp:6
         * i:0,j:2,tmp:14
         * i:0,j:3,tmp:20
         * i:0,j:4,tmp:26
         * i:0,j:5,tmp:20
         * i:0,j:6,tmp:31
         * i:1,j:2,tmp:8
         * i:1,j:3,tmp:14
         * i:1,j:4,tmp:20
         * i:1,j:5,tmp:14
         * i:1,j:6,tmp:25
         * i:2,j:3,tmp:14
         * i:2,j:4,tmp:20
         * i:2,j:5,tmp:14
         * i:2,j:6,tmp:25
         * i:3,j:4,tmp:12
         * i:3,j:5,tmp:8
         * i:3,j:6,tmp:11
         * i:4,j:5,tmp:8
         * i:4,j:6,tmp:5
         * i:5,j:6,tmp:11
         */
        int res = 0;
        for(int i=0; i<arr1.length-1; i++){
            for(int j=i+1; j<arr1.length; j++){
                int tmp = Math.abs(arr1[i]-arr1[j]) + Math.abs(arr2[i]-arr2[j]) + (j-i);
                System.out.println("i:"+i+",j:"+j+",tmp:"+tmp);
                res = Math.max(res, tmp);
            }
        }
        return res;
    }
}
