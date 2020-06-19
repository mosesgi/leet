package com.moses.leet.n0720;

import java.util.Stack;

/**
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 *
 *     push(x) -- Push element x onto stack.
 *     pop() -- Remove the element on top of the stack and return it.
 *     top() -- Get the element on the top.
 *     peekMax() -- Retrieve the maximum element in the stack.
 *     popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
 *
 * Example 1:
 *
 * MaxStack stack = new MaxStack();
 * stack.push(5);
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 *
 * Note:
 *
 *     -1e7 <= x <= 1e7
 *     Number of operations won't exceed 10000.
 *     The last four operations won't be called when stack is empty.
 *
 */
public class MaxStack {
    Stack<Integer> origin = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();
    /** initialize your data structure here. */
    public MaxStack() {

    }

    public void push(int x) {
        int max = x;
        if(!maxStack.isEmpty()){
            max = Math.max(max, maxStack.peek());
        }
        origin.push(x);
        maxStack.push(max);
    }

    public int pop() {
        maxStack.pop();
        return origin.pop();
    }

    public int top() {
        return origin.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        Stack<Integer> tmpOrigin = new Stack<>();
        int max = maxStack.peek();
        while(max!=origin.peek()){
            tmpOrigin.push(origin.pop());
            maxStack.pop();
        }
        int ret = origin.pop();
        maxStack.pop();
        while(!tmpOrigin.isEmpty()){
            int cur = tmpOrigin.pop();
            int tmpMax= cur;
            if(!maxStack.isEmpty()){
                tmpMax = Math.max(tmpMax, maxStack.peek());
            }
            maxStack.push(tmpMax);
            origin.push(cur);
        }
        return ret;
    }
}
