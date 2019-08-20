/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */
class Solution {
    public int rob(int[] nums) {
        int preMax = 0;
        int currMax = 0;
        for(int n : nums){
            int temp = currMax;
            currMax = Math.max(preMax + n,currMax);
            preMax = temp;
        }
        return currMax;
    }
}

