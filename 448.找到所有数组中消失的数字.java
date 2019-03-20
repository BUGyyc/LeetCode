/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 *
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * algorithms
 * Easy (45.32%)
 * Total Accepted:    5K
 * Total Submissions: 11K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 
 * 示例:
 * 
 * 
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 
 * 输出:
 * [5,6]
 * 
 * 
 */
class Solution {
    //TODO:
    /**
     * 遍历一遍
     * 把值当做索引，把对应索引的值变化成负数，最后没变化的值,就是缺少对应索引的值 j，（j+1）即为要求的值
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0)//
            {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                list.add(j+1);
            }
        }
        return list;
    }
}
