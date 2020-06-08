package com.moses.leet.n1140;

public class Largest1_BorderedSquare {

    int max = 0;
    public int largest1BorderedSquare(int[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] != 0){
                    dfs1(grid, i, j);
                }
            }
        }
        return max;
    }

    void dfs1(int[][] grid, int i, int j){
        int x = i;
        int y = j;
        max = Math.max(max, 1);
        while(x<grid.length-1 && y < grid[0].length-1){
            if(grid[x+1][j] == 1 && grid[i][y+1] == 1){
                x++;
                y++;
                dfs2(grid, i,j,x,y);
            }else{
                return;
            }
        }
    }

    void dfs2(int[][] grid, int i, int j, int x, int y){
        for(int k=i; k<=x; k++){
            if(grid[k][y] == 0 ){
                return;
            }
        }
        for(int k=j; k<=y; k++){
            if(grid[x][k] == 0){
                return;
            }
        }
        max = Math.max(max, (x-i+1) *(x-i+1));
    }
}
