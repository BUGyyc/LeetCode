/*
 * @lc app=leetcode.cn id=812 lang=java
 *
 * [812] 旋转字符串
 *
 * https://leetcode-cn.com/problems/largest-triangle-area/description/
 *
 * algorithms
 * Easy (54.03%)
 * Total Accepted:    1.7K
 * Total Submissions: 3.2K
 * Testcase Example:  '[[0,0],[0,1],[1,0],[0,2],[2,0]]'
 *
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 * 
 * 
 * 示例:
 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出: 2
 * 解释: 
 * 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
 * 
 * 
 * 
 * 
 * 注意: 
 * 
 * 
 * 3 <= points.length <= 50.
 * 不存在重复的点。
 * -50 <= points[i][j] <= 50.
 * 结果误差值在 10^-6 以内都认为是正确答案。
 * 
 * 
 */
class Solution {
    //TODO:
    public double largestTriangleArea(int[][] points) {
        double area = 0;
        double maxArea = 0;
        for (int i = 0; i < points.length; i++)
            for (int j = i + 1; j < points.length; j++)
                for (int k = j + 1; k < points.length; k++) {
                    area = (points[i][0] * points[j][1] + points[k][1] * points[j][0] + points[k][0] * points[i][1]
                            - points[i][0] * points[k][1] - points[j][0] * points[i][1] - points[k][0] * points[j][1])
                            * 0.5;
                    if (Math.abs(area) > maxArea)
                        maxArea = Math.abs(area);
                }
        return maxArea;
    }
}
