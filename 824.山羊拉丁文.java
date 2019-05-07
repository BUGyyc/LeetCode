import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=824 lang=java
 *
 * [824] 山羊拉丁文
 */
class Solution {
    private StringBuilder sb = null;
    public String toGoatLatin(String S) {
        sb = new StringBuilder();
        S = S.trim();
        String [] str = S.split(" ");
        String t = "a";
        for(int i = 0;i<str.length;i++){
            str[i] = itemLogic(str[i]);
            str[i] += t;
            t+="a";
        }
        return String.join(" ",str);
    }

    public String itemLogic(String s) {
        char[] cs = s.toCharArray();
        char c = cs[0];
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
        || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {

        } else {
            sb = new StringBuilder();
        //    char f = cs[0];
            for (int i = 1; i < cs.length; i++) {
                // cs[i - 1] = cs[i];
                sb.append(cs[i]);
            }
            // cs[cs.length - 1] = f;
            sb.append(cs[0]);
            s = sb.toString();
        }
        s += "ma";
        return s;
    }
}
