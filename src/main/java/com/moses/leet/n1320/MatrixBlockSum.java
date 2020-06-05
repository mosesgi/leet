package com.moses.leet.n1320;

/**
 * Given a m * n matrix mat and an integer K, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for i - K <= r <= i + K, j - K <= c <= j + K, and (r, c) is a valid position in the matrix.
 *
 *
 *
 * Example 1:
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 * Output: [[12,21,16],[27,45,33],[24,39,28]]
 *
 * Example 2:
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 * Output: [[45,45,45],[45,45,45],[45,45,45]]
 *
 *
 *
 * Constraints:
 *
 *     m == mat.length
 *     n == mat[i].length
 *     1 <= m, n, K <= 100
 *     1 <= mat[i][j] <= 100
 *
 */
public class MatrixBlockSum {

    //copy from discuss
    public int[][] matrixBlockSum(int[][] mat, int K) {

        int m=mat.length;
        int n=mat[0].length;
        int [][] res=new int[m][n];
        int [][] S=new int[m][n];//前缀和矩阵
        //先求前缀和矩阵
        S[0][0]=mat[0][0];
        for(int i=1;i<m;i++) S[i][0]=S[i-1][0]+mat[i][0];
        for(int j=1;j<n;j++) S[0][j]=S[0][j-1]+mat[0][j];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                S[i][j]=S[i-1][j]+S[i][j-1]-S[i-1][j-1]+mat[i][j];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[i][j]=sub_sum_mat(i-K<0?0:i-K,j-K<0?0:j-K,i+K>=m?m-1:i+K,j+K>=n?n-1:j+K,S);
            }
        }
        return res;

    }
    public int sub_sum_mat(int x1,int y1,int x2,int y2,int[][] S){
        return S[x2][y2]-(x1-1<0?0:S[x1-1][y2])-(y1-1<0?0:S[x2][y1-1])+(x1-1<0||y1-1<0?0:S[x1-1][y1-1]);
    }

}
