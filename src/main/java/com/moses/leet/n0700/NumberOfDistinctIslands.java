package com.moses.leet.n0700;

import java.util.HashSet;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected
 * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Count the number of distinct islands. An island is considered to be the same as another if and only if one island can
 * be translated (and not rotated or reflected) to equal the other.
 *
 * Example 1:
 * 11000
 * 11000
 * 00011
 * 00011
 * Given the above grid map, return 1.
 * Example 2:
 * 11011
 * 10000
 * 00001
 * 11011
 * Given the above grid map, return 3.
 *
 * Notice that:
 * 11
 * 1
 * and
 *  1
 * 11
 * are considered different island shapes, because we do not consider reflection / rotation.
 * Note: The length of each dimension in the given grid does not exceed 50.
 *
 */
public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                dfs(grid, i, j, sb);
                set.add(sb.toString());
            }
        }
        return set.size();
    }

    public void dfs(int[][] grid, int i, int j, StringBuilder sb) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = -1;
        dfs(grid, i + 1, j, sb.append("d"));
        dfs(grid, i, j + 1, sb.append("r"));
        dfs(grid, i - 1, j, sb.append("u"));
        dfs(grid, i, j - 1, sb.append("l"));
    }
}
