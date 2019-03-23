/*
 * @lc app=leetcode.cn id=520 lang=java
 *
 * [520] 检测大写字母
 *
 * https://leetcode-cn.com/problems/detect-capital/description/
 *
 * algorithms
 * Easy (51.10%)
 * Total Accepted:    5.3K
 * Total Submissions: 10.3K
 * Testcase Example:  '"USA"'
 *
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * 
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * 
 * 
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 
 * 
 * 否则，我们定义这个单词没有正确使用大写字母。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "USA"
 * 输出: True
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: "FlaG"
 * 输出: False
 * 
 * 
 * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
 * 
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        return extracted(word);
    }

    private boolean extracted(String word) {
        // if(word.length == 0)return true;
        char[] chars = word.toCharArray();
        int type = (chars[0] <= 'Z' && chars[0] >= 'A') ? 2 : 1;// 1 是小写 2是大写
        int lastT = -1;
        for (int i = 1; i < chars.length; i++) {
            int t = (chars[i] <= 'Z' && chars[i] >= 'A') ? 2 : 1;
            if (type == 1 && t == 2) {// 如果首字母是小写，其他大写
                return false;
            } else if (type == 2) {// 大写首字母
                if (lastT == -1) {
                    lastT = t;
                } else {
                    if (lastT != t) {// 和上次结果不一样
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
