package com.moses.leet.n0080;

/**
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        if(rows == 0){
            return false;
        }
        int cols = board[0].length;
        if(cols==0){
            return false;
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean rst = find(board, i, j, word, 0);
                    if(rst){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean find(char[][] board, int currI, int currJ, String word, int currPos){
        char currChar = word.charAt(currPos);
        if(currChar != board[currI][currJ]){
            return false;
        }
        if(currPos == word.length()-1){
            return true;
        }

        board[currI][currJ] = '.';
        boolean rst = false;

        if(currI > 0 && find(board, currI-1, currJ, word, currPos+1)){
            rst = true;
        }
        if(!rst && currJ > 0 && find(board, currI, currJ-1, word, currPos+1)){
            rst = true;
        }
        if(!rst && currI + 1 < board.length && find(board, currI+1, currJ, word, currPos+1)){
            rst = true;
        }
        if(!rst && currJ + 1 < board[0].length && find(board, currI, currJ+1, word, currPos+1)){
            rst = true;
        }
        board[currI][currJ] = currChar;
        return rst;
    }

//    private char[][] copyBoard(char[][] board){
//        char[][] newB = new char[board.length][board[0].length];
//        for(int i=0; i<board.length; i++){
//            for(int j=0; j<board[0].length; j++){
//                newB[i][j] = board[i][j];
//            }
//        }
//        return newB;
//    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println(new WordSearch().exist(board, word));

        word = "SEE";
        System.out.println(new WordSearch().exist(board, word));

        word = "ABCB";
        System.out.println(new WordSearch().exist(board, word));

        board = new char[][]{{'a'}};
        word = "a";
        System.out.println(new WordSearch().exist(board, word));

        board = new char[][]{{'a', 'a'}};
        word = "aa";
        System.out.println(new WordSearch().exist(board, word));
    }
}
