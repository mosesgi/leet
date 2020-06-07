package com.moses.leet.lcci;

import java.util.LinkedList;

public class MaxValueInQueue {
    class MaxQueue {
        //5,1,2,3,6,5,8
        //6,5,
        LinkedList<Integer> origin = new LinkedList<>();
        LinkedList<Integer> maxQueue = new LinkedList<>();
        public MaxQueue() {

        }

        public int max_value() {
            if(maxQueue.isEmpty()){
                return -1;
            }
            return maxQueue.peekFirst();
        }

        public void push_back(int value) {
            origin.addLast(value);
            while(!maxQueue.isEmpty() && maxQueue.peekLast() < value){
                maxQueue.pollLast();
            }
            maxQueue.addLast(value);
        }

        public int pop_front() {
            if(origin.isEmpty()){
                return -1;
            }
            int first= origin.pollFirst();
            if(first == maxQueue.peekFirst()){
                maxQueue.pollFirst();
            }
            return first;
        }
    }
}
