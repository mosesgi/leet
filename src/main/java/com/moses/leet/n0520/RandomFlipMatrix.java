package com.moses.leet.n0520;

import java.util.*;

public class RandomFlipMatrix {
    class Solution {
        Map<Integer, Integer> swapped = new HashMap<>();
        int rows, cols, total;
        Random r = new Random();
        public Solution(int n_rows, int n_cols) {
            this.rows = n_rows;
            this.cols = n_cols;
            reset();
        }

        public int[] flip() {
            int idx = r.nextInt(total);
            total--;
            int actual = swapped.getOrDefault(idx, idx);
            swapped.put(idx, swapped.getOrDefault(total, total));    //the last one might have been switched before.
            return new int[]{actual/cols, actual%cols};
        }

        public void reset() {
            total = rows * cols;
            swapped.clear();
        }
    }

    public static void main(String[] args) {
        Solution s;
        s = new RandomFlipMatrix().new Solution(2,2);
        System.out.println(Arrays.toString(s.flip()));
        System.out.println(Arrays.toString(s.flip()));
        System.out.println(Arrays.toString(s.flip()));
        System.out.println(Arrays.toString(s.flip()));

        s = new RandomFlipMatrix().new Solution(10000,10000);
        System.out.println(Arrays.toString(s.flip()));
        System.out.println(Arrays.toString(s.flip()));
        System.out.println(Arrays.toString(s.flip()));
        System.out.println(Arrays.toString(s.flip()));
        System.out.println(Arrays.toString(s.flip()));
        System.out.println(Arrays.toString(s.flip()));
        System.out.println(Arrays.toString(s.flip()));
    }

}
