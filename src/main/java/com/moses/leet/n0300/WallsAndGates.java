package com.moses.leet.n0300;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 *     -1 - A wall or an obstacle.
 *     0 - A gate.
 *     INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 *
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * Example:
 *
 * Given the 2D grid:
 *
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 *
 * After running your function, the 2D grid should be:
 *
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 *
 */
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        for(int i=0; i<rooms.length; i++){
            for(int j=0; j<rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    int[][] directions = new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    void dfs(int[][] rooms, int i, int j, int step){
        for(int[] dir: directions){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || x>= rooms.length || y<0 || y>=rooms[0].length || rooms[x][y] <= step+1){
                continue;
            }
            rooms[x][y] = step+1;
            dfs(rooms, x, y, step+1);
        }
    }

    public static void main(String[] args) {
        int[][] rooms;
        rooms = new int[][]{{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        new WallsAndGates().wallsAndGates(rooms);

    }
}
