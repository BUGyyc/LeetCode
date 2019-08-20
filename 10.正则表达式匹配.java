/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 *
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * 
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 
 * 
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * 
 * 说明:
 * 
 * 
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * 
 * 
 * 示例 3:
 * 
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 * 
 * 
 * 示例 4:
 * 
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 * 
 * 
 * 示例 5:
 * 
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * 
 */
class Solution {
    //TODO:
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
		boolean[][] memory = new boolean[2][pLen+1];
		memory[0][0] = true;
		int cur = 0, pre = 0;
		for(int i = 0; i <= sLen; i++) {
			cur = i % 2;
			pre = (i + 1) % 2;
			if(i > 1) {
				for(int j = 0; j <= pLen; j++) {
					memory[cur][j] = false;
				}
			}
			for(int j = 1; j <= pLen; j++) {
				if(p.charAt(j-1) == '*') {
					
					memory[cur][j] = memory[cur][j-2] || (i > 0 && (s.charAt(i-1) == p.charAt(j-2) || 
							p.charAt(j-2) == '.') && memory[pre][j]);
				}else {
					memory[cur][j] = i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
									&& memory[pre][j-1];
				}
			}
		}
		return memory[cur][pLen];
    }
}

