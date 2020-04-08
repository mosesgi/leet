package com.moses.leet.n0700;

import java.util.ArrayList;
import java.util.List;

public class FallingSquares {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Square> list = new ArrayList<>();
        for(int[] pos: positions){
            Square s = new Square(pos[0], pos[0]+pos[1], pos[1]);
            list.add(s);
        }

        List<Integer> rst = new ArrayList<>();
        int prevHeight = 0;
        for(int i=0; i<list.size(); i++){
            int curHeight = Math.max(prevHeight, findHeight(list, i));
            prevHeight = curHeight;
            rst.add(curHeight);
        }
        return rst;
    }

    private int findHeight(List<Square> list, int pos) {
        int prevHeight = 0;
        Square cur = list.get(pos);
        for(int i=0; i<pos; i++){
            Square s = list.get(i);
            if(s.end <= cur.start || s.start >=cur.end){
                continue;
            }
            prevHeight = Math.max(prevHeight, s.height);
        }
        cur.height = prevHeight + cur.height;
        return cur.height;
    }


    class Square{
        int start, end, height;

        public Square(int start, int end, int height){
            this.start = start;
            this.end = end;
            this.height= height;
        }
    }
}
