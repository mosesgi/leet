package com.moses.leet.n0960;

import java.util.*;

public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        List<int[]> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++){
            int[] next = new int[8];
            for(int j=1; j<7; j++){
                if(cells[j-1]==0 && cells[j+1]==0 || cells[j-1]==1 && cells[j+1]==1){
                    next[j] = 1;
                }else{
                    next[j] = 0;
                }
            }
            int key = serialize(next);
            if(set.contains(key)){
                break;
            }
            set.add(key);
            res.add(next);
            cells = next;
        }

        int pos = (N-1)%set.size();
        return res.get(pos);
    }

    int serialize(int[] cells){
        int res = 0;
        for(int i=0; i<cells.length; i++){
            if(cells[i] == 1){
                res |= 1<<i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] cells = new int[]{0,1,0,1,1,0,0,1};
        System.out.println(Arrays.toString(new PrisonCellsAfterNDays().prisonAfterNDays(cells, 100)));
    }
}
