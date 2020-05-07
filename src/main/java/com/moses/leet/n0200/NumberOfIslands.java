package com.moses.leet.n0200;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int res = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    void dfs(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = 'X';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }



    public int numIslandsOld(char[][] grid) {
        int rows = grid.length;
        if(rows == 0){
            return 0;
        }
        int cols = grid[0].length;
        if(cols == 0){
            return 0;
        }

        boolean[][] visited = new boolean[rows][cols];
        int cnt = 0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '0'){
                    continue;
                }else if(visited[i][j]){
                    continue;
                }

                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i,j});
                visited[i][j] = true;
                while(!queue.isEmpty()){
                    int[] curr = queue.poll();
                    int tmpI = curr[0];
                    int tmpJ = curr[1];
                    if(tmpI > 0 && grid[tmpI-1][tmpJ] == '1' && !visited[tmpI-1][tmpJ]){
                        visited[tmpI-1][tmpJ] = true;
                        queue.offer(new int[]{tmpI-1,tmpJ});
                    }
                    if(tmpJ > 0 && grid[tmpI][tmpJ-1] == '1' && !visited[tmpI][tmpJ-1]){
                        visited[tmpI][tmpJ-1] = true;
                        queue.offer(new int[]{tmpI, tmpJ-1});
                    }
                    if(tmpI+1 < rows && grid[tmpI+1][tmpJ] == '1' && !visited[tmpI+1][tmpJ]){
                        visited[tmpI+1][tmpJ] = true;
                        queue.offer(new int[]{tmpI+1, tmpJ});
                    }
                    if(tmpJ+1 < cols && grid[tmpI][tmpJ+1] == '1' && !visited[tmpI][tmpJ+1]){
                        visited[tmpI][tmpJ+1] = true;
                        queue.offer(new int[]{tmpI, tmpJ+1});
                    }
                }
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        char[][] grid;

        grid = new char[][]{
                {'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
                {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
                {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
                {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
                {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}
        };
        System.out.println(new NumberOfIslands().numIslands(grid));
    }

}
