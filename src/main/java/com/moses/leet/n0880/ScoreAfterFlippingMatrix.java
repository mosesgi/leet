package com.moses.leet.n0880;

/**
 * We have a two dimensional matrix A where each value is 0 or 1.
 *
 * A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.
 *
 * After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.
 *
 * Return the highest possible score.
 *
 *
 *
 * Example 1:
 *
 * Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * Output: 39
 * Explanation:
 * Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 *
 *
 * Note:
 *
 *     1 <= A.length <= 20
 *     1 <= A[0].length <= 20
 *     A[i][j] is 0 or 1.
 *
 */
public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
        if(A.length==0 || A[0].length==0) return 0;
        int rows = A.length;//行
        int cols = A[0].length;//列
        //行移动
        for(int i=0; i<rows; i++) {
            if(A[i][0] == 0) {//行翻转条件
                for(int j=0; j<cols; j++){
                    A[i][j] ^= 1;
                }
            }
        }

        int sum = rows * (1<<(cols-1));//第一列全为1，sum初始值、
        for(int i=1; i<cols; i++) {//按列计算
            int count = 0;
            for(int j=0; j<rows; j++) {
                if(A[j][i] == 1)//统计1的个数
                    count++;
            }
            if(count <= rows/2) {//列反转条件,不用进行翻转操作，直接计算
                count = rows - count;
            }
            sum += count * (1 << (cols - i -1));
        }

        return sum;
    }
}
