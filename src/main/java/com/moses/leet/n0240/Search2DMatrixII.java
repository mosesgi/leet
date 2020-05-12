package com.moses.leet.n0240;

public class Search2DMatrixII {
    public boolean searchMatrixSmart(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int row = 0;
        int col = matrix[0].length-1;
        //search from top right corner.
        while(row < matrix.length && col >=0){
            if(matrix[row][col] == target){
                return true;
            } else if(matrix[row][col] > target){
                col--;
            } else if(matrix[row][col] < target){
                row++;
            }
        }
        return false;
    }


    //Recursive, slow. 5%
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        return search(matrix, target, 0, matrix.length-1, 0, matrix[0].length-1);
    }

    boolean search(int[][] matrix, int target, int xl, int xr, int yl, int yr){
        if(xl<0 || yl<0 || xr >=matrix.length || yr >= matrix[0].length || xl>xr || yl>yr){
            return false;
        }
        int xm = xl + (xr-xl)/2;
        int ym = yl + (yr-yl)/2;
        if(matrix[xm][ym] == target){
            return true;
        }else if(matrix[xm][ym] < target){
            return search(matrix, target, xl, xm, ym+1, yr) || search(matrix, target, xm+1, xr, yl, ym) || search(matrix, target, xm+1, xr, ym+1, yr);
        }else{
            return search(matrix, target, xl, xm-1, yl, ym-1) || search(matrix, target, xl, xm-1, ym, yr) || search(matrix, target, xm, xr, yl, ym-1);
        }
    }


    //my own stupid resolution. find region, and row by row/col by col. Beat 39%
    public boolean searchMatrixMyOwn(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0){
            return false;
        }
        int cols = matrix[0].length;
        if(cols == 0){
            return false;
        }

        int minRow=0, maxRow=rows-1;
        for(int i=0; i<rows; i++){
            if(matrix[i][cols-1] < target){
                minRow = i+1;
            }
            if(matrix[i][0] > target && i<maxRow){
                maxRow = i-1;
            }
        }

        int minCol = 0, maxCol = cols-1;
        for(int i=0; i<cols; i++){
            if(matrix[rows-1][i] < target){
                minCol = i+1;
            }
            if(matrix[0][i] > target && i<maxCol){
                maxCol = i-1;
            }
        }

//        System.out.println("minRow=" + minRow + ", maxRow=" + maxRow + ", minCol=" + minCol + ", maxCol=" + maxCol);

        if(maxCol - minCol > maxRow - minRow) {
            for (int i = minRow; i <= maxRow; i++) {
                int minC = minCol, maxC = maxCol;
                while (minC <= maxC) {
                    if (minC == maxC) {
                        if(matrix[i][minC] == target){
                            return true;
                        } else {
                            break;
                        }
                    } else if (minC + 1 == maxC) {
                        if (matrix[i][minC] == target || matrix[i][maxC] == target) {
                            return true;
                        } else {
                            break;
                        }
                    }
                    int midC = (minC + maxC) / 2;
                    if (matrix[i][midC] > target) {
                        maxC = midC;
                    } else if (matrix[i][midC] < target) {
                        minC = midC;
                    } else if (matrix[i][midC] == target) {
                        return true;
                    }
                }
            }
        } else {
            for(int j = minCol; j<=maxCol; j++) {
                int minR = minRow, maxR = maxRow;
                while(minR <= maxR){
                    if(minR == maxR){
                        if(matrix[minR][j] == target){
                            return true;
                        }else {
                            break;
                        }
                    } else if(minR +1 == maxR){
                        if(matrix[minR][j] == target || matrix[maxR][j] == target){
                            return true;
                        }else {
                            break;
                        }
                    }
                    int midR = (minR + maxR) / 2;
                    if(matrix[midR][j] > target){
                        maxR = midR;
                    } else if(matrix[midR][j] < target){
                        minR = midR;
                    } else if(matrix[midR][j] == target){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix;
        int target;

        matrix = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        target = 5;
        System.out.println(new Search2DMatrixII().searchMatrix(matrix, target));

        target = 20;
        System.out.println(new Search2DMatrixII().searchMatrix(matrix, target));
    }
}
