/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */
class Solution {
    //TODO:
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        String[] s = new String[digits.length()];
        int M = digits.length();
        if (s.length == 0) {
            return list;
        }
        for (int i = 0; i < digits.length(); i++) {
            switch (digits.charAt(i)) {
            case '2':
                s[i] = "abc";
                break;
            case '3':
                s[i] = "def";
                break;
            case '4':
                s[i] = "ghi";
                break;
            case '5':
                s[i] = "jkl";
                break;
            case '6':
                s[i] = "mno";
                break;
            case '7':
                s[i] = "pqrs";
                break;
            case '8':
                s[i] = "tuv";
                break;
            case '9':
                s[i] = "wxyz";
                break;
            }
        }
        list = getStringWithFor(s, 0, list, "");
        return list;
    }

    private static List<String> getStringWithFor(String[] s, int i, List<String> list, String stemp) {
        if (i < s.length - 1) {
            for (int j = 0; j < s[i].length(); j++) {
                list = getStringWithFor(s, i + 1, list, stemp + s[i].charAt(j));
            }
            i++;
        } else {
            for (int j = 0; j < s[i].length(); j++) {
                list.add(stemp + s[i].charAt(j));
            }
        }
        return list;
    }
}
