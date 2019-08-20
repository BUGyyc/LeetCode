import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 *
 * https://leetcode-cn.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (34.03%)
 * Total Accepted:    9.9K
 * Total Submissions: 28.9K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 最大行
        int rowMax = matrix.length;
        // 最大列
        int colMax = matrix[0].length;
        List<Integer> list = new ArrayList<>();

        printRow(matrix, 0, list, rowMax, colMax, true);
    }

    // // 输出行
    // private void printRow(int[][] matrix, int curr, List<Integer> list, int rowMax, int colMax, boolean isAdd) {
    //     if (isAdd) {
    //         for (int i = 0; i < colMax; i++) {
    //             list.add(matrix[curr][i]);
    //         }
    //     } else {
    //         for (int i = colMax; i >= 0; i--) {
    //             list.add(matrix[curr][i]);
    //         }
    //     }
    //     rowMax
    //     printCol(matrix,colMax-1,list,)
    // }

    // private void printCol(int[][] matrix, int curr, List<Integer> list, int rowMax, int colMax, boolean isAdd) {
    //     if (isAdd) {
    //         for (int i = 0; i < colMax; i++) {
    //             list.add(matrix[i][curr]);
    //         }
    //     } else {
    //         for (int i = colMax; i >= 0; i--) {
    //             list.add(matrix[i][curr]);
    //         }
    //     }
    // }
}
