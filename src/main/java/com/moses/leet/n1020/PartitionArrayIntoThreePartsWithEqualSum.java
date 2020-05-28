package com.moses.leet.n1020;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i : A){
            sum+=i;
        }
        if(sum%3 != 0){
            return false;
        }
        int target = sum/3;
        int tmp = 0;
        int cnt = 0;
        for(int i=0; i<A.length; i++){
            tmp+=A[i];
            if(tmp == target){
                tmp = 0;
                cnt++;
                if(cnt == 2 && i!= A.length-1){
                    return true;
                }
            }
        }
        return false;

    }
}
