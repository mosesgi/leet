package com.moses.leet.n0420;

import com.moses.leet.utils.PrintUtil;

import java.util.*;

public class PacificAtlanticWaterFlow {

    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if(matrix.length == 0){
            return result;
        }
        Queue<int[]> pFlood = new LinkedList<>();
        Queue<int[]> aFlood = new LinkedList<>();
        for(int i=0; i<matrix.length; i++){
            pFlood.offer(new int[]{i, 0});
            aFlood.offer(new int[]{i, matrix[0].length-1});
        }
        for(int j=0; j<matrix[0].length; j++){
            pFlood.offer(new int[]{0, j});
            aFlood.offer(new int[]{matrix.length-1, j});
        }
        boolean[][] pCan = new boolean[matrix.length][matrix[0].length];
        boolean[][] aCan = new boolean[matrix.length][matrix[0].length];
        while(!pFlood.isEmpty()){
            int[] cur = pFlood.poll();
            if(pCan[cur[0]][cur[1]]){
                continue;
            }
            pCan[cur[0]][cur[1]] = true;
            for(int[] dir : directions){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if(x < 0 || x>=matrix.length || y<0 || y>=matrix[0].length || matrix[x][y] < matrix[cur[0]][cur[1]]){
                    continue;
                }
                pFlood.offer(new int[]{x,y});
            }
        }

        while(!aFlood.isEmpty()){
            int[] cur = aFlood.poll();
            if(aCan[cur[0]][cur[1]]){
                continue;
            }
            aCan[cur[0]][cur[1]] = true;
            for(int[] dir : directions){
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if(x < 0 || x>=matrix.length || y<0 || y>=matrix[0].length || matrix[x][y] < matrix[cur[0]][cur[1]]){
                    continue;
                }
                aFlood.offer(new int[]{x,y});
            }
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(aCan[i][j] && pCan[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    //very slow
    public List<List<Integer>> pacificAtlantic2(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if(matrix.length==0 || matrix[0].length==0){
            return result;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] atlanticPoints = new boolean[rows][cols];
        boolean[][] pacificPoints = new boolean[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                deep(matrix, i, j, atlanticPoints, pacificPoints, new boolean[rows][cols]);
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(Boolean.TRUE.equals(atlanticPoints[i][j]) && Boolean.TRUE.equals(pacificPoints[i][j])){
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    void deep(int[][] matrix, int x, int y, boolean[][] atlanticPoints, boolean[][] pacificPoints, boolean[][] visited){
        if(visited[x][y]){
            return;
        }
        visited[x][y] = true;
        for(int[] dir : directions){
            int newX = x + dir[0];
            int newY = y + dir[1];
            if(newX < 0 || newY < 0){
                pacificPoints[x][y] = true;
            }else if(newX >=matrix.length || newY >=matrix[0].length){
                atlanticPoints[x][y] = true;
            }else if(matrix[newX][newY] > matrix[x][y]){
                continue;
            } else {
                deep(matrix, newX, newY, atlanticPoints, pacificPoints, visited);
                if (Boolean.TRUE.equals(atlanticPoints[newX][newY])) {
                    atlanticPoints[x][y] = true;
                }
                if (Boolean.TRUE.equals(pacificPoints[newX][newY])) {
                    pacificPoints[x][y] = true;
                }
            }
        }
    }



//    class Point{
//        int x;
//        int y;
//        Point(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public int hashCode() {
//            return x*13+y*13;
//        }
//
//        @Override
//        public boolean equals(Object o){
//            Point o1 = (Point)o;
//            return this.x == o1.x && this.y == o1.y;
//        }
//    }

    public List<List<Integer>> pacificAtlantic1(int[][] matrix) {
        List<List<Integer>> list = new ArrayList<>();
        int rows = matrix.length;
        if(rows == 0){
            return list;
        }
        int cols = matrix[0].length;
        if(cols == 0){
            return list;
        }
        Boolean[][] pacDp = new Boolean[rows][cols];
        Boolean[][] atlDp = new Boolean[rows][cols];

        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]];
            }
        });
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                p.offer(new int[]{i,j});
            }
        }

        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!p.isEmpty()){
            int[] curr = p.poll();
            int i = curr[0];
            int j = curr[1];
            boolean pac = dfs(matrix, pacDp, i, j, rows, cols, visited, directions, true);
            pacDp[i][j] = pac;
            boolean atl = dfs(matrix, atlDp, i, j, rows, cols, visited, directions, false);
            atlDp[i][j] = atl;
            if(pac && atl){
                list.add(Arrays.asList(i,j));
            }
        }

        return list;
    }

//    //First success... cost 1.5 hours because of HashSet doesn't recognize int[]
//    public List<List<Integer>> pacificAtlanticSlow(int[][] matrix) {
//        List<List<Integer>> list = new ArrayList<>();
//        int rows = matrix.length;
//        if(rows == 0){
//            return list;
//        }
//        int cols = matrix[0].length;
//        if(cols == 0){
//            return list;
//        }
//        Boolean[][] pacDp = new Boolean[rows][cols];
//        Boolean[][] atlDp = new Boolean[rows][cols];
//
//        Set<Point> visited = new HashSet<>();
//        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
//        for(int i=0; i<rows; i++){
//            for(int j=0; j<cols; j++){
//                boolean pac = dfs(matrix, pacDp, i, j, rows, cols, visited, directions, true);
//                pacDp[i][j] = pac;
//                boolean atl = dfs(matrix, atlDp, i, j, rows, cols, visited, directions, false);
//                atlDp[i][j] = atl;
//                if(pac && atl){
//                    list.add(Arrays.asList(i,j));
//                }
//            }
//        }
//        return list;
//    }

    private boolean dfs(int[][] matrix, Boolean[][] dp, int i, int j, int rows, int cols,
                        boolean[][] visited, int[][] directions, boolean checkPac) {
        if(dp[i][j] != null){
            return dp[i][j];
        }
//        Point p = new Point(i, j);
        visited[i][j] = true;
        for(int[] dir : directions){
            int tmpI = i+dir[0];
            int tmpJ = j+dir[1];
            if(tmpI < 0 || tmpJ < 0){
                if(checkPac) {
                    visited[i][j] = false;
                    return checkPac;
                }
                continue;
            }
            if(tmpI > rows-1 || tmpJ > cols-1){
                if(!checkPac){
                    visited[i][j] = false;
                    return !checkPac;
                }
                continue;
            }
            if(visited[tmpI][tmpJ]){
                continue;
            }
            if(matrix[tmpI][tmpJ] <= matrix[i][j]) {
                boolean rst = dfs(matrix, dp, tmpI, tmpJ, rows, cols, visited, directions, checkPac);
                if (rst) {
                    visited[i][j] = false;
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix;
        List<List<Integer>> list;
        matrix = new int[][]{
                {10,10,10},
                {10,1,10},
                {10,10,10}
        };
        list = new PacificAtlanticWaterFlow().pacificAtlantic(matrix);
        PrintUtil.printNestedList(list);

        matrix = new int[][]{
                {1,2},
                {4,3}
        };
        list = new PacificAtlanticWaterFlow().pacificAtlantic(matrix);
        PrintUtil.printNestedList(list);

        matrix = new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        list = new PacificAtlanticWaterFlow().pacificAtlantic(matrix);
        PrintUtil.printNestedList(list);
    }

}
