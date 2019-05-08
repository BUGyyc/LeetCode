/*
 * @lc app=leetcode.cn id=696 lang=java
 *
 * [696] 计数二进制子串
 *
 * https://leetcode-cn.com/problems/count-binary-substrings/description/
 *
 * algorithms
 * Easy (47.00%)
 * Total Accepted:    1.8K
 * Total Submissions: 3.9K
 * Testcase Example:  '"00110"'
 *
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 
 * 重复出现的子串要计算它们出现的次数。
 * 
 * 示例 1 :
 * 
 * 
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * 
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * 
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 
 * 
 * 示例 2 :
 * 
 * 
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * 
 * 
 * 注意：
 * 
 * 
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 * 
 * 
 */
class Solution {
    public int countBinarySubstrings(String s1) {
        List<String> subList = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < (s1.length() - 1); i++) {
            for (int j = i + 2; j <= s1.length(); j++) {
                subList.add(s1.substring(i, j));

            }
        }
        for (String s2 : subList) {
            int numofzero = 0;
            int numofone = 0;
            for (int n = 0; n < s2.length(); n++) {
                if (s2.charAt(n) == '0')
                    numofzero = numofzero + 1;
                else
                    numofone = numofone + 1;

            }
            int onechain = 0;
            int zerochain = 0;
            if (numofzero == numofone) {
                for (int k = 0; k < s2.length() - 1; k++) {

                    if ((s2.charAt(k) == '0') && (s2.charAt(k + 1) == '0'))
                        zerochain = zerochain + 1;
                    if ((s2.charAt(k) == '1') && (s2.charAt(k + 1) == '1'))
                        onechain = onechain + 1;
                }
                if ((numofzero == zerochain + 1) && (numofone == onechain + 1))
                    counter = counter + 1;

            }
        }
        return counter;
    }
}
