package com.moses.leet.n0120;

import com.moses.leet.utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * 杨辉三角
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rst = new ArrayList<>();
        if(numRows == 0){
            return rst;
        }
        for(int i=0; i<numRows; i++){
            List<Integer> l = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    l.add(1);
                } else {
                    List<Integer> prev = rst.get(i-1);
                    l.add(prev.get(j-1) + prev.get(j));
                }
            }
            rst.add(l);
        }
        return rst;
    }

    public static void main(String[] args) {
        PrintUtil.printNestedList(new PascalTriangle().generate(5));
    }
}
