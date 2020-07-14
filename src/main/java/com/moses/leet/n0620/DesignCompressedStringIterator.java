package com.moses.leet.n0620;

/**
 * Design and implement a data structure for a compressed string iterator. It should support the following operations:
 * next and hasNext.
 *
 * The given compressed string will be in the form of each letter followed by a positive integer representing the number
 * of this letter existing in the original uncompressed string.
 *
 * next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
 * hasNext() - Judge whether there is any letter needs to be uncompressed.
 *
 * Note:
 * Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted
 * across multiple test cases. Please see here for more details.
 *
 * Example:
 *
 * StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
 *
 * iterator.next(); // return 'L'
 * iterator.next(); // return 'e'
 * iterator.next(); // return 'e'
 * iterator.next(); // return 't'
 * iterator.next(); // return 'C'
 * iterator.next(); // return 'o'
 * iterator.next(); // return 'd'
 * iterator.hasNext(); // return true
 * iterator.next(); // return 'e'
 * iterator.hasNext(); // return false
 * iterator.next(); // return ' '
 *
 */
public class DesignCompressedStringIterator {
    class StringIterator {
        String str;
        int p;
        char currChar;
        int remainNum;
        public StringIterator(String compressedString) {
            this.str = compressedString;
            this.p = 0;
            currChar = str.charAt(p++);
            remainNum = str.charAt(p++) - '0';
            while(p<str.length() && Character.isDigit(str.charAt(p))){
                remainNum = remainNum*10 + (str.charAt(p++) - '0');
            }
        }

        public char next() {
            if(remainNum > 0){
                remainNum--;
                char tmp = currChar;
                if(remainNum == 0){
                    if(p == str.length()){
                        currChar = ' ';
                        return tmp;
                    }
                    currChar = str.charAt(p++);
                    remainNum = str.charAt(p++) - '0';
                    while(p<str.length() && Character.isDigit(str.charAt(p))){
                        remainNum = remainNum*10 + (str.charAt(p++) - '0');
                    }
                }
                return tmp;
            }else{
                return ' ';
            }
        }

        public boolean hasNext() {
            return remainNum > 0;
        }
    }
}
