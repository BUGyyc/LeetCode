/*
 * @lc app=leetcode.cn id=665 lang=java
 *
 * [665] 非递减数列
 *
 * https://leetcode-cn.com/problems/non-decreasing-array/description/
 *
 * algorithms
 * Easy (18.44%)
 * Total Accepted:    3.7K
 * Total Submissions: 19.8K
 * Testcase Example:  '[4,2,3]'
 *
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [4,2,3]
 * 输出: True
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [4,2,1]
 * 输出: False
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 
 * 
 * 说明:  n 的范围为 [1, 10,000]。
 * 
 */
class Solution {
    public boolean checkPossibility(int[] nums) {
        return extracted(nums);
    }

    /**
     * 找到不符合的位置，记录次数
     * 如果大于1次直接不符合
     * 其他情况就是1次或者0次
     * 1次就判断情况，根据索引点来判断
     * @param nums
     * @return
     */
    private boolean extracted(int[] nums) {
        int cnt = 0;// 记录次数
        int index = 0;// 记录索引
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                cnt++;
                index = i;
            }
        }
        if (cnt > 1)
            return false;
        if (cnt == 0 || index == 0 || index == nums.length - 2 || (nums[index - 1] <= nums[index + 1])
                || (nums[index] <= nums[index + 2])) {
            return true;
        }
        return false;
    }
}
