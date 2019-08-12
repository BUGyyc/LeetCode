/*
 * @lc app=leetcode.cn id=892 lang=java
 *
 * [892] 三维形体的表面积
 */
class Solution {
    public int surfaceArea(int[][] grid) {
        int all = 0;
        int sub = 0;

        int num = 0;
        // 总面积
        for (int[] arr : grid) {
            for (int v : arr) {
                // int d = 0;
                // if (v != 1) {
                // d = (int) Math.pow(2, v - 1);
                // }
                // all += v * 6 - d;
                int temp = 0;
                if (v > 0) {
                    temp = 6 + (v - 1) * 4;
                }
                all += temp;
            }
        }
        int row = grid.length;
        int col = row;
        // 计算出相邻面积
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sub += getCost(grid, i, j, row, col);
            }
        }

        return all - sub;
    }

    public int getCost(int[][] grid, int i, int j, int row, int col) {
        int cost = 0;
        if (i + 1 < row) {
            cost += Math.min(grid[i][j], grid[i + 1][j]);
        }
        if (i - 1 >= 0) {
            cost += Math.min(grid[i][j], grid[i - 1][j]);
        }

        if (j + 1 < col) {
            cost += Math.min(grid[i][j], grid[i][j + 1]);
        }
        if (j - 1 >= 0) {
            cost += Math.min(grid[i][j], grid[i][j - 1]);
        }

        return cost;
    }
}
