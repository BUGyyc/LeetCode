/*
 * @lc app=leetcode.cn id=334 lang=java
 *
 * [334] 递增的三元子序列
 */
class Solution {
    public boolean increasingTriplet(int[] nums) {
        // 线性查找
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= a) {
                a = n;
            } else if (n <= b) {
                b = n;
            } else {
                return true;
            }
        }
        return false;
    }
}
