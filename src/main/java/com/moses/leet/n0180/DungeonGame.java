package com.moses.leet.n0180;

public class DungeonGame {

    Integer[][] cache;
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        cache = new Integer[rows][cols];

        int rst = recursive(dungeon, 0, 0,  rows, cols);
        return 0-rst+1;
    }

    private int recursive(int[][] dungeon, int row, int col, int rows, int cols) {
        if(row == rows-1 && col == cols-1){
            return dungeon[row][col]>=0?0:dungeon[row][col];
        }
        if(cache[row][col] != null){
            return cache[row][col];
        }

        int next = 0;
        if(row<rows-1 && col<cols-1) {
            next = recursive(dungeon,row + 1, col, rows, cols);
            int next1 = recursive(dungeon, row, col + 1, rows, cols);
            if(next1 > next){
                next = next1;
            }
        } else if(row<rows-1 && col == cols-1){
            next = recursive(dungeon, row+1, col, rows, cols);
        } else if(row==rows-1 && col < cols-1){
            next = recursive(dungeon, row, col+1, rows, cols);
        }
        if(next >=0){
            if(dungeon[row][col] >=0){
                cache[row][col] = 0;
                return 0;
            } else {
                cache[row][col] = dungeon[row][col];
                return dungeon[row][col];
            }
        } else {
            if(dungeon[row][col] + next >= 0){
                cache[row][col] = 0;
                return 0;
            } else{
                cache[row][col] = dungeon[row][col] + next;
                return dungeon[row][col] + next;
            }
        }

    }

    public static void main(String[] args) {
        int[][] dungeon;
        dungeon = new int[][]{
                {100}
        };
        System.out.println(new DungeonGame().calculateMinimumHP(dungeon));

        dungeon = new int[][]{
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        };
        System.out.println(new DungeonGame().calculateMinimumHP(dungeon));

        dungeon = new int[][]{
                {0,-3}
        };
        System.out.println(new DungeonGame().calculateMinimumHP(dungeon));

        dungeon = new int[][]{
                {-3,5}
        };
        System.out.println(new DungeonGame().calculateMinimumHP(dungeon));

        dungeon = new int[][]{
                {2,1}
        };
        System.out.println(new DungeonGame().calculateMinimumHP(dungeon));

        dungeon = new int[][]{
                {2,1},
                {1,-1}
        };
        System.out.println(new DungeonGame().calculateMinimumHP(dungeon));
    }
}
