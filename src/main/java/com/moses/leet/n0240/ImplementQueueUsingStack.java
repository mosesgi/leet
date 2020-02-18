package com.moses.leet.n0240;

import java.util.Stack;

public class ImplementQueueUsingStack {

    class MyQueue {
        Stack<Integer> pushStack = new Stack<>();
        Stack<Integer> popStack = new Stack<>();
        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            pushStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(popStack.isEmpty()){
                while(!pushStack.isEmpty()){
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(popStack.isEmpty()){
                while(!pushStack.isEmpty()){
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new ImplementQueueUsingStack().new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty()); // returns false
    }
}
