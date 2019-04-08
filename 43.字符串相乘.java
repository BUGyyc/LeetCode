/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 *
 * https://leetcode-cn.com/problems/multiply-strings/description/
 *
 * algorithms
 * Medium (37.94%)
 * Total Accepted:    11.6K
 * Total Submissions: 30.5K
 * Testcase Example:  '"2"\n"3"'
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
 * 示例 1:
 * 
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 
 * 示例 2:
 * 
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 
 * 说明：
 * 
 * 
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 
 * 
 */
class Solution {
    /**
     * 从尾部开始递归，把所有值加到字符中
     * 
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int[] newArr = new int[num1.length() + num2.length()];
        for (int i = num1.trim().length() - 1; i >= 0; i--) {
            for (int j = num2.trim().length() - 1; j >= 0; j--) {
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + newArr[i + j + 1];
                newArr[i + j] += sum / 10;
                newArr[i + j + 1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n : newArr)
            if (!(sb.length() == 0 && n == 0))
                sb.append(n);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
