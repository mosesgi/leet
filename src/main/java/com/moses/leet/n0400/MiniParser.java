package com.moses.leet.n0400;

import java.util.List;
import java.util.Stack;

public class MiniParser {
    // [123,[456,[789,3232,32323],8954,898,[8392,232,1121]]]
    // [[[789,3232,32323],8954,898,[8392,232,1121]],323,1489,8588,[2882]]
    public NestedInteger deserialize(String s) {
        if(!s.contains("[")){
            return new NestedInteger(Integer.parseInt(s));
        }
        StringBuilder num = new StringBuilder();
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger rst = null;
        for(char c : s.toCharArray()){
            if(c == '['){
                NestedInteger ni = new NestedInteger();
                if(!stack.isEmpty()){
                    stack.peek().add(ni);
                }
                stack.push(ni);
            } else if(c==']'){
                if(num.length() > 0){
                    int in = Integer.parseInt(num.toString());
                    stack.peek().add(new NestedInteger(in));
                    num.setLength(0);
                }
                rst = stack.pop();
            } else if(c==','){
                if(num.length() > 0) {
                    int in = Integer.parseInt(num.toString());
                    stack.peek().add(new NestedInteger(in));
                    num.setLength(0);
                }
            } else {
                num.append(c);
            }
        }
        return rst;
    }


    class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return true;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return 0;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }
    }
}
