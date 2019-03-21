/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (46.70%)
 * Total Accepted:    18.7K
 * Total Submissions: 39.7K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 */
class Solution {
    /**
     * 取两个字符遍历，都从尾部开始遍历，进位也要算进去
     */
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int m = a.length() - 1, n = b.length() - 1;
        while(m >= 0 || n >= 0){
            int temp = carry;
            if(m >= 0) temp += a.charAt(m--) - '0';
            if(n >= 0) temp += b.charAt(n--) - '0';
            carry = temp / 2;//大于就是有进位
            res.append(temp % 2);
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}
