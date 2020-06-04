package com.moses.leet.n1140;

/**
 * Alex and Lee continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones. 
 *
 * Alex and Lee take turns, with Alex starting first.  Initially, M = 1.
 *
 * On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).
 *
 * The game continues until all the stones have been taken.
 *
 * Assuming Alex and Lee play optimally, return the maximum number of stones Alex can get.
 *
 *  
 *
 * Example 1:
 *
 * Input: piles = [2,7,9,4,4]
 * Output: 10
 * Explanation:  If Alex takes one pile at the beginning, Lee takes two piles, then Alex takes 2 piles again. Alex can get 2 + 4 + 4 = 10 piles in total. If Alex takes two piles at the beginning, then Lee can take all three piles left. In this case, Alex get 2 + 7 = 9 piles in total. So we return 10 since it's larger.
 *  
 *
 * Constraints:
 *
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 10 ^ 4
 *
 */
public class StoneGameII {
    Integer[][] mem;
    public int stoneGameII(int[] piles) {
        mem = new Integer[piles.length][piles.length*2];
        int[] sum = new int[piles.length];
        sum[piles.length-1] = piles[piles.length-1];
        for(int i=piles.length-2; i>=0; i--){
            sum[i] = sum[i+1] + piles[i];       //i及之后的所有piles和
        }
        return rec(piles, 0, 1, sum);
    }

    int rec(int[] piles, int start, int m, int[] sum){
        if(start >=piles.length){
            return 0;
        }
        if(mem[start][m] != null){
            return mem[start][m];
        }
        int max = 0;
        for(int i=start; i<start+2*m && i<piles.length; i++){
            int tmp = sum[start] - rec(piles, i+1, Math.max(m, i-start+1), sum);
            max = Math.max(max, tmp);
        }
        System.out.println("m:" + m + ",start: " + start + ", max:" + max);
        mem[start][m] = max;
        return max;
    }


    public static void main(String[] args) {
        int[] piles;
        piles =new int[]{2,7,9,4,4};
        System.out.println(new StoneGameII().stoneGameII(piles));
    }
}
