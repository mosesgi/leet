package com.moses.leet.n0360;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator {

    class NestedIterator implements Iterator<Integer> {

        Stack<Iterator<NestedInteger>> stack = new Stack<>();
        Integer cur = null;
        public NestedIterator(List<NestedInteger> nestedList) {
            stack.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            Integer tmp = cur;
            cur = null;
            return tmp;
        }

        @Override
        public boolean hasNext() {
            if(cur != null){
                return true;
            }
            if(stack.isEmpty()){
                return false;
            }
            if(!stack.isEmpty() && !stack.peek().hasNext()){
                stack.pop();
                return hasNext();
            }
            NestedInteger next = stack.peek().next();
            if(!next.isInteger()){
                stack.push(next.getList().iterator());
                return hasNext();
            }
            cur = next.getInteger();
            return true;
        }
    }


//    class NestedIterator implements Iterator<Integer> {
//        LinkedList<NestedInteger> rst = new LinkedList<>();
//
//        public NestedIterator(List<NestedInteger> nestedList) {
//            rst.addAll(flattern(nestedList));
//        }
//
//        private LinkedList<NestedInteger> flattern(List<NestedInteger> origin){
//            LinkedList<NestedInteger> list = new LinkedList<>();
//            for(NestedInteger ni:origin){
//                if(ni.isInteger()){
//                    list.add(ni);
//                } else {
//                    LinkedList<NestedInteger> next = flattern(ni.getList());
//                    list.addAll(next);
//                }
//            }
//            return list;
//        }
//
//        @Override
//        public Integer next() {
//            return rst.poll().getInteger();
//        }
//
//        @Override
//        public boolean hasNext() {
//            return !rst.isEmpty();
//        }
//    }

    public static void main(String[] args) {

    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}
