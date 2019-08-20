/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉K位数字
 */
class Solution {
    public String removeKdigits(String num, int k) {
        char[] cs = num.toCharArray();
        int len = cs.length;
        int length = len;
        if (k == 0)
            return num;
        if (k == len)
            return "0";

        while (k != 0) {
            boolean hasChange = false;// 是否有重置值
            for (int i = 0; i < len - 1; i++) {
                // 前一个比后一个大
                if ((int) cs[i] > (int) cs[i + 1]) {
                    // 重置前一个值
                    for (int t = i; t < len - 1; t++) {
                        cs[t] = cs[t + 1];
                    }
                    hasChange = true;
                    length--;
                    k--;
                    break;
                }
            }
            // 在循环没结束之前，没有重置值
            if (hasChange == false && k != 0) {
                length--;
                k--;
            }
        }

        boolean cut = true;
        while (cut) {
            cut = false;
            if (cs[0] == '0' && length != 1) {
                cut = true;
                // 前移
                for (int t = 0; t < len - 1; t++) {
                    cs[t] = cs[t + 1];
                }
                length--;
            }
        }

        // 最终的数组长度
        char[] pre = new char[length];
        for (int i = 0; i < length; i++) {
            pre[i] = cs[i];
        }

        return String.valueOf(pre);// 返回这个新的数组
    }
}
