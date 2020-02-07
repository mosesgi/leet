package com.moses.leet.n0160;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinStack {
    private LinkedList<Integer> list;
    private ArrayList<Integer> minList;
    int size;

    /** initialize your data structure here. */
    public MinStack() {
        list = new LinkedList<>();
        minList = new ArrayList<>();
        size = 0;
    }

    public void push(int x) {
        list.addLast(x);
        if(size == 0){
            minList.add(x);
        } else {
            minList.add(Math.min(minList.get(size-1), x));
        }
        size++;
    }

    public void pop() {
        list.removeLast();
        minList.remove(size-1);
        if(size>0){
            size--;
        }
    }

    public int top() {
        return list.getLast();
    }

    public int getMin() {
        return minList.get(size-1);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-5);
        minStack.push(-3);
        System.out.println(minStack.getMin());      //Returns -3.
        minStack.pop();
        System.out.println(minStack.top());         //Returns -5.
        System.out.println(minStack.getMin());      //Returns -5.

        minStack.pop();
        System.out.println(minStack.top());         //Returns 0.
        System.out.println(minStack.getMin());      //Returns -2.
    }
}
