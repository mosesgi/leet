package com.moses.leet.n0300;

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
