/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 *
 * https://leetcode-cn.com/problems/valid-palindrome-ii/description/
 *
 * algorithms
 * Easy (28.84%)
 * Total Accepted:    2.9K
 * Total Submissions: 10.1K
 * Testcase Example:  '"aba"'
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "aba"
 * 输出: True
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 
 * 
 * 注意:
 * 
 * 
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * 
 * 
 */
class Solution {
    //TODO:
    public boolean validPalindrome(String s) {
        String input = s.replaceAll("[^a-z^0-9]+", "").toLowerCase();
        return isValid(input,1);
    }
    
    private boolean isValid(String s, int numsDeletable){
        for(int start = 0, end = s.length()-1; start < (s.length()+2) / 2; start++, end--){
            if(s.charAt(start) != s.charAt(end)){
                if(numsDeletable > 0){
                    return isValid(s.substring(start+1, end+1), numsDeletable-1) ||
                            isValid(s.substring(start, end), numsDeletable-1);
                }else{
                    return false;
                }  
            } 
        }
        return true;   
    }
}

