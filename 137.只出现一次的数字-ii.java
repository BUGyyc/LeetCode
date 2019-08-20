/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */
class Solution {
    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                int num = nums[j] >> i;
                bit[i] += num & 1;
            }
        }

        int result = 0;
        for (int i = 31; i >= 0; i--) {
            result <<= 1;
            result += bit[i]%3;
        }

        return result;
    }
}
