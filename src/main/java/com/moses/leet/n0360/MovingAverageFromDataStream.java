package com.moses.leet.n0360;

import java.util.LinkedList;

public class MovingAverageFromDataStream {
    class MovingAverage {
        LinkedList<Integer> list = new LinkedList<>();
        int size;
        int sum;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
            this.sum = 0;
        }

        public double next(int val) {
            if(list.size() == size){
                int rem = list.removeFirst();
                sum-=rem;
            }
            list.addLast(val);
            sum+=val;
            return (double)sum/list.size();
        }
    }
}
