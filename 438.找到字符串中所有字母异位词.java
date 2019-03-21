/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 *
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Easy (34.73%)
 * Total Accepted:    3K
 * Total Submissions: 8.7K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * 
 * 说明：
 * 
 * 
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 
 * 输出:
 * [0, 6]
 * 
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入:
 * s: "abab" p: "ab"
 * 
 * 输出:
 * [0, 1, 2]
 * 
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 
 * 
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexes = new ArrayList<>();
        if (s.isEmpty() || p.length() > s.length())
            return indexes;
        Map<Character, Integer> pHash = new HashMap<>();
        for (char c : p.toCharArray()) {
            if (pHash.containsKey(c)) {
                pHash.put(c, pHash.get(c) + 1);
            } else {
                pHash.put(c, 1);
            }
        }

        int numberOfCharsToBeZero = pHash.keySet().size();

        for (int i = 0; i < p.length(); i++) {
            char c = s.charAt(i);
            if (pHash.containsKey(c)) {
                int value = pHash.get(c) - 1;
                pHash.put(c, value);
                if (value == 0)
                    numberOfCharsToBeZero--;
            }
        }
        if (numberOfCharsToBeZero == 0)
            indexes.add(0);
        int start = 0;
        int end = p.length() - 1;
        while (end < s.length() - 1) {
            char startChar = s.charAt(start++);
            char endChar = s.charAt(++end);
            if (pHash.containsKey(startChar)) {
                if (pHash.get(startChar) == 0)
                    numberOfCharsToBeZero++;
                pHash.put(startChar, pHash.get(startChar) + 1);
            }
            if (pHash.containsKey(endChar)) {
                pHash.put(endChar, pHash.get(endChar) - 1);
                if (pHash.get(endChar) == 0)
                    numberOfCharsToBeZero--;
            }
            if (numberOfCharsToBeZero == 0)
                indexes.add(start);
        }
        return indexes;
    }
}
