/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 *
 * https://leetcode-cn.com/problems/base-7/description/
 *
 * algorithms
 * Easy (41.60%)
 * Total Accepted:    2.4K
 * Total Submissions: 5.7K
 * Testcase Example:  '100'
 *
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 100
 * 输出: "202"
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: -7
 * 输出: "-10"
 * 
 * 
 * 注意: 输入范围是 [-1e7, 1e7] 。
 * 
 */
class Solution {
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        boolean f = num < 0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            sb.append(String.valueOf(num%7));
            num /= 7;
        }
        return (f)?"-"+sb.reverse().toString():sb.reverse().toString();
    }
}

