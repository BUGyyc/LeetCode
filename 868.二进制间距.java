/*
 * @lc app=leetcode.cn id=868 lang=java
 *
 * [868] 推多米诺
 */
class Solution {
    public int binaryGap(int N) {
        int x = -1;
        int max = 0;
        while (N != 0) {
            if ((N & 1) == 1) {
                max = Math.max(x, max);
                x = 1;
            } else {
                if (x != -1)
                    x++;
            }
            N >>= 1;
        }
        return max;
    }
}
