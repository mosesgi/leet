package com.moses.leet.n0740;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, oldColor, newColor, visited);
        return image;
    }

    int[][] directions = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
    void dfs(int[][] image, int sr, int sc, int oldColor, int newColor, boolean[][] visited) {
        if(sr < 0 || sc < 0 || sr >=image.length || sc >= image[0].length){
            return;
        }
        if(image[sr][sc] != oldColor || visited[sr][sc]){
            return;
        }

        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        for(int[] dir : directions){
            dfs(image, sr+dir[0], sc+dir[1], oldColor, newColor, visited);
        }
    }


//    int[][] directions = new int[][]{
//            {-1, 0}, {0, -1}, {1, 0}, {0,1}
//    };
    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        if(sr < 0 || sr >= image.length || sc<0 || sc >=image[0].length){
            return image;
        }
        if(image[sr][sc] == newColor){
            return image;
        }
        int originColor = image[sr][sc];
        image[sr][sc] = newColor;
        for(int[] dir : directions){
            int x = sr + dir[0];
            int y = sc + dir[1];
            if(x<0 || x>=image.length || y<0 || y>=image[0].length){
                continue;
            }
            if(image[x][y] == originColor){
                floodFill(image, x, y, newColor);
            }
        }
        return image;
    }
}
