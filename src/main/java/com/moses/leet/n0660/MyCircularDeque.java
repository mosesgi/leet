package com.moses.leet.n0660;

public class MyCircularDeque {
    int[] array;
    int capacity;
    int size;
    int begin;
    int end;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        array = new int[k];
        this.capacity = k;
        size = 0;
        begin = -1;
        end = -1;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size == capacity){
            return false;
        }
        if(begin == end && begin == -1){
            begin = 0;
            end = 0;
            array[0] = value;
        }else{
            if(begin > 0){
                begin--;
                array[begin] = value;
            }else if(begin == 0){
                begin = capacity-1;
                array[begin] = value;
            }
        }
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size == capacity){
            return false;
        }
        if(begin == end && begin == -1){
            begin = 0;
            end = 0;
            array[0] = value;
        }else{
            if(end < capacity-1){
                end++;
                array[end] = value;
            } else{
                end = 0;
                array[end] = value;
            }
        }
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size == 0){
            return false;
        }
        if(begin < capacity-1){
            begin++;
        }else{
            begin = 0;
        }
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size == 0){
            return false;
        }
        if(end > 0){
            end--;
        }else{
            end = capacity-1;
        }
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(size == 0){
            return -1;
        }
        return array[begin];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(size == 0){
            return -1;
        }
        return array[end];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return capacity == size;
    }


}
