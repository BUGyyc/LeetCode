/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 *
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/description/
 *
 * algorithms
 * Easy (38.27%)
 * Total Accepted:    4.2K
 * Total Submissions: 11K
 * Testcase Example:  '[1,3,5,4,7]'
 *
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。 
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * 
 * 
 * 注意：数组长度不会超过10000。
 * 
 */
class Solution {
    //TODO:
    public int findLengthOfLCIS(int[] nums) {
        return func2(nums);
    }

    private int func2(int[] nums){
        if(nums.length < 2)return nums.length;
        int max = 1;
        int cur = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                cur++;
                max = Math.max(max,cur);
            }else{
                cur = 1;
            }
        }
        return max;
    }

    private int extracted(int[] nums) {
        int max = -1;
        int lastIndex = 0;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - pre <= 0) {
                max = Math.max(max, i - lastIndex);
                lastIndex = i;// 重置
            }
            pre = nums[i];
        }
        return (max == -1) ? nums.length : max;
    }
}
