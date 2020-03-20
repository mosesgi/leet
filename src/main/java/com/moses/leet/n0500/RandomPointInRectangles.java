package com.moses.leet.n0500;

import java.util.Arrays;
import java.util.Random;

public class RandomPointInRectangles {

    class Solution {
        int[] areas;
        int[][] rects;
        Random random = new Random();
        public Solution(int[][] rects) {
            this.rects = rects;
            areas = new int[rects.length];
            int prevArea = 0;
            for(int i=0; i<rects.length; i++){
                int[] rect = rects[i];
                int area = (rect[2]-rect[0]+1) * (rect[3]-rect[1]+1);       // +1 !!!!
                areas[i] = prevArea+area;
                prevArea = areas[i];
            }
        }

        public int[] pick() {
            int max = areas[areas.length-1];
            int rand = random.nextInt(max+1);
            int idx = Arrays.binarySearch(areas, rand);
            if(idx < 0){
                idx = -idx-1;
            }
            int[] rect = rects[idx];
            int l = rect[2]-rect[0];
            int w = rect[3]-rect[1];
            int x = random.nextInt(l+1);
            int y = random.nextInt(w+1);
            return new int[]{x+rect[0], y+rect[1]};
        }
    }

    public static void main(String[] args) {
        int[][] rects;
        rects = new int[][]{{82918473, -57180867, 82918476, -57180863}, {83793579, 18088559, 83793580, 18088560}, {66574245, 26243152, 66574246, 26243153}, {72983930, 11921716, 72983934, 11921720}};
        RandomPointInRectangles r = new RandomPointInRectangles();
        Solution s = r.new Solution(rects);
        s.pick();
        s.pick();
    }

}
