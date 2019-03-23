import java.util.List;

/*
 * @lc app=leetcode.cn id=500 lang=java
 *
 * [500] 键盘行
 *
 * https://leetcode-cn.com/problems/keyboard-row/description/
 *
 * algorithms
 * Easy (64.26%)
 * Total Accepted:    5.1K
 * Total Submissions: 7.9K
 * Testcase Example:  '["Hello","Alaska","Dad","Peace"]'
 *
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 * 
 * 
 * 
 * 
 * 注意：
 * 
 * 
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 * 
 */
class Solution {
    private String[] strs = new String[3];
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        strs[0] = "qwertyuiop";
        strs[1] = "asdfghjkl";
        strs[2] = "zxcvbnm";
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            char[] chars = str.toLowerCase().toCharArray();
            int type = fromType(chars[0]);
            boolean fg = true;
            for(int j = 1;j<chars.length;j++){
                if(type !=  fromType(chars[j])){
                    fg = false;
                    break;
                }
            }
            if(fg == true){//是同一行
                result.add(str);
            }
        }
        return result.toArray(new String[0]);
    }
    private int fromType(char c) {
         for (int i = 0; i < strs.length; i++) {
            if (strs[i].indexOf(c) > -1)
                return i;
        }
        return -1;
    }
}
