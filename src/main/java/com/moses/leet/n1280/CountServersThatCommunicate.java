package com.moses.leet.n1280;

public class CountServersThatCommunicate {
    public int countServers(int[][] grid) {
        if(grid.length==0 || grid[0].length==0){
            return 0;
        }
        int[] rowCnt = new int[grid.length];
        int[] colCnt = new int[grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    rowCnt[i]++;
                    colCnt[j]++;
                }
            }
        }
        int res = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1 && (rowCnt[i] > 1 || colCnt[j] > 1)){
                    res++;
                }
            }
        }
        return res;
    }
}
