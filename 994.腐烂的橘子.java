/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] N 天后的牢房
 */
class Solution {
    private int row = 0;
    private int col = 0;
    private int[][] Grid;

    // [[1,2,1,1,2,1,1]]
    public int orangesRotting(int[][] grid) {
        int cost = 0;
        row = grid.length;
        int[] arr = grid[0];
        col = arr.length;
        // Grid = grid;
        Grid = new int[row][col];
        setArrValue(Grid, grid);
        return runTime(grid, cost);
    }

    public int runTime(int[][] grid, int cost) {

        boolean haveBeBad = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    boolean temp = setOrangeArr(i, j);
                    haveBeBad = haveBeBad || temp;
                }
            }
        }
        // 没有变腐烂的橘子，说明结束
        if (haveBeBad == false) {
            boolean haveFresh = false;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 1) {
                        haveFresh = true;
                        break;
                    }
                }
            }
            return (haveFresh) ? -1 : cost;
        }
        setArrValue(grid, Grid);
        // grid = Grid;
        cost++;
        return runTime(grid, cost);
    }

    public void setArrValue(int[][] arr1, int[][] arr2) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr1[i][j] = arr2[i][j];
            }
        }
    }

    public boolean setOrangeArr(int i, int j) {
        boolean canBeBad1 = false;
        boolean canBeBad2 = false;
        boolean canBeBad3 = false;
        boolean canBeBad4 = false;// 周围是否有好的橘子被腐烂
        if (i - 1 >= 0) {
            if (Grid[i - 1][j] == 1) {
                Grid[i - 1][j] = 2;
                canBeBad1 = true;
            }
        }
        if (i + 1 < row) {
            if (Grid[i + 1][j] == 1) {
                Grid[i + 1][j] = 2;
                canBeBad2 = true;
            }
        }

        if (j - 1 >= 0) {
            if (Grid[i][j - 1] == 1) {
                Grid[i][j - 1] = 2;
                canBeBad3 = true;
            }
        }
        if (j + 1 < col) {
            if (Grid[i][j + 1] == 1) {
                Grid[i][j + 1] = 2;
                canBeBad4 = true;
            }
        }
        return (canBeBad1 || canBeBad2 || canBeBad3 || canBeBad4);
    }
}
