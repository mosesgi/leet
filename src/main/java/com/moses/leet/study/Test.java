package com.moses.leet.study;

import com.moses.leet.pojo.TreeNode;

import java.util.*;

public class Test {

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


    public static void main(String[] args) {

    }
}
