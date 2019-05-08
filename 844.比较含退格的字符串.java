/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] Backspace String Compare
 */
class Solution {
    private StringBuilder sb = null;

    public boolean backspaceCompare(String S, String T) {
        return getNewString(S).equals(getNewString(T));
    }

    private String getNewString(String s) {
        if (s.length() == 0) {
            return "";
        }
        sb = new StringBuilder();
        char[] cs = s.toCharArray();
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == '#') {
                // cs[i-1] = '#';
                for (int j = i - 1; j >= 0; j--) {
                    if (cs[j] != '#') {
                        cs[j] = '#';
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '#')
                continue;
            sb.append(cs[i]);
        }
        return sb.toString();
    }

}
