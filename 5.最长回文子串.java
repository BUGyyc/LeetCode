/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */
class Solution {
    //TODO:
    //回文串
    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - longestPalindrome.length(); i++) {
            for (int j = chars.length - 1; j >= i; j--) {
                // 从后往前找
                if (chars[j] == chars[i]) {
                    // 判断是不是回文
                    for (int k = i; k <= j; k++) {
                        if (chars[k] != chars[j + i - k]) {
                            break;
                        }
                        // 判断一半是不是对了
                        if (k >= j + i - k) {
                            if (longestPalindrome.length() < (k - i + 1)) {// 判断是不是比上一个长
                                char[] bs = new char[k - i + 1];
                                System.arraycopy(chars, i, bs, 0, k - i + 1);
                                // 保存长的
                                longestPalindrome = String.valueOf(bs);
                            }

                        }
                    }
                }
            }
        }
        return longestPalindrome;
    }
}
