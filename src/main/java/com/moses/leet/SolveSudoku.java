package com.moses.leet;

import java.util.*;

/**
 * https://leetcode.com/problems/sudoku-solver/
 */
public class SolveSudoku {

    public void solveSudoku(char[][] board){
        recursiveSolve(board, null, 0, 0);
    }

    private boolean recursiveSolve(char[][] initialBoard, char[][] board, int currRow, int currCol){
        Set<Character> nine = new TreeSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
        int nextRow = currCol == 8?currRow+1:currRow;
        int nextCol = currCol == 8?0:currCol+1;
        if(nextRow >= 9 && nextCol >=9){
            //assign tmpBoard result to initialBoard
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[i].length; j++){
                    initialBoard[i][j] = board[i][j];
                }
            }
            return true;
        }

        //create tmpBoard for next recursive call.
        char[][] tmpBoard = new char[9][9];
        if(board == null){
            board = initialBoard;
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                tmpBoard[i][j] = board[i][j];
            }
        }

        if(board[currRow][currCol] != '.'){
            boolean rst = recursiveSolve(initialBoard, tmpBoard, nextRow, nextCol);
            if(rst && nextRow >=9){
                //assign tmpBoard result to initialBoard
                for(int i=0; i<board.length; i++){
                    for(int j=0; j<board[i].length; j++){
                        initialBoard[i][j] = board[i][j];
                    }
                }
                return true;
            } else {
                return false;
            }
        }
        //remove numbers from same row
        for(int i=0; i<9; i++){
            if(i==currCol || board[currRow][i] == '.'){
                continue;
            }
            nine.remove(board[currRow][i]);
        }

        //remove numbers from same column
        for(int i=0; i<9; i++){
            if(i==currRow || board[i][currCol] == '.'){
                continue;
            }
            nine.remove(board[i][currCol]);
        }

        //remove numbers from same block
        int rowBegin = 0, rowEnd = 0, colBegin = 0, colEnd = 0;
        if(currRow < 3){
            rowBegin = 0; rowEnd = 2;
        } else if(currRow < 6){
            rowBegin = 3; rowEnd = 5;
        } else if(currRow < 9){
            rowBegin = 6; rowEnd = 8;
        }
        if(currCol < 3){
            colBegin = 0; colEnd = 2;
        } else if(currCol < 6){
            colBegin = 3; colEnd = 5;
        } else if(currCol < 9){
            colBegin = 6; colEnd = 8;
        }
        for(int i = rowBegin; i<=rowEnd; i++){
            for(int j = colBegin; j<=colEnd; j++){
                if(board[i][j] != '.' && i!=currRow && j!=currCol){
                    nine.remove(board[i][j]);
                }
            }
        }

        if(nine.isEmpty()){
            return false;
        }

        List<Character> nineList = new ArrayList<>(nine);
        Collections.sort(nineList);
        for(Character c : nineList){
            tmpBoard[currRow][currCol] = c;
//            print(tmpBoard);
            boolean rst = recursiveSolve(initialBoard, tmpBoard, nextRow, nextCol);
            if(rst){
                return true;
            }
        }
        return false;
    }

//    private boolean isValid(char[][] board){
//
//    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        new SolveSudoku().solveSudoku(board);
        print(board);


        board = new char[][]{
                {'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}
        };
        new SolveSudoku().solveSudoku(board);
        print(board);

    }

    public static void print(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                System.out.print(board[i][j] + ' ');
            }
            System.out.println();
        }
    }
}
