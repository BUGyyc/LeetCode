/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现strStr()
 *
 * https://leetcode-cn.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (37.88%)
 * Total Accepted:    41.6K
 * Total Submissions: 109.7K
 * Testcase Example:  '"hello"\n"ll"'
 *
 * 实现 strStr() 函数。
 * 
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回  -1。
 * 
 * 示例 1:
 * 
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 
 * 
 * 说明:
 * 
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * 
 */
class Solution {
    //TODO:
    /**
     * 滑动窗口来比较
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        int i = 0;
        while (i <= haystack.length()-needle.length()) {
            if (isValid(haystack,needle,i)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private boolean isValid(String haystack, String needle, int start) {
        int i = 0;
        while (i < needle.length()) {
            if (haystack.charAt(start) != needle.charAt(i)) {
                return false;
            }
            start++;
            i++;
        }
        return true;
    }
}
