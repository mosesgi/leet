package com.moses.leet.n0480;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int ones = 0;
        int connected = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    ones++;
                    if(i-1>=0 && grid[i-1][j] == 1){
                        connected++;
                    }
                    if(j-1>=0 && grid[i][j-1] == 1){
                        connected++;
                    }
                }
            }
        }
        return ones*4 - connected*2;
    }


    public int islandPerimeter1(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        int sum = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] != 1){
                    continue;
                }
                int tmpReduce = 0;
                if(i-1>=0 && grid[i-1][j] == 1){
                    tmpReduce++;
                }
                if(j-1>=0 && grid[i][j-1] == 1){
                    tmpReduce++;
                }
                if(i+1 < rows && grid[i+1][j] == 1){
                    tmpReduce++;
                }
                if(j+1 < cols && grid[i][j+1] == 1){
                    tmpReduce++;
                }
                System.out.println(4-tmpReduce);
                sum += (4-tmpReduce);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid;
        grid = new int[][]{{0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}};
        System.out.println(new IslandPerimeter().islandPerimeter(grid));
    }
}
