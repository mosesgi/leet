package com.moses.leet.n1000;

public class AvailableCapturesForRook {
    public int numRookCaptures(char[][] board) {
        int res = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 'R'){
                    if(dfs(board, i, j, -1, 0)){
                        res++;
                    }
                    if(dfs(board, i, j, 1, 0)){
                        res++;
                    }
                    if(dfs(board, i, j, 0, -1)){
                        res++;
                    }
                    if(dfs(board, i, j, 0, 1)){
                        res++;
                    }
                }
            }
        }
        return res;
    }

    boolean dfs(char[][] board, int x, int y, int incX, int incY){
        while(x+incX >=0 && x+incX < board.length && y+incY >= 0 && y+incY <board[0].length){
            x+=incX;
            y+=incY;
            if(board[x][y] == 'B'){
                return false;
            }else if(board[x][y] == 'p'){
                return true;
            }
        }
        return false;
    }
}
