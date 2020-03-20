package com.moses.leet.n0500;

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sumReduce = 0;
        for(int i=0; i<timeSeries.length-1; i++){
            int curr = timeSeries[i];
            int next = timeSeries[i+1];
            if(next-curr < duration){
                sumReduce += (duration - (next-curr));
            }
        }
        return duration* timeSeries.length - sumReduce;
    }

    public static void main(String[] args) {
        int[] timeSeries; int duration;
        timeSeries = new int[]{1,2};
        duration = 2;
        System.out.println(new TeemoAttacking().findPoisonedDuration(timeSeries, duration));
    }
}
