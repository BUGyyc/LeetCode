/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 *
 * https://leetcode-cn.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (55.99%)
 * Total Accepted:    83.4K
 * Total Submissions: 148.8K
 * Testcase Example:  '121'
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * 示例 1:
 * 
 * 输入: 121
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 
 * 
 * 示例 3:
 * 
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 
 * 
 * 进阶:
 * 
 * 你能不将整数转为字符串来解决这个问题吗？
 * 
 */
class Solution {
    /**
     * 利用回文数的特点，前后各取一半 x,newNum 有可能多一位，所以判断的时候要判断两种情况
     */
    public boolean isPalindrome(int x) {
        return func1(x);
    }

    private boolean extracted(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) {// 小于0肯定不是,除了0之外，被10整除肯定也不是
            return false;
        }
        int newNum = 0;
        while (x > newNum) {
            newNum = newNum * 10 + x % 10;// 把这个数颠倒，最后用来比较x
            x = x / 10;
        }
        return x == newNum || x == newNum / 10;
    }

    private boolean func1(int x) {
        if (x < 0 || x != 0 && x % 10 == 0)
            return false;
        int num = 0;
        while (num < x) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        return num == x || num / 10 == x;
    }
}
