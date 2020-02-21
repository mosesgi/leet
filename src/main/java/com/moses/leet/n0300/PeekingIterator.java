package com.moses.leet.n0300;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    Integer peek = null;
    Iterator<Integer> origin;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        origin = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(peek == null){
            this.peek = origin.next();
        }
        return this.peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(peek != null){
            int tmp = peek;
            peek = null;
            return tmp;
        }
        return origin.next();
    }

    @Override
    public boolean hasNext() {
        if(peek != null){
            return true;
        }
        return origin.hasNext();
    }
}
