package com.moses.leet.n1360;

public class CountNegativeNumbersInSortedMatrix {

    public int countNegatives(int[][] grid) {
        int res = 0;
        for(int i=0; i<grid.length; i++){
            int l=0, r = grid[i].length-1;
            while(l<=r){
                int m = l+(r-l)/2;
                if(grid[i][m] >= 0){
                    l = m+1;
                }else if(grid[i][m] < 0){
                    r = m-1;
                }
            }
            res += grid[i].length - l;
        }
        return res;
    }

}
