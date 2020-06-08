package com.moses.leet.lcci;

//https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
public class RobotMovingRange {

    int[][] directions = new int[][]{
            {-1,0},{1,0},{0,-1},{0,1}
    };
    int res= 0;
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        dfs(0,0,m,n,visited, k);
        return res;
    }

    void dfs(int x, int y, int m, int n, boolean[][] visited, int k){
        if(x<0 || y<0 || x>=m || y>=n || visited[x][y]){
            return;
        }
        int tmpX = x, tmpY = y;
        int sum = 0;
        while(tmpX > 0){
            sum += tmpX%10;
            tmpX/=10;
        }
        while(tmpY > 0){
            sum += tmpY%10;
            tmpY/=10;
        }
        if(sum > k){
            return;
        }
        visited[x][y] = true;
        res++;
        for(int[] d : directions){
            dfs(x+d[0], y+d[1], m, n, visited, k);
        }
    }
}
