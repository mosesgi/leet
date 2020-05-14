package com.moses.leet.n0300;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        // -1 dead->live; 2 live -> dead;
        if(board.length == 0 ||board[0].length == 0){
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        int[][] directions = new int[][]{
                {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}
        };
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int cnt = 0;
                for(int[] dir : directions){
                    int x = i+dir[0];
                    int y = j+dir[1];
                    if(x<0 || y<0 || x>=rows || y>=cols){
                        continue;
                    }
                    if(board[x][y] > 0){
                        cnt++;
                    }
                }

                if(board[i][j] == 1){
                    if(cnt <2 || cnt > 3){
                        board[i][j] = 2;
                    }
                }else{
                    if(cnt == 3){
                        board[i][j] = -1;
                    }
                }
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == -1){
                    board[i][j] = 1;
                }else if(board[i][j] == 2){
                    board[i][j] = 0;
                }
            }
        }

    }


    public void gameOfLifeOld(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] ori = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                ori[i][j] = board[i][j];
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int cnt = 0;
                if(i-1>=0){
                    if(j-1>=0 && ori[i-1][j-1] == 1){
                        cnt++;
                    }
                    if(ori[i-1][j] == 1){
                        cnt++;
                    }
                    if(j+1<cols && ori[i-1][j+1] == 1){
                        cnt++;
                    }
                }
                if(j-1>=0){
                    if(ori[i][j-1] == 1){
                        cnt++;
                    }
                    if(i+1<rows && ori[i+1][j-1] == 1){
                        cnt++;
                    }
                }
                if(i+1<rows){
                    if(ori[i+1][j] == 1){
                        cnt++;
                    }
                    if(j+1<cols && ori[i+1][j+1] == 1){
                        cnt++;
                    }
                }
                if(j+1<cols){
                    if(ori[i][j+1] ==1){
                        cnt++;
                    }
                }
                if(ori[i][j] == 1){
                    if(cnt < 2 || cnt >3){
                        board[i][j] = 0;
                    }
                }else{
                    if(cnt == 3){
                        board[i][j] = 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
