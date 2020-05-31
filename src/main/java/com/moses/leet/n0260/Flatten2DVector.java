package com.moses.leet.n0260;

/**
 * Design and implement an iterator to flatten a 2d vector. It should support the following operations: next and hasNext.
 *
 *  
 *
 * Example:
 *
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 *
 * iterator.next(); // return 1
 * iterator.next(); // return 2
 * iterator.next(); // return 3
 * iterator.hasNext(); // return true
 * iterator.hasNext(); // return true
 * iterator.next(); // return 4
 * iterator.hasNext(); // return false
 *  
 *
 * Notes:
 *
 * Please remember to RESET your class variables declared in Vector2D, as static/class variables are persisted across multiple test cases. Please see here for more details.
 * You may assume that next() call will always be valid, that is, there will be at least a next element in the 2d vector when next() is called.
 *  
 *
 * Follow up:
 *
 * As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */
public class Flatten2DVector {
    class Vector2D {
        Integer next;
        int[][] v;
        int row, col;
        public Vector2D(int[][] v) {
            next = null;
            this.v = v;
            for(int i=0; i<v.length; i++){
                if(v[i].length==0){
                    continue;
                } else {
                    next = v[i][0];
                    row = i;
                    col = 0;
                    break;
                }
            }

        }

        public int next() {
            int tmp = next;
            if(col+1 < v[row].length){
                col++;
                next = v[row][col];
            }else{
                boolean found = false;
                for(int i=row+1; i<v.length; i++){
                    if(v[i].length==0){
                        continue;
                    }else {
                        found = true;
                        next = v[i][0];
                        row = i;
                        col = 0;
                        break;
                    }
                }
                if(!found){
                    next = null;
                }
            }
            return tmp;
        }

        public boolean hasNext() {
            return next != null;
        }
    }

    public static void main(String[] args) {
        Flatten2DVector f = new Flatten2DVector();
        int[][] v;
        v = new int[][]{
                {1,2},{3},{4}
        };
        Vector2D v2 = f.new Vector2D(v);
        System.out.println(v2.next());
        System.out.println(v2.next());
        System.out.println(v2.next());
        System.out.println(v2.hasNext());
        System.out.println(v2.hasNext());
        System.out.println(v2.next());
        System.out.println(v2.hasNext());
    }
}
