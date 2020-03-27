package com.moses.leet.n0640;

public class MyCircularQueue {
    int[] mem;
    int count;
    int size;
    int beginPos;
    int endPos;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        mem = new int[k];
        count = 0;
        size = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(count==size){
            return false;
        }
        if(count == 0){
            mem[0] = value;
            beginPos=0;
            endPos = 0;
        }else{
            endPos++;
            if(endPos == size){
                endPos = 0;
            }
            mem[endPos] = value;
        }
        count++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(count==0){
            return false;
        }
        beginPos++;
        if(beginPos == size){
            beginPos = 0;
        }
        count--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(count ==0){
            return -1;
        }
        return mem[beginPos];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(count ==0){
            return -1;
        }
        return mem[endPos];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count ==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count==size;
    }
}
