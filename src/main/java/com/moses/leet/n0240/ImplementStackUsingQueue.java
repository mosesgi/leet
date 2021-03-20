package com.moses.leet.n0240;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    class MyStack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        Queue<Integer> fullQ, emptyQ;

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            init();
            fullQ.offer(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            init();
            while(fullQ.size() > 1){
                emptyQ.offer(fullQ.poll());
            }
            return fullQ.poll();
        }

        /** Get the top element. */
        public int top() {
            init();
            while(fullQ.size() > 1){
                emptyQ.offer(fullQ.poll());
            }
            int result = fullQ.peek();
            emptyQ.offer(fullQ.poll());
            return result;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        private void init(){
            if(q1.isEmpty() && q2.isEmpty()){
                fullQ = q1;
                emptyQ = q2;
            }else if(q1.isEmpty()) {
                fullQ = q2;
                emptyQ = q1;
            }else if(q2.isEmpty()) {
                fullQ = q1;
                emptyQ = q2;
            }
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
