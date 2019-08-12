
/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */
class Solution {
    private StringBuilder sb = null;

    public String removeDuplicates(String S) {
        // return checkLogic(S);\
        sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private String checkLogic(String s) {
        sb = new StringBuilder();
        char[] arr = s.toCharArray();
        if (s.isEmpty() || arr.length < 2) {
            return s;
        }
        if (arr.length == 2) {
            if (arr[0] == arr[1]) {
                return "";
            } else {
                return s;
            }
        }
        if (arr[0] != arr[1]) {
            sb.append(arr[0]);
        }
        for (int i = 1; i < arr.length - 2; i++) {
            if (arr[i - 1] != arr[i] && arr[i] != arr[i + 1]) {
                sb.append(arr[i]);
            }
        }
        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            sb.append(arr[arr.length - 1]);
        }
        return checkLogic(sb.toString());
    }
}
