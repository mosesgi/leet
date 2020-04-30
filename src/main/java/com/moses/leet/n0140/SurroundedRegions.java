package com.moses.leet.n0140;

import com.moses.leet.utils.PrintUtil;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int rows = board.length;
        if(rows <= 1){
            return;
        }
        int cols = board[0].length;
        if(cols <= 1){
            return;
        }

        boolean[][] openBoard = new boolean[rows][cols];
        int topRow = 0, bottomRow = rows-1, leftCol = 0, rightCol = cols-1;

        for(int i=0; i<cols; i++){
            recursive(topRow, i, board, openBoard, rows, cols);
            recursive(bottomRow, i, board, openBoard, rows, cols);
        }

        for(int i=1; i<rows-1; i++){
            recursive(i, leftCol, board, openBoard, rows, cols);
            recursive(i, rightCol, board, openBoard, rows, cols);
        }

        for(int i=0; i<rows; i++){
            for(int j= 0; j<cols; j++){
                if(board[i][j] == 'O' && openBoard[i][j] == false){
                    board[i][j] = 'X';
                }
            }
        }
    }

    //Find out all "OPEN" positions
    private void recursive(int i, int j, char[][] board, boolean[][] openBoard, int rows, int cols){
        if(i<0 || i>=rows || j<0 || j>=cols || openBoard[i][j]){
            return;
        }
        if(board[i][j] == 'O'){
            openBoard[i][j] = true;
            recursive(i+1, j, board, openBoard,rows, cols);
            recursive(i-1, j, board, openBoard,rows, cols);
            recursive(i, j+1, board, openBoard,rows, cols);
            recursive(i, j-1, board, openBoard,rows, cols);
        }
    }


    public static void main(String[] args) {
        char[][] board;

        board = new char[][]{
                {'O','X','O','O','O','O','O','O','O'},
                {'O','O','O','X','O','O','O','O','X'},
                {'O','X','O','X','O','O','O','O','X'},
                {'O','O','O','O','X','O','O','O','O'},
                {'X','O','O','O','O','O','O','O','X'},
                {'X','X','O','O','X','O','X','O','X'},
                {'O','O','O','X','O','O','O','O','O'},
                {'O','O','O','X','O','O','O','O','O'},
                {'O','O','O','O','O','X','X','O','O'}};
        new SurroundedRegions().solve(board);
        PrintUtil.printMatrixChar(board);


        board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        new SurroundedRegions().solve(board);
        PrintUtil.printMatrixChar(board);

        board = new char[][]{
                {'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}
        };
        new SurroundedRegions().solve(board);
        PrintUtil.printMatrixChar(board);

        board = new char[][]{
                {'O','X','X','O','X'},
                {'X','O','O','X','X'},
                {'X','O','X','O','O'},
                {'O','X','O','O','X'},
                {'X','X','X','X','X'}
        };
        new SurroundedRegions().solve(board);
        PrintUtil.printMatrixChar(board);
    }
}
