package com.moses.leet.n0420;

public class BattleshipsInBoard {
    public int countBattleships(char[][] board) {
        int cnt = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] != 'X'){
                    continue;
                }
                if(i-1>=0 && board[i-1][j] == 'X') {
                    continue;
                }
                if(j-1 >=0 && board[i][j-1] == 'X'){
                    continue;
                }
                cnt++;
            }
        }
        return cnt;
    }

    //This is O(N) space.
    public int countBattleshipsONSpace(char[][] board) {
        int rows = board.length;
        if(rows == 0){
            return 0;
        }
        int cols = board[0].length;
        if(cols == 0){
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        int cnt = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == '.'){
                    continue;
                } else if(visited[i][j]){
                    continue;
                }
                int x = i;
                int y = j;
                cnt++;
                while(x+1 < rows && board[x+1][j] == 'X'){
                    visited[x+1][j] = true;
                    x++;
                }
                while(y+1 < cols && board[x][y+1] == 'X'){
                    visited[x][y+1] = true;
                    y++;
                }
            }
        }
        return cnt;
    }


}
