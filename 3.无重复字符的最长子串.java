/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (28.42%)
 * Total Accepted:    92.2K
 * Total Submissions: 321.8K
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */
class Solution {
    //TODO:
    public int lengthOfLongestSubstring(String s) {
        String temp = "";// 临时存放的字符串
        String list = "";// 每个阶段最长的连续字串
        for (int i = 0; i < s.length(); i++) {
            /*
             * 如果在临时字符串中存在，将出现那个位置之前的字符都删除。
             */
            if (temp.contains(s.charAt(i) + "")) {
                int t = temp.indexOf(s.charAt(i));
                if ((t + 1) == temp.length())
                    temp = "";
                else
                    temp = temp.substring(t + 1, temp.length());
                temp = temp.concat(s.charAt(i) + "");
            } else {
                temp = temp.concat(s.charAt(i) + "");//无重复就加进去
            }
            if (list.length() <= temp.length()) {// 如果找到一个比现在的长的子串，置换
                list = temp;
            }
        }
        return list.length();
    }
}
