/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 *
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (28.91%)
 * Total Accepted:    20.2K
 * Total Submissions: 69.7K
 * Testcase Example:  '"Hello World"'
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 
 * 如果不存在最后一个单词，请返回 0 。
 * 
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * 
 * 示例:
 * 
 * 输入: "Hello World"
 * 输出: 5
 * 
 * 
 */
class Solution {
    /**
     * 倒着遍历，记录两个索引，第一索引是首个字符，第二个索引是非字符，或者不存在第二个索引，单词直接结束
     */
    public int lengthOfLastWord(String s) {
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();
        char[] cs = s.toCharArray();
        boolean start = false;
        int j = 0;
        int i = 0;
        for (i = 0; i < cs.length; i++) {
            if (start == false && cs[i] != ' ') {
                start = true;
                j = i;
            } else if (start == true && cs[i] == ' ') {
                return i - j;
            }
        }
        return (start)?i - j:0;
    }
}
