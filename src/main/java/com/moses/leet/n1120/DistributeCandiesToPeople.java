package com.moses.leet.n1120;

public class DistributeCandiesToPeople {
    public int[] distributeCandiesWRONG(int candies, int num_people) {
        // 1, 2, 3, 4, 5, 6, 7
        // 8, 9,10,11,12,13,14
        //15,16,17,18,19,20,21
        //22,23
        int[] res = new int[num_people];
        int idx = 0;
        int cur = 1;
        while(candies > 0){
            int candy = Math.min(cur, candies);
            res[idx++] += candy;
            candies -= candy;
            cur++;
            if(idx == num_people){
                idx = 0;
            }
        }
        return res;
    }
}
