package com.moses.leet.n0980;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        //3,2,4,1
        //4,2,3,1; 1,3,2,4
        //3,1,2,4; 2,1,3,4
        //1,2,3,4

        List<Integer> l = new ArrayList<>();
        for(int i : A){
            l.add(i);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=A.length; i>=2; i--){
            //find i, switch if it's not 1st
            int pos = -1;
            for(int j=0; j<l.size(); j++){
                if(l.get(j) == i){
                    pos = j;
                    break;
                }
            }
            if(pos != 0){
                res.add(pos+1);
                int x=0, y = pos;
                while(x<y){
                    int tmp = l.get(x);
                    l.set(x, l.get(y));
                    l.set(y, tmp);
                    x++;
                    y--;
                }
            }

            //then switch to last pos(i)
            res.add(i);
            int x=0, y = i-1;
            while(x < y){
                int tmp = l.get(x);
                l.set(x, l.get(y));
                l.set(y, tmp);
                x++;
                y--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A;
        A = new int[]{1,2,3};
        System.out.println(new PancakeSorting().pancakeSort(A));

        A = new int[]{3,2,4,1};
        System.out.println(new PancakeSorting().pancakeSort(A));
    }

}
