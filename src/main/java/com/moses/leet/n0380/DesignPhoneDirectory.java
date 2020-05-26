package com.moses.leet.n0380;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class DesignPhoneDirectory {
    class PhoneDirectory {
        LinkedHashSet<Integer> used;
        LinkedHashSet<Integer> unused;
        /** Initialize your data structure here
         @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
        public PhoneDirectory(int maxNumbers) {
            used = new LinkedHashSet<>();
            unused = new LinkedHashSet<>();
            for(int i=0; i<maxNumbers; i++){
                unused.add(i);
            }
        }

        /** Provide a number which is not assigned to anyone.
         @return - Return an available number. Return -1 if none is available. */
        public int get() {
            Iterator<Integer> iter = unused.iterator();
            if(iter.hasNext()){
                int tmp = iter.next();
                iter.remove();
                used.add(tmp);
                return tmp;
            }else{
                return -1;
            }
        }

        /** Check if a number is available or not. */
        public boolean check(int number) {
            return unused.contains(number);
        }

        /** Recycle or release a number. */
        public void release(int number) {
            used.remove(number);
            unused.add(number);
        }
    }
}
