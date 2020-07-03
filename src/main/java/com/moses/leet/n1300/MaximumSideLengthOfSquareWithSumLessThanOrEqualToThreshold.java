package com.moses.leet.n1300;

public class MaximumSideLengthOfSquareWithSumLessThanOrEqualToThreshold {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sum = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                sum[i][j] = mat[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
        int ans = 0;
        int maxLen = Math.min(m, n);
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=maxLen; k++){
                    if(i-k < 0 || j-k < 0){
                        break;
                    }
                    int cur = sum[i][j] - sum[i-k][j] - sum[i][j-k] + sum[i-k][j-k];
                    if(cur <= threshold){
                        ans = Math.max(ans, k);
                    }
                }
            }
        }
        return ans;
    }
}
