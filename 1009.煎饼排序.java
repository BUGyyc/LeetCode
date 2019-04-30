/*
 * @lc app=leetcode.cn id=1009 lang=java
 *
 * [1009] 煎饼排序
 */
class Solution {
    public int bitwiseComplement(int N) {
        int num = 1;
        while (num < N) {
            num = (num << 1) + 1;
        }
        return num ^ N;
    }
}
