/*
 * @lc app=leetcode.cn id=661 lang=java
 *
 * [661] 图片平滑器
 *
 * https://leetcode-cn.com/problems/image-smoother/description/
 *
 * algorithms
 * Easy (44.96%)
 * Total Accepted:    1.9K
 * Total Submissions: 4.3K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入)
 * ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 * 
 * 示例 1:
 * 
 * 
 * 输入:
 * [[1,1,1],
 * ⁠[1,0,1],
 * ⁠[1,1,1]]
 * 输出:
 * [[0, 0, 0],
 * ⁠[0, 0, 0],
 * ⁠[0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 * 
 * 
 * 注意:
 * 
 * 
 * 给定矩阵中的整数范围为 [0, 255]。
 * 矩阵的长和宽的范围均为 [1, 150]。
 * 
 * 
 */
class Solution {
    //TODO:
    public int[][] imageSmoother(int[][] M) {
        return extracted(M);
    }

    private int[][] extracted(int[][] M) {
        int[][] res = new int[M.length][M[0].length];
        int[][] tem = new int[M.length + 2][M[0].length + 2];

        for (int i = 0; i < M.length * M[0].length; i++) {
            tem[i / M[0].length + 1][i % M[0].length + 1] = M[i / M[0].length][i % M[0].length];
        }

        for (int i = 0; i < M.length * M[0].length; i++) {
            int row = i / M[0].length;
            int col = i % M[0].length;
            int count = 9;
            int sum = tem[row + 1][col + 1] + tem[row + 0][col + 0] + tem[row + 0][col + 1] + tem[row + 0][col + 2]
                    + tem[row + 1][col + 0] + tem[row + 1][col + 2] + tem[row + 2][col + 0] + tem[row + 2][col + 1]
                    + tem[row + 2][col + 2];

            if (row == 0 || col == 0 || row == M.length - 1 || col == M[0].length - 1) {
                count = 6;
                if (row == 0 && col == 0) {
                    count = 4;
                } else if (row == M.length - 1 && col == M[0].length - 1) {
                    count = 4;
                } else if (row == 0 && col == M[0].length - 1) {
                    count = 4;
                } else if (row == M.length - 1 && col == 0) {
                    count = 4;
                }
            }

            if (M.length == 1 || M[0].length == 1) {
                count = 3;
                if (row == 0 || col == 0) {
                    if (row == 0 && col == 0) {
                        count = 2;
                    } else if (row == 0 && col == M[0].length - 1) {
                        count = 2;
                    } else if (row == M.length - 1 && col == 0) {
                        count = 2;
                    }
                }
                if (M.length == M[0].length) {
                    count = 1;
                }
            }

            res[row][col] = sum / count;
        }

        return res;
    }
}

