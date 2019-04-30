/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 *
 * https://leetcode-cn.com/problems/wildcard-matching/description/
 *
 * algorithms
 * Hard (20.87%)
 * Total Accepted:    3.8K
 * Total Submissions: 18.2K
 * Testcase Example:  '"aa"\n"a"'
 *
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * 
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 
 * 
 * 两个字符串完全匹配才算匹配成功。
 * 
 * 说明:
 * 
 * 
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 
 * 示例 2:
 * 
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 
 * 
 * 示例 3:
 * 
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 
 * 
 * 示例 4:
 * 
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 
 * 
 * 示例 5:
 * 
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 * 
 */
class Solution {

    /**
     * 遍历字符串p,去比较s
     * 
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        return extracted(s, p);
    }

    //FIXME:
    private boolean extracted(String s, String p) {
        if (p.length() == 0 && s.length() != 0)
            return false;
        if (p.length() > s.length())
            return false;
        if (p.length() == 0 && s.length() == 0)
            return true;
        int j = 0;
        int len = s.length() - 1;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '*') {
                if (i == p.length() - 1) {// 最后一个

                } else {
                    char t = p.charAt(i + 1);
                    int index = s.indexOf(t + "");
                    if (index >= 0) {
                        j = index;// j
                    } else {
                        return false;
                    }
                }
            } else if (c == '?') {
                j++;
            } else {
                if (c == s.charAt(j)) {
                    j++;
                } else {
                    return false;
                }
            }
            s = s.substring(j, len);
        }
        return s.length() <= 0;
    }
}
