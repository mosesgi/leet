package com.moses.leet.n0240;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    class MyStack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            if(q1.isEmpty() && q2.isEmpty()){
                q1.offer(x);
            } else if(!q1.isEmpty()){
                q1.offer(x);
            } else {
                q2.offer(x);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            Queue<Integer> fullQueue, emptyQueue;
            if(q1.isEmpty()){
                fullQueue = q2;
                emptyQueue = q1;
            } else {
                fullQueue = q1;
                emptyQueue = q2;
            }
            int size = fullQueue.size();

            for(int i=0; i<size-1; i++){
                emptyQueue.offer(fullQueue.poll());
            }
            return fullQueue.poll();
        }

        /** Get the top element. */
        public int top() {
            Queue<Integer> fullQueue, emptyQueue;
            if(q1.isEmpty()){
                fullQueue = q2;
                emptyQueue = q1;
            } else {
                fullQueue = q1;
                emptyQueue = q2;
            }
            int size = fullQueue.size();

            int tmp = 0;
            for(int i=0; i<size; i++){
                tmp = fullQueue.poll();
                emptyQueue.offer(tmp);
            }
            return tmp;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

    public static void main(String[] args) {
        ImplementStackUsingQueue s = new ImplementStackUsingQueue();
        MyStack stack = s.new MyStack();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());   // returns 2
        System.out.println(stack.pop());   // returns 2
        System.out.println(stack.empty()); // returns false
    }

}
