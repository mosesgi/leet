package com.moses.leet.n1340;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        for(int i=rows-1; i>=0; i--){
            int ti = i;
            int tj = 0;
            List<Integer> l = new ArrayList<>();
            while(ti < rows && tj < cols){
                l.add(mat[ti++][tj++]);
            }
            Collections.sort(l);
            ti = i; tj = 0;
            int pos = 0;
            while(ti < rows && tj < cols){
                mat[ti++][tj++] = l.get(pos++);
            }
        }

        for(int j=0; j<cols; j++){
            int ti = 0;
            int tj = j;
            List<Integer> l = new ArrayList<>();
            while(ti < rows && tj < cols){
                l.add(mat[ti++][tj++]);
            }
            Collections.sort(l);
            ti = 0; tj = j;
            int pos = 0;
            while(ti < rows && tj < cols){
                mat[ti++][tj++] = l.get(pos++);
            }
        }
        return mat;
    }
}
