/*
 * @lc app=leetcode.cn id=686 lang=java
 *
 * [686] 重复叠加字符串匹配
 *
 * https://leetcode-cn.com/problems/repeated-string-match/description/
 *
 * algorithms
 * Easy (26.58%)
 * Total Accepted:    1.9K
 * Total Submissions: 7.2K
 * Testcase Example:  '"abcd"\n"cdabcdab"'
 *
 * 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
 * 
 * 举个例子，A = "abcd"，B = "cdabcdab"。
 * 
 * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B
 * 并不是其子串。
 * 
 * 注意:
 * 
 * A 与 B 字符串的长度在1和10000区间范围内。
 * 
 */
class Solution {
    //TODO:
    public int repeatedStringMatch(String A, String B) {
        return func1(A, B);
    }

    private int func1(String A, String B) {
        int i = 0, j = 0;
        while (i < A.length()) {
            j = 0;
            while (j < B.length() && A.charAt((i + j) % A.length()) == B.charAt(j)) {
                j++;
            }
            if (j == B.length()) {
                return (i + j) / A.length() + ((i + j) % A.length() == 0 ? 0 : 1);
            }
            i++;
        }
        return -1;
    }
}
