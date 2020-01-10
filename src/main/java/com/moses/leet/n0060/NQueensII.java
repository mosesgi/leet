package com.moses.leet.n0060;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens-ii/
 */
public class NQueensII {

    List<List<String>> list = new ArrayList<>();

    public int totalNQueens(int n){
        char[][] array = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                array[i][j] = '.';
            }
        }
        recursive(array, n, 0);
        return list.size();
    }

    private void recursive(char[][] array, int n, int row){
        if(row == n){
            List<String> l = new ArrayList<>();
            for(int i=0; i<n; i++){
                l.add(String.valueOf(array[i]));
            }
            list.add(l);
            return;
        }
        for(int i=0; i<n; i++){
            if(isQValid(array, n, row, i)){
                array[row][i] = 'Q';
                recursive(array, n, row+1);
                array[row][i] = '.';
            }
        }
    }

    private boolean isQValid(char[][] array, int n, int row, int col) {
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==row && j==col){
                    continue;
                }
                if(row==i && array[i][j]=='Q'){
                    return false;
                }
                if(col==j && array[i][j]=='Q'){
                    return false;
                }
                if(i-row==j-col && array[i][j] == 'Q'){
                    return false;
                }
                if(row-i == j-col && array[i][j] == 'Q'){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueensII().totalNQueens(4));
    }







    public int totalNQueensWithI(int n){
        char[][] array = new char[n][n];
        recursiveSolve(array, n, 0);
        return list.size();
    }

    private void recursiveSolve(char[][] array, int n, int row){
        if(row == array.length){
            List<String> l = new ArrayList<>();
            for(int i=0; i<array.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<array[i].length; j++){
                    if(array[i][j] == 0){
                        sb.append('.');
                    }else {
                        sb.append(array[i][j]);
                        array[i][j] = 0;
                    }
                }
                l.add(sb.toString());
            }
            list.add(l);
            return;
        }
        char[] rowChars = array[row];
        for(int i=0; i<rowChars.length; i++){
            if(rowChars[i] == '.'){
                continue;
            }
            char[][] tmpArray = new char[n][n];
            tmpArray[row][i] = 'Q';
            populateDots(tmpArray, array, row, i);
            recursiveSolve(tmpArray, n,row+1);
        }
    }

    private void populateDots(char[][] tmpArray, char[][] array, int row, int col) {
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length; j++){
                if(array[i][j] != 0){
                    tmpArray[i][j] = array[i][j];
                    continue;
                }
                if(i==row && j==col){
                    continue;
                }
                //same row
                if(row == i){
                    tmpArray[i][j] = '.';
                }
                //same column
                if(col == j){
                    tmpArray[i][j] = '.';
                }
                //slope \
                if(i-row == j-col){
                    tmpArray[i][j] = '.';
                }

                //slope /
                //22: 13, 04, 31, 40
                if(row-i == j-col){
                    tmpArray[i][j] = '.';
                }
            }
        }
    }
}
