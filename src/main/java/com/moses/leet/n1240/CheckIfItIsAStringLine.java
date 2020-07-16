package com.moses.leet.n1240;

public class CheckIfItIsAStringLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[1][0] - coordinates[0][0];
        int y1 = coordinates[1][1] - coordinates[0][1];

        for(int i=2; i<coordinates.length; i++){
            int x2 = coordinates[i][0] - coordinates[0][0];
            int y2 = coordinates[i][1] - coordinates[0][1];

            if(x1*y2 != y1*x2){
                return false;
            }
        }
        return true;
    }
}
