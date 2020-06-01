package com.moses.leet.n1120;

public class DistributeCandiesToPeople {
    public int[] distributeCandiesWRONG(int candies, int num_people) {
        // 1, 2, 3, 4, 5, 6, 7
        // 8, 9,10,11,12,13,14
        //15,16,17,18,19,20,21
        //22,23
        int rows = candies/num_people;
        int lastCol = candies%num_people;

        int[] res = new int[num_people];
        int first = 1;
        for(int i=1; i<=rows; i++){
            res[0] += first;
            first += num_people;
        }
        for(int i=1; i<res.length; i++){
            res[i] = res[i-1] + rows;
        }

        int base = rows * num_people + 1;
        for(int i=0; i<lastCol; i++){
            res[i] += base + i;
        }
        return res;
    }
}
