package com.moses.leet.n0120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalTriangleII {

    //O(k) only.
    public List<Integer> getRow(int rowIndex){
        List<Integer> row = new ArrayList<>();
        row.add(1);
        if(rowIndex == 0){
            return row;
        }
        row.add(1);
        for(int i=1; i<=rowIndex; i++){
            for(int j=i-1;j>0; j--){
                if(j==i-1){
                    row.add(i-1, row.get(j-1) + row.get(j));
                } else {
                    int tmp = row.get(j-1) + row.get(j);
                    row.remove(j);
                    row.add(j, tmp);
                }
            }
        }
        return row;
    }

    //Is this "extra" O(k) space? O(2k) maybe..
    public List<Integer> getRowInitialVer(int rowIndex){
        List<Integer> prevRow = new ArrayList<>();
        prevRow.add(1);
        if(rowIndex == 0){
            return prevRow;
        }
        List<Integer> currRow = new ArrayList<>();
        for(int i=1; i<=rowIndex; i++){
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    currRow.add(1);
                    continue;
                }
                currRow.add(prevRow.get(j-1)+prevRow.get(j));
            }
            if(i==rowIndex){
                return currRow;
            }
            prevRow.clear();
            prevRow.addAll(currRow);
            currRow.clear();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PascalTriangleII().getRow(0).toArray()));
        System.out.println(Arrays.toString(new PascalTriangleII().getRow(1).toArray()));
        System.out.println(Arrays.toString(new PascalTriangleII().getRow(4).toArray()));
        System.out.println(Arrays.toString(new PascalTriangleII().getRow(5).toArray()));
    }
}
