/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */
class Solution {

    // 状态转移方程
    // 例如 [1,2,3,4] target = 10
    /**
     * dp[10] = dp[10-1] + dp[10-2] + dp[10-3]+dp[10-4]
     * dp[10-1]就是选了第一层选1
     * dp[10-2]就是第一层选了2，依次类推
     * 
     * 最后得到状态转移方程
     * 
     * 
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0)
            return 0;

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
