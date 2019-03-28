/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 *
 * https://leetcode-cn.com/problems/sum-of-square-numbers/description/
 *
 * algorithms
 * Easy (28.71%)
 * Total Accepted:    3.7K
 * Total Submissions: 12.9K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * 
 * 示例1:
 * 
 * 
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 * 
 * 
 * 
 * 
 * 示例2:
 * 
 * 
 * 输入: 3
 * 输出: False
 * 
 * 
 */
class Solution {
    public boolean judgeSquareSum(int c) {
        int high = (int) Math.sqrt(c), low = 0, result;
        while (low <= high) {
            result = low * low + high * high;
            if (result == c) {
                return true;
            } else if (result > c) {
                high -= 1;
            } else {
                low += 1;
            }
        }
        return false;
    }
}
