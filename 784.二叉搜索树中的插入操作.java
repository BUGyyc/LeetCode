/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784] 二叉搜索树中的插入操作
 *
 * https://leetcode-cn.com/problems/letter-case-permutation/description/
 *
 * algorithms
 * Easy (50.25%)
 * Total Accepted:    2.9K
 * Total Submissions: 5.7K
 * Testcase Example:  '"a1b2"'
 *
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * 
 * 
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * 
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 * 
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 
 * 
 * 注意：
 * 
 * 
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 * 
 * 
 */
class Solution {
    //TODO:
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        dfs(S.toCharArray(), 0, ans);
        return ans;
    }

    private void dfs(char[] S, int i, List<String> ans) {
        if (i == S.length) {
            ans.add(new String(S));
            return;
        }
        dfs(S, i + 1, ans);
        if (!Character.isLetter(S[i]))
            return;
        S[i] ^= 1 << 5;
        dfs(S, i + 1, ans);
        S[i] ^= 1 << 5;
    }
}
