/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] Binary Search
 *
 * https://leetcode-cn.com/problems/binary-search/description/
 *
 * algorithms
 * Easy (47.72%)
 * Total Accepted:    8.1K
 * Total Submissions: 17K
 * Testcase Example:  '[-1,0,3,5,9,12]\n9'
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的
 * target，如果目标值存在返回下标，否则返回 -1。
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 * 
 * 
 */
class Solution {
    /**
     * 根据已经条件，明显二分查找
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // return func1(nums, target, 0, nums.length - 1);
        return func2(nums, 0, nums.length/2, nums.length-1, target);
    }

    private int func1(int[] nums, int target, int f, int e) {
        int mid = (f + e) / 2;
        if (target == nums[mid])
            return mid;
        if (f == e)
            return -1;
        else if (target < nums[mid])
            return func1(nums, target, f, mid - 1);
        else
            return func1(nums, target, mid + 1, e);
    }

    public int func2(int[] nums, int start, int mid, int end, int target){
        if(nums[mid] == target)
            return mid;
        if(start == end)
            return -1;
        else if(target < nums[mid])
            return func2(nums, start, (start+mid-1)/2, mid-1, target);
        else
            return func2(nums, mid+1, (mid+1+end)/2, end, target);
    }
}
