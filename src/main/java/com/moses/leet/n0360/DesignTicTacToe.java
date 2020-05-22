package com.moses.leet.n0360;

/**
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 *
 * You may assume the following rules:
 *
 *     A move is guaranteed to be valid and is placed on an empty block.
 *     Once a winning condition is reached, no more moves is allowed.
 *     A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 *
 */
public class DesignTicTacToe {
    class TicTacToe {
        int[][] board;
        int n;
        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            board = new int[n][n];
            this.n = n;
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            board[row][col] = player;
            if(check(row, col, player)){
                return player;
            }
            return 0;
        }

        boolean check(int row, int col, int player){
            //check row
            boolean flag = true;
            for(int i=0; i<n; i++){
                if(board[row][i] != player){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }

            flag = true;
            //check col
            for(int i=0; i<n; i++){
                if(board[i][col] != player){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }

            //check diagonal
            if(row == col){
                flag = true;
                for(int i=0; i<n; i++){
                    if(board[i][i] != player){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    return true;
                }
            }
            if(row == n-col-1){
                flag = true;
                for(int i=0; i<n; i++){
                    if(board[i][n-i-1] != player){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    return true;
                }
            }
            return false;
        }
    }
}
