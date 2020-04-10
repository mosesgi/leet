package com.moses.leet.n0740;

public class FloodFill {
    int[][] directions = new int[][]{
            {-1, 0}, {0, -1}, {1, 0}, {0,1}
    };
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
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
