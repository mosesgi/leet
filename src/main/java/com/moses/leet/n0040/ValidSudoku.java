package com.moses.leet.n0040;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board){
        Map<Integer, Set<Character>> rows = new HashMap<>(9);
        Map<Integer, Set<Character>> cols = new HashMap<>(9);
        Map<Integer, Set<Character>> blocks = new HashMap<>(9);

        for(int i=0; i<board.length; i++){
            char[] row = board[i];
            for(int j= 0; j<board[i].length; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                Set<Character> curRow = rows.get(i);
                if(curRow == null){
                    rows.put(i, new HashSet<>());
                    curRow = rows.get(i);
                }
                if(curRow.contains(board[i][j])){
                    return false;
                }else {
                    curRow.add(board[i][j]);
                }

                Set<Character> curCol = cols.get(j);
                if(curCol == null){
                    cols.put(j, new HashSet<>());
                    curCol = cols.get(j);
                }
                if(curCol.contains(board[i][j])){
                    return false;
                }else {
                    curCol.add(board[i][j]);
                }

                int block = calculateBlock(i,j);
                Set<Character> curBlc = blocks.get(block);
                if(curBlc == null){
                    blocks.put(block, new HashSet<>());
                    curBlc = blocks.get(block);
                }

                if(curBlc.contains(board[i][j])){
                    return false;
                }else {
                    curBlc.add(board[i][j]);
                }
            }
        }
        return true;
    }

    // i<3, j<3 -> block 1; i<3, j<6 -> block 2; i<3, j<9 -> block 3;
    // i<6, j<3 -> block 4;....
    private int calculateBlock(int i, int j) {
        if(i<3){
            return j/3+1;
        }
        if(i<6){
            return j/3 + 4;
        }
        if(i<9){
            return j/3 + 7;
        }
        return -1;
    }

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
        System.out.println(new ValidSudoku().isValidSudoku(board));

        board = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(new ValidSudoku().isValidSudoku(board));

    }
}
