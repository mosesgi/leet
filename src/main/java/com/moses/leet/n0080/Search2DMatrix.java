package com.moses.leet.n0080;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int len = rows * cols;
        int start = 0, end = len-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            int x = mid/cols;
            int y = mid%cols;
            if(matrix[x][y] == target){
                return true;
            } else if(matrix[x][y] > target){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }


    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0){
            return false;
        }
        int n = matrix[0].length;
        if(n==0){
            return false;
        }
        int t =0, b = m-1, x = 0;
        while(t<=b){
            int mid = t+(b-t)/2;
            if(matrix[mid][0] == target){
                return true;
            }else if(matrix[mid][0] > target){
                b = mid-1;
            }else{
                t = mid+1;
                x = mid;
            }
        }

        int l=0, r = n-1, y=0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(matrix[x][mid] == target){
                return true;
            }else if(matrix[x][mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return false;
    }

    public boolean searchMatrixOld(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0){
            return false;
        }
        int cols = matrix[0].length;
        if(cols == 0){
            return false;
        }
        int minRow = 0; int maxRow = rows-1;

        int row = 0;
        if(rows > 1) {
            while (minRow < maxRow) {
                int middleRow = (minRow + maxRow) / 2;
                if (minRow == maxRow - 1) {
                    if (target <= matrix[minRow][cols - 1]) {
                        row = minRow;
                        break;
                    } else if (target >= matrix[maxRow][0]) {
                        row = maxRow;
                        break;
                    } else {
                        return false;
                    }
                }
                if (target < matrix[middleRow][0]) {
                    maxRow = middleRow;
                } else if (target > matrix[middleRow][cols - 1]) {
                    minRow = middleRow;
                } else {
                    row = middleRow;
                    break;
                }
            }
        }

        int minCol = 0; int maxCol = cols -1;
        if(cols == 1){
            return target == matrix[row][0];
        } else {
            while (minCol < maxCol) {
                int middleCol = (minCol + maxCol) / 2;
                if (minCol == maxCol - 1) {
                    if (target == matrix[row][minCol] || target == matrix[row][maxCol]) {
                        return true;
                    } else {
                        return false;
                    }
                }

                if (target < matrix[row][middleCol]) {
                    maxCol = middleCol;
                } else if (target > matrix[row][middleCol]) {
                    minCol = middleCol;
                } else if (target == matrix[row][middleCol]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10,11,16,20},
                {23,30,34,50}
        };
        int target = 3;
        System.out.println(new Search2DMatrix().searchMatrix(matrix, target));


        matrix = new int[][]{
                {1, 3, 5, 7},
                {10,11,16,20},
                {23,30,34,50}
        };
        target = 13;
        System.out.println(new Search2DMatrix().searchMatrix(matrix, target));

    }
}
