package com.moses.leet.n0700;

import java.util.HashSet;

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
