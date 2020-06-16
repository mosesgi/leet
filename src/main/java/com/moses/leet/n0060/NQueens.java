package com.moses.leet.n0060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> res =new ArrayList<>();
        for(int i=0; i<board.length; i++){
            Arrays.fill(board[i], '.');
        }
        dfs(board, 0, res);
        return res;
    }

    void dfs(char[][] board, int row, List<List<String>> res){
        if(row == board.length){
            res.add(convert(board));
            return;
        }
        for(int i=0; i<board[row].length; i++){
            if(board[row][i] != '.'){
                continue;
            }
            if(!valid(row, i, board)){
                continue;
            }
            board[row][i] = 'Q';
            dfs(board, row+1, res);
            board[row][i] = '.';
        }
    }

    private boolean valid(int x, int y, char[][] board) {
        for(int i=0; i<x; i++){
            if(board[i][y] == 'Q'){
                return false;
            }
        }
        int i=x, j = y;
        while(i>0 && j>0){
            if(board[i-1][j-1] == 'Q'){
                return false;
            }
            i--;
            j--;
        }
        i=x; j=y;
        while(i>0 && j<board[0].length-1){
            if(board[i-1][j+1] == 'Q'){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    private List<String> convert(char[][] board) {
        List<String> l = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            l.add(new String(board[i]));
        }
        return l;
    }




    List<List<String>> list = new ArrayList<>();
    public List<List<String>> solveNQueensOld(int n){
        char[][] array = new char[n][n];
        recursiveSolve(array, n, 0);
        return list;
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


    public static void main(String[] args) {

        List<List<String>> result = new NQueens().solveNQueens(4);
        for(List<String> l : result){
            for(String s: l){
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
