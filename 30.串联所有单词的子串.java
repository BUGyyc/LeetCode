/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 *
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/description/
 *
 * algorithms
 * Hard (24.77%)
 * Total Accepted:    4.9K
 * Total Submissions: 19.6K
 * Testcase Example:  '"barfoothefoobarman"\n["foo","bar"]'
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：
 * ⁠ s = "barfoothefoobarman",
 * ⁠ words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入：
 * ⁠ s = "wordgoodgoodgoodbestword",
 * ⁠ words = ["word","good","best","word"]
 * 输出：[]
 * 
 * 
 */
class Solution {
    // TODO:
    //FIXME:
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        Map<String, Integer> wordsCount = generateCount(words);//将所有字符加入数组Hash表
        int length = words[0].length();
// HashMap
        for (int i = 0; i < length; ++i) {//错位循环，保证每种情况都遍历到
            Map<String, Integer> window = new HashMap<>();
            int left = i;
            int right = i;
            while (right <= s.length() - length && left <= s.length() - length * words.length) {
                String sub = s.substring(right, right + length);
                incr(window, sub);//取一个字符加入窗口Hash表
                if (!wordsCount.containsKey(sub)) {//如果这个字符在数组Hash表中不存在，就清理窗口并重置left和right
                    window.clear();
                    right += length;
                    left = right;
                    continue;
                }
                while (window.get(sub) > wordsCount.get(sub)) {//当窗口Hash中字符次数多于数组Hash字符次数时，left+l,交从窗口中移除最左边的字符
                    decr(window, s.substring(left, left + length));
                    left += length;
                }
                right += length;
                if (right - left == length * words.length) {//当窗口长度正好等于数组字符总长度时，表示匹配成功，加入结果中
                    result.add(left);
                }
            }
        }
        return result;
    }

    private Map<String, Integer> generateCount(String[] words) {
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String word : words) {
            incr(wordsCount, word);
        }
        return wordsCount;
    }

    private void incr(Map<String, Integer> map, String key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    private void decr(Map<String, Integer> map, String key) {
        if (map.containsKey(key)) {
            Integer value = map.get(key);
            if (value <= 1) {
                map.remove(key);
            } else {
                map.put(key, value - 1);
            }
        }
    }
}
