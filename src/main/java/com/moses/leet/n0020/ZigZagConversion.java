package com.moses.leet.n0020;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * PAYPALISHIRING
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * PAHNAPLSIIGYIR
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if(numRows ==1){
            return s;
        }
        StringBuffer[] sbs = new StringBuffer[numRows];
        int midRows = numRows>2?numRows-2:0;
        for(int i=0; i<sbs.length; i++){
            sbs[i] = new StringBuffer();
        }
        int letterPerFullSet = numRows + midRows;
        int finishedCol = 0;
        int currCol = 1;
        int finishedFullSet = 0;

        for(int i=1; i<=s.length(); i++){
            boolean inFullCol = false;

            if( (currCol - 1) % (numRows -1) == 0){
                inFullCol = true;
            }

            int startingCntAfterFullSet = i<=letterPerFullSet? i:i-finishedFullSet*letterPerFullSet;
            if(inFullCol){
                int row = startingCntAfterFullSet;
                sbs[row-1].append(s.charAt(i-1));
                if(startingCntAfterFullSet%numRows == 0){
                    finishedCol++;
                    currCol++;
                    if(finishedCol == (numRows -1) || finishedCol>=numRows && finishedCol%(numRows-1)==0){
                        finishedFullSet++;
                    }
                }
            } else {
                int row = numRows - (startingCntAfterFullSet - numRows);
                sbs[row-1].append(s.charAt(i-1));
                finishedCol++;
                currCol++;
                if(finishedCol == (numRows -1) || finishedCol>=numRows && finishedCol%(numRows-1)==0){
                    finishedFullSet++;
                }
            }
        }

        StringBuffer result = new StringBuffer();
        for(StringBuffer sb: sbs){
            result.append(sb);
        }
        return result.toString();
    }


    public String convertOfficial(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }


    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int num = 3;

        System.out.println(new ZigZagConversion().convert(s, num));

        s="PAYPALISHIRING";
        num=4;
        System.out.println(new ZigZagConversion().convert(s, num));

    }
}
