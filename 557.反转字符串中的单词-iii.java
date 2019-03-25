/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/description/
 *
 * algorithms
 * Easy (62.53%)
 * Total Accepted:    10.6K
 * Total Submissions: 17K
 * Testcase Example:  '"Let\'s take LeetCode contest"'
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 
 * 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * 
 */
class Solution {
    /**
     * 字符串中没有额外空格
     * 
     */
    public String reverseWords(String s) {
        if (s.equals("") || s == null)
            return "";
        String[] strs = s.split(" ");// 按空格划分
        String str = "";
        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            strs[i] = chars2Str(c);
            str += (i != 0) ? " " + strs[i] : strs[i];
        }
        return str;
    }

    private String chars2Str(char[] c) {
        StringBuilder sb = new StringBuilder();
        for (int i = c.length - 1; i >= 0; i--) {
            sb.append(c[i]);
        }
        return sb.toString();
    }
}
