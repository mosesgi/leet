package com.moses.leet.n0280;

/**
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
 *
 * Note:
 * All costs are positive integers.
 *
 * Example:
 *
 * Input: [[1,5,3],[2,9,4]]
 * Output: 5
 * Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
 *              Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
 * Follow up:
 * Could you solve it in O(nk) runtime?
 */
public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if(costs.length== 0 || costs[0].length==0){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[costs.length][costs[0].length];
        for(int j=0; j<costs[0].length; j++){
            dp[0][j] = costs[0][j];
            if(costs.length==1){
                res = Math.min(res, dp[0][j]);
            }
        }

        for(int i=1; i<costs.length; i++){
            for(int j=0; j<costs[i].length; j++){
                for(int k = 0; k<costs[i-1].length; k++){
                    if(j==k){
                        continue;
                    }
                    if(dp[i][j] == 0){
                        dp[i][j] = costs[i][j] + dp[i-1][k];
                    }else {
                        dp[i][j] = Math.min(dp[i][j], costs[i][j] + dp[i - 1][k]);
                    }
                }
                if(i == costs.length-1){
                    res = Math.min(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] costs;
        costs = new int[][]{{1,5,3},{2,9,4}};
        System.out.println(new PaintHouseII().minCostII(costs));
    }
}
