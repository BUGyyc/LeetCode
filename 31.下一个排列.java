/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 *
 * https://leetcode-cn.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (30.03%)
 * Total Accepted:    9.4K
 * Total Submissions: 31.1K
 * Testcase Example:  '[1,2,3]'
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 
 * 必须原地修改，只允许使用额外常数空间。
 * 
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */
class Solution {
    // TODO:
    public void nextPermutation(int[] nums) {
        // extracted(nums);
        logic(nums);
    }

    private void logic(int[] nums) {
        int len = nums.length;
        boolean hasBreak = false;
        int index = 0;
        for (int i = len - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                hasBreak = true;
                index = i - 1;
                break;
            }
        }

        if (hasBreak == false)
            return;
        int target = nums[index];
        int num = 0;
        for (int i = index; i < len; i++) {
            if (target > nums[i]) {
                num = i - 1;
                break;
            }
        }
        int temp = target;
        nums[index] = nums[num];
        nums[num] = temp;
    }

    private void extracted(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
