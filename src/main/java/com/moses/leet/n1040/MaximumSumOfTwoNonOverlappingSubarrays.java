package com.moses.leet.n1040;

public class MaximumSumOfTwoNonOverlappingSubarrays {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        //A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2, len = 9
        //ls[0 ~ 6], ms[0 ~ 7]
        // m from 0 to 7.
        // L then M :  when mPos >= L  ( 4, L [0 to 1]  (LPos<=mPos -L)
        // M then L: when mPos <= len - L -M,  LPos >= mPos +M

        int[][] dp = new int[A.length + 1][4];
        int presum = 0;
        int maxsum;
        for (int i = 0; i < L; ++i) {
            presum += A[i];
        }
        maxsum = presum;
        dp[L - 1][0] = maxsum;
        for (int i = L; i < A.length; ++i) {
            presum -= A[i - L];
            presum += A[i];
            maxsum = Math.max(maxsum, presum);
            dp[i][0] = maxsum;
        }

        presum = 0;
        for (int i = 0; i < M; ++i) {
            presum += A[i];
        }
        maxsum = presum;
        dp[M - 1][1] = maxsum;
        for (int i = M; i < A.length; ++i) {
            presum -= A[i - M];
            presum += A[i];
            maxsum = Math.max(maxsum, presum);
            dp[i][1] = maxsum;
        }

        presum = 0;
        for (int i = A.length - 1; i >= A.length - L; --i) {
            presum += A[i];
        }
        maxsum = presum;
        dp[A.length - L][2] = maxsum;
        for (int i = A.length - L - 1; i >= 0; --i) {
            presum -= A[i + L];
            presum += A[i];
            maxsum = Math.max(maxsum, presum);
            dp[i][2] = maxsum;
        }

        presum = 0;
        for (int i = A.length - 1; i >= A.length - M; --i) {
            presum += A[i];
        }
        maxsum = presum;
        dp[A.length - M][3] = maxsum;
        for (int i = A.length - M - 1; i >= 0; --i) {
            presum -= A[i + M];
            presum += A[i];
            maxsum = Math.max(maxsum, presum);
            dp[i][3] = maxsum;
        }

        //计算答案
        int res = 0;
        //L在M左边
        for (int i = L; i <= A.length - M; ++i)
            res = Math.max(res, dp[i - 1][0] + dp[i][3]);
        //M在L左边
        for (int i = M; i <= A.length - L; ++i)
            res = Math.max(res, dp[i - 1][1] + dp[i][2]);

        return res;
    }
}
