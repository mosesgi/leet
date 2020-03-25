package com.moses.leet.n0540;

import com.moses.leet.utils.PrintUtil;

public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return board;
        }
        int[][] directions = new int[][]{
                {1,0}, {-1,0},{0,1},{0,-1},{-1,1},{-1,-1},{1,1},{1,-1}
        };
        dfs(board, x, y, directions);
        return board;
    }

    private void dfs(char[][] board, int x, int y, int[][] directions) {
        int rows = board.length;
        int cols = board[0].length;
        int mines = 0;
        for(int[] direct: directions){
            int tmpX = x + direct[0];
            int tmpY = y + direct[1];
            if(tmpX <0 || tmpX>=rows || tmpY <0 || tmpY >=cols){
                continue;
            }
            if(board[tmpX][tmpY] == 'M'){
                mines++;
            }
        }
        if(mines > 0){
            board[x][y] = (char)(mines + '0');
        }else{
            board[x][y] = 'B';
            for(int[] direct: directions){
                int tmpX = x + direct[0];
                int tmpY = y + direct[1];
                if(tmpX <0 || tmpX>=rows || tmpY <0 || tmpY >=cols){
                    continue;
                }
                if(board[tmpX][tmpY] == 'B'){
                    continue;
                }
                dfs(board, tmpX, tmpY, directions);
            }
        }
    }

    public static void main(String[] args) {
        char[][] board;
        int[] click;
        board = new char[][]{{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        click = new int[]{3,0};
        board = new Minesweeper().updateBoard(board, click);
        PrintUtil.printMatrixChar(board);
    }
}
