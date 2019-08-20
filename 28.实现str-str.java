/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现strStr()
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
    // TODO:
    /**
     * 滑动窗口来比较
     */
    public int strStr(String haystack, String needle) {
        //这个时间复杂度要高些
        for (int i = 0;; i++) {
            for (int j = 0;; j++) {
                if (j == needle.length())
                    return i;
                if (i + j == haystack.length())
                    return -1;
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;
            }
        }

        // if (haystack == null || needle == null || haystack.length() <
        // needle.length()) {
        // return -1;
        // }
        // if ("".equals(needle)) {
        // return 0;
        // }
        // int i = 0;
        // while (i <= haystack.length()-needle.length()) {
        // if (isValid(haystack,needle,i)) {
        // return i;
        // }
        // i++;
        // }
        // return -1;
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
