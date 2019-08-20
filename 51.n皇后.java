/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (59.42%)
 * Total Accepted:    5.3K
 * Total Submissions: 8.9K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: [
 * ⁠[".Q..",  // 解法 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // 解法 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 
 * 
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<List<String>>();
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 0;
            }
        }
        placeQueenLogic(list, result, 0, n);
        return list;
    }

    ///////////////////////////////////////////////////////////
    // 递归解法

    /**
     * 放置皇后
     * 
     * @param list
     * @param result
     * @param i
     * @param n
     */
    private void placeQueenLogic(List<List<String>> list, int[][] result, int i, int n) {
        if (i >= n) {
            // 到达最后一行
            String[] arr = resultToString(result);
            list.add(Arrays.asList(arr));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (onCheckValue(i, j, result, n)) {
                result[i][j] = 1;
                // 查找下一行的选择
                placeQueenLogic(list, result, i + 1, n);
                result[i][j] = 0;
            }
        }
    }

    /*
     * 检查放的皇后是否有效
     */
    public boolean onCheckValue(int i, int j, int[][] result, int n) {
        // 检查行
        for (int x = 0; x < n; x++) {
            if (x != i && result[x][j] == 1) {
                return false;
            }
        }
        // 检查列
        for (int y = 0; y < j; y++) {
            if (y != j && result[i][y] == 1) {
                return false;
            }
        }
        // 四个方向的对角线
        for (int a = i + 1, b = j + 1; a < n && b < n; a++, b++) {
            if (result[a][b] == 1) {
                return false;
            }
        }
        for (int a = i + 1, b = j - 1; a < n && b >= 0; a++, b--) {
            if (result[a][b] == 1) {
                return false;
            }
        }
        for (int a = i - 1, b = j - 1; a >= 0 && b >= 0; a--, b--) {
            if (result[a][b] == 1) {
                return false;
            }
        }
        for (int a = i - 1, b = j + 1; a >= 0 && b < n; a--, b++) {
            if (result[a][b] == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 转化为字符数组
     * 
     * @param result
     * @return
     */
    private String[] resultToString(int[][] result) {
        StringBuilder sBuilder = new StringBuilder();
        int max = result.length;
        String[] strArr = new String[max];
        for (int i = 0; i < max; i++) {
            sBuilder = new StringBuilder();
            for (int j = 0; j < max; j++) {
                if (result[i][j] == 1) {
                    sBuilder.append('Q');
                } else {
                    sBuilder.append('.');
                }
            }
            strArr[i] = sBuilder.toString();
        }
        return strArr;
    }
}
