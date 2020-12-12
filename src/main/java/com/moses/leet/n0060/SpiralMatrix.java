package com.moses.leet.n0060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0){
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int di = 0;
        int x=0, y=0;
        boolean hit = false;
        list.add(matrix[x][y]);
        visited[x][y] = true;
        while(true){
            int nextX = x + directions[di][0];
            int nextY = y + directions[di][1];
            if(nextX <0 || nextX>=rows || nextY<0 || nextY>=cols || visited[nextX][nextY]){
                if(!hit){
                    hit = true;
                    di = (di+1)%4;
                    continue;
                }else{
                    break;
                }
            }
            hit = false;
            x = nextX;
            y = nextY;
            visited[x][y] = true;
            list.add(matrix[x][y]);
        }
        return list;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0){
            return res;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int x=0, y=0, xEnd=rows-1, yEnd = cols-1;
        while(x<=xEnd && y<=yEnd){
            //right
            for(int i=y; i<=yEnd; i++){
                res.add(matrix[x][i]);
            }
            x++;
            //down
            for(int i=x; i<=xEnd; i++){
                res.add(matrix[i][yEnd]);
            }
            yEnd--;
            //left
            if(x>xEnd) {
                break;
            }
            for (int i = yEnd; i >= y; i--) {
                res.add(matrix[xEnd][i]);
            }
            xEnd--;
            //top
            if(y > yEnd) {
                break;
            }
            for (int i = xEnd; i >= x; i--) {
                res.add(matrix[i][y]);
            }
            y++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.toString(new SpiralMatrix().spiralOrder(matrix).toArray()));


        matrix = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        System.out.println(Arrays.toString(new SpiralMatrix().spiralOrder(matrix).toArray()));

        matrix = new int[][]{
                { 1, 2, 3, 4, 5, 6},
                { 7, 8, 9,10,11,12},
                {13,14,15,16,17,18},
                {19,20,21,22,23,24},
                {25,26,27,28,29,30},
                {31,32,33,34,35,36},
                {37,38,39,40,41,42}
        };
        System.out.println(Arrays.toString(new SpiralMatrix().spiralOrder(matrix).toArray()));
    }

    public List<Integer> spiralOrderOld(int[][] matrix) {
        //00,01,02,12,22,21,20,10,11

        //00,01,02,03,13,23,22,21,20,10,11,12

        List<Integer> list = new ArrayList<>();
        if(matrix.length==0 || matrix[0].length == 0){
            return list;
        }
        int totalRows = matrix.length;
        int totalCols = matrix[0].length;
        recursive(matrix, 0, totalRows, totalCols, list);
        return list;
    }

    private void recursive(int[][] matrix, int level, int totalRows, int totalCols, List<Integer> list) {
        int x = level, y = level;
        int maxCol = totalCols - level;
        int maxRow = totalRows - level;
        if(maxCol<=0 && maxRow <=0){
            return;
        }
        if(y>=maxCol){
            return;
        }
        while (y < maxCol) {
            list.add(matrix[x][y++]);
        }
        y--;
        x++;
        if(x>=maxRow) {
            return;
        }
        while (x < maxRow) {
            list.add(matrix[x++][y]);
        }
        x--;
        y--;

        if(y<level) {
            return;
        }
        while (y >= level) {
            list.add(matrix[x][y--]);
        }
        y++;
        x--;
        if(x<=level){
            return;
        }
        while(x>level){
            list.add(matrix[x--][y]);
        }
        recursive(matrix, level+1, totalRows, totalCols, list);
    }


}
