package com.moses.leet.n0300;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
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
