package com.moses.leet.n0140;

/**
 * https://leetcode.com/problems/candy/
 */
public class Candy {
    public int candy(int[] ratings) {
        if(ratings.length == 1){
            return 1;
        }
        int[] candies = new int[ratings.length];
        for(int i=0; i<ratings.length; i++){
            candies[i] = -1;
        }
        //1. find  1s, assign 1
        //2. find peak between two 1s, assign 0
        for(int i=0; i<ratings.length; i++){
            if(i==0){
                if(ratings[i] <= ratings[i+1]){
                    candies[i] = 1;
                } else if(ratings[i] > ratings[i+1]){
                    candies[i] = 0;
                }
                continue;
            }
            if(i==ratings.length-1){
                if(ratings[i] <= ratings[i-1]){
                    candies[i] = 1;
                } else if(ratings[i] > ratings[i-1]){
                    candies[i] = 0;
                }
                continue;
            }
            if(ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1]){
                candies[i] = 1;
            } else if(ratings[i] > ratings[i-1] && ratings[i] > ratings[i+1]){
                candies[i] = 0;
            } else if((ratings[i] -ratings[i-1]) * (ratings[i] -ratings[i+1]) < 0 ){
                candies[i] = -1;
            } else{
                //two ratings are same peak
                if(i+1<=ratings.length-2 && ratings[i] == ratings[i+1] && ratings[i] > ratings[i-1] && ratings[i+1] > ratings[i+2]){
                    candies[i] = 0;
                    candies[i+1] = 0;
                    i = i+1;
                }
            }
        }
        //3. assign candies
        for(int i=0; i<candies.length; i++){
            if(candies[i] == 1){
                int j = i+1;
                while(j<candies.length && candies[j] ==-1){
                    candies[j] = candies[j-1] + 1;
                    j++;
                }
                i=j-1;
            }
        }
        for(int i=candies.length-1; i>=0; i--){
            if(candies[i] == 1){
                int j = i-1;
                while(j>=0 && candies[j] == -1){
                    candies[j] = candies[j+1] + 1;
                    j--;
                }
                i=j+1;
            }
        }
        for(int i=0; i<candies.length; i++){
            if(candies[i] == 0){
                int left = i==0?0:candies[i-1];
                candies[i] = left+1;

                if(i<candies.length-1 && candies[i+1] == 0){        //two ratings are same peak.
                    candies[i+1] = candies[i+2]+1;
                    i = i+1;
                } else {
                    int right = i == candies.length - 1 ? 0 : candies[i + 1];
                    candies[i] = Math.max(left, right) + 1;
                }
            }
        }

        //4. sum
        int total = 0;
        for(int i=0; i<candies.length;i++){
            total +=candies[i];
        }
        return total;
    }


    public static void main(String[] args) {
        int[] ratings = new int[]{1,0,2};
        System.out.println(new Candy().candy(ratings)); //5.   2,1,2

        ratings = new int[]{1,2,2};
        System.out.println(new Candy().candy(ratings)); //4.    1,2,1

        ratings = new int[]{1,1};
        System.out.println(new Candy().candy(ratings)); //2

        ratings = new int[]{3,2,4,6,1,2,6,8,7,6,5,2,3,5,1};
                        //  2,1,2,3,1,2,3,5,4,3,2,1,2,3,1     35
        System.out.println(new Candy().candy(ratings));

        ratings = new int[]{29,51,87,87,72,12};     //1,2,3,3,2,1   12
        System.out.println(new Candy().candy(ratings));

        ratings = new int[]{5,10,10,10,10,10,10};     //1,2,1,1,1,1,1   8
        System.out.println(new Candy().candy(ratings));
    }
}
