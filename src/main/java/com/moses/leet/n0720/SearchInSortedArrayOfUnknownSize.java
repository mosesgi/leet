package com.moses.leet.n0720;

public class SearchInSortedArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {
        int l=0, r = 1000;
        boolean exceededFound = false;
        while(l <= r){
            int m = l+(r-l)/2;
            int tmp = reader.get(m);
            if(tmp >= 10000){
                r = m-1;
                exceededFound = true;
            }else{
                if(!exceededFound){
                    r*=2;
                }
                l = m+1;
            }
        }
        l = 0;
        while(l<=r){
            int m = l+(r-l)/2;
            int tmp = reader.get(m);
            if(tmp == target){
                return m;
            }else if(tmp > target){
                r = m-1;
            }else{
                //tmp<target
                l = m+1;
            }
        }
        return -1;
    }

    interface ArrayReader {
         public int get(int index);
     }
}
